package com.automation;

import org.testng.Reporter;

public class Login {
	
	public static String text;
	
	public static void CreateAnAccountBefore(String typeofemail)
	{
		if(Common.isElementPresent(Common.read("sigin"),"xpath"))
		{
			Common.click(Common.read("sigin"),"xpath");
			CreateAnAccount(typeofemail);
		}
		else
		{
			Reporter.log("SignIn not present");
		}
		
	}
	
	public static void CreateAnAccountAFter(String typeofemail)
	{
		CreateAnAccount(typeofemail);
	}
	
	public static void CreateAnAccount(String typeofemail)
	{
			if(Common.isElementPresent(Common.read("createAnAccount"),"xpath"))
			{
				Reporter.log("Create an Account is present");
				if(typeofemail.equalsIgnoreCase("invalid"))
				{
					Common.sendkeys(Common.read("emailid"),"id",Common.read("invalid_email"));
					Common.click(Common.read("createButton"), "name");
					Common.wait(2);
					if(Common.getText(Common.read("accouterror"),"xpath").equalsIgnoreCase("Invalid email address."))
					{
						Reporter.log("Error is diaplayed if invalid email is given");
					}
					else
					{
						Reporter.log("Error is not diaplayed if invalid email is given");
					}
					Common.clear(Common.read("emailid"), "id");
					Common.sendkeys(Common.read("emailid"),"id",Common.RandomGenerator());
					Common.click(Common.read("createButton"), "name");
					Common.wait(2);
					if(Common.isElementPresent(Common.read("personalinfo"),"xpath"))
					{
						Common.ScrollWindow();
						Common.click(Common.read("registerbutton"), "name");
						if(Common.isElementPresent(Common.read("registererror"),"xpath"))
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
					Common.sendkeys(Common.read("emailid"),"id",Common.RandomGenerator());
					Common.click(Common.read("createButton"), "name");
					Common.wait(2);
					if(Common.isElementPresent(Common.read("personalinfo"),"xpath"))
					{
						Common.click(Common.read("title"), "id");
						Common.sendkeys(Common.read("customer_firstname"), "id", Common.read("first_name"));
						Common.sendkeys(Common.read("customer_lastname"), "id", Common.read("last_name"));
						Common.sendkeys(Common.read("password"), "id", Common.read("pass_word"));
						Common.ScrollWindow();
						Common.sendkeys(Common.read("firstname"), "id", Common.read("first_name"));
						Common.sendkeys(Common.read("lastname"), "id", Common.read("last_name"));
						Common.sendkeys(Common.read("address"), "id", Common.read("address_1"));
						Common.sendkeys(Common.read("city"), "id", Common.read("city_1"));
						Common.click(Common.read("stateselect"), "id");
						Common.click(Common.read("state"), "xpath");
						Common.sendkeys(Common.read("postcode"), "id", Common.read("Postalcode_1"));
						Common.sendkeys(Common.read("mobilephone"), "id", Common.read("mobilephone_1"));
						Common.sendkeys(Common.read("adressalias"), "id", Common.read("addressalias_1"));
						Common.click(Common.read("registerbutton"), "name");
						Common.wait(2);
						if(Common.isElementPresent(Common.read("createdaccount"), "xpath"))
						{
							Reporter.log("Account created successfully");
						}
						else
						{
							Reporter.log("Account is not created successfully");
						}
					}
					
				}
			}
			else
			{
				Reporter.log("Create an Account is not present");
			}
	}
	
	public static void SignInBefore()
	{
		Common.click(Common.read("sigin"),"xpath");
		SignIn();
	}
	public static void SignInAfter()
	{
		SignIn();
	}
	
	public static void SignIn()
	{
		if(Common.isElementPresent(Common.read("SignInDirect"), "xpath"))
		{
			Common.sendkeys(Common.read("email"), "id", Common.read("valid_email"));
			Common.sendkeys(Common.read("password"), "id", Common.read("valid_password"));
			Common.click(Common.read("loginbutton"), "id");
			Common.wait(2);
		}
		else
		{
			Reporter.log("SignIn is not present");
		}
	}
}
