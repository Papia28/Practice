package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.common.genericFunctions;

public class DragAndDrop {
	
	private static final genericFunctions gf = new genericFunctions();
	private static String [] droppedElements = null;
	
	@Then("^user selects Drag and Drop$")
	public void selectDrag() throws Throwable {
		try {
			Thread.sleep(50);
			gf.selectDropdownText("xpath", "OthersDropDown", "DragAndDropText");
			Thread.sleep(50);
			gf.click("xpath", "DragAndDrop");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectDrag().");
		}
	}
	
	@When("^user drags and drops all items$")
	public void performDragAndDrop() throws Throwable {
		try {
			Thread.sleep(50);
			droppedElements = gf.dragAndDropElements("xpath", "ItemsToDrag", "DropHere");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in performDragAndDrop().");
		}
	}
	
	@Then("^all items displayed in list$")
	public void allItemsDisplayed() throws Throwable {
		try {
			Thread.sleep(50);
			gf.verifyDroppedItems("xpath", droppedElements, "DropedList");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in allItemsDisplayed().");
		}
	}

}
