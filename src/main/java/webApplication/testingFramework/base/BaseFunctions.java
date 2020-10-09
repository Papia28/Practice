package webApplication.testingFramework.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import webApplication.testingFramework.seleniumBaseFramework.seleniumBase;

public abstract class BaseFunctions {

	private static WebDriver driver = null;
	
	//constructor for BaseFunctions	
	  public BaseFunctions()
	{ 
		  try { 
			  setBaseDriver(seleniumBase.getDriver());
			  } 
		  catch (Throwable e) 
		  {
			  e.printStackTrace();  
		  } 
	}	 

	// getter method for driver
	public static WebDriver getBaseDriver() {
		return driver;
	}

	// setter method for driver
	public static void setBaseDriver(WebDriver driver) {
		BaseFunctions.driver = driver;
	}

	// method to launch the URL of the application
	public static void launchBaseURL() throws Throwable {
		try {
			String URL = PageObjects.getURL();
			if (URL != "") {
				driver.get(URL);
				Thread.sleep(500);
				System.out.println("URL launched successfully.");
			} else if (URL == "")
				throw new NullPointerException("URL cannot be empty!");
		} catch (Exception e) {
			System.out.println("Error Occured: launchURL()");
			e.printStackTrace();
			throw e;
		}
	}

	// method to return locator type
	public static By getLocator(String locatorType, String locatorValue) throws Throwable {
		try {
			switch (locatorType.toUpperCase()) {
			case "XPATH":
				return By.xpath(locatorValue);
			case "ID":
				return By.id(locatorValue);
			case "NAME":
				return By.name(locatorValue);
			case "LINKTEXT":
				return By.linkText(locatorValue);
			case "PARTIALLINKTEXT":
				return By.partialLinkText(locatorValue);
			case "CSSSELECTOR":
				return By.cssSelector(locatorValue);
			case "TAGNAME":
				return By.tagName(locatorValue);
			case "CLASSNAME":
				return By.className(locatorValue);
			default:
				throw new NullPointerException("No match found for Locators!");
				// TODO correct exception name
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getLocator()");
			throw e;
		}
	}

	// method to find element
	public static WebElement getElement(String locatorType, String locatorValue) throws Throwable {
		try {
			String actuallocatorValue = PageObjects.getActualLocatorValue(locatorValue);
			By locator = getLocator(locatorType, actuallocatorValue);
			System.out.println(locator);
			WebElement element = driver.findElement(locator);
			Thread.sleep(100);
			return element;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getElement()");
			throw e;
		}
	}

	// method to find list of elements
	public static List<WebElement> getElements(String locatorType, String locatorValue) throws Throwable {
		try {
			String actuallocatorValue = PageObjects.getActualLocatorValue(locatorValue);
			By locator = getLocator(locatorType, actuallocatorValue);
			System.out.println(locator);
			List<WebElement> elements = driver.findElements(locator);
			Thread.sleep(100);
			return elements;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getElements()");
			throw e;
		}
	}

	// method to return username
	public static String returnUsername() throws Throwable {
		try {
			String username = PageObjects.getUsername();
			return username;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in returnUsername()");
			throw e;
		}
	}

	// method to return password
	public static String returnPassword() throws Throwable {
		try {
			String password = PageObjects.getPassword();
			return password;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in returnPassword()");
			throw e;
		}
	}
}
