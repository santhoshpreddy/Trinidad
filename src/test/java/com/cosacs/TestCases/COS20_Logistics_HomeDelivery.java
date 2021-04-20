package com.cosacs.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.cosacs.Locators.Xpath;
import com.cosacs.PageObject.BaseClass;
import com.cosacs.PageObject.Library;
import com.cosacs.Utilities.JsonParser;

public class COS20_Logistics_HomeDelivery extends BaseClass {
	

	
	public static String SID;
	public static JavascriptExecutor js;
	public static String PickListNumber ;
	public static String DeliveryScheduleNumber;


	

	@Test
	public void Picking()throws Exception
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Logistics.Logistics);
			log.info("User is clicked on Merchandising");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Logistics.Picking);
			log.info("User is clicked on Picking");
			
			Library.Interaction.userWait();
			String ActualPageTitle = Library.Interaction.verifyPageTitle();
			Assert.assertEquals(ActualPageTitle, JsonParser.testData("HomeDelivery.ExpectedPageTitle"));
			log.info("Page Title is Verified SuccessFully");
			
			
			Library.Interaction.userWait();
			Library.Interaction.selectEleVisibleTextByContains(Xpath.Picking.SendingLocationClick, Xpath.Picking.SendingLocationSearch,Xpath.Picking.SendingLocationList, JsonParser.testData("HomeDelivery.SendingLocation"), JsonParser.testData("HomeDelivery.SendingLocation"));
			log.info("User is selcted Sending Location");
			
			Library.Interaction.userWait();
			Library.Interaction.selectEleVisibleTextByContains(Xpath.Picking.TypeClick, Xpath.Picking.TypeSearch, Xpath.Picking.TypeList, JsonParser.testData("HomeDelivery.Type"), JsonParser.testData("HomeDelivery.Type"));
			log.info("User is selcted Type");
			

			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Picking.search);
			log.info("Shipment is Searched Successfully");
			
			Thread.sleep(5000);
			js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0,200)");
			
			//Truck
			Thread.sleep(2000);
			Library.Interaction.userWait();
			Library.Interaction.selectele(Xpath.Picking.Driver, Xpath.Picking.DriverSearch, Xpath.Picking.DriverList, JsonParser.testData("HomeDelivery.Truck"), JsonParser.testData("HomeDelivery.Truck"));
			log.info("Driver selected successfully");
			Thread.sleep(2000);
			
			Library.Interaction.userWait();
			Thread.sleep(3000);
			Library.Interaction.click(Xpath.Picking.ShipmentPick);
			log.info("Shipment is added to Truck Successfully");
			
			Thread.sleep(2000);
			Library.Interaction.userWait();
			String PickingSuccessMsg= Library.Interaction.verifyToastMessageWithNumbers(Xpath.Picking.PickingSuccessMsg);
			log.info(PickingSuccessMsg);
			
			
		    
			

			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Picking.PrintByTruck);
			log.info("User is clicked on Print Truck");
			
			String parent = driver.getWindowHandle();
			
			Thread.sleep(2000);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Picking.ExternalLink);
			log.info("User is clicked on ExternalLink");
			
			
			
			Library.Interaction.userWait();
			Library.Interaction.switchToNewWindow();
			PickListNumber = Library.Interaction.getOnlyNumbers(Xpath.Picking.PickListNumber).trim().replaceFirst("^0*","");
			log.info("PickList Number is Generated Successfully");
			
			Thread.sleep(5000);
			driver.close();
			driver.switchTo().window(parent);
			Library.Interaction.click(Xpath.Picking.Ok);
			log.info("Shipment Picking Successfully");
			
			
			
			
		}
		catch (Exception e) {
			captureScreen(driver, "location");
			AssertJUnit.assertFalse(false);
			log.info("Test Failed");
			throw(e);
		}
	}
	
@Test(dependsOnMethods="Picking")
	public void SearchPicklist()throws Exception
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Logistics.Logistics);
			log.info("User clicked on Logistics");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Logistics.SearchPicklist);
			log.info("User clicked on SearchPicklist");
			

			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchPickList.SearchPicklistTxtbox);
			
			Library.Interaction.setTextBoxByXpath(Xpath.SearchPickList.SearchPicklistTxtbox, PickListNumber);
			log.info("User is able to search picklist");
			
			Thread.sleep(3000);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchPickList.PickListNumberLink);
			log.info("User is able to select PickList");
			
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchPickList.PickedOnDate);
			log.info("User is able to select Picked Date");
			Library.Interaction.selectele(Xpath.SearchPickList.pickeddroparrow, Xpath.SearchPickList.pickedtextbox, Xpath.SearchPickList.pickedselect, JsonParser.testData("HomeDelivery.PickedByEmp"), JsonParser.testData("HomeDelivery.PickedByEmp"));
			log.info("Shipment is Picked Successfully");
		    Thread.sleep(5000);
		    Library.Interaction.selectele(Xpath.SearchPickList.checkedby, Xpath.SearchPickList.checkedtextbox, Xpath.SearchPickList.checkedselect, JsonParser.testData("HomeDelivery.CheckedEmp"), JsonParser.testData("HomeDelivery.CheckedEmp"));
		    log.info("Shipment is Checked Successfully");
			Thread.sleep(3000);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchPickList.ShipmentComment);
			Library.Interaction.setTextBoxByXpath(Xpath.SearchPickList.ShipmentComment,JsonParser.testData("HomeDelivery.comment"));
			log.info("User is commented");
			
			Thread.sleep(3000);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchPickList.Save);
			log.info("Saved Successfully");
			
			Thread.sleep(3000);
			Library.Interaction.userWait();
			String PickingStatus = Library.Interaction.get_ElmtText(Xpath.SearchPickList.PickingRejectionStaus);
			log.info(PickingStatus);
			
			Thread.sleep(2000);
		}
		catch (Exception e) {
			captureScreen(driver, "location");
			AssertJUnit.assertFalse(false);
			log.info("Test Failed");
			throw(e);
		}
	}
			
	@Test(dependsOnMethods="SearchPicklist")
	public void Scheduling() throws Exception
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Logistics.Logistics);
			log.info("User Clicked On Merchandising");
			
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Logistics.Scheduling);
			log.info("User Clicked On Scheduling");
			

			
			Library.Interaction.userWait();
			Library.Interaction.selectEleVisibleTextByContains(Xpath.Scheduling.DeliveryBranch, Xpath.Scheduling.DeliveryBranchSearch, Xpath.Scheduling.DeliveryBranchList, JsonParser.testData("HomeDelivery.DeleveryBranch"), JsonParser.testData("HomeDelivery.DeleveryBranch"));
			log.info("User able to select DeliveryBranch");
			
		
			Library.Interaction.selectEleVisibleTextByContains(Xpath.Scheduling.Truck, Xpath.Scheduling.TruckSearch, Xpath.Scheduling.TruckList, JsonParser.testData("HomeDelivery.Truck") , JsonParser.testData("HomeDelivery.Truck"));
			log.info("User able to select Truck");
			
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Scheduling.Type);
			Library.Interaction.userWait();
			Library.Interaction.selectEleByIndex(Xpath.Scheduling.Type, 0);
			log.info("User selected  Type");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Scheduling.CreateDeliverySchedule);
			log.info("User able to click on CreateDeliverySchedule");
			
			

			
/*			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Scheduling.Comment);
			Library.Interaction.setTextBoxByXpath(Xpath.Scheduling.Comment, JsonParser.testData("HomeDelivery.comment"));
			log.info("User able to Comment");*/
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Scheduling.Save);
			log.info("User able to Save");
			
			String parent = driver.getWindowHandle();
			
			Thread.sleep(2000);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Scheduling.DeliveryScheduleLink);
			log.info("User is clicked on ExternalLink");
			
			
		    Thread.sleep(3000);
			Library.Interaction.userWait();
			Library.Interaction.switchToNewWindow();
			DeliveryScheduleNumber = Library.Interaction.getOnlyNumbers(Xpath.Scheduling.ReceiptDeliveryScheduleNumber).trim();
			
			driver.switchTo().window(parent);
			Library.Interaction.click(Xpath.Scheduling.Ok);
			log.info("Load and Delivery Schedule is Completed Successfully");
			
		}
		catch (Exception e) {
			captureScreen(driver, "location");
			AssertJUnit.assertFalse(false);
			log.info("Test Failed");
			throw(e);
		}
	}
	@Test(dependsOnMethods="Scheduling")	
	public void SearchDeliverySchedules() throws Exception
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Logistics.Logistics);
			log.info("User able to click on Logistics");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Logistics.SearchDeliverySchedule);
			log.info("User able to click on SearchDeliverySchedule");
			
			Library.Interaction.userWait();
			String SrchDeliverySchdlActualTitle = Library.Interaction.verifyPageTitle();
			Assert.assertEquals(SrchDeliverySchdlActualTitle, JsonParser.testData("HomeDelivery.SrchDeliverySchdlExpectedTitle"));
			log.info("Page Title is Verified Successfully");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchDeliverySchedules.SearchBox);
			Library.Interaction.setTextBoxByXpath(Xpath.SearchDeliverySchedules.SearchBox, DeliveryScheduleNumber);
			log.info("User able to Search Shipment");
			
			Thread.sleep(2000);
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchDeliverySchedules.ScheduleNumberLink);
			log.info("User Clicked On ScheduleNumber");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchDeliverySchedules.ConfirmationDate);
			Library.Interaction.click(Xpath.SearchDeliverySchedules.ConfirmDate);
			log.info("User Confirmed Date Successfully");
			
			Library.Interaction.userWait();
			SID=Library.Interaction.get_ElmtText(Xpath.SearchDeliverySchedules.ShipmentID).replaceAll("[^0-9]", "").trim();
			
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchDeliverySchedules.Confirm);
			log.info("Delivery Confirmed Successfully");
			

			
		}
		catch (Exception e) {
			captureScreen(driver, "location");
			AssertJUnit.assertFalse(false);
			log.info("Test Failed");
			throw(e);
		}
	}
	@Test(dependsOnMethods="SearchDeliverySchedules")		
	public void SearchShipments() throws Exception
	{
		try
		{
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Logistics.Logistics);
			log.info("User able to Click on Logistics");
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.Logistics.SearchShipments);
			log.info("User able to click on Search Shipments");
			
			Thread.sleep(2000);
			Library.Interaction.userWait();
			String ActualPageTitle = Library.Interaction.verifyPageTitle();
			Assert.assertEquals(ActualPageTitle, JsonParser.testData("HomeDelivery.ExpectedSearchShipmentPageTitle"));
			log.info("Page Title is Verified Successfully");
			
			
			Library.Interaction.userWait();
			Library.Interaction.click(Xpath.SearchShipments.ShipmentSearchBox);
			Library.Interaction.setTextBoxByXpath(Xpath.SearchShipments.ShipmentSearchBox, SID);
			log.info("User able to Search Shipment");
			
			Thread.sleep(2000);
			Library.Interaction.userWait();
			String ShipmentStatus = Library.Interaction.get_ElmtText(Xpath.SearchShipments.SearchShimpmentStatus);
			log.info("Shipment is "+ShipmentStatus);
			Thread.sleep(1000);
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
