package com.automation;

import org.testng.Reporter;

public class OrderHistory extends Common{

	public static void CheckOrderHistory()
	{
		Common.click(Common.read("account"), "xpath");
		Common.click(Common.read("orderhistory"), "xpath");
		Common.wait(2);
		if(Common.isElementPresent(Common.read("item"), "xpath"))
		{
			Reporter.log("ordered item is present in orderhistory");
		}
		else
		{
			Reporter.log("ordered item is present in orderhistory");
		}
	}
}
