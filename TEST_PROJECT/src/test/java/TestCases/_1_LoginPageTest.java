package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._1_LoginPage;
import Ulitlity.CaptureScreenshot;
import Ulitlity.ReadDate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _1_LoginPageTest extends TestBase{

	_1_LoginPage login;

  	//This is pre-requsite to run test case
	@BeforeMethod (alwaysRun = true)
	
	  public void setup() throws Exception
	{
	    initalization();
		login = new _1_LoginPage();		
   }
	//Test case to login to application and verify the current URl (inventory page URL)
			@Test  (enabled = true, priority = 4/*, dependsOnMethods = "verifyURLofAppTest"*/,groups = {"Regression","Sanity"})
			
			public void loginToApplicationTest() throws Exception
			{
				String expURL = ReadDate.readExcelFile(1, 2);
				String actURL = login.loginToApplication();
				Assert.assertEquals(expURL, actURL);
				Reporter.log("Current URL of application :- " + actURL);
			}
			//Test case to verify visibility of login_logo
			@Test (enabled = true, priority = 3/*, dependOnMethods = "verifyURLofAppTest"*/,groups = "Smoke")
			
			public void verifyLoginLogoTest()
			{
				boolean result = login.verifyLoginLogo();
				Assert.assertEquals(result, true);
				Reporter.log("visibility of login_logo :- " + result);
			}
			//Test case to verify URL of application (login page URL)
			 
			@Test (enabled = true, priority = 1,groups = {"Smoke","Sanity"})
			
			public void verifyURLofAppTest() throws Exception
			{
				String expURL = ReadDate.readExcelFile(1, 1);
				String actURL = login.verifyURLofApp();
				Assert.assertEquals(expURL, actURL);
				Reporter.log("Origional URL of application:- " + actURL);
			}
			//Test case of verify Title of application
			@Test (enabled = true, priority = 2/*, dependsOnMethods = "verifyURLofAppTest"*/,groups = "Smoke")
			public void verifyTitleTest() throws Exception
			{
				String expTitle = ReadDate.readExcelFile(1, 0);
				String actTitle = login.verifyTitleofApp();
				Assert.assertEquals(expTitle, actTitle);
				Reporter.log("Title of application:- " + actTitle);
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
