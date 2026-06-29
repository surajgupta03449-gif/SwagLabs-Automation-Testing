package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _3_CartPage extends TestBase {

	// Checkout the cartIncon
	@FindBy (xpath = "//span[@class='title']") private WebElement cartLabel;
	@FindBy (xpath = "//button[@id='checkout']") private WebElement checkoutBtn;
	
	public _3_CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCartPageURL()
	{
		return driver.getCurrentUrl();		
	}
	
	public String verifyCartLabel()
	{
		return cartLabel.getText();		
	}
	
	public void clickCheckoutBtn()
	{
		checkoutBtn.click();
	}
}
