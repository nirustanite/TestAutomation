package com.automation;

import org.testng.Reporter;

import com.automation.utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends Common{

	public static void LoadDriver()
	{
		Common.LoadDriver();
		Common.getUrl();
		if(Common.isElementPresent(Common.read("logo"),"xpath"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Logo is present");
			ExtentTestManager.getTest().log(LogStatus.PASS, "The Url is loaded");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Logo is not present");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The Url is not loaded");
			Common.TakeScreenshot("fail");
		}
	}
	
	
}

