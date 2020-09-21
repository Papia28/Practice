package webApplication.testingFramework.seleniumBaseFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import webApplication.testingFramework.base.PageObjects;


public final class seleniumBase {

	private static WebDriver driver = null;
	private static Logger log = LogManager.getLogger(seleniumBase.class.getName());
	private static seleniumBaseDriver sbd = null;
	
	//accessor method for driver
	public static WebDriver getDriver()
	{			
		//return the driver
		return driver;
	} 
	
	//mutator method for driver
	public static void setDriver(WebDriver driver)
	{
		//set value of the driver
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
			
			//To run via .propeties file use below command
			//seleniumBaseDriver.setBrowser(readConfig.getBrowser());
			
			/** This is running via maven command.
			 * For maven command System.getProperty is required to get the value of any system property.
			 * Browser is regarded as a system property.
			 * Its value is provided by maven commands via Jenkins or command prompt
			 */
			seleniumBaseDriver.setBrowser(System.getProperty("browser"));
						
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
