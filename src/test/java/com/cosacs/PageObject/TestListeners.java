package com.cosacs.PageObject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class TestListeners implements ITestListener{
	
	private static ExtentReports extent=ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> ExtentTest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		ExtentTest test=extent.createTest(result.getTestClass().getName()+"::--> "+result.getMethod().getMethodName());
		ExtentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		String logText="<b>Test Method - "+result.getMethod().getMethodName() +" Successfull </b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		ExtentTest.get().log(Status.PASS, m);
	}

	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String ExceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		ExtentTest.get().fail("<Details><Summary><b><font color=red>"+"Exception Occured, Click here to see Details"+"</font></b></Summary></Details>"+
		ExceptionMessage.replaceAll(",", "<br>")+"</Details> \n");
		
		String path=takeScreenshot(BaseClass.driver,result.getMethod().getMethodName());
		
		try {
			ExtentTest.get().fail("<b><font color=red>"+"Screenshot of failure"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		}catch(IOException e) {
			ExtentTest.get().fail("Test failed, canot attach screenshot");
		}
		
		String logText="<b>Test method "+methodName+" failed</b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
		ExtentTest.get().log(Status.FAIL, m);
	}

	public void onTestSkipped(ITestResult result) {
		String logText="<b>Test Method"+result.getMethod().getMethodName()+" Skipped<b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		ExtentTest.get().log(Status.SKIP, m);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		if(extent != null) {
			extent.flush();
		}
		
	}
	
	public String takeScreenshot(WebDriver driver,String methodname) {
		String fileName=getScreenshotName(methodname);
		String directory=System.getProperty("user.dir")+"/ScreenShots/";
		new File(directory).mkdirs();
		String path=directory+fileName;
		
		try {
			File screenshot=(File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("************************");
			System.out.println("Screenshot stored at : "+path);
			System.out.println("************************");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return path;

	}
	
	public static String getScreenshotName(String methodName) {
		Date d=new Date();
		String fileName=methodName+"_"+d.toString().replace(":", "_").replace(" ", "_")+".png";
		return fileName;
	}

	
	
}
