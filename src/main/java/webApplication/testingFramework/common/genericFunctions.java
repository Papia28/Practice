package webApplication.testingFramework.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public final class genericFunctions extends baseFunctions {

	private static final pageObjects po = baseFunctions.po;
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
		} catch (Exception e) {
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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in writeValue()");
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

	// method to verify page Title
	public boolean verifyPageTitle(String title) throws Throwable {
		try {
			Thread.sleep(500);
			String expectedPageTitle = po.getActualLocatorValue(title);
			String actualPageTitle = getActualPageTitle();
			boolean result = a.assertEqualValue(actualPageTitle, expectedPageTitle);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getExpectedPageTitle()");
			return false;
		}
	}

	// method to check if element visibility
	public void isElementVisible(String locatorType, String locatorValue) throws Throwable {
		try {
			Thread.sleep(500);
			WebElement element = getElement(locatorType, locatorValue);
			Thread.sleep(200);
			boolean result = a.assertTrueValue(element.isDisplayed());
			if (result == true)
				System.out.println("Success! " + locatorValue + " is visible!");
			else
				System.out.println("Failure! " + locatorValue + " is not visible!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in isElementVisible().");
			throw e;
		}
	}

	// method to select an item from dropdown by visible text
	public void selectDropdownText(String locatorType, String locatorValue, String text) throws Throwable {
		try {
			Thread.sleep(500);
			WebElement element = getElement(locatorType, locatorValue);
			Thread.sleep(100);
			Select s = new Select(element);
			Thread.sleep(100);
			s.selectByVisibleText(text);
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectDropdownText().");
		}
	}

	// method to click and hold
	public void clickAndHoldElement(String locatorType, String locatorValue) throws Throwable {
		try {
			Thread.sleep(500);
			WebElement element = getElement(locatorType, locatorValue);
			Thread.sleep(100);
			Actions grab = new Actions(driver);
			grab.clickAndHold(element);
			grab.build();
			grab.perform();
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in clickAndHoldElement().");
		}
	}

	// method to drag an element
	public String[] dragAndDropElements(String locatorType, String sourceValue, String targetValue) throws Throwable {
		try {
			Thread.sleep(500);
			List<WebElement> sourceList = getElements(locatorType, sourceValue);
			WebElement target = getElement(locatorType, targetValue);
			Thread.sleep(100);
			Actions dragDrop = new Actions(driver);
			WebElement source = null;
			String[] names = new String[sourceList.size()];

			for (int i = 0; i < sourceList.size(); i++) {
				source = sourceList.get(i);
				names[i] = source.getText();
				dragDrop.dragAndDrop(source, target);
				dragDrop.build();
				dragDrop.perform();
				Thread.sleep(100);
			}
			return names;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in dragAndDropElements().");
			return null;
		}
	}

	// method to verify the dropped items
	public void verifyDroppedItems(String locatorType, String values[], String locatorValue) throws Throwable {
		try {
			Thread.sleep(500);
			List<WebElement> droppedItems = getElements(locatorType, locatorValue);
			for (int i = 0; i < droppedItems.size(); i++) {
				Thread.sleep(100);
				String itemName = droppedItems.get(i).getText();
				Thread.sleep(100);
				a.assertEqualValue(itemName, values[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in verifyDroppedItems().");
		}
	}

}
