package com.automation;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Common {

	public static String value;
	public static WebDriver driver;
	
	public static String read(String key)
	{
		try {
			File file = new File("resources/config.properties");
			FileInputStream fileinput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileinput);
			fileinput.close();
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void LoadDriver()
	{
		System.setProperty("webdriver.chrome.driver",read("chromedriverpath"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	public static void getUrl()
	{
		driver.get(Common.read("OpenUrl"));
	}
	
	public static void click(String value,String type)
	{
		if(type.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(value)).click();
		}
		else if(type.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(value)).click();
		}
		else if(type.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(value)).click();
		}
		
	}
	
	public static void sendkeys(String selectorvalue,String type,String value)
	{
		if(type.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(selectorvalue)).sendKeys(value);;
		}
		else if(type.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(selectorvalue)).sendKeys(value);
		}
	}
	
	public static String getText(String xpath)
	{

		String val=driver.findElement(By.xpath(xpath)).getText();
		return val;
	}
	
	public static void clear(String value,String type)
	{

		if(type.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(value)).clear();
		}
		else if(type.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(value)).clear();
		}
		else if(type.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(value)).clear();
		}
		
	}
	
	public static void wait(int seconds)
	{
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean isElementPresent(String xpath)
	{
		try
		{
			driver.findElement(By.xpath(xpath));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public static void ScrollWindow()
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,1000)");
	}
}
