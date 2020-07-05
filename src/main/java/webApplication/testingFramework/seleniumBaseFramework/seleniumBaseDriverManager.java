package webApplication.testingFramework.seleniumBaseFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.UnreachableBrowserException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumBaseDriverManager 
{
	private static String browser = null;
	private static Logger log = LogManager.getLogger(seleniumBaseDriverManager.class.getName());
	
	//getter method for browser
	protected static String getBrowser()
	{
		return browser;
	}
	
	//setter method for browser
	protected static void setBrowser(String browser)
	{
		seleniumBaseDriverManager.browser = browser;
	}
	
	//getter method for 
	
	protected static void setWebDriverManager() throws Throwable {
		try {
			//set the WebDriverManager
			if (browser.length() != 0) 
			{
				log.info("Success! Browser is set.");
				log.info("Browser is " + browser + ".");

				// check the browser obtained from config file
				if ("Chrome".equalsIgnoreCase(browser)) 
				{
					WebDriverManager.chromedriver().setup();
					log.info("Success! Browser driver path set.");
				} 
				else if ("ChromeHeadless".equalsIgnoreCase(browser)) 
				{
					WebDriverManager.chromedriver().setup();
					log.info("Success! Browser driver path set.");
				} 
				else if ("Firefox".equalsIgnoreCase(browser)) 
				{
					WebDriverManager.firefoxdriver().setup();
					log.info("Success! Browser driver path set.");
				} 
				else if ("Firefox Headless".equalsIgnoreCase(browser)) 
				{
					WebDriverManager.firefoxdriver().setup();
					log.info("Success! Browser driver path set.");
				} 
				else if ("Internet Explorer".equalsIgnoreCase(browser)) 
				{
					WebDriverManager.iedriver().setup();
					log.info("Success! Browser driver path set.");
				} 
				else if ("Microsoft Edge".equalsIgnoreCase(browser)) 
				{
					WebDriverManager.edgedriver().setup();
					log.info("Success! Browser driver path set.");
				}
				/*
				 * else if("Headless".equalsIgnoreCase(browser)) { //TODO for headless } else
				 * if("Safari".equalsIgnoreCase(browser)) {
				 * //System.setProperties("webdriver.safari.driver", ""); //TODO for safari }
				 */
			}
			else
				throw new NullPointerException();
		}
		catch(NullPointerException e) 
		{
			log.error("Failure! Browser name is empty.");
			e.printStackTrace();
			throw e;
		}
		catch(UnreachableBrowserException e)
		{
			log.fatal("Failure! Unreachable browser.");
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) 
		{
			log.fatal("Failure! Browser driver path not set.");
			e.printStackTrace();
			throw e;
		}
		
	}
	
}
