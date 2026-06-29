package Ulitlity;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class CaptureScreenshot extends TestBase{
	
	//Method to take screenshot when test case get failed
	public static void screenshot(String nameofMethod) throws Exception
	{
		Date date = new Date();
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\hp\\eclipse-workspace\\TEST_PROJECT\\Screenshots/" + nameofMethod + "---" +  date.toString().replace(":", "_") + ".jpeg");
		FileHandler.copy(source, dest);
	}
	
}
