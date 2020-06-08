package webApplication.testingFramework.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class genericFunctions extends baseFunctions {

	protected static final pageObjects po = baseFunctions.po;
	protected static final WebDriver driver = baseFunctions.driver;
	protected static final assertions a = new assertions();

	// method to maximize opened browser window
	public void maximizeBrowser() throws Throwable {
		try {
			driver.manage().window().maximize();
			Thread.sleep(200);
		} catch (Exception e) {
			System.out.println("Error occurred: maximizeBrowser()");
			e.printStackTrace();
			throw e;
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
			throw e;
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
			throw e;
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
			throw e;
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
			throw e;
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
			throw e;
		}
	}

	// method to check if element visibility
	public void isElementVisible(String locatorType, String locatorValue) throws Throwable {
		try {
			String value = po.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			WebElement element = getElement(locatorType, value);
			Thread.sleep(200);
			if (a.assertTrueValue(element.isDisplayed()) == true)
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
	public void singleSelectByText(String locatorType, String locatorValue, String textValue) throws Throwable {
		try {
			Thread.sleep(500);
			String value = po.getActualLocatorValue(locatorValue);
			String text = po.getActualLocatorValue(textValue);
			Thread.sleep(500);
			WebElement element = getElement(locatorType, value);
			Thread.sleep(100);
			Select dropDown = new Select(element);
			Thread.sleep(100);
			dropDown.selectByVisibleText(text);
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectDropdownByText().");
			throw e;
		}
	}
	
	//method to select an item from dropdown by value
	public void singleSelectByValue(String locatorType, String locatorValue, String optionValue) throws Throwable {
		try {
			Thread.sleep(500);
			String value = po.getActualLocatorValue(locatorValue);
			String option = po.getActualLocatorValue(optionValue);
			Thread.sleep(500);
			WebElement element = getElement(locatorType, value);
			Thread.sleep(100);
			Select dropDown = new Select(element);
			Thread.sleep(100);
			dropDown.selectByValue(option);
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectDropdownByValue().");
			throw e;
		}
	}
	
	//verify single selected value
	public boolean verifySingleSelected(String locatorType, String locatorValue, String verifyValue) throws Throwable {
		try {
			boolean result = false;
			String value = po.getActualLocatorValue(locatorValue);
			String expectedValue = po.getActualLocatorValue(verifyValue);
			WebElement actualElement = getElement(locatorType, value);
			String actualSetence = actualElement.getText();
			String[] actualSetenceArray = actualSetence.split("-");
			result = a.assertEqualValue(actualSetenceArray[1].trim(), expectedValue.trim());
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in verifySingleSelected().");
			throw e;
		}
	}
	
	//method to verify is selection is multi select
	public void checkMultiSelect(String locatorType, String locatorValue) throws Throwable {
		try {
			String value = po.getActualLocatorValue(locatorValue);
			WebElement element = getElement(locatorType, value);
			Select dropDown = new Select(element);
			if(a.assertTrueValue(dropDown.isMultiple()) == true)
				System.out.println("Dropdown is Multi Select type.");
			else
				System.out.println("Dropdown is Single Select type.");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in checkMultiSelect().");
			throw e;
		}
	}
	
	//method to do multiple selection by Value
	public Select multiSelectByValue(String locatorType, String locatorValue, String values) throws Throwable {
		try {
			String value = po.getActualLocatorValue(locatorValue);
			WebElement element = getElement(locatorType, value);
			String [] valuesArray = values.split(",");
			Select dropdown = new Select(element);
			
			for(int i=0; i< valuesArray.length; i++)
			{
				dropdown.selectByValue(valuesArray[i].trim());
			}
			return dropdown;			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in multiSelectByValue().");
			throw e;
		}
	}
	
	//method to check first option selected by Select class object
	public void verifyFirstSelected(String locatorType, String locatorValue, Select dropdown, String values) throws Throwable {
		try {
			String value = po.getActualLocatorValue(locatorValue);
			
			WebElement resultDisplayed = getElement(locatorType, value);
			WebElement firstOption = dropdown.getFirstSelectedOption();
			//TODO contains ","
			String[] valuesArray = values.split(",");
			String[] resultArray = resultDisplayed.getText().split(":");
			
			String actual1 = firstOption.getText();
			String actual2 = resultArray[1].trim();
			String expected = valuesArray[0].trim();
			
			a.assertEqualValue(actual1, actual2, expected);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in verifyFirstSelected().");
		}
	}

	// method to click and hold
	public void clickAndHoldElement(String locatorType, String locatorValue) throws Throwable {
		try {
			String value = po.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			WebElement element = getElement(locatorType, value);
			Thread.sleep(100);
			Actions hold = new Actions(driver);
			hold.clickAndHold(element);
			hold.build();
			hold.perform();
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in clickAndHoldElement().");
			throw e;
		}
	}

	// method to drag an element via single function
	public String[] dragAndDropElements(String locatorType, String sourceValue, String targetValue) throws Throwable {
		try {
			String sourcePath = po.getActualLocatorValue(sourceValue);
			String targetPath = po.getActualLocatorValue(targetValue);
			Thread.sleep(500);
			List<WebElement> sourceList = getElements(locatorType, sourcePath);
			WebElement target = getElement(locatorType, targetPath);
			Thread.sleep(100);	
			String[] names = new String[sourceList.size()];	
			WebElement source = null;
			Actions dragDrop = new Actions(driver);
			
			for (int i = 0; i < sourceList.size(); i++) 
			{
				source = sourceList.get(i);		
				System.out.println("Item " + (i+1) + " : " + source);
				//dragDrop.moveToElement(source).build();
				dragDrop.dragAndDrop(source, target).build().perform();
				names[i] = source.getText();
				Thread.sleep(100);
			}
			return names;
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in dragAndDropElements().");
			throw e;
		}
	}
	
	// method to drag an element via multiple functions
		public String[] dragAndDropElements1(String locatorType, String sourceValue, String targetValue) throws Throwable {
			try {
				String sourcePath = po.getActualLocatorValue(sourceValue);
				String targetPath = po.getActualLocatorValue(targetValue);
				Thread.sleep(500);
				List<WebElement> sourceList = getElements(locatorType, sourcePath);
				WebElement target = getElement(locatorType, targetPath);
				Thread.sleep(100);
				Actions dragDrop = new Actions(driver);
				WebElement source = null;
				String[] names = new String[sourceList.size()];

				for (int i = 0; i < sourceList.size(); i++) {
					source = sourceList.get(i);	
					System.out.println("Item " + (i+1) + " : " + source);
					dragDrop.clickAndHold(source).moveToElement(target, 1, 1).perform();					
					Thread.sleep(2000);
					dragDrop.release(target).build().perform();
					names[i] = source.getText();
					Thread.sleep(100);
				}
				return names;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error in dragAndDropElements().");
				throw e;
			}
		}

	// method to verify the dropped items
	public void verifyDroppedItems(String locatorType, String values[], String locatorValue) throws Throwable {
		try {
			String value = po.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			List<WebElement> droppedItems = getElements(locatorType, value);
			
			if(droppedItems.size() == 0)
				throw new NullPointerException("No dropped elements found!");
			
			for (int i = 0; i < droppedItems.size(); i++) {
				Thread.sleep(100);
				String itemName = droppedItems.get(i).getText();
				Thread.sleep(100);
				a.assertEqualValue(itemName, values[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in verifyDroppedItems().");
			throw e;
		}
	}

}
