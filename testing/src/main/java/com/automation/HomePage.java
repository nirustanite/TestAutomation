package com.automation;

import org.testng.Reporter;

public class HomePage extends Common{

	public static void LoadDriver()
	{
		Common.LoadDriver();
		Common.getUrl();
		if(Common.isElementPresent(Common.read("logo")))
		{
			Reporter.log("Logo is present");
		}
		else
		{
			Reporter.log("Logo is not present");
		}
	}
	
	
}

