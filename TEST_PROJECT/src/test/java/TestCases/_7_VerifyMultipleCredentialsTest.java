package TestCases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages._1_LoginPage;
import Ulitlity.CaptureScreenshot;
import Ulitlity.ReadDate;

public class _7_VerifyMultipleCredentialsTest extends TestBase{

	_1_LoginPage login;

  	//This is pre-requsite to run test case
	@BeforeMethod (alwaysRun = true)
	
	  public void setup() throws Exception
	{
	    initalization();
		login = new _1_LoginPage();		
   }
	
	@Test (dataProvider = "credentials")
	public void loginToAppWithMultipleCredsTest(String un, String pwd) throws Exception
	{
		SoftAssert s = new SoftAssert();
		String expURL = "https://www.saucedemo.com/inventory.html";
		String actURL = login.loginToAppWithMultipleCreds(un, pwd);
		s.assertEquals(expURL, actURL);
		s.assertAll();
	}
	
	@DataProvider (name = "credentials")
	public Object[][] getData()
	{
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user", "standard_user"},
			{"problem_user", "standard_user"},
			{"performance_glitch_user", "secret_sauce"},
			{"standard_user","secret_sauce"}
		};
	}
	
    @AfterMethod (alwaysRun = true)
	
    public void closeBrowser(ITestResult it) throws Exception
	{
		if(it.FAILURE == it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
		}
		
		report.flush();
		driver.close();
	}
}
