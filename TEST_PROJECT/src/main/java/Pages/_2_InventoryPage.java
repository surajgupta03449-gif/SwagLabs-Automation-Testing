package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Ulitlity.HandleDropdown;
import Ulitlity.ReadDate;

public class _2_InventoryPage extends TestBase {

	//Object Reap
	@FindBy(xpath = "//span[@class='title']") private WebElement productLabel;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement productSortDropdown;
	@FindBy(xpath = "//li[@class='social_twitter']//a") private WebElement twitterLogo;
	@FindBy(xpath = "//li[@class='social_facebook']//a") private WebElement fbLogo;
	@FindBy(xpath = "//li[@class='social_linkedin']//a") private WebElement linkedinLogo;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProducts;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltBlackTshirtProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketProducts;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement boltRedTshirtProduct ;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement rebTshirtProduct;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;

	//Remove the product form add cart
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpackProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement removebikeLightProducts;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeboltBlackTshirtProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removejacketProducts;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement removeboltRedTshirtProduct ;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removerebTshirtProduct;

	public _2_InventoryPage()
	{
		PageFactory.initElements(driver, this);	
		
	}
	
	//Method to verify the label
	public String verifyLabel()
	{
		return productLabel.getText();
	}	
	
	//Method to verify the Twitter_logo
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}	
	
	//Method to verify the facebook_logo
	public boolean verifyFbLogo()
	{
		return fbLogo.isDisplayed();
	}	
	
	//Method to verify the linkedin_logo
	public boolean verifyLinkedinLogo()
	{
		return linkedinLogo.isDisplayed();
	}	
	
	//method to verify the added Products
	public String add6Product() throws Exception
	{
	
		HandleDropdown.handleSelectClass(productSortDropdown, ReadDate.readExcelFile(0, 0));
		Thread.sleep(2000);
		backpackProduct.click();
		Thread.sleep(1000);
		bikeLightProducts.click();
		Thread.sleep(1000);
		boltBlackTshirtProduct.click();
		Thread.sleep(1000);
		jacketProducts.click();
		Thread.sleep(1000);
		boltRedTshirtProduct.click();
		Thread.sleep(1000);
		rebTshirtProduct.click();
		Thread.sleep(1000);
		return cartCount.getText();
	}
	
	//Method to verify the removed Product from cart
	public String remove2Products() throws Exception
	{
		add6Product();
		Thread.sleep(1000);
		removebackpackProduct.click();
		Thread.sleep(1000);
		removebikeLightProducts.click();
		Thread.sleep(1000);
		return cartCount.getText();
	}
	
	public void clickCartIcon()
	{
		cartCount.click();
	}
}
