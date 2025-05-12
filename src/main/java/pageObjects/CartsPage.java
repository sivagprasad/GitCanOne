package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractComponents.UtilityComponents;

public class CartsPage extends UtilityComponents {
	
	WebDriver driver;
	public CartsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutEle;
	

	public boolean verifyProduct(String prodName)
	{
		boolean match = cartProducts.stream().anyMatch(s->s.getText().equals(prodName));
		return match;
	}
	
	public CheckoutPage checkOutPage()
	{
		checkOutEle.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
		
	

}
