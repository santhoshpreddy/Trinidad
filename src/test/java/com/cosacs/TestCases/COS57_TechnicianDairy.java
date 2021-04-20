package com.cosacs.TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

public class COS57_TechnicianDairy extends BaseClass{
	public String ExpectedTitle="Technician Diary";
	public static JavascriptExecutor js;
	/*
	public static String ExpectedColor="rgba(236, 0, 140, 1)";
	public static String AvailableTo="03/18/2020";
	public static String AvailableFrom="03/18/2020";
	public static String TechnicianName="148";
	public static String VisibleWeeks="1";*/
	
	@Test
	public void TechnicianDairy()throws Exception
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.Services);
			log.info("User Clicked on Service");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.TechnicianDairy);
			log.info("User clicked on TechnicianDairy");
			
			Library.Interaction.userWait();
			String ActualTitle = Library.Interaction.verifyPageTitle();
			Assert.assertEquals(ActualTitle, JsonParser.testData("TechnicianDairy.ExpectedTitle"));
			log.info("Page Title is Verified Successfully");
			
			Thread.sleep(5000);
			
			Library.Interaction.userWait();
			Library.Interaction.selectele(Xpath.TechnicanDairy.TechnicianName, Xpath.TechnicanDairy.TechnicianNameSearch, Xpath.TechnicanDairy.TechnicianList, JsonParser.testData("TechnicianDairy.TechnicianName"), JsonParser.testData("TechnicianDairy.TechnicianName"));
			log.info("User selected Technician Name");
			
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.Date);
			Thread.sleep(2000);
			Library.Interaction.click(Xpath.TechnicanDairy.TD);
			log.info("User Selected Date of Start Week to View");

			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.VisibleWeeks);
			driver.findElement(By.xpath(Xpath.TechnicanDairy.VisibleWeeks)).clear();
			Library.Interaction.setTextBoxByXpath(Xpath.TechnicanDairy.VisibleWeeks, JsonParser.testData("TechnicianDairy.VisibleWeeks"));
			log.info("User entered visible weeks");
			
			Thread.sleep(5000);
			
			js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0,500)");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.AvailbleFromDate);
			Thread.sleep(2000);
			Library.Interaction.setTextBoxByXpath(Xpath.TechnicanDairy.AvailbleFromDate, JsonParser.testData("TechnicianDairy.AvailableFrom"));
			log.info("User Selected Technician Unavailable From Date");
			Thread.sleep(2000);
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.AvailbleToDate);
			Thread.sleep(2000);
			Library.Interaction.setTextBoxByXpath(Xpath.TechnicanDairy.AvailbleToDate, JsonParser.testData("TechnicianDairy.AvailableTo"));
			log.info("User Selected Technician Unavailable To Date");
			Thread.sleep(1000);
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);

			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.TechnicanDairy.ASubmit);
			log.info("Technician Unavailablity Dates Submited Successfully");
			Thread.sleep(2000);
			Library.Interaction.userWait();
			String Actualcolor = driver.findElement(By.xpath(Xpath.TechnicanDairy.color)).getCssValue("background-color");
			Assert.assertEquals(Actualcolor, JsonParser.testData("TechnicianDairy.ExpectedColor"));
			log.info("Technician Not Available From "+ JsonParser.testData("TechnicianDairy.AvailableFrom") + " To "+JsonParser.testData("TechnicianDairy.AvailableTo"));
			
			Library.Interaction.click(Xpath.TechnicanDairy.HolidayApprove);
			log.info("User clicked on holiday approve date");
			Library.Interaction.click(Xpath.TechnicanDairy.Delete);
			log.info("User deleted approved date");
			driver.quit();

			
		}
		catch (Exception e) {
			captureScreen(driver, "location");
			AssertJUnit.assertFalse(false);
			log.info("Test Failed");
			throw(e);
		}
	}


}
