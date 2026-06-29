package Ulitlity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdown {

	//This method automate the drop down using select class
	public static void handleSelectClass(WebElement ele,String value)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(value);
	}
}
