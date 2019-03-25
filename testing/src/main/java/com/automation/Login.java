package com.automation;

import org.testng.Reporter;

import com.automation.utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class Login {
	
	public static String text;
	
	public static void CreateAnAccountBefore(String typeofemail)
	{
		if(Common.isElementPresent(Common.read("sigin"),"xpath"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Sign In option is present in homepage");
			Common.click(Common.read("sigin"),"xpath");
			CreateAnAccount(typeofemail);
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Sign In option is not present in homepage");
			Common.TakeScreenshot("fail");
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
				ExtentTestManager.getTest().log(LogStatus.PASS, "Create an Account is present");
				if(typeofemail.equalsIgnoreCase("invalid"))
				{
					Common.sendkeys(Common.read("emailid"),"id",Common.read("invalid_email"));
					Common.click(Common.read("createButton"), "name");
					Common.Explicitwait(Common.read("accouterror"), "xpath");
					if(Common.getText(Common.read("accouterror"),"xpath").equalsIgnoreCase("Invalid email address."))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Error is diaplayed if invalid email is given");	
						Common.TakeScreenshot("pass");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Error is not diaplayed if invalid email is given");
						Common.TakeScreenshot("fail");
					}
					Common.clear(Common.read("emailid"), "id");
					Common.sendkeys(Common.read("emailid"),"id",Common.RandomGenerator());
					Common.click(Common.read("createButton"), "name");
					Common.wait(3);
					if(Common.isElementPresent(Common.read("personalinfo"),"xpath"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "The Personal information page is navigated successfully");
						Common.ScrollWindow();
						Common.click(Common.read("registerbutton"), "name");
						if(Common.isElementPresent(Common.read("registererror"),"xpath"))
						{
							ExtentTestManager.getTest().log(LogStatus.PASS, "Error is diaplayed if invalid details are given");
							Common.TakeScreenshot("pass");
						}
						else
						{
							Reporter.log("Error is not diaplayed if invalid details are given");
							Common.TakeScreenshot("fail");
						}
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "The Personal information page is not navigated successfully");
						Common.TakeScreenshot("fail");
					}
				}
				else
				{
					Common.sendkeys(Common.read("emailid"),"id",Common.RandomGenerator());
					Common.click(Common.read("createButton"), "name");
					Common.wait(3);
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
					    Common.wait(3);
						if(Common.isElementPresent(Common.read("createdaccount"), "xpath"))
						{
							ExtentTestManager.getTest().log(LogStatus.PASS, "Account created successfully");
							Common.TakeScreenshot("pass");
						}
						else
						{
							ExtentTestManager.getTest().log(LogStatus.FAIL, "Account is not created successfully");
					        Common.TakeScreenshot("fail");
						}
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Personal info page is not navigated");
						Common.TakeScreenshot("fail");
					}
					
				}
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Create an Account is not present");
				Common.TakeScreenshot("fail");
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
			ExtentTestManager.getTest().log(LogStatus.PASS, "Sign In option is available");
			Common.sendkeys(Common.read("email"), "id", Common.read("valid_email"));
			Common.sendkeys(Common.read("password"), "id", Common.read("valid_password"));
			Common.click(Common.read("loginbutton"), "id");
			//Common.wait(2);
			Common.Explicitwait(Common.read("heading"), "xpath");
			if(Common.getText(Common.read("heading"), "xpath").equalsIgnoreCase("My account"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Signed In successfully");
				
			}
			else if(Common.getText(Common.read("heading"), "xpath").equalsIgnoreCase("Addresses"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Signed In successfully");
			}
			else
			{	
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Sign In  not successfull");
				Common.TakeScreenshot("fail");
			}
			
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Sign In option is not available");
			Common.TakeScreenshot("fail");
		}
	}
}
