package webApplication.testingFramework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import webApplication.testingFramework.common.AssertionsAndVerifications;
import webApplication.testingFramework.common.JavascriptFunctions;


public class GenericFunctions extends BaseFunctions {

	private WebDriver driver = null;
	public static Logger log = LogManager.getLogger(GenericFunctions.class.getName());
	
	//----------------------------------------------------------------------------------------------------------------------------------------------
	
	//privatised constructor of genericFunctions
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
		catch (Throwable e) {
			log.error("Error occurred: maximizeBrowser()");
			e.printStackTrace();
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to perform mouse click on items
	
	public void click(String locatorType, String locatorValue) throws Throwable {
		try {
			//get the element
			WebElement element = getElement(locatorType, locatorValue);
			JavascriptFunctions.highlightElement(driver, element);
			Thread.sleep(100);
			
			//click on the element
			element.click();
			Thread.sleep(100);
		} 
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in click()");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to clear text field contents
	
	public void clearValue(String locatorType, String locatorValue) throws Throwable {
		try {			
			//get the element using the actual locator
			WebElement element = getElement(locatorType, locatorValue);
			JavascriptFunctions.highlightElement(driver, element);
			Thread.sleep(100);
			
			//clear contents of the element
			element.clear();
			Thread.sleep(100);
		} 
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in clearText()");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to write in the text fields
	
	public void writeValue(String locatorType, String locatorValue, String fieldValue) throws Throwable {
		try {
			//get the element using the actual locator
			WebElement element = getElement(locatorType, locatorValue);
			JavascriptFunctions.highlightElement(driver, element);
			Thread.sleep(100);
			
			//write the fieldValue in the text field 
			element.sendKeys(fieldValue);
			Thread.sleep(100);
		} 
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in writeValue()");
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
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in getActualPageTitle()");
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
			AssertionsAndVerifications.assertEqualValue(actualPageTitle, expectedPageTitle);
		} 
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in getExpectedPageTitle()");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to check element visibility
	
	public void isElementVisible(String locatorType, String locatorValue) throws Throwable {
		try {
			//get the element using the actual locator
			WebElement element = getElement(locatorType, locatorValue);
			Thread.sleep(200);
			
			//assert visibility of element
			AssertionsAndVerifications.assertTrueValue(element.isDisplayed());
			JavascriptFunctions.highlightElement(driver, element);
			log.info("Success! " + locatorValue + " is visible!");
		} 
		catch(AssertionError e)
		{
			e.printStackTrace();
			log.error("Failure! " + locatorValue + " is not visible!");
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in isElementVisible().");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to return inner text from element
	
		public String getInnerText(String locatorType, String locatorValue) throws Throwable {
			try {
				//get the element using the actual locator
				WebElement element = getElement(locatorType, locatorValue);
				JavascriptFunctions.highlightElement(driver, element);
				Thread.sleep(200);
				
				//return the inner text fro the element
				return element.getText();
			} 
			catch (Throwable e) {
				e.printStackTrace();
				log.error("Error in getInnerText().");
				throw e;
			}
		}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// end of class
}
