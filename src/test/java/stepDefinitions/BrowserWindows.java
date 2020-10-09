package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.common.ActionFunctions;
import webApplication.testingFramework.common.JavascriptFunctions;
import webApplication.testingFramework.common.Screenshots;
import webApplication.testingFramework.common.StringUtility;
import webApplication.testingFramework.common.WindowHandler;
import webApplication.testingFramework.reporting.ExtentReportHandler;

public class BrowserWindows {
	
	private static GenericFunctions gf = null;
	private static WebDriver driver = null;
	public static Logger log = LogManager.getLogger(BrowserWindows.class.getName());
	private static String parent = null;
	private static WebElement element = null;
	
	@When("^user clicks on Alerts Frames and Windows$")
	public void clickAlerts() throws Throwable
	{
		gf = new GenericFunctions();
		gf.setDriver();
		driver = gf.getDriver();
		
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("user clicks on Alerts Frames and Windows");
		stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
		Thread.sleep(200);
		
		try {		
			JavascriptFunctions.scrollDownByPixelValue(driver, 300);
			
			//hover on the element to be clicked
			ActionFunctions.hoverOnElement(driver, GenericFunctions.getElement("xpath", "AlertsFramesWindows"));
			
			//take screenshot of the element to be clicked
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Click"));
			
			//click on the element
			gf.click("xpath", "AlertsFramesWindows");
			Thread.sleep(50);
			
			//pass the step status
			ExtentReportHandler.testStepStatus("PASS", stepName, stepInfo, null);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error occurred clickAlerts()!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Click"));
			ExtentReportHandler.testStepStatus("FAIL", stepName, stepInfo, t);
			throw t;
		}
	}
	
	@Then("^Alerts Frames and Windows page opens$")
	public void alertsFramesWindowsPage() throws Throwable
	{
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("Alerts Frames and Windows page opens");
		stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
		
		try {					
			//TODO verify interactions page or not			
			
			//take screenshot of the element to be clicked
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Page"));
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			System.out.println("Error occurred!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Page"));
			ExtentReportHandler.testStepStatus("FAIL", "Alerts Frames and Windows page opens", stepInfo, t);
			throw t;
		}
	}
	
	@Given("^user clicks Browser Windows$")
	public void clickBrowserWindows() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, GenericFunctions.getElement("xpath", "BrowserWindows"));
			Thread.sleep(50);
			gf.click("xpath", "BrowserWindows");
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickBrowserWindows().");
			throw e;
		}
	}
	
	@When("^user clicks New Tab$")
	public void clickNewTab() throws Throwable {
		try {			
			ActionFunctions.hoverOnElement(driver, GenericFunctions.getElement("cssselector", "NewTab"));
			Thread.sleep(50);
			gf.click("cssselector", "NewTab");
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickNewTab().");
			throw e;
		}
	}
	
	@When("^user clicks New Window$")
	public void clickNewWindow() throws Throwable {
		try {			
			ActionFunctions.hoverOnElement(driver, GenericFunctions.getElement("cssselector", "NewWindow"));
			Thread.sleep(50);
			gf.click("cssselector", "NewWindow");
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickNewWindow().");
			throw e;
		}
	}
	
	@When("^user clicks New Window Message$")
	public void clickNewWindowMessage() throws Throwable {
		try {			
			ActionFunctions.hoverOnElement(driver, GenericFunctions.getElement("cssselector", "NewWindowMessage"));
			Thread.sleep(50);
			gf.click("cssselector", "NewWindowMessage");
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickNewWindowMessage().");
			throw e;
		}
	}
	
	@Then("^new tab is opened$")
	@Then("^new window is opened$")
	public void tabWindowOpened() throws Throwable {
		try {
			parent = WindowHandler.getParentWindow(driver);
			element = WindowHandler.switchToWindowWithElement(driver, parent, "cssselector", "NewTabHeading");
			Thread.sleep(100);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in tabWindowOpened().");
			throw e;
		}
	}
	
	@Then("^new message window is opened$")
	public void messageWindowOpened() throws Throwable {
		try {
			parent = WindowHandler.getParentWindow(driver);
			//element = 
			WindowHandler.switchUsingJavascriptElement(driver, parent);
			Thread.sleep(100);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in messageWindowOpened().");
			throw e;
		}
	}
	
	@And("^user prints text in it$")
	public void printText() throws Throwable {
		try {
			log.info("Message in new tab/window: " + gf.getInnerText(element));
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in printText().");
			throw e;
		}
	}
	
	@And("^user switches back to parent window$")
	public void switchToParent() throws Throwable {
		try {
			gf.closeCurrentWindow();
			WindowHandler.switchToWindow(driver, parent);
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in switchToParent().");
			throw e;
		}
	}

}

