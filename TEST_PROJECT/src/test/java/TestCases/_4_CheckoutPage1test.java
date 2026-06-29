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
import Pages._4_CheckoutPage1;
import Ulitlity.ReadDate;

public class _4_CheckoutPage1test extends TestBase{

	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;
	_4_CheckoutPage1 check1;
	
	//Test the Checkout of page
	@BeforeMethod (alwaysRun = true)
	public void setup() throws Exception
	{
		initalization();
		login = new _1_LoginPage();
		invent = new _2_InventoryPage();
		cart = new _3_CartPage();
		check1 = new _4_CheckoutPage1();
		login.loginToApplication();
		invent.add6Product();
		invent.clickCartIcon();
		cart.clickCheckoutBtn();
	}
	
	//Test the verify visibility of checkout_URL
	@Test (groups = "Smoke")
	public void verifyCheckoutPage1URl() throws Exception
	{
		String expURL = ReadDate.readExcelFile(1, 8);
		String actURL = check1.verifyCheckoutPage1URl();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of checkout page :- " + actURL);
	}
	
	//Test the verify visibility of checkout_label
	@Test (groups = {"Smoke","Sanity"})
	public void verifyCheckoutPage1Label() throws Exception
	{
		String expLabel = ReadDate.readExcelFile(1, 9);
		String actLabel = check1.verifyCheckoutPage1Label();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Checkout Page Label :-" + actLabel);
	}
	
	//Test the verify visibility of checkout_info
	@Test (groups = "Sanity")
	public void inputCheckoutInfo() throws Exception
	{
		String expURL = ReadDate.readExcelFile(1, 10);
		String actURL = check1.inputCheckoutInfo();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of checkout page 2:-" + actURL);
	}
	
	//Test the visibility of close_browser
	@AfterMethod (alwaysRun = true)
	
	public void closeBrowser()
	{
		driver.close();
	}
}
