package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.UtilityComponents;

public class LandingPage extends UtilityComponents {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		String err = errorMessage.getText();
		return err;
	}
	public ProductCatalogue loginApplication(String uname, String password)
	{
		userName.sendKeys(uname);
		pwd.sendKeys(password);
		submit.click();
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

}
