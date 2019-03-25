package com.automation;

import org.testng.Reporter;

import com.automation.utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class OrderHistory extends Common{

	public static void CheckOrderHistory()
	{
		Common.click(Common.read("account"), "xpath");
		Common.click(Common.read("orderhistory"), "xpath");
		Common.Explicitwait(Common.read("item"), "xpath");
		if(Common.isElementPresent(Common.read("item"), "xpath"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Ordered item is present in orderhistory");
			if(Common.isElementPresent(Common.read("orderproduct"), "xpath"))
			{
				Common.click(Common.read("orderproduct"), "xpath");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Details of ordered item is present in orderhistory");
				Common.TakeScreenshot("pass");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Details of ordered item is not present in orderhistory");
				Common.TakeScreenshot("fail");
			}
			
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Ordered item is not present in orderhistory");
			Common.TakeScreenshot("fail");
		}
	}
}
