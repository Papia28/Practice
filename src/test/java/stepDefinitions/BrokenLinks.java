package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.common.BrokenLinksImages;

public class BrokenLinks {
	
	public static Logger log = LogManager.getLogger(BrokenLinks.class.getName()); 
	private static GenericFunctions gf = new GenericFunctions();
	private static WebDriver driver = gf.getDriver();

	@Then("^user verifies if link is broken$")
	public void brokenLinksVerify() throws Throwable {
		try {
			Thread.sleep(50);
			//if(BrokenLinksImages.isBrokenLink(GenericFunctions.getElement("xpath", "BokenImage")) == true)
				//TODO;
			//else
				//TODO;
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error in checking broken link!");
			throw t;
		}
	}

	@And("^user verifies if link is not broken$")
	public void notBrokenLinksVerify() throws Throwable {
		try {
			Thread.sleep(50);
			//if(BrokenLinksImages.isBrokenLink(GenericFunctions.getElement("xpath", "ValidImage")) == true)
				//TODO;
			//else
				//TODO;
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error in checking valid link!");
			throw t;
		}
	}
}
