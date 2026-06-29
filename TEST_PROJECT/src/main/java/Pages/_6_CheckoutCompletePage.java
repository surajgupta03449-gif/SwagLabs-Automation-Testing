package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _6_CheckoutCompletePage extends TestBase {

	//Explore the successful
	@FindBy(xpath = "//span[@class='title']") private WebElement checkoutCompleteLabel1;
	@FindBy(xpath = "//h2[@class='complete-header']") private WebElement checkoutCompleteLabel2;
	@FindBy(xpath = "//div[@class='complete-text']") private WebElement checkoutCompleteLabel3;
	@FindBy(xpath = "//img[@class='pony_express']") private WebElement ponyLogo;
	
	public _6_CheckoutCompletePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String verifyCompletePageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyChecoutCompleteLabel1()
	{
		return checkoutCompleteLabel1.getText();
	}
	
	public String verifyCheckoutCompleteLbel2()
	{
		return checkoutCompleteLabel2.getText();
	}
	
	public String verifyCheckoutCompleteLabel3()
	{
		return checkoutCompleteLabel3.getText();
	}
	public boolean verifyPonyLogo()
	{
		 return ponyLogo.isDisplayed();
	}
}
