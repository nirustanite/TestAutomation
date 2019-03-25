package com.automation;

import org.testng.Reporter;

import com.automation.utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class Checkout extends Common{
     
	public static void CheckoutafterLogin()
	{
		if(Common.isElementPresent(Common.read("carttitle"), "id"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "The cart page is navigated");
			Common.ScrollWindow();
			Common.click(Common.read("ProceedToCheckoutCart"), "xpath");
			Checkout();
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The cart page is not navigated");
			Common.TakeScreenshot("fail");
		}
	}
	
	public static void CheckoutbeforeLogin(String value)
	{
		if(Common.isElementPresent(Common.read("carttitle"), "id"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "The cart page is navigated");
			Common.ScrollWindow();
			Common.click(Common.read("ProceedToCheckoutCart"), "xpath");
			if(value.equalsIgnoreCase("CreateAnAccount"))
			{
				Login.CreateAnAccountAFter("valid");
			}
			else
			{
				Login.SignInAfter();
			}
			Checkout();
			
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The cart page is not navigated");
			Common.TakeScreenshot("fail");
		}
	}
	
	public static void Checkout()
	{
		if(Common.getText(Common.read("heading"), "xpath").equalsIgnoreCase("Addresses"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "The address tab is navigated");
			Common.click(Common.read("addresscheckout"), "name");
			if(Common.getText(Common.read("heading"), "xpath").equalsIgnoreCase("Shipping"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "The shipping tab is navigated");
				Common.click(Common.read("agreecheckbox"), "name");
				Common.click(Common.read("shippingcheckout"), "name");
				Common.click(Common.read("paymenttype"), "xpath");
				if(Common.isElementPresent(Common.read("heading"), "xpath"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "The payment tab is navigated");
					Common.click(Common.read("confirmorder"), "xpath");
					if(Common.getText(Common.read("heading"),"xpath").equalsIgnoreCase("Order confirmation"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Order is confirmed");
						Common.TakeScreenshot("pass");
						OrderHistory.CheckOrderHistory();
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Order is not confirmed");
						Common.TakeScreenshot("fail");
					}
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "The payment tab is not navigated");
					Common.TakeScreenshot("fail");
				}	
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "The shipping tab is not navigated");
				Common.TakeScreenshot("fail");
			}
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The address tab is not navigated");
			Common.TakeScreenshot("fail");
		}
	}
}
