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
import Pages._6_CheckoutCompletePage;
import Ulitlity.ReadDate;

public class _6_CheckoutCompletePageTest extends TestBase{

	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;
	_4_CheckoutPage1 check1;
	_5_CheckoutPage2 check2;
	_6_CheckoutCompletePage check3;
	
	@BeforeMethod (alwaysRun = true)
	
	public void setup() throws Exception
	{
		initalization();
		login = new _1_LoginPage();
		invent = new _2_InventoryPage();
		cart = new _3_CartPage();
		check1 = new _4_CheckoutPage1();
		check2 = new _5_CheckoutPage2();
		check3 = new _6_CheckoutCompletePage();
		login.loginToApplication();
		invent.add6Product();
		invent.clickCartIcon();
		cart.clickCheckoutBtn();
		check1.inputCheckoutInfo();
		check2.clickFinishBtn();
//		check1.clickContinueBtn();
	}
	
	@Test (groups = "Smoke")
	
	public void verifyCompletePageURLTest() throws Exception
	{
		String expURL = ReadDate.readExcelFile(1, 15);
		String actURL = check3.verifyCompletePageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of checkout :- " + actURL);
	}
	@Test (groups = "Smoke")
	public void verifyChecoutCompleteLabel1Test() throws Exception
	{
		String expLabel = ReadDate.readExcelFile(1, 16);
		String actLabel = check3.verifyChecoutCompleteLabel1();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Checkout Page3 Label :- " + actLabel);
	}
	@Test (groups = "Smoke")
	public void verifyCheckoutCompleteLbel2Test() throws Exception
	{
		String expLabel = ReadDate.readExcelFile(1, 17);
		String actLabel = check3.verifyCheckoutCompleteLbel2();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Checkout Page3 Label :- " + actLabel);
	}
	@Test (groups = "Somke")
	public void verifyCheckoutCompleteLabel3Test() throws Exception
	{
		String expLabel = ReadDate.readExcelFile(1, 18);
		String actLabel = check3.verifyCheckoutCompleteLabel3();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Checkout Page3 Label :-" + actLabel);
	}
	@Test (groups = "Smoke")
	public void verifyPonyLogoTest()
	{
		boolean result = check3.verifyPonyLogo();
		Assert.assertEquals(result, true);
	}

	@AfterMethod (alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
}
