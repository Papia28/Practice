package webApplication.testingFramework.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import webApplication.testingFramework.seleniumBaseFramework.seleniumBase;

public class baseFunctions {

	protected static WebDriver driver = null;
	private static final seleniumBase sb = new seleniumBase();

	@BeforeSuite
	public static void openBrowser() throws Throwable {
		try {
			driver = sb.beforeExecution();
		} catch (Exception e) {
			System.out.println("Error occurred: openBrowser()");
			e.printStackTrace();
		}
	}

	@AfterSuite
	public static void closeBrowser() throws Throwable {
		try {
			sb.afterExecution();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred: closeBrowser()");
		}
	}

	// method to launch the URL of the application
	public WebDriver launchBaseURL() throws Throwable {
		try {
			String URL = sb.rc.getURL();
			if (URL != "") {
				driver.get(URL);
				Thread.sleep(2000);
				System.out.println("URL launched successfully.");
			} else if (URL == "") {
				System.out.println("URL cannot be empty!");
				throw new NullPointerException();
			}
			return driver;
		} catch (Exception e) {
			System.out.println("Error Occured: launchURL()");
			e.printStackTrace();
			return null;
		}
	}

	// method to return locator type
	public By getLocator(String locatorValue, String locatorType) throws Throwable{
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
				System.out.println("No match found for Locators!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getLocator()");
			return null;
		}
	}
	
	
	
}
