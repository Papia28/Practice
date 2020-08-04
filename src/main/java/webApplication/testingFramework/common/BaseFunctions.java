package webApplication.testingFramework.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;

import webApplication.testingFramework.seleniumBaseFramework.seleniumBase;

public class BaseFunctions {

	private WebDriver driver = null;
	
	//constructor forBaseFunctions
	
	  public BaseFunctions()
	{ 
		  try { 
			  beforeExecution(); 
			  } 
		  catch (Throwable e) 
		  {
			  e.printStackTrace(); 
			  afterExecution(); 
		  } 
	}
	 

	// getter method for driver
	public WebDriver getBaseDriver() {
		return driver;
	}

	// setter method for driver
	public void setBaseDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	//this should be run before starting any test
	public void beforeExecution() throws Throwable {
		try {
			PageObjects.setReadConfig();
			PageObjects.setPageObjects();
			setBaseDriver(seleniumBase.openBrowser());
		} catch (Exception e) {
			System.out.println("Error occurred: beforeExecution()");
			e.printStackTrace();
			throw e;
		}
	}

	//this should be run after completing any test
	public void afterExecution() {
			seleniumBase.closeBrowser();
	}

	// method to launch the URL of the application
	public void launchBaseURL() throws Throwable {
		try {
			String URL = PageObjects.getURL();
			if (URL != "") {
				driver.get(URL);
				Thread.sleep(2000);
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
	public By getLocator(String locatorType, String locatorValue) throws Throwable {
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
	public WebElement getElement(String locatorType, String locatorValue) throws Throwable {
		try {
			By locator = getLocator(locatorType, locatorValue);
			System.out.println(locator);
			WebElement element = driver.findElement(locator);
			Thread.sleep(500);
			return element;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getElement()");
			throw e;
		}
	}

	// method to find list of elements
	public List<WebElement> getElements(String locatorType, String locatorValue) throws Throwable {
		try {
			By locator = getLocator(locatorType, locatorValue);
			System.out.println(locator);
			List<WebElement> elements = driver.findElements(locator);
			Thread.sleep(500);
			return elements;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getElements()");
			throw e;
		}
	}

	// method to return username
	public String returnUsername() throws Throwable {
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
	public String returnPassword() throws Throwable {
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
