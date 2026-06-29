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
import Pages._5_CheckoutPage2;
import Ulitlity.ReadDate;

public class _5_CheckoutPage2Test extends TestBase{

	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;
	_4_CheckoutPage1 check1;
	_5_CheckoutPage2 check2;
	
	//Test the Checkout2 Page
	@BeforeMethod (alwaysRun = true)
	public void setup() throws Exception
	{
		initalization();
		login = new _1_LoginPage();
		invent = new _2_InventoryPage();
		cart = new _3_CartPage();
		check1 = new _4_CheckoutPage1();
		check2 = new _5_CheckoutPage2();
		login.loginToApplication();
		invent.add6Product();
		invent.clickCartIcon();
		cart.clickCheckoutBtn();
		check1.inputCheckoutInfo();
//		check1.clickContinueBtn();
	}
	
	//Test the verify visibility of checkout_label
	@Test (groups = {"Smoke","Sanity"})
	
	public void verifyCheckoutPage2LabelTest() throws Exception
	{
		String expLabel = ReadDate.readExcelFile(1, 11);
		String actLabel = check2.verifyCheckoutPage2Label();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Checkout Page2 of label :-" + actLabel);
	}
	//Test the verify the payment
	@Test (groups = "Smoke")
	public void verifypaymentInfoLabelTest() throws Exception
	{
		String expLabel = ReadDate.readExcelFile(1, 12);
		String actLabel = check2.verifypaymentInfoLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Checkout Page2 of payment :-" + actLabel);
	}
	//Test the verify shipping  
	@Test (groups = "Smoke")
	public void verifyshippingInfoLabelTest() throws Exception
	{
		String expLabel = ReadDate.readExcelFile(1, 13);
		String actLabel = check2.verifyshippingInfoLabel();
    	Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Checkout Page2 of shipping :-" + actLabel);
	}
	//Test the verify the total_amount
	@Test (groups = "Smoke")
	public void verifytotalAmountLabelTest() throws Exception
	{
		String expLabel = ReadDate.readExcelFile(1, 14);
		String actLabel = check2.verifytotalAmountLabel();
    	Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Checkout Page2 of Total amount :-" + actLabel);
	}

	@AfterMethod (alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
	
	
}
