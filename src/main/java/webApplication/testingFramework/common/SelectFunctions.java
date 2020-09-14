package webApplication.testingFramework.common;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectFunctions {
	
	public static Logger log = LogManager.getLogger(SelectFunctions.class.getName());
	
	//----------------------------------------------------------------------------------------------------------------------------------------------
	// method to select an item from dropdown by visible text
	
		public static void singleSelectByText(WebElement element, String text) throws Throwable {
			try {
				
				//create Select class object of the dropdown element
				Select dropDown = new Select(element);
				Thread.sleep(100);
				
				//select the option of the dropdown via text
				dropDown.selectByVisibleText(text);
				Thread.sleep(100);
			} 
			catch (Exception e) {
				e.printStackTrace();
				log.error("Error in selectDropdownByText().");
				throw e;
			}
		}
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		//method to select an item from dropdown by value
		
		public static void singleSelectByValue(WebElement element, String value) throws Throwable {
			try {
				//create Select class object of the dropdown element
				Select dropDown = new Select(element);
				Thread.sleep(100);
				
				//select the option of the dropdown via value
				dropDown.selectByValue(value);
				Thread.sleep(100);
			} 
			catch (Exception e) {
				e.printStackTrace();
				log.error("Error in selectDropdownByValue().");
				throw e;
			}
		}
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		//verify single selected value
		
		public static void verifySingleDropdownResult(WebElement element, String expected) throws Throwable {
			try {
				String actualSetence = element.getText();
				String[] actual = actualSetence.split("-");
				
				//assert selected and displayed result value
				AssertionsAndVerifications.assertEqualValue(actual[1].trim(), expected.trim());
			}
			catch(Exception e) {
				e.printStackTrace();
				log.error("Error in verifySingleSelected().");
				throw e;
			}
		}
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		//method to verify is selection is multi select
		
		public static void checkMultiSelect(WebElement element) throws Throwable {
			try {				
				//create Select class object of the dropdown element
				Select dropDown = new Select(element);
				
				//assert whether dropdown is multi select or not
				AssertionsAndVerifications.assertTrueValue(dropDown.isMultiple());
				log.info("Dropdown is Multi Select type.");
			}
			catch(AssertionError e) {
				e.printStackTrace();
				log.info("Dropdown is Single Select type.");
				throw e;
			}			
			catch(Throwable e) {
				e.printStackTrace();
				log.error("Error in checkMultiSelect().");
				throw e;
			}
		}
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		//method to do multiple selection by Value
		
		public static Select multiSelectByValue(WebDriver driver, WebElement element, String values) throws Throwable {
			try {				
				//put the actual values to be selected into a String array
				String [] valuesArray = values.split(",");
				
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
				log.error("Error in multiSelectByValue().");
				throw e;
			}
		}
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		//method to check first option selected by Select class object
		
		public static void verifyFirstSelected(WebElement result, Select dropdown, String values) throws Throwable {
			try {				
				//get the first option selected from the dropdown
				WebElement firstOption = dropdown.getFirstSelectedOption();
				
				//set the actual and expected values to be verified
				String[] valuesArray = values.split(",");
				String[] resultArray = result.getText().split(":");			
				String actual1 = firstOption.getText();
				String actual2 = resultArray[1].trim();
				String expected = valuesArray[0].trim();
				
				//verify the first selected actual and expected values 
				AssertionsAndVerifications.assertEqualValue(actual1, actual2, expected);
			}
			catch(Exception e) {
				e.printStackTrace();
				log.error("Error in verifyFirstSelected().");
				throw e;
			}
		}
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		//method to verify all selected options in a multi select dropdown
		
		public static void verifyAllSelected(WebElement result, Select dropdown, String values) throws Throwable {
			try {				
				//get the list of web elements selected in the dropdown 
				List <WebElement> selectedOptions = dropdown.getAllSelectedOptions();
				
				//set the actual and expected values selected to be verified
				String[] valuesArray = values.split(",");
				int loc = result.getText().indexOf(":");
				String resultString = result.getText().substring(loc+2);
				String[] resultArray = resultString.split(",");
				
				for(int i = 0; i < selectedOptions.size(); i++) 
				{
					String actual1 = selectedOptions.get(i).getText().trim();
					String actual2 = resultArray[i].trim();
					String expected = valuesArray[i].trim();	
					
					//verify the actual and expected selected values in same order
					AssertionsAndVerifications.assertEqualValue(actual1, actual2, expected);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				log.error("Error in verifyAllSelected().");
				throw e;
			}
		}

		//-----------------------------------------------------------------------------------------------------------------------------------------------

}
