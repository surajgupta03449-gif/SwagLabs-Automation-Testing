package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Ulitlity.ReadDate;

public class _4_CheckoutPage1 extends TestBase {

	//Explore the Continue_Btn
	@FindBy(xpath = "//span[@class='title']") private WebElement checkout1Label;
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstnameTextbox;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastnameTextbox;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement zipcodeTextbox;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
	
	public _4_CheckoutPage1()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckoutPage1URl()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyCheckoutPage1Label()
	{
		return checkout1Label.getText();
	}
	
	public String inputCheckoutInfo() throws Exception
	{
		firstnameTextbox.sendKeys(ReadDate.readExcelFile(0, 1));
		lastnameTextbox.sendKeys(ReadDate.readExcelFile(0, 2));
		zipcodeTextbox.sendKeys(ReadDate.readExcelFile(0, 3));
		continueBtn.click();
		return driver.getCurrentUrl();
	}
	public void clickContinueBtn()
	{
		continueBtn.click();
	}
}

