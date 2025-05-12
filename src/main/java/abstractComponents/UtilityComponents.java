package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CartsPage;
import pageObjects.OrdersPage;

public class UtilityComponents 
{
	
	WebDriver driver;
	public UtilityComponents(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	By FindBy = By.cssSelector(".mb-3");
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartsPage;

	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersPage;
	

	public void waitForElementToAppear(By FindBy)
	{
		
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	
	}
	
	public void waitForWebElementToAppear(WebElement FindBy)
	{
		
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(FindBy));
	
	}
	
	public void waitForWebElementToDisAppear(WebElement FindBy) throws InterruptedException
	{
		Thread.sleep(1000);		
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	//wait.until(ExpectedConditions.invisibilityOf(FindBy));
	
	}

	
	public CartsPage goToCartsPage()
	{
		cartsPage.click();
		CartsPage cartsPage = new CartsPage(driver);
		return cartsPage;
		
	}
	
	public OrdersPage gotToOrdersPage()
	{
		ordersPage.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
		
	}
	
	
}
