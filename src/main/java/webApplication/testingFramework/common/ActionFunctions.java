package webApplication.testingFramework.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionFunctions {
	
	//----------------------------------------------------------------------------------------------------------------------------------------------	
		// method to hover on element
		
		public static void hoverOnElement(WebDriver driver, WebElement element) throws Throwable {
			try {
				//create Actions class object of the WebDriver object
				Actions hover = new Actions(driver);
				
				//perform click and hold of the element using the Actions class object
				hover.moveToElement(element);
				hover.perform();
				JavascriptFunctions.highlightElement(driver, element);
				Thread.sleep(100);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Thread interrupted in hoverOnElement().");
				throw e;
			}
			catch (Throwable e) {
				e.printStackTrace();
				System.out.println("Error in hoverOnElement().");
				throw e;
			}
		}

	//----------------------------------------------------------------------------------------------------------------------------------------------	
	// method to click and hold
	
	public static void clickAndHoldElement(WebDriver driver, WebElement element) throws Throwable {
		try {
			//create Actions class object of the WebDriver object
			Actions hold = new Actions(driver);
			
			//perform click and hold of the element using the Actions class object
			JavascriptFunctions.highlightElement(driver, element);
			hold.clickAndHold(element);
			hold.perform();
			Thread.sleep(100);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Thread interrupted in hoverOnElement().");
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickAndHoldElement().");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
		// method to drag and drop an element
	//DO NOT USE BUILD().IT CAUSES THE DRAG AND DROP TO NOT WORK
		
		public static void dragAndDropElement(WebDriver driver, WebElement sourceElement, WebElement targetElement) throws Throwable {
			try {				
				//create Actions class object of the WebDriver ojbect
				Actions dragDrop = new Actions(driver);
				
				//perform drag and drop of the source element into the target element
				dragDrop.dragAndDrop(sourceElement, targetElement);
				dragDrop.perform();
				Thread.sleep(100);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Thread interrupted in hoverOnElement().");
				throw e;
			}
			catch (Throwable e) {
				e.printStackTrace();
				System.out.println("Error in dragAndDropElement().");
				throw e;
			}
		}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to drag and drop list of elements via single function
	
	public static String[] dragAndDropElements(WebDriver driver, List<WebElement> sourceElements, WebElement targetElement) throws Throwable {
		try {			
			//String array to store names of the source elements to be dragged and dropped
			String[] names = new String[sourceElements.size()];	
			
			//create Actions class object of the WebDriver ojbect
			Actions dragDrop = new Actions(driver);
			
			WebElement source = null;
			
			for (int i = 0; i < sourceElements.size(); i++) 
			{
				//get one of the source web elements
				source = sourceElements.get(i);		
				System.out.println("Item " + (i+1) + " : " + source);
				
				JavascriptFunctions.highlightElement(driver, source);
				JavascriptFunctions.highlightElement(driver, targetElement);
				
				//perform drag and drop of the source element into the target element
				dragDrop.moveToElement(source).perform();
				Thread.sleep(50);
				dragDrop.dragAndDrop(source, targetElement).perform();
				
				//store the dragged and dropped element name into the array
				names[i] = source.getText();
				Thread.sleep(100);
			}
			//return the dragged and dropped elements' name array
			return names;
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Thread interrupted in hoverOnElement().");
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in dragAndDropElements().");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------	
	// method to drag an element via multiple functions
	
		public static String[] dragAndDropElements1(WebDriver driver, List<WebElement> sourceElements, WebElement targetElement) throws Throwable {
			try {
				//create Actions class object of the WebDriver ojbect
				Actions dragDrop = new Actions(driver);
				
				//String array to store names of the source elements to be dragged and dropped
				String[] names = new String[sourceElements.size()];

				WebElement source = null;
				
				for (int i = 0; i < sourceElements.size(); i++) 
				{
					//get one of the source web elements
					source = sourceElements.get(i);	
					System.out.println("Item " + (i+1) + " : " + source);
					
					JavascriptFunctions.highlightElement(driver, source);
					JavascriptFunctions.highlightElement(driver, targetElement);
					
					//perform drag and drop of the source element into the target element
					dragDrop.clickAndHold(source).moveToElement(targetElement, 0, 0).build().perform();					
					Thread.sleep(50);
					dragDrop.release(targetElement).perform();
					
					//store the dragged and dropped element name into the array
					names[i] = source.getText();
					Thread.sleep(100);
				}
				//return the dragged and dropped elements' name array
				return names;
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Thread interrupted in hoverOnElement().");
				throw e;
			}
			catch (Throwable e) {
				e.printStackTrace();
				System.out.println("Error in dragAndDropElements().");
				throw e;
			}
		}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	// method to verify the dropped items

	public static void verifyDroppedItems(WebDriver driver, List<WebElement> droppedItems, String values[]) throws Throwable {
		try {
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
				AssertionsAndVerifications.assertEqualValue(itemName, values[i]);
			}
			
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Thread interrupted in hoverOnElement().");
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in verifyDroppedItems().");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------

}
