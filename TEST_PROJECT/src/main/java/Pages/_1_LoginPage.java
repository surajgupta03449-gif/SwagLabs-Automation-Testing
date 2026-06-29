package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import Ulitlity.ReadDate;

public class _1_LoginPage extends TestBase {

	//object Repository
	@FindBy(xpath ="//div[@class='login_logo']") private WebElement loginLogo;
	@FindBy(xpath ="//input[@id='user-name']") private WebElement usernameTextbox;
	@FindBy(xpath ="//input[@id='password']") private WebElement passwordTextbox;
	@FindBy(xpath ="//input[@id='login-button']") private WebElement loginBtn;

	//Constructor to initialize the web element (current class members)
	public _1_LoginPage()
	{
		PageFactory.initElements(driver, this);// connect to current class member:
	}
	//Method to login in application
			public String loginToApplication() throws Exception
			{
				logger = report.createTest("Login to Sauce Lab Application");
				usernameTextbox.sendKeys(ReadDate.readPropertyFile("username"));
				logger.log(Status.INFO, "Username is entered");
				passwordTextbox.sendKeys(ReadDate.readPropertyFile("password"));
				logger.log(Status.INFO, "Password is entered");
				loginBtn.click();
				logger.log(Status.INFO, "Login button is clicked");
				logger.log(Status.PASS, "Login is Successful");
				return driver.getCurrentUrl();
			}
			//Method to verify login_logo
			public boolean verifyLoginLogo()
			{
				logger = report.createTest("Test Case of Verify Login Logo");
				logger.log(Status.INFO, "Logo is diisplayed");
				logger.log(Status.PASS, "Login Logo verification is passed ");
				return loginLogo.isDisplayed();
			}
			//Method to verify Title of application 
			public String verifyTitleofApp()
			{
				logger = report.createTest("Test Case of Verify Application Title");
				logger.log(Status.INFO, "Application Title is available");
				logger.log(Status.PASS, "Application Title is verified");
				return driver.getTitle();
			}
			//Method to verify URL of application
			public String verifyURLofApp()
			{
				logger = report.createTest("Test Case of Verify URL of application");
				logger.log(Status.INFO, "URL of application is available");
				logger.log(Status.PASS, "URl of application is verified");
				return driver.getCurrentUrl();
			}
			//Method to verify multiple set of data
			public String loginToAppWithMultipleCreds(String un, String pwd) throws Exception
			{
				usernameTextbox.sendKeys(un);
				passwordTextbox.sendKeys(pwd);
				loginBtn.click();
				return driver.getCurrentUrl();
			}

}

