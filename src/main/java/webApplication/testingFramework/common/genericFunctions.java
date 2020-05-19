package webApplication.testingFramework.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import webApplication.testingFramework.seleniumBaseFramework.readConfig;

public final class genericFunctions extends baseFunctions {

	private static final pageObjectProperties op = new pageObjectProperties();
	private static final readConfig rc = new readConfig();
	private static final WebDriver driver = baseFunctions.driver;
	

	// method to maximize opened browser window
	public void maximizeBrowser() throws Throwable {
		try {
			driver.manage().window().maximize();
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println("Error occurred: maximizeBrowser()");
			e.printStackTrace();
		}
	}

	// method to find element
	public WebElement getElement(String locatorValue, String locatorType) throws Throwable {
		try {
			By locator = super.getLocator(locatorValue, locatorType);
			WebElement element = driver.findElement(locator);
			Thread.sleep(500);
			return element;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getElement()");
			return null;
		}

	}

	// method to find list of elements
	public List<WebElement> getElements(String locatorValue, String locatorType) throws Throwable {
		try {
			By locator = super.getLocator(locatorValue, locatorType);
			List<WebElement> elements = driver.findElements(locator);
			Thread.sleep(500);
			return elements;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getElements()");
			return null;
		}

	}

	// method to perform mouse click on items
	public void click(String locatorValue, String locatorType) throws Throwable {
		try {
			String value = op.getActualLocatorValue(locatorValue);
			WebElement element = getElement(value, locatorType);
			element.click();
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in click()");
		}
	}

	// method to clear text
	public void clearValue(String locatorValue, String locatorType) throws Throwable {
		try {
			String value = op.getActualLocatorValue(locatorValue);
			WebElement element = getElement(value, locatorType);
			element.clear();
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in clearText()");
		}
	}

	// method to write in the fields
	public void writeValue(String locatorValue, String locatorType, String fieldValue) throws Throwable {
		try {
			String locatorValue1 = op.getActualLocatorValue(locatorValue);
			WebElement element = getElement(locatorValue1, locatorType);
			element.sendKeys(fieldValue);
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in writeValue()");
		}
	}

	// method to return username
	public String returnUsername() throws Throwable {
		try {
			String username = rc.getUsername();
			return username;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in returnUsername()");
			return null;
		}
	}

	// method to return password
	public String returnPassword() throws Throwable {
		try {
			String password = rc.getPassword();
			return password;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in returnPassword()");
			return null;
		}
	}

	// method to return current page title
	public String getActualPageTitle() throws Throwable {
		try {
			String pageTitle = driver.getTitle();
			return pageTitle;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getActualPageTitle()");
			return null;
		}
	}
	
	//method to return expected page Title
	public String getExpectedPageTitle() throws Throwable {
		try {
			String pageTitle = op.getActualLocatorValue("Page_Title");
			return pageTitle;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getExpectedPageTitle()");
			return null;
		}
	}
	
	
}


















