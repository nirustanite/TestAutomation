package com.automation;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.automation.utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Common {

	public static String value;
	public static WebDriver driver;
	public static WebElement element;
    public static int count;
	
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
	
	
	public static WebElement findElement(String value,String type)
	{

		if(type.equalsIgnoreCase("xpath"))
		{
			element = driver.findElement(By.xpath(value));
		}
		else if(type.equalsIgnoreCase("id"))
		{
			element = driver.findElement(By.id(value));
		}
		else if(type.equalsIgnoreCase("name"))
		{
			element = driver.findElement(By.name(value));
		}
		
		return element;
	}

	public static void click(String value,String type)
	{
		findElement(value, type).click();
	}
	
	public static void sendkeys(String selectorvalue,String type,String value)
	{
		findElement(selectorvalue,type).sendKeys(value);;
	}
	
	public static String getText(String value,String type)
	{

		String val=findElement(value,type).getText();
		return val;
	}
	
	public static void clear(String value,String type)
	{
		findElement(value, type).clear();
	}
	
	
	public static void wait(int seconds)
	{
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean isElementPresent(String value,String type)
	{
		try
		{
			findElement(value,type);
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
	
	public static void quit()
	{
		driver.close();
		driver.quit();
	}
	
	public static String RandomGenerator()
	{
		String email;
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		email="testusername"+ randomInt +"@gmail.com";
		return email;
	}
	
	public static void mouseover(String value,String type)
	{
		WebElement wb = findElement(value, type);
		Actions builder = new Actions(driver);
		builder.moveToElement(wb).build().perform();
	}
	
	public static void TakeScreenshot(String result)
	{
		 String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
	                getScreenshotAs(OutputType.BASE64);
		 
		 if(result.equalsIgnoreCase("pass"))
		 {
			 ExtentTestManager.getTest().log(LogStatus.PASS,"Step passed",
		                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		 }
		 else
		 {
			 ExtentTestManager.getTest().log(LogStatus.PASS,"Step passed",
		                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		 }
	       
	}
	
	public static void Explicitwait(String value,String type)
	{
		WebDriverWait wait = new WebDriverWait(driver,120);
		WebElement wb;
		if(type.equalsIgnoreCase("xpath"))
		{
			wb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
		}
		else if(type.equalsIgnoreCase("id"))
		{
			wb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
		}
		else if(type.equalsIgnoreCase("name"))
		{
			wb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
		}
		 
	}
	

	

}
