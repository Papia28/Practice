package webApplication.testingFramework.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionFunctions extends GenericFunctions{
	
	private WebDriver driver = null;
	private GenericFunctions gf = new GenericFunctions();	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------
		// methods to manipulate driver
	
	//constructor for actionsFunctions
	public ActionFunctions()
	{
		setDriver(gf.getDriver());
	}
	
	//accessor method for actionsFunctions
	public WebDriver getDriver()
	{
		return driver;
	}
	
	//mutator method for actionsFunctions
	public void setDriver(WebDriver driver)
	{
		this.driver = driver;
	}	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------
	
	// method to click and hold
	
	public void clickAndHoldElement(String locatorType, String locatorValue) throws Throwable {
		try {
			//get the actual value of the locator by reading the objectProperties file
			String value = PageObjects.getActualLocatorValue(locatorValue);
			Thread.sleep(500);
			
			//get the element using the actual locator
			WebElement element = getElement(locatorType, value);
			Thread.sleep(100);
			
			//create Actions class object of the WebDriver object
			Actions hold = new Actions(getDriver());
			
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
			String sourcePath = PageObjects.getActualLocatorValue(sourceValue);
			String targetPath = PageObjects.getActualLocatorValue(targetValue);
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
				String sourcePath = PageObjects.getActualLocatorValue(sourceValue);
				String targetPath = PageObjects.getActualLocatorValue(targetValue);
				Thread.sleep(500);
				
				//get the list of source elements using the actual locator value
				List<WebElement> sourceList = getElements(locatorType, sourcePath);
				
				//get the target element using the actual locator value
				WebElement target = getElement(locatorType, targetPath);
				Thread.sleep(100);
				
				//create Actions class object of the WebDriver ojbect
				Actions dragDrop = new Actions(getDriver());
				
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
			String value = PageObjects.getActualLocatorValue(locatorValue);
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

}
