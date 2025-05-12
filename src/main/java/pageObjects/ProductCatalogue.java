package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.UtilityComponents;

public class ProductCatalogue extends UtilityComponents {
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By productsBy = By.cssSelector(".mb-3");
	
	@FindBy(css=".mb-3")
	List<WebElement> productList;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement submit;
	
	By selectedprod = By.cssSelector(".card-body button:last-of-type");
	By toastContainer = By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return productList;
	}
	
	public WebElement getProductByName(String ProdName)
	{
	
		WebElement prod = getProductList().stream().filter(s->s.findElement(By.cssSelector("b")).getText()
				.equals(ProdName)).findFirst().orElse(null);
		return prod;
		
	}
	

	
	public void addToCart(String ProductName) throws InterruptedException
	{
		WebElement prod = getProductByName(ProductName);
		prod.findElement(selectedprod).click();
		waitForElementToAppear(toastContainer);
		waitForWebElementToDisAppear(spinner);
	}

	
}
