package com.cosacs.PageObject;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extent;

	
	public static ExtentReports createInstance() {
		
		String fileName=getReportName();
		String directory=System.getProperty("user.dir")+"/reports/";
		new File(directory).mkdirs();
		String path=fileName+directory;
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Results");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Organization", "IGT Infoglobaltech");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Executed by", "Chidanand");
		extent.attachReporter(htmlReporter);
		return extent;
	}
	
	public static String getReportName() {
		Date d=new Date();
		String fileName="Automation Report_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
		return fileName;
	}
	
	
	

}
