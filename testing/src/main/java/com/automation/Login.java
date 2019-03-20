package com.automation;

import org.testng.Reporter;

public class Login {
	
	public static String text;
	public static void CreateAnAccount(String typeofemail)
	{
		if(Common.isElementPresent(Common.read("sigin")))
		{
			Common.click(Common.read("sigin"),"xpath");
			if(Common.isElementPresent(Common.read("createAnAccount")))
			{
				Reporter.log("Create an Account is present");
				if(typeofemail.equalsIgnoreCase("invalid"))
				{
					Common.sendkeys(Common.read("emailid"),"id",Common.read("invalid_email"));
					Common.click(Common.read("createButton"), "name");
					Common.wait(2);
					if(Common.getText(Common.read("accouterror")).equalsIgnoreCase("Invalid email address."))
					{
						Reporter.log("Error is diaplayed if invalid email is given");
					}
					else
					{
						Reporter.log("Error is not diaplayed if invalid email is given");
					}
					Common.clear(Common.read("emailid"), "id");
					Common.sendkeys(Common.read("emailid"),"id",Common.read("valid_email"));
					Common.click(Common.read("createButton"), "name");
					Common.wait(2);
					if(Common.isElementPresent(Common.read("personalinfo")))
					{
						Common.ScrollWindow();
						Common.click(Common.read("registerbutton"), "name");
						if(Common.isElementPresent(Common.read("registererror")))
						{
							Reporter.log("Error is diaplayed if invalid details are given");
						}
						else
						{
							Reporter.log("Error is not diaplayed if invalid details are given");
						}
					}
				}
				else
				{
					
				}
			}
			else
			{
				Reporter.log("Create an Account is not present");
			}
		}
		else
		{
			Reporter.log("SignIn not present");
		}
	}
}
