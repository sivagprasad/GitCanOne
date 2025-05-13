package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import pageObjects.CartsPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseTest;


import org.testng.IRetryAnalyzer;
public class ErrorValidations extends BaseTest {

	@Test(groups= {"ErrorHandle"},retryAnalyzer=testComponents.Retry.class)
	//@Test(retryAnalyzer = Retry.class)
		public void LoginErrorValidation() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		String prodName = "IPHONE 13 PRO";
		
		
		landingPage.loginApplication("gorre.sivaprasad@gmail.com", "Sivin0906");
		String error = landingPage.getErrorMessage();
		System.out.println(error);
		Assert.assertEquals(error, "Incorrect email  password.");
		System.out.println("Hello");
		System.out.println("dear sir");
		
		
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException	
	{
		// TODO Auto-generated method stub
		String prodName = "IPHONE 13 PRO";
		String prd = "hello";
		
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("gorre.sivaprasad@gmail.com", "Sivin@0906");
		productCatalogue.addToCart(prodName);
		CartsPage cartsPage =productCatalogue.goToCartsPage();
		boolean match = cartsPage.verifyProduct("IPHONE 133 PRO");
		Assert.assertFalse(match);
		
	}

}
