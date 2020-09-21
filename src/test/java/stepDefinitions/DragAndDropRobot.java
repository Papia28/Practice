package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.common.ActionFunctions;
import webApplication.testingFramework.common.JavascriptFunctions;
import webApplication.testingFramework.common.RobotFunctions;
import webApplication.testingFramework.common.Screenshots;
import webApplication.testingFramework.common.StringUtility;
import webApplication.testingFramework.reporting.ExtentReportHandler;

public class DragAndDropRobot {
	
	private static GenericFunctions gf = new GenericFunctions();
	private static WebDriver driver = gf.getDriver();
	public static Logger log = LogManager.getLogger(DragAndDrop.class.getName());
	
	
	@When("^user clicks Interactions using Robot$")
	public void clickInteractions() throws Throwable
	{
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("user clicks Interactions");
		try {
			stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
			Thread.sleep(200);
			
			//hover on the element to be clicked
			ActionFunctions.hoverOnElement(driver, GenericFunctions.getElement("xpath", "Interactions"));
			
			//take screenshot of the element to be clicked
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "Interactions_Click"));
			
			//click on the element
			gf.click("xpath", "Interactions");
			Thread.sleep(50);
			
			//pass the step status
			ExtentReportHandler.testStepStatus("PASS", stepName, stepInfo, null);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error occurred clickInteractions()!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "Interactions_Click"));
			ExtentReportHandler.testStepStatus("FAIL", stepName, stepInfo, t);
			throw t;
		}
	}
	
	@When("^Interactions page opens using Robot$")
	public void interactionsPage() throws Throwable
	{
		ExtentTest stepInfo = null;
		try {			
			stepInfo = ExtentReportHandler.createStepInfo("When", "Interactions page opens");
			//TODO verify interactions page or not			
			
			//take screenshot of the element to be clicked
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "Interactions_Page"));
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			System.out.println("Error occurred!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "Interactions_Page"));
			ExtentReportHandler.testStepStatus("FAIL", "user clicks Interactions", stepInfo, t);
			throw t;
		}
	}
	
	@Then("^user selects Droppable using Robot$")
	public void selectDragDrop() throws Throwable {
		try {
			JavascriptFunctions.scrollToLast(gf.getDriver());
			Thread.sleep(100);
			ActionFunctions.hoverOnElement(driver, GenericFunctions.getElement("xpath", "Droppable"));
			gf.click("xpath", "Droppable");
			Thread.sleep(300);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectDragDrop().");
			throw e;
		}
	}
	
	@And("^user drags and drops item using Robot$")
	public void performDragAndDrop() throws Throwable {
		try {			
			Thread.sleep(50);
			//ActionFunctions.dragAndDropElement(driver, GenericFunctions.getElement("xpath", "DragMe"), GenericFunctions.getElement("xpath", "DropHere"));
			RobotFunctions.dragAndDropElementRobot(GenericFunctions.getElement("xpath", "DragMe"), GenericFunctions.getElement("xpath", "DropHere"));
			Thread.sleep(500);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in performDragAndDrop().");
			throw e;
		}
	}
	
	@Then("^text changes using Robot$")
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
