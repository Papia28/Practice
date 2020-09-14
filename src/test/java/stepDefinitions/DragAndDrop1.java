package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.common.ActionFunctions;
import webApplication.testingFramework.common.GenericFunctions;
import webApplication.testingFramework.common.JavascriptFunctions;

public class DragAndDrop1 {
	
	private static GenericFunctions gf = new GenericFunctions();
	private static WebDriver driver = gf.getDriver();
	
	@When("^user clicks Interactions$")
	public void clickInteractions() throws Throwable
	{
		try {
			Thread.sleep(500);
			ActionFunctions.hoverOnElement(driver, gf.getElement("xpath", "Interactions"));
			gf.click("xpath", "Interactions");
			Thread.sleep(300);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			System.out.println("Error occurred!");
			throw t;
		}
	}
	
	@When("^Interactions page opens$")
	public void interactionsPage() throws Throwable
	{
		try {			
			//verify interactions page or not			
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			System.out.println("Error occurred!");
			throw t;
		}
	}
	
	@Then("^user selects Droppable$")
	public void selectDragDrop() throws Throwable {
		try {
			JavascriptFunctions.scrollToLast(gf.getDriver());
			Thread.sleep(100);
			ActionFunctions.hoverOnElement(driver, gf.getElement("xpath", "Droppable"));
			gf.click("xpath", "Droppable");
			Thread.sleep(300);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectDragDrop().");
			throw e;
		}
	}
	
	@And("^user drags and drops item$")
	public void performDragAndDrop() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, gf.getElement("xpath", "DragMe"));
			Thread.sleep(50);
			ActionFunctions.dragAndDropElement(driver, gf.getElement("xpath", "DragMe"), gf.getElement("xpath", "DropHere"));
			Thread.sleep(100);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in performDragAndDrop().");
			throw e;
		}
	}
	
	@Then("^text changes$")
	public void verifyDragDroppedItems() throws Throwable {
		try {
			gf.isElementVisible("xpath", "Dropped");
			Thread.sleep(100);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in verifyDragDroppedItems().");
			throw e;
		}
	}

}
