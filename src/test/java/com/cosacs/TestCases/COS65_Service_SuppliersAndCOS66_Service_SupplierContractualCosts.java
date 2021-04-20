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

public class COS65_Service_SuppliersAndCOS66_Service_SupplierContractualCosts extends BaseClass {
	
//public String ExpectedTitle="Service Suppliers";
	public static JavascriptExecutor js;
//	public String companyname="IFB";
	public static Robot rb;
	
	@Test
	public void Suppliers()throws Exception
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Suppliers.Services);
			log.info("User Clicked On Services");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Suppliers.Suppliers);
			log.info("User Clicked On Suppliers");
			
			Library.Interaction.userWait();
			String ActualTitle = Library.Interaction.verifyPageTitle();
			Assert.assertEquals(ActualTitle, JsonParser.testData("Supplier.ExpectedTitle"));
			log.info("Page Title is Verified Successfully");
			

			
			Thread.sleep(8000);
			rb=new Robot();
			rb.keyPress(KeyEvent.VK_END);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Suppliers.Add);
			log.info("User Clicked On Add Icon");
			
			
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Suppliers.SupplierTextbox);
			Thread.sleep(3000);
			Library.Interaction.setTextBoxByXpath(Xpath.Suppliers.SupplierTextbox,JsonParser.testData("Supplier.companyname"));
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Suppliers.SupplierSave);
			log.info("Supplier Saved Successfully");
			
			Library.Interaction.userWait();
			String SuccessMsg= Library.Interaction.verifyToastMessage(Xpath.Suppliers.SupplierSuccessMsg).trim();
			log.info(SuccessMsg);
			
			rb.keyPress(KeyEvent.VK_HOME);
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Suppliers.SupplierSearchtbox);
			Library.Interaction.setTextBoxByXpath(Xpath.Suppliers.SupplierSearchtbox,JsonParser.testData("Supplier.companyname"));
			Library.Interaction.click(Xpath.Suppliers.Search);
			log.info("Supplier Searched Successfully");

			
			Thread.sleep(2000);
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Suppliers.Edit);
			log.info("User Clicked on Edit Icon");
			
			Thread.sleep(3000);
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Suppliers.SupplierTextbox);
			Library.Interaction.setTextBoxByXpath(Xpath.Suppliers.SupplierTextbox, "Co");
			Library.Interaction.click(Xpath.Suppliers.SupplierSave);
			log.info("Supplier Edited Successfully");
			String EditSuccessMsg = Library.Interaction.verifyToastMessage(Xpath.Suppliers.SupplierSuccessMsg).trim();
			log.info(EditSuccessMsg);
			
			Thread.sleep(3000);
			
//			Library.Interaction.userWait();
//			Library.Interaction.click(Xpath.Suppliers.Delete);
//			log.info("User Clicked On Delete Icon");
//			
//			Thread.sleep(2000);
//			
//			Library.Interaction.userWait();
//			Library.Interaction.click(Xpath.Suppliers.DeleteBtn);
//			String DeleteMsg = Library.Interaction.verifyToastMessage(Xpath.Suppliers.SupplierSuccessMsg).trim();
//			log.info(DeleteMsg);
			
			
			
			
			
			
			
		}
		catch (Exception e) {
			captureScreen(driver, "location");
			AssertJUnit.assertFalse(false);
			log.info("Test Failed");
			throw(e);
		}
	}
	@Test(priority=1)
	public void SupplierContractualCosts()throws Exception
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.Services);
			log.info("User Clicked On Services");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.SupplierContractualCost);
			log.info("User Clicked On Supplier COntractual Cost");
			
			Thread.sleep(5000);
			
			Library.Interaction.userWait();
			String ActualPageTitle = Library.Interaction.verifyPageTitle();
			Assert.assertEquals(ActualPageTitle, JsonParser.testData("Scontract.ExpectedPageTitle"));
			log.info("Page Title is Verified Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.selectele(Xpath.SupplierContractualCost.Supplier, Xpath.SupplierContractualCost.SupplierSearch, Xpath.SupplierContractualCost.SupplierList, JsonParser.testData("Supplier.companyname"), JsonParser.testData("Supplier.companyname"));
			log.info("Supplier Selected Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.RowNumbers);
			driver.findElement(By.xpath(Xpath.SupplierContractualCost.RowNumbers)).clear();
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.RowNumbers, JsonParser.testData("Scontract.Rownumber"));
			Thread.sleep(2000);
			Library.Interaction.click(Xpath.SupplierContractualCost.Addrow);
			log.info("Rows Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.Product);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.Product, JsonParser.testData("Scontract.ProductName"));
			log.info("Product Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.PartType);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.PartType,JsonParser.testData("Scontract.PartType"));
			log.info("Part Type Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.PartPercent);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.PartPercent,JsonParser.testData("Scontract.PartPercentage"));
			log.info("Part Percentage Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.PartValue);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.PartValue,JsonParser.testData("Scontract.PartValue"));
			log.info("Part Value Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.LabourPercent);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.LabourPercent,JsonParser.testData("Scontract.LabourPercentage"));
			log.info("Labour Percentage Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.LabourValue);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.LabourValue,JsonParser.testData("Scontract.LabourValue"));
			log.info("Labour Value Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.AddPercent);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.AddPercent,JsonParser.testData("Scontract.AddtionalPercentage"));
			log.info("Addtional Percentage Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.AddtionalValue);
			Library.Interaction.setTextBoxByXpath(Xpath.SupplierContractualCost.AddtionalValue,JsonParser.testData("Scontract.AddtionalValue"));
			log.info("Addtional Value Added Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SupplierContractualCost.Save);
			
			log.info("Saved Successfully");
			
			Library.Interaction.userWait();
			String SuccessMsg = Library.Interaction.verifyToastMessage(Xpath.SupplierContractualCost.SupplierSuccessMsg);
			log.info(SuccessMsg);
			Thread.sleep(2000);
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
