package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Ulitlity.ExtentreportManager;
import Ulitlity.ReadDate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public ExtentReports report = ExtentreportManager.getReportInstance();
    public ExtentTest logger;
	
	//driver is defined global by which it can be use all page and test class
	//driver is defined as static cause only single copy of driver should be used across the project 
	public static WebDriver driver;
	
	//This method open the browser and enter the url of application
	public void initalization() throws Exception
	{
		String browser = ReadDate.readPropertyFile("browser");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		  
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(ReadDate.readPropertyFile("url"));
		Thread.sleep(3000);	
	}
}
