package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericFunctions extends BaseFunctions {

	private WebDriver driver = null;
	private Logger log = LogManager.getLogger(GenericFunctions.class.getName());
	
	//----------------------------------------------------------------------------------------------------------------------------------------------
	// methods to manipulate driver
	
	//constructor of genericFunctions
	public GenericFunctions()
	{	
		super();
		setDriver();
	}
	
	//accessor method for driver
	public WebDriver getDriver()
	{
		return driver;
	}

	//mutator method for driver
	public void setDriver()
	{			
		this.driver = getBaseDriver();
	}	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------
	
	// method to maximize open browser window
	
	public void maximizeBrowser() throws Throwable {
		try {
			//code to maximize the browser window
			log.debug("Maximizing browser");
			driver.manage().window().maximize();
			Thread.sleep(200);
			log.info("Successfully maximized browser!");
		} 
		catch (Exception e) {
			log.error("Error occurred: maximizeBrowser()");
			e.printStackTrace();
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to perform mouse click on items
	
	public void click(String locatorType, String locatorValue) throws Throwable {
		try {
			//get the actual value of the locator by reading the objectProperties file
			String value = PageObjects.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			
			//get the element using the actual locator
			WebElement element = getElement(locatorType, value);
			Thread.sleep(100);
			
			//click on the element
			element.click();
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in click()");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to clear text field contents
	
	public void clearValue(String locatorType, String locatorValue) throws Throwable {
		try {
			//get the actual value of the locator by reading the objectProperties file
			String value = PageObjects.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			
			//get the element using the actual locator
			WebElement element = getElement(locatorType, value);
			Thread.sleep(100);
			
			//clear contents of the element
			element.clear();
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in clearText()");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to write in the text fields
	
	public void writeValue(String locatorType, String locatorValue, String fieldValue) throws Throwable {
		try {
			//get the actual value of the locator by reading the objectProperties file
			String locatorValue1 = PageObjects.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			
			//get the element using the actual locator
			WebElement element = getElement(locatorType, locatorValue1);
			Thread.sleep(100);
			
			//write the fieldValue in the text field 
			element.sendKeys(fieldValue);
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in writeValue()");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to return current page title
	
	public String getActualPageTitle() throws Throwable {
		try {
			Thread.sleep(500);
			
			//return the title of the current web page
			return driver.getTitle();
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getActualPageTitle()");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to verify actual and expected page Titles
	
	public void verifyPageTitle(String title) throws Throwable {
		try {			
			//get the actual value of the expected page title by reading the objectProperties file
			String expectedPageTitle = PageObjects.getActualLocatorValue(title);
			Thread.sleep(500);
			
			//call function to return current web page title
			String actualPageTitle = getActualPageTitle();
			
			//assert the actual and expected page titles
			Assertions.assertEqualValue(actualPageTitle, expectedPageTitle);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getExpectedPageTitle()");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to check element visibility
	
	public void isElementVisible(String locatorType, String locatorValue) throws Throwable {
		try {
			//get the actual value of the locator by reading the objectProperties file
			String value = PageObjects.getActualLocatorValue(locatorValue);
			Thread.sleep(500);			
			
			//get the element using the actual locator
			WebElement element = getElement(locatorType, value);
			Thread.sleep(200);
			
			//assert visibility of element
			if (Assertions.assertTrueValue(element.isDisplayed()) == true)
				System.out.println("Success! " + locatorValue + " is visible!");
			else
				System.out.println("Failure! " + locatorValue + " is not visible!");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in isElementVisible().");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	// end of class
}
