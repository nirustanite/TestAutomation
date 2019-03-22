package com.automation;

import org.testng.Reporter;

public class Checkout extends Common{
     
	public static void CheckoutafterLogin()
	{
		if(Common.isElementPresent(Common.read("carttitle"), "xpath"));
		{
			Common.ScrollWindow();
			Common.click(Common.read("ProceedToCheckoutCart"), "xpath");
			Checkout();
		}
	}
	
	public static void CheckoutbeforeLogin(String value)
	{
		if(Common.isElementPresent(Common.read("carttitle"), "xpath"));
		{
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
	}
	
	public static void Checkout()
	{
		if(Common.getText(Common.read("heading"), "xpath").equalsIgnoreCase("Addresses"))
		{
			Common.click(Common.read("addresscheckout"), "name");
			if(Common.getText(Common.read("heading"), "xpath").equalsIgnoreCase("Shipping"))
			{
				Common.click(Common.read("agreecheckbox"), "name");
				Common.click(Common.read("shippingcheckout"), "name");
				Common.click(Common.read("paymenttype"), "xpath");
				if(Common.isElementPresent(Common.read("heading"), "xpath"))
				{
					
					Common.click(Common.read("confirmorder"), "xpath");
					if(Common.getText(Common.read("heading"),"xpath").equalsIgnoreCase("Order confirmation"))
					{
						Reporter.log("Order is confirmed");
					}
				}
				
			}
		}
	}
}
