package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class ProductPage extends Common{
	
	public static void SearchProduct()
	{
		Common.clear(Common.read("searchquery"), "id");
		Common.sendkeys(Common.read("searchquery"), "id", Common.read("searchvalue"));
		Common.Explicitwait(Common.read("search_button"), "name");
		Common.click(Common.read("search_button"), "name");
		if(Common.isElementPresent(Common.read("instock"), "xpath"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "The product is in stock");
			Common.mouseover(Common.read("instock"), "xpath");
			Common.Explicitwait(Common.read("addtocart"), "xpath");
			Common.click(Common.read("addtocart"), "xpath");
			Common.Explicitwait(Common.read("ProceedToCheckout"), "xpath");
			Common.click(Common.read("ProceedToCheckout"), "xpath");
			Common.wait(4);
			//Common.Explicitwait(Common.read("carttitle"), "xpath");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The product is not in stock");
		}
		
		
		
	}
}
