package webApplication.testingFramework.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class genericFunctions extends baseFunctions {

	protected static final pageObjects po = baseFunctions.po;
	protected static final WebDriver driver = baseFunctions.driver;
	protected static final assertions a = new assertions();

	//----------------------------------------------------------------------------------------------------------------------------------------------
	// method to maximize open browser window
	
	public void maximizeBrowser() throws Throwable {
		try {
			//code to maximize the browser window
			driver.manage().window().maximize();
			Thread.sleep(200);
		} 
		catch (Exception e) {
			System.out.println("Error occurred: maximizeBrowser()");
			e.printStackTrace();
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to perform mouse click on items
	
	public void click(String locatorType, String locatorValue) throws Throwable {
		try {
			//get the actual value of the locator by reading the objectProperties file
			String value = po.getActualLocatorValue(locatorValue);
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
			String value = po.getActualLocatorValue(locatorValue);
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
			String locatorValue1 = po.getActualLocatorValue(locatorValue);
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
			String expectedPageTitle = po.getActualLocatorValue(title);
			Thread.sleep(500);
			
			//call function to return current web page title
			String actualPageTitle = getActualPageTitle();
			
			//assert the actual and expected page titles
			a.assertEqualValue(actualPageTitle, expectedPageTitle);
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
			String value = po.getActualLocatorValue(locatorValue);
			Thread.sleep(500);			
			
			//get the element using the actual locator
			WebElement element = getElement(locatorType, value);
			Thread.sleep(200);
			
			//assert visibility of element
			if (a.assertTrueValue(element.isDisplayed()) == true)
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
	// method to select an item from dropdown by visible text
	
	public void singleSelectByText(String locatorType, String locatorValue, String textValue) throws Throwable {
		try {
			//get the actual value of the locator and text to be selected by reading the objectProperties file
			String value = po.getActualLocatorValue(locatorValue);
			String text = po.getActualLocatorValue(textValue);
			Thread.sleep(500);
			
			//get the dropdown element using the actual locator
			WebElement element = getElement(locatorType, value);
			Thread.sleep(100);
			
			//create Select class object of the dropdown element
			Select dropDown = new Select(element);
			Thread.sleep(100);
			
			//select the option of the dropdown via text
			dropDown.selectByVisibleText(text);
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectDropdownByText().");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//method to select an item from dropdown by value
	
	public void singleSelectByValue(String locatorType, String locatorValue, String optionValue) throws Throwable {
		try {
			//get the actual value of the locator and value to be selected by reading the objectProperties file
			String value = po.getActualLocatorValue(locatorValue);
			String option = po.getActualLocatorValue(optionValue);
			Thread.sleep(500);
			
			//get the dropdown element using the actual locator
			WebElement element = getElement(locatorType, value);
			Thread.sleep(100);
			
			//create Select class object of the dropdown element
			Select dropDown = new Select(element);
			Thread.sleep(100);
			
			//select the option of the dropdown via value
			dropDown.selectByValue(option);
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectDropdownByValue().");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//verify single selected value
	
	public void verifySingleDropdownResult(String locatorType, String locatorValue, String verifyValue) throws Throwable {
		try {
			//get the actual value of the locator and expected value by reading the objectProperties file
			String value = po.getActualLocatorValue(locatorValue);
			String expected = po.getActualLocatorValue(verifyValue);
			Thread.sleep(300);
			
			//get the result element using the actual locator
			WebElement actualElement = getElement(locatorType, value);
			String actualSetence = actualElement.getText();
			String[] actual = actualSetence.split("-");
			
			//assert selected and displayed result value
			a.assertEqualValue(actual[1].trim(), expected.trim());
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in verifySingleSelected().");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//method to verify is selection is multi select
	
	public void checkMultiSelect(String locatorType, String locatorValue) throws Throwable {
		try {
			//get the actual value of the locator by reading the objectProperties file
			String value = po.getActualLocatorValue(locatorValue);
			Thread.sleep(300);
			
			//get the dropdown element using the actual locator
			WebElement element = getElement(locatorType, value);
			
			//create Select class object of the dropdown element
			Select dropDown = new Select(element);
			
			//assert whether dropdown is multi select or not
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
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//method to do multiple selection by Value
	
	public Select multiSelectByValue(String locatorType, String locatorValue, String values) throws Throwable {
		try {
			//get the actual value of the locator and values to be selected by reading the objectProperties file
			String value = po.getActualLocatorValue(locatorValue);
			String actualValues = po.getActualLocatorValue(values);
			Thread.sleep(300);
			
			//get the dropdown element using the actual locator
			WebElement element = getElement(locatorType, value);
			
			//put the actual values to be selected into a String array
			String [] valuesArray = actualValues.split(",");
			
			//create Select class object of the dropdown element
			Select dropdown = new Select(element);
			
			//select the options of the dropdown by value
			for(int i=0; i< valuesArray.length; i++)
			{
				dropdown.selectByValue(valuesArray[i].trim());
			}
			
			//after selecting all options return the dropdown 
			return dropdown;			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in multiSelectByValue().");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//method to check first option selected by Select class object
	
	public void verifyFirstSelected(String locatorType, String locatorValue, Select dropdown, String values) throws Throwable {
		try {
			//get the actual value of the locator and values to be selected by reading the objectProperties file
			String value = po.getActualLocatorValue(locatorValue);
			String actualValues = po.getActualLocatorValue(values);
			Thread.sleep(300);
			
			//get the result element using the actual locator
			WebElement resultDisplayed = getElement(locatorType, value);
			
			//get the first option selected from the dropdown
			WebElement firstOption = dropdown.getFirstSelectedOption();
			
			//set the actual and expected values to be verified
			String[] valuesArray = actualValues.split(",");
			String[] resultArray = resultDisplayed.getText().split(":");			
			String actual1 = firstOption.getText();
			String actual2 = resultArray[1].trim();
			String expected = valuesArray[0].trim();
			
			//verify the first selected actual and expected values 
			a.assertEqualValue(actual1, actual2, expected);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in verifyFirstSelected().");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//method to verify all selected options in a multi select dropdown
	
	public void verifyAllSelected(String locatorType, String locatorValue, Select dropdown, String values) throws Throwable {
		try {
			//get the actual value of the locator and values to be selected by reading the objectProperties file
			String value = po.getActualLocatorValue(locatorValue);
			String actualValues = po.getActualLocatorValue(values);
			Thread.sleep(300);
			
			//get the list of web elements selected in the dropdown 
			List <WebElement> selectedOptions = dropdown.getAllSelectedOptions();
			
			//get the result element using the actual locator
			WebElement resultDisplayed = getElement(locatorType, value);
			
			//set the actual and expected values selected to be verified
			String[] valuesArray = actualValues.split(",");
			int loc = resultDisplayed.getText().indexOf(":");
			String resultString = resultDisplayed.getText().substring(loc+2);
			String[] resultArray = resultString.split(",");
			
			for(int i = 0; i < selectedOptions.size(); i++) 
			{
				String actual1 = selectedOptions.get(i).getText().trim();
				String actual2 = resultArray[i].trim();
				String expected = valuesArray[i].trim();	
				
				//verify the actual and expected selected values in same order
				a.assertEqualValue(actual1, actual2, expected);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in verifyAllSelected().");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to click and hold
	
	public void clickAndHoldElement(String locatorType, String locatorValue) throws Throwable {
		try {
			//get the actual value of the locator by reading the objectProperties file
			String value = po.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			
			//get the element using the actual locator
			WebElement element = getElement(locatorType, value);
			Thread.sleep(100);
			
			//create Actions class object of the WebDriver object
			Actions hold = new Actions(driver);
			
			//perform click and hold of the element using the Actions class object
			hold.clickAndHold(element);
			hold.build();
			hold.perform();
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in clickAndHoldElement().");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to drag an element via single function
	
	public String[] dragAndDropElements(String locatorType, String sourceValue, String targetValue) throws Throwable {
		try {
			//get the actual value of the source and target element locators by reading the objectProperties file
			String sourcePath = po.getActualLocatorValue(sourceValue);
			String targetPath = po.getActualLocatorValue(targetValue);
			Thread.sleep(500);
			
			//get the list of source elements using the actual locator value
			List<WebElement> sourceList = getElements(locatorType, sourcePath);
			
			//get the target element using the actual locator value
			WebElement target = getElement(locatorType, targetPath);
			Thread.sleep(100);	
			
			//String array to store names of the source elements to be dragged and dropped
			String[] names = new String[sourceList.size()];	
			
			//create Actions class object of the WebDriver ojbect
			Actions dragDrop = new Actions(driver);
			
			WebElement source = null;
			
			for (int i = 0; i < sourceList.size(); i++) 
			{
				//get one of the source web elements
				source = sourceList.get(i);		
				System.out.println("Item " + (i+1) + " : " + source);
				
				//perform drag and drop of the source element into the target element
				//dragDrop.moveToElement(source).build();
				dragDrop.dragAndDrop(source, target).build().perform();
				
				//store the dragged and dropped element name into the array
				names[i] = source.getText();
				Thread.sleep(100);
			}
			//return the dragged and dropped elements' name array
			return names;
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in dragAndDropElements().");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------	
	// method to drag an element via multiple functions
	
		public String[] dragAndDropElements1(String locatorType, String sourceValue, String targetValue) throws Throwable {
			try {
				//get the actual value of the source and target element locators by reading the objectProperties file
				String sourcePath = po.getActualLocatorValue(sourceValue);
				String targetPath = po.getActualLocatorValue(targetValue);
				Thread.sleep(500);
				
				//get the list of source elements using the actual locator value
				List<WebElement> sourceList = getElements(locatorType, sourcePath);
				
				//get the target element using the actual locator value
				WebElement target = getElement(locatorType, targetPath);
				Thread.sleep(100);
				
				//create Actions class object of the WebDriver ojbect
				Actions dragDrop = new Actions(driver);
				
				//String array to store names of the source elements to be dragged and dropped
				String[] names = new String[sourceList.size()];

				WebElement source = null;
				
				for (int i = 0; i < sourceList.size(); i++) 
				{
					//get one of the source web elements
					source = sourceList.get(i);	
					System.out.println("Item " + (i+1) + " : " + source);
					
					//perform drag and drop of the source element into the target element
					dragDrop.clickAndHold(source).moveToElement(target, 1, 1).perform();					
					Thread.sleep(2000);
					dragDrop.release(target).build().perform();
					
					//store the dragged and dropped element name into the array
					names[i] = source.getText();
					Thread.sleep(100);
				}
				//return the dragged and dropped elements' name array
				return names;
			} 
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error in dragAndDropElements().");
				throw e;
			}
		}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	// method to verify the dropped items

	public void verifyDroppedItems(String locatorType, String values[], String locatorValue) throws Throwable {
		try {
			//get the actual value of the dropped list locator by reading the objectProperties file
			String value = po.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			
			//store the web elements present in the dropped list into a List
			List<WebElement> droppedItems = getElements(locatorType, value);

			//throw error if dropped list is empty
			if (droppedItems.size() == 0)
				throw new NullPointerException("No dropped elements found!");

			for (int i = 0; i < droppedItems.size(); i++) 
			{
				Thread.sleep(100);
				
				//set the actual value as name of the item in dropped list
				String itemName = droppedItems.get(i).getText();
				Thread.sleep(100);
				
				//asert whether name of item in dropped list matches with name of dropped items array
				a.assertEqualValue(itemName, values[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in verifyDroppedItems().");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	
	// end of class
}
