package com.automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class StartTest {
	
  @BeforeClass
  public void beforeClass() {
  }
  
  
  @Test(priority = 1)
  public void CreateAnAccoutUsingNegativeValues() {
	  HomePage.LoadDriver();
	  Login.CreateAnAccountBefore("invalid");
	  Common.quit();
  }
  
  @Test(priority = 2)
  public void CreateAnAccoutUsingPositiveValues() {
	  HomePage.LoadDriver();
	  Login.CreateAnAccountBefore("valid");
	  Common.quit();
  }

  @Test(priority = 3)
  public void SignInAndCheckout()
  {
	  HomePage.LoadDriver();
	  Login.SignInBefore();
	  ProductPage.SearchProduct();
	  Checkout.CheckoutafterLogin();
	  OrderHistory.CheckOrderHistory();
	  Common.quit();
  }
  
  @Test(priority = 4)
  public void CheckoutAndSignIn()
  {
	  HomePage.LoadDriver();
	  ProductPage.SearchProduct();
	  Checkout.CheckoutbeforeLogin("SignIn");
	  OrderHistory.CheckOrderHistory();
	  Common.quit();
  }
  
  @Test(priority = 5)
  public void CheckoutAndCreateAnAccount()
  {
	  HomePage.LoadDriver();
	  ProductPage.SearchProduct();
	  Checkout.CheckoutbeforeLogin("CreateAnAccount");
	  OrderHistory.CheckOrderHistory();
	  Common.quit();
  }

  @AfterClass
  public void afterClass() {
  }

}
