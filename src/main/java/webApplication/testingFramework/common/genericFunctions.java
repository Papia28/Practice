package webApplication.testingFramework.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class genericFunctions extends baseFunctions {

	private static pageObjectProperties op = new pageObjectProperties();
	
	private WebDriver driver = baseFunctions.driver;

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
	
	
	//method to clear text
	public void clearValue(String locatorValue, String locatorType)throws Throwable {
		try {
			String value = op.getActualLocatorValue(locatorValue);
			WebElement element = getElement(value, locatorType);
			element.clear();
			Thread.sleep(500);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in clearText()");
		}
	}
	
	
	//method to write in the fields
	public void writeValue(String locatorValue, String locatorType, String fieldValue)throws Throwable {
		try {
			String locatorValue1 = op.getActualLocatorValue(locatorValue);
			WebElement element = getElement(locatorValue1, locatorType);
			element.sendKeys(fieldValue);
			Thread.sleep(500);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in writeValue()");
		}
	}
}
