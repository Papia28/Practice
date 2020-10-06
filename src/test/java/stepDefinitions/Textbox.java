package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.base.PageObjects;
import webApplication.testingFramework.common.ActionFunctions;
import webApplication.testingFramework.common.JDBC;

public class Textbox {
	
	public static Logger log = LogManager.getLogger(UploadDownload.class.getName());
	private static GenericFunctions gf = new GenericFunctions();
	private static WebDriver driver = gf.getDriver();
	
	@And("^user clicks Textbox$")
	public void clickTextbox() throws Throwable
	{
		try {
			Thread.sleep(10);
			ActionFunctions.hoverOnElement(driver, GenericFunctions.getElement("xpath", "Textbox"));
			gf.click("xpath", "Textbox");
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking upload and download!");
			throw t;
		}		
	}
	
	@And("^user writes fullname$")
	public void writeFullName() throws Throwable
	{
		String fullName = null;
		String query = null;
		try {
			query = PageObjects.getActualLocatorValue("Query");
			Thread.sleep(10);
			
			JDBC.openConnection();
			Thread.sleep(1000);
			fullName = JDBC.runQuery(query);
			Thread.sleep(10);
			JDBC.closeConnection();
			Thread.sleep(100);
			
			ActionFunctions.hoverOnElement(driver, GenericFunctions.getElement("cssselector", "Fullname"));
			gf.click("cssselector", "Fullname");
			gf.writeValue("cssselector", "Fullname", fullName);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking choose a file!");
			throw t;
		}		
	}
}
