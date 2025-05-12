package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import abstractComponents.UtilityComponents;

public class CheckoutPage extends UtilityComponents {
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-results button:last-of-type")
	WebElement countrylistEle;
	
	@FindBy(css="[class*='action__submit']")
	WebElement placeOrder;
	By countrylistby = By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryName)
	{
		
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
			
		waitForElementToAppear(countrylistby);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		countrylistEle.click();
		
		
		
	}
	public ConfirmationPage submitOrder()
	{
		placeOrder.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
	

}
