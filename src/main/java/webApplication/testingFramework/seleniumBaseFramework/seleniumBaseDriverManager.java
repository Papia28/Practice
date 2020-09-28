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
	
	//setting the path for webdriver
	protected static void setWebDriverManager() throws Throwable {
		try {
			//set the WebDriverManager
			if (browser.length() != 0) 
			{
				log.info("Success! Browser is set.");
				log.info("Browser is " + browser + ".");

				// check the browser obtained from config file
				if (browser.toUpperCase().contains("CHROME")) 
				{
					WebDriverManager.chromedriver().setup();
					log.info("Success! Browser driver path set.");
				} 
				else if (browser.toUpperCase().contains("FIREFOX")) 
				{
					WebDriverManager.firefoxdriver().setup();
					log.info("Success! Browser driver path set.");
				} 
				else if (browser.toUpperCase().contains("INTERNET")) 
				{
					WebDriverManager.iedriver().setup();
					log.info("Success! Browser driver path set.");
				} 
				else if (browser.toUpperCase().contains("EDGE")) 
				{
					WebDriverManager.edgedriver().setup();
					log.info("Success! Browser driver path set.");
				}
				/*
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
		catch (Throwable e) 
		{
			log.fatal("Failure! Browser driver path not set.");
			e.printStackTrace();
			throw e;
		}
		
	}
	
}
