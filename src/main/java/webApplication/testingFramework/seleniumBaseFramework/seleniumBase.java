package webApplication.testingFramework.seleniumBaseFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import webApplication.testingFramework.common.PageObjects;


public final class seleniumBase {

	private static WebDriver driver = null;
	private static Logger log = LogManager.getLogger(seleniumBase.class.getName());
	private static seleniumBaseDriver sbd = null;
	
	//getter method for driver
	public static WebDriver getDriver()
	{			
		//return the driver
		return driver;
	} 
	
	//setter method for driver
	public static void setDriver(WebDriver driver)
	{
		seleniumBase.driver = driver;
	}
	
	// launch the browser
	public static void openBrowser() throws Throwable {
		try {
			
			/*
			 * System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			 * WebDriverManager.chromedriver().setup(); 
			 * driver = new ChromeDriver();
			 */	
			
			PageObjects.setReadConfig();
			PageObjects.setPageObjects();
			
			// set value for browser
			log.debug("Setting browser.");
			seleniumBaseDriver.setBrowser(readConfig.getBrowser());
						
			//set the webDriverManager as per the browser
			log.debug("Setting WebDriverManager.");
			seleniumBaseDriver.setWebDriverManager(); 
			
			//set the WebDriver driver object
			log.debug("Setting driver.");
			sbd = seleniumBaseDriver.getInstance();
			
			//get the WebDriver driver object
			setDriver(sbd.getDriver());
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
		try {
			log.debug("************Quitting Browser**************");
			Thread.sleep(1000);
			driver.quit();
		} 
		catch (Throwable e) {
			log.error("Failure! Error occurred during closeBrowser().");
			e.printStackTrace();
			//System.exit(0);
		} 
		finally 
		{ 
			setDriver(null);
			sbd = null;			
			seleniumBaseDriver.deleteInstance();
		}
	}
}
