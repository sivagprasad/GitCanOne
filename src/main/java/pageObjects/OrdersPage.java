package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.UtilityComponents;

public class OrdersPage extends UtilityComponents {
	
	WebDriver driver;
	public OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	
	public Boolean VerifyOrderDisplay(String ProdName)
	{
		Boolean match = productNames.stream().anyMatch(s->s.getText().equalsIgnoreCase(ProdName));
		return match;
	}
	

}
