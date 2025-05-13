package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartsPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.OrdersPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseTest;

public class StandAlone extends BaseTest {
	String prodName = "IPHONE 13 PRO";
	
	@Test
	public void getDatad()
	{
		System.out.println("This is my life");
	}
	@Test(dataProvider="getData",groups="Purchase")
	public void SubmitOrder(HashMap<String,String>input) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		productCatalogue.addToCart(input.get("product"));
		CartsPage cartsPage =productCatalogue.goToCartsPage();
		boolean match = cartsPage.verifyProduct(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartsPage.checkOutPage();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String Actualmsg =confirmationPage.getConfirmationMessage();
		Assert.assertEquals(Actualmsg, "THANKYOU FOR THE ORDER.");
		//driver.close();
	}
	
	@Test
	public void submittwo() throws IOException	
	{
		System.out.println("hello");
		//driver.close();
	}
	
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication("gorre.sivaprasad@gmail.com", "Sivin@0906");
		OrdersPage ordersPage = productCatalogue.gotToOrdersPage();
		boolean match = ordersPage.VerifyOrderDisplay(prodName);
		Assert.assertTrue(match);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
	//	List<HashMap<String,String>> data =getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\data\\PurchaseOrder.json");
	//	return new Object[][] {{data.get(0)},{data.get(1)}};
		
	//HashMap
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("email" , "gorre.sivaprasad@gmail.com");
		map.put("password", "Sivin@0906");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String, String> map1 = new HashMap<String,String>();
		map1.put("email" , "vinneith@gmail.com");
		map1.put("password", "Sivin@0906");
		map1.put("product", "IPHONE 13 PRO");
		
		return new Object[][] {{map},{map1}};
		
		/* DATA READER
		return new Object[][] {{"gorre.sivaprasad@gmail.com", "Sivin@0906","ZARA COAT 3"}
								,{"vinneith@gmail.com","Sivin@0906","IPHONE 13 PRO"}};
								
								*/
	}

}
