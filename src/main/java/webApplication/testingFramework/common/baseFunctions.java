package webApplication.testingFramework.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import webApplication.testingFramework.seleniumBaseFramework.seleniumBase;

public class baseFunctions {

	private static WebDriver driver = null;
	private static final seleniumBase sb = new seleniumBase();
	
	//getter method for driver
	public static WebDriver getDriver() {
		return driver;
	}

	//setter method for driver
	public static void setDriver(WebDriver driver) {
		baseFunctions.driver = driver;
	}

	@BeforeSuite
	public static void openBrowser() throws Throwable {
		try {
			setDriver(sb.beforeExecution());
		} catch (Exception e) {
			System.out.println("Error occurred: openBrowser()");
			e.printStackTrace();
			throw e;
		}
	}

	@AfterSuite
	public static void closeBrowser() throws Throwable {
		try {
			sb.afterExecution();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred: closeBrowser()");
			throw e;
		}
	}

	// method to launch the URL of the application
	public void launchBaseURL() throws Throwable {
		try {
			String URL = pageObjects.getURL();
			if (URL != "") {
				getDriver().get(URL);
				Thread.sleep(2000);
				System.out.println("URL launched successfully.");
			} 
			else if (URL == "")
				throw new NullPointerException("URL cannot be empty!");
		} 
		catch (Exception e) {
			System.out.println("Error Occured: launchURL()");
			e.printStackTrace();
			throw e;
		}
	}

	// method to return locator type
	public By getLocator(String locatorType, String locatorValue) throws Throwable{
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
				//TODO correct exception name
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
				WebElement element = getDriver().findElement(locator);
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
				List<WebElement> elements = getDriver().findElements(locator);
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
				String username = pageObjects.getUsername();
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
				String password = pageObjects.getPassword();
				return password;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error in returnPassword()");
				throw e;
			}
		}
}
