package com.automation;

public class Login {
	
	public static void CreateAnAccount()
	{
		if(Common.isElementPresent(Common.read("sigin")))
		{
			Common.click(Common.read("sigin"));
			
		}
	}
}
