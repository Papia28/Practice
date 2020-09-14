package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.common.ActionFunctions;
import webApplication.testingFramework.common.AssertionsAndVerifications;
import webApplication.testingFramework.common.GenericFunctions;
import webApplication.testingFramework.common.JavascriptFunctions;
import webApplication.testingFramework.common.UploadDownloadFiles;
import webApplication.testingFramework.common.Waits;

public class UploadDownload {
	
	public static Logger log = LogManager.getLogger(UploadDownload.class.getName());
	private static GenericFunctions gf = new GenericFunctions();
	private static WebDriver driver = gf.getDriver();
	private static String expectedFileName = null;
	
	@When("^user clicks elements$")
	public void clickElements() throws Throwable
	{
		try {
			Thread.sleep(500);
			JavascriptFunctions.scrollDownByPixelValue(driver, 300);
			ActionFunctions.hoverOnElement(driver, gf.getElement("xpath", "Elements"));
			gf.click("xpath", "Elements");
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking elements!");
			throw t;
		}		
	}
	
	@And("^user clicks on Upload and Download$")
	public void clickUploadDownload() throws Throwable
	{
		try {
			Thread.sleep(1000);
			JavascriptFunctions.scrollToLast(driver);
			Thread.sleep(100);
			JavascriptFunctions.scrollUpByPixelValue(driver, 300);
			Thread.sleep(100);
			gf.click("xpath", "UploadAndDownload");
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking upload and download!");
			throw t;
		}		
	}
	
	@And("^user clicks on choose a file$")
	public void chooseFile() throws Throwable
	{
		try {
			Thread.sleep(200);
			ActionFunctions.hoverOnElement(driver, gf.getElement("xpath", "SelectFile"));
			gf.click("xpath", "SelectFile");
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking choose a file!");
			throw t;
		}		
	}
	
	@And("^user uploads a file$")
	public void uploadFile() throws Throwable
	{
		try {
			Thread.sleep(2000);
			expectedFileName = UploadDownloadFiles.uploadSampleFile("fileToUpload", "exeFilePath");
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while uploading file!");
			throw t;
		}		
	}
	
	@Then("^chosen file is uploaded$")
	public void verifyFileUpload() throws Throwable
	{
		try {
			Waits.explicitWaitByVisibility(driver, gf.getElement("CssSelector", "uploadedFile"));
			
			String uploadedFile = gf.getInnerText("CssSelector", "uploadedFile");
			int index = uploadedFile.lastIndexOf('\\');
			
			String actualFileName = uploadedFile.substring(index+1);
			
			AssertionsAndVerifications.assertEqualValue(actualFileName, expectedFileName);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while verifying file upload!");
			throw t;
		}		
	}

}
