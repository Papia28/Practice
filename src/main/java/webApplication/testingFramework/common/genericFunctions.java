package webApplication.testingFramework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public final class genericFunctions extends baseFunctions {

	private static final pageObjects po = new pageObjects();
	private static final WebDriver driver = baseFunctions.driver;
	private static final assertions a = new assertions();
	

	// method to maximize opened browser window
	public void maximizeBrowser() throws Throwable {
		try {
			driver.manage().window().maximize();
			Thread.sleep(200);
		} catch (Exception e) {
			System.out.println("Error occurred: maximizeBrowser()");
			e.printStackTrace();
		}
	}	

	// method to perform mouse click on items
	public void click(String locatorType, String locatorValue) throws Throwable {
		try {
			String value = po.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			WebElement element = getElement(locatorType, value);
			Thread.sleep(100);
			element.click();
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in click()");
		}
	}

	// method to clear text
	public void clearValue(String locatorType, String locatorValue) throws Throwable {
		try {
			String value = po.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			WebElement element = getElement(locatorType, value);
			Thread.sleep(100);
			element.clear();
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in clearText()");
		}
	}

	// method to write in the fields
	public void writeValue(String locatorType, String locatorValue, String fieldValue) throws Throwable {
		try {
			String locatorValue1 = po.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			WebElement element = getElement(locatorType, locatorValue1);
			Thread.sleep(100);
			element.sendKeys(fieldValue);
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in writeValue()");
		}
	}

	// method to return username
	public String returnUsername() throws Throwable {
		try {
			String username = po.getUsername();
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
			String password = po.getPassword();
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
			Thread.sleep(500);
			String pageTitle = driver.getTitle();
			return pageTitle;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getActualPageTitle()");
			return null;
		}
	}
	
	//method to verify page Title
	public boolean verifyPageTitle(String title) throws Throwable {
		try {
			Thread.sleep(500);
			String expectedPageTitle = po.getActualLocatorValue(title);
			String actualPageTitle = getActualPageTitle();
			boolean result = a.assertEqualValue(actualPageTitle, expectedPageTitle);
			return result;
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getExpectedPageTitle()");
			return false;
		}
	}
	
	//method to check if element visibility
	public void isElementVisible(String locatorType, String locatorValue) throws Throwable {
		try {
			WebElement element = getElement(locatorType, locatorValue);
			Thread.sleep(500);
			boolean result = a.assertTrueValue(element.isDisplayed());
			if(result == true)
				System.out.println("Success! " + locatorValue + " is visible!");
			else
				System.out.println("Failure! " + locatorValue + " is not visible!");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in isElementVisible().");
			throw e;
		}
	}
	
	
}


















