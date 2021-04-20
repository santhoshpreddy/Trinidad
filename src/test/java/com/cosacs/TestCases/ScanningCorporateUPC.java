package com.cosacs.TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

public class ScanningCorporateUPC extends BaseClass {
	
	@Test
	public void PurchaseOrder()throws Exception
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.CreatePurchaseOrder.Merchandising);
			log.info("User able to click on Merchandising");
			
			Library.Interaction.userWait();
			Library.Interaction.moveToElement(Xpath.CreatePurchaseOrder.Create);
			log.info("User able to click on Create");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.CreatePurchaseOrder.PurchaseOrder);
			log.info("User able to click on Purchase Order");
			
			Library.Interaction.userWait();
			String ActualText = Library.Interaction.get_ElmtText(Xpath.CreatePurchaseOrder.VerifyCreatePurchaseOrderPage);
			Thread.sleep(2000);
			Assert.assertEquals(ActualText,"Create Purchase Order");
			log.info("Page Title is Verified Successfully");
			
		
			
			Library.Interaction.userWait();
			Library.Interaction.selectEleVisibleText(Xpath.CreatePurchaseOrder.ReceivingLocation, Xpath.CreatePurchaseOrder.RecevingLocationSearch, Xpath.CreatePurchaseOrder.RecevingLocationList,JsonParser.testData("Purchaseorder.RecivingLoc"), JsonParser.testData("Purchaseorder.RecivingLoc"));
			Library.Interaction.print("User able to select Receiving Location");
			
			Library.Interaction.userWait();
			Library.Interaction.selectEleVisibleText(Xpath.CreatePurchaseOrder.Vendor, Xpath.CreatePurchaseOrder.VendorSearch, Xpath.CreatePurchaseOrder.VendorList, JsonParser.testData("Purchaseorder.Vendor"),JsonParser.testData("Purchaseorder.Vendor"));
			Library.Interaction.print("User able to select Vendor");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.CreatePurchaseOrder.RequestedDelivery);
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.CreatePurchaseOrder.RequestedDeliveryDate, JsonParser.testData("Purchaseorder.PORequsetingDeliverDate"));
			Library.Interaction.print("User able to select Requested Delivery Date");
			
			Thread.sleep(2000);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.CreatePurchaseOrder.AddProduct);
			Library.Interaction.print("User able to click on Add");
			Thread.sleep(2000);
			
			
			Library.Interaction.userWait();
			Library.Interaction.selectEleVisibleTextByContains(Xpath.CreatePurchaseOrder.ProductCode, Xpath.CreatePurchaseOrder.SKUSearch, Xpath.CreatePurchaseOrder.SKUList,JsonParser.testData("Purchaseorder.POSKU") ,JsonParser.testData("Purchaseorder.POSKU"));
			Library.Interaction.print("User able to select Product");
			

			
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.CreatePurchaseOrder.ProductRecevingDate, JsonParser.testData("Purchaseorder.RequsetingDeliverDate"));
			Library.Interaction.print("User able to select Requested Delivery Date");
			
			Library.Interaction.userWait();
			driver.findElement(By.xpath(Xpath.CreatePurchaseOrder.Quantity)).clear();
			Library.Interaction.setTextBoxByXpath(Xpath.CreatePurchaseOrder.Quantity, JsonParser.testData("Purchaseorder.Qty"));
			Library.Interaction.print("User able to enter Quantity");
			
//			Library.Interaction.userWait();
//			Thread.sleep(2000);
//			Library.Interaction.click(Xpath.CreatePurchaseOrder.RequireLabel);
//			log.info("Requires Lable Checked");

			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.CreatePurchaseOrder.SavePO);
			Library.Interaction.print("User able to Save Product");
			
			Thread.sleep(3000);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.CreatePurchaseOrder.CreatePO);
			Library.Interaction.print("User able to Create Purchase Order");
			
			Thread.sleep(8000);
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.CreatePurchaseOrder.EditLable);
			Library.Interaction.print("User clicked on Edit Lables");
			
			
			Library.Interaction.click(Xpath.CreatePurchaseOrder.Qtytoprint);
			
			
			Robot r=new Robot();

			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			
			Library.Interaction.userWait();
			Library.Interaction.setTextBoxByXpath(Xpath.CreatePurchaseOrder.Qtytoprint, "1");
			log.info("User entered data");
			
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.CreatePurchaseOrder.PrintLables);
			log.info("User able to click on Print Lables");
				
			Thread.sleep(3000);

		}
		
		catch (Exception e) {
			captureScreen(driver, "location");
			Assert.assertFalse(false);
			log.info("Test Failed");
			throw(e);
		}
	}

	@Test(dependsOnMethods="PurchaseOrder")
	public void StockCount() throws Exception
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchPurchaseOrder.merchandising);
			log.info("User able to click on Merchandising");
			
			Library.Interaction.userWait();
			Library.Interaction.moveToElement(Xpath.StockCount.Create);
			log.info("User able to click on Search");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.Stokcount);
			log.info("User able to click on StockCount");
			
			Thread.sleep(3000);
			
			Library.Interaction.userWait();
			Library.Interaction.selectEleVisibleText(Xpath.StockCount.Location, Xpath.StockCount.LocationSearch, Xpath.StockCount.LocationList, JsonParser.testData("StockCount.Location"), JsonParser.testData("StockCount.Location"));
			log.info("User able to select location");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.Date);
			Library.Interaction.setTextBoxByXpath(Xpath.StockCount.Date,JsonParser.testData("StockCount.Date") );
			log.info("User able to select date");
			
			Library.Interaction.userWait();
			Library.Interaction.selectEleVisibleText(Xpath.StockCount.Division, Xpath.StockCount.DivisionSearch, Xpath.StockCount.DivisionList, JsonParser.testData("StockCount.Div"), JsonParser.testData("StockCount.Div"));
			log.info("User able to select division");
			
			Library.Interaction.userWait();
			Library.Interaction.selectEleVisibleText(Xpath.StockCount.Department, Xpath.StockCount.DepartmentSearch, Xpath.StockCount.DepartmentList, JsonParser.testData("StockCount.Dept"), JsonParser.testData("StockCount.Dept"));
			log.info("User able to select department");
			
			Library.Interaction.userWait();
			Library.Interaction.selectEleVisibleText(Xpath.StockCount.Class, Xpath.StockCount.ClassSearch, Xpath.StockCount.ClassList, JsonParser.testData("StockCount.Cls"), JsonParser.testData("StockCount.Cls"));
			log.info("User able to select class");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.schedule);
			log.info("User able to schedule");
			
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.CreatePurchaseOrder.Merchandising);
			log.info("User able to click on Merchandising");
			
			Library.Interaction.userWait();
			Library.Interaction.moveToElement(Xpath.StockCount.MerchandisingSearch);
			log.info("User clicked on Search");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.SearchStockCount);
			log.info("User able to click on Stock Counts");
			
			Library.Interaction.userWait();
			Library.Interaction.selectEleVisibleText(Xpath.StockCount.StockLocation, Xpath.StockCount.StockLocationSearch, Xpath.StockCount.StockLocationList,JsonParser.testData("StockCount.Location") ,JsonParser.testData("StockCount.Location") );
			log.info("User able to select location");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.ScheduleFrom);
			Library.Interaction.setTextBoxByXpath(Xpath.StockCount.ScheduleFrom, JsonParser.testData("StockCount.Date"));
			log.info("User able to from date");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.ScheduleTo);
			Library.Interaction.setTextBoxByXpath(Xpath.StockCount.ScheduleTo, JsonParser.testData("StockCount.Date"));
			log.info("User able select to date");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.Search);
			log.info("User able search");
			
			Thread.sleep(2000);
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.StockCountID);
			log.info("User able click on stock count id");
			
			Thread.sleep(5000);
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.Start);
			log.info("User able click on start");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.CollectionNotes);
			log.info("User able click on CollectionNotes");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.DeliveryNotes);
			log.info("User able click on DeliveryNotes");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.GoodsReciept);
			log.info("User able click on GoodsReciept");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.ReturnToVendor);
			log.info("User able click on ReturnToVendor");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.StartCount);
			log.info("User able click on StartCount");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.StockCount.PrintStockcountsheet);
			log.info("User able click on PrintStockcountsheet");
			Thread.sleep(3000);
			driver.quit();
			
		}
		catch (Exception e) {
			captureScreen(driver, "location");
			Assert.assertFalse(false);
			log.info("Test Failed");
			throw(e);
		}
	}
}
