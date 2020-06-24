package webApplication.testingFramework.seleniumBaseFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.safari.SafariDriver;

public class seleniumBaseDriver extends seleniumBaseDriverManager 
{
	private static WebDriver baseDriver = null;

	//getter method for driver
	protected WebDriver getBaseDriver() 
	{
		return baseDriver;
	}
	
	//setter method for driver
	protected void setBaseDriver() throws Throwable
	{
		try {
			seleniumBaseDriver.baseDriver = setSeleniumBaseDriver();
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in setting driver!");
		}
	}
	
	
	//method to provide value to driver as per the browser
	private WebDriver setSeleniumBaseDriver() throws Exception {
		try {
			//return proper WebDriver object
			switch (getBrowser()) 
			{
			case "Chrome":
				System.out.println("Browser is Chrome!");
				return new ChromeDriver();
				
			case "Firefox":
				System.out.println("Browser is Firefox!");
				return new FirefoxDriver();
				
			case "Internet Explorer":
				System.out.println("Browser is Internet Explorer!");
				return new InternetExplorerDriver();
				
			case "Microsoft Edge":
				System.out.println("Browser is Microsoft Edge!");
				return new EdgeDriver();
				
			case "Headless":
				System.out.println("Browser is Headless!");
				return new HtmlUnitDriver();
				
			//TODO safari
				
			default:
				throw new NullPointerException("Browser not specified!");
			}			
		}
		catch (Exception e) 
		{
			System.out.println("Error occurred: setSeleniumBaseDriver()");
			e.printStackTrace();
			throw e;
		}
	}
}
