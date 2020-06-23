package webApplication.testingFramework.common;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class selectFunctions extends genericFunctions{
	
	private WebDriver driver = null;
	private genericFunctions gf = new genericFunctions();
	
	//----------------------------------------------------------------------------------------------------------------------------------------------
		// methods to manipulate driver
	
	//constructor of selectFunctions
	public selectFunctions()
	{
		setDriver(gf.getDriver());
	}
	
	//accessor method of selectFunctions
	public WebDriver getDriver()
	{
		return driver;
	}
	
	//mutator method of selectFunctions
	public void setDriver(WebDriver driver)
	{
		this.driver = driver;
	}	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------
	
	// method to select an item from dropdown by visible text
	
		public void singleSelectByText(String locatorType, String locatorValue, String textValue) throws Throwable {
			try {
				//get the actual value of the locator and text to be selected by reading the objectProperties file
				String value = pageObjects.getActualLocatorValue(locatorValue);
				String text = pageObjects.getActualLocatorValue(textValue);
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
				String value = pageObjects.getActualLocatorValue(locatorValue);
				String option = pageObjects.getActualLocatorValue(optionValue);
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
				String value = pageObjects.getActualLocatorValue(locatorValue);
				String expected = pageObjects.getActualLocatorValue(verifyValue);
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
				String value = pageObjects.getActualLocatorValue(locatorValue);
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
				String value = pageObjects.getActualLocatorValue(locatorValue);
				String actualValues = pageObjects.getActualLocatorValue(values);
				Thread.sleep(300);
				
				//get the dropdown element using the actual locator
				WebElement element = getElement(locatorType, value);
				
				//put the actual values to be selected into a String array
				String [] valuesArray = actualValues.split(",");
				
				//create Select class object of the dropdown element
				Select dropdown = new Select(element);
				Actions actions = new Actions(driver);
				
				//select the options of the dropdown by value
				for(int i=0; i< valuesArray.length; i++)
				{
					Thread.sleep(300);
					actions.keyDown(Keys.ALT);
					dropdown.selectByValue(valuesArray[i].trim());
				}
				
				//actions.keyUp(Keys.ALT);
				
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
				String value = pageObjects.getActualLocatorValue(locatorValue);
				String actualValues = pageObjects.getActualLocatorValue(values);
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
				String value = pageObjects.getActualLocatorValue(locatorValue);
				String actualValues = pageObjects.getActualLocatorValue(values);
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

}
