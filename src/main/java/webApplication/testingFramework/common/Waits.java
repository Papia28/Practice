package webApplication.testingFramework.common;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	private static Logger log = LogManager.getLogger(Waits.class.getName());
	
	public static WebDriver implicitWait(WebDriver driver) throws Throwable {
		try {
			log.debug("Setting implicit wait for the driver.");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return driver;
		}
		catch(Throwable e) {
			log.error("Failure! Implicit wait not set.");
			e.printStackTrace();
			return driver;
		}
	}
	
	public static void explicitWaitByVisibility(WebDriver driver, WebElement element) throws Throwable {
		try {
			log.debug("Setting explicit wait for the element." + element);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Throwable e) {
			log.error("Failure! Explicit wait not set.");
			e.printStackTrace();
			throw e;
		}
	}

}
