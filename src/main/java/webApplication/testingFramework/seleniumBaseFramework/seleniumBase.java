package webApplication.testingFramework.seleniumBaseFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public final class seleniumBase extends seleniumBaseDriver {

	private static WebDriver driver = null;
	private static Logger log = LogManager.getLogger(seleniumBase.class.getName());
	
	// launch the browser
	public static WebDriver openBrowser() throws Throwable {
		try {
			
			/*
			 * System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			 * WebDriverManager.chromedriver().setup(); 
			 * driver = new ChromeDriver();
			 */			
			
			// set value for browser
			log.debug("Setting browser.");
			setBrowser(readConfig.getBrowser());
						
			//set the webDriverManager as per the browser
			log.debug("Setting WebDriverManager.");
			setWebDriverManager(); 
			
			//set the WebDriver driver object
			log.debug("Setting driver.");
			setBaseDriver();
			//Thread.sleep(500);
			
			//get the WebDriver driver object
			driver = getBaseDriver();
			//Thread.sleep(500);
			
			//return the driver
			return driver;
		} 
		catch (Exception e) {
			log.error("Failure! openBrowser() not executed correctly.");
			e.printStackTrace();
			throw e;
		}
	}

	

	// close all opened browsers
	public static void closeBrowser() 
	{		
		log.debug("************Quitting Browser**************");
		try {		
			Thread.sleep(1000);
			driver.quit();
		} 
		catch (Throwable e) {
			log.error("Failure! Error occurred during closeBrowser().");
			e.printStackTrace();
			System.exit(0);
		} 
		/*
		 * finally { driver.quit(); }
		 */
	}
}
