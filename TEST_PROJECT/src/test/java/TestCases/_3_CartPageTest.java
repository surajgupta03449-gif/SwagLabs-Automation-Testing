package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._1_LoginPage;
import Pages._2_InventoryPage;
import Pages._3_CartPage;
import Ulitlity.ReadDate;

public class _3_CartPageTest extends TestBase {

	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;

	// Test the Cart Page in the page 
	@BeforeMethod (alwaysRun = true)
	public void setup() throws Exception
	{
		initalization();
		login = new _1_LoginPage();
		invent = new _2_InventoryPage();
		cart = new _3_CartPage();
		login.loginToApplication();
		invent.add6Product();
		invent.clickCartIcon();
	}
	// Test the verify visibility of URL
	@Test	(groups = {"Smoke","Sanity"})
	public void verifyCartPageURLTest() throws Exception
	{
		String expURL = ReadDate.readExcelFile(1, 6);
		String actURl = cart.verifyCartPageURL();
		Assert.assertEquals(expURL, actURl);
		Reporter.log("URL of Cart page :-" + actURl);
	}
	//Test the verify visibility of Cart_Label
	@Test (groups = "Smoke")
	public void verifyCartLabel() throws Exception
	{
		String expLabel = ReadDate.readExcelFile(1, 7);
		String actLabel = cart.verifyCartLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Cart Page Label :-" + actLabel);
	}
	//Test the visibility of Close_browser
	@AfterMethod (alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
}
