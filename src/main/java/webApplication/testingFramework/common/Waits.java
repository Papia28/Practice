package webApplication.testingFramework.common;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Waits {
	
	private static Logger log = LogManager.getLogger(Waits.class.getName());
	
	public static WebDriver implicitWait(WebDriver driver) throws Throwable {
		try {
			log.debug("Setting implicit wait for the driver.");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return driver;
		}
		catch(Exception e) {
			log.error("Failure! Implicit wait not set.");
			e.printStackTrace();
			return driver;
		}
	}

}
