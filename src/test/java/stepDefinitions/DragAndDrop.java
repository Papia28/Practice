package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.common.ActionFunctions;
import webApplication.testingFramework.common.GenericFunctions;

public class DragAndDrop {
	
	public static GenericFunctions gf = new GenericFunctions();
	private static String [] droppedElements = null;
	
	@Then("^user selects Drag and Drop$")
	public void selectDragDrop() throws Throwable {
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "DragAndDrop");
			//rf.selectDropdownText("xpath", "OthersDropDown", "DragAndDropText");
			Thread.sleep(100);
			gf.click("xpath", "DragAndDrop");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectDragDrop().");
			throw e;
		}
	}
	
	@When("^user drags and drops all items$")
	public void performDragAndDrop() throws Throwable {
		try {
			Thread.sleep(100);
			//droppedElements = ActionFunctions.dragAndDropElements(gf, "xpath", "ItemsToDrag", "DropHere");			
			//droppedElements = ActionFunctions.dragAndDropElements1(gf, "xpath", "ItemsToDrag", "DropHere");
			//droppedElements  = RobotFunctions.dragAndDropElementsRobot("xpath", "Item1", "DropHere");
			ActionFunctions.dragAndDropElement(gf, "xpath", "Item1", "DropHere");	
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in performDragAndDrop().");
			throw e;
		}
	}
	
	@Then("^all items displayed in list$")
	public void verifyDragDroppedItems() throws Throwable {
		try {
			Thread.sleep(100);
			ActionFunctions.verifyDroppedItems(gf, "xpath", droppedElements, "DropedList");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in verifyDragDroppedItems().");
			throw e;
		}
	}

}
