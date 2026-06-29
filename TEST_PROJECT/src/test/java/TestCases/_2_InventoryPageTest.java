package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._1_LoginPage;
import Pages._2_InventoryPage;
import Ulitlity.ReadDate;

public class _2_InventoryPageTest extends TestBase{
	
	_1_LoginPage login;
	_2_InventoryPage invent;
	
	// Test the Inventory Invent 
     @BeforeMethod (alwaysRun = true)
     public void setup() throws Exception
	{
		initalization();
		login = new _1_LoginPage();
		invent = new _2_InventoryPage();
		login.loginToApplication();
	}
     //Test case to verify the label
     @Test(enabled = false, groups = "Smoke")
     public void verifyLabelTest() throws Exception
     {
    	 String expLabel = ReadDate.readExcelFile(1, 3);
    	 String actLabel = invent.verifyLabel();
    	 Assert.assertEquals(expLabel, actLabel);
    	 Reporter.log("Label Title :- " + actLabel);
     }
     //Test case to verify added products
     @Test (enabled = false, groups = {"Regression", "Sanity"}, invocationCount = 3)
     public void add6ProductTest() throws Exception
     {
    	String expCount = ReadDate.readExcelFile(1, 4);
   	    String actCount = invent.add6Product();
   	    Assert.assertEquals(expCount, actCount);
   	    Reporter.log("Total Product added  :- " + actCount);  	    
     }
     //Test case to verify visibility of Twitter_Logo
     @Test (enabled = false, groups = "Smoke")
     public void verifyTwitterLogoTest()
     {
    	boolean result = invent.verifyTwitterLogo();
    	Assert.assertEquals(result, true);
    	Reporter.log("Visibility of Twitter logo :- " + result);
     }
     //Test case to verify visibility of Facebook_Logo
     @Test (enabled = false, groups = "Smoke")
     public void verifyFbLogoTest()
     {
    	boolean result = invent.verifyFbLogo();
    	Assert.assertEquals(result, true);
    	Reporter.log("Visibility of fb logo :- " + result);
     }
     //Test case to verify visibility of Linkedin_Logo
     @Test (enabled = false, groups = "Smoke")
     public void verifyLinkedinLogoTest()
     {
    	boolean result = invent.verifyLinkedinLogo();
    	Assert.assertEquals(result, true);
    	Reporter.log("Visibility of Linkedin Logo :-" + result);
     }  
     //Test case to verify remove Products
     @Test (enabled = true, groups = {"Regression", "Sanity"}, timeOut = 30000)
     public void remove3ProductsTest() throws Exception
     {
    	 String expCount = ReadDate.readExcelFile(1, 5);
    	 String actCount = invent.remove2Products();
    	 Assert.assertEquals(expCount, actCount);
    	 Reporter.log("Count of Product after removing :- " + actCount);
     }
     //Test the visibility of Close_browser
     @AfterMethod (alwaysRun = true)
      public void closeBrowser()
   { 
	  driver.close();
   }
}
