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
	  Login.CreateAnAccount("invalid");
	  Common.quit();
  }
  
  @Test(priority = 2)
  public void CreateAnAccoutUsingPositiveValues() {
	  HomePage.LoadDriver();
	  Login.CreateAnAccount("valid");
	  Common.quit();
  }


  @AfterClass
  public void afterClass() {
  }

}
