package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.common.genericFunctions;
import webApplication.testingFramework.common.robotFunctions;

public class DragAndDrop {
	
	private static final genericFunctions gf = new genericFunctions();
	private static final robotFunctions rf = new robotFunctions();
	private static String [] droppedElements = null;
	
	@Then("^user selects Drag and Drop$")
	public void selectDragDrop() throws Throwable {
		try {
			Thread.sleep(100);
			//gf.isElementVisible("xpath", "OthersDropDown");
			gf.isElementVisible("xpath", "DragAndDrop");
			//gf.selectDropdownText("xpath", "OthersDropDown", "DragAndDropText");
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
			//droppedElements = gf.dragAndDropElements("xpath", "Item1", "DropHere");			
			//droppedElements = gf.dragAndDropElements1("xpath", "ItemsToDrag", "DropHere");
			droppedElements  = rf.dragAndDropElements("xpath", "ItemsToDrag", "DropHere");
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
			gf.verifyDroppedItems("xpath", droppedElements, "DropedList");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in verifyDragDroppedItems().");
			throw e;
		}
	}

}
