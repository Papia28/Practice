package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.common.ActionFunctions;
import webApplication.testingFramework.common.GenericFunctions;

public class DragAndDrop1 {
	
	public static GenericFunctions gf = new GenericFunctions();
	
	@When("^user clicks Interactions$")
	public void clickInteractions() throws Throwable
	{
		try {
			Thread.sleep(500);
			ActionFunctions.hoverOnElement(gf, "xpath", "Interactions");
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
			ActionFunctions.hoverOnElement(gf, "xpath", "Droppable");
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
			ActionFunctions.hoverOnElement(gf, "xpath", "DragMe");
			Thread.sleep(50);
			ActionFunctions.dragAndDropElement(gf, "xpath", "DragMe", "DropHere");
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
