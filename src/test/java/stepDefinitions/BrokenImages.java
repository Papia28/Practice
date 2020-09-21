package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.common.BrokenLinksImages;
import webApplication.testingFramework.common.JavascriptFunctions;

public class BrokenImages {
	
	public static Logger log = LogManager.getLogger(BrokenImages.class.getName()); 
	private static GenericFunctions gf = new GenericFunctions();
	private static WebDriver driver = gf.getDriver();

	@And("^user clicks on Broken Links and Images$")
	public void brokenImagesClick() throws Throwable {
		try {
			Thread.sleep(100);
			JavascriptFunctions.scrollToLast(driver);
			Thread.sleep(50);
			JavascriptFunctions.scrollUpByPixelValue(driver, 300);
			Thread.sleep(50);
			gf.click("xpath", "BrokenLinksImages");
		} 
		catch (Throwable t) {
			t.printStackTrace();
			log.error("Error in clicking broken images link!");
			throw t;
		}
	}

	@Then("^user verifies if image is broken$")
	public void brokenImagesVerify() throws Throwable {
		try {
			Thread.sleep(50);
			//if(BrokenLinksImages.isBrokenImage(GenericFunctions.getElement("xpath", "BokenImage")) == true)
				//TODO;
			//else
				//TODO;
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error in clicking broken images link!");
			throw t;
		}
	}

	@And("^user verifies if image is not broken$")
	public void notBrokenImagesVerify() throws Throwable {
		try {
			Thread.sleep(50);
			//if(BrokenLinksImages.isBrokenImage(GenericFunctions.getElement("xpath", "ValidImage")) == true)
				//TODO;
			//else
				//TODO;
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error in clicking broken images link!");
			throw t;
		}
	}
}
