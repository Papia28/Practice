package webApplication.testingFramework.seleniumBaseFramework;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import webApplication.testingFramework.base.PageObjects;
import webApplication.testingFramework.common.Waits;

public class seleniumBaseDriver extends seleniumBaseDriverManager 
{
	private static WebDriver driver = null;
	private static Logger log = LogManager.getLogger(seleniumBaseDriver.class.getName());
	//private Logger log = Log.getInstance(Thread.currentThread().getStackTrace()[1].getClassName());
	private static DesiredCapabilities capabilities  = null;
	private static seleniumBaseDriver baseInstance = null;

	//private contrustor of the class
	private seleniumBaseDriver()
	{
		try {
			setDriver();
		} catch (Throwable e) {
			log.error("Error in creating object of seleniumBaseDriver()");
			e.printStackTrace();
		}
	}
	
	//method to get instance of the singleton class
	public static seleniumBaseDriver getInstance()
	{
		if(baseInstance == null)
			baseInstance = new seleniumBaseDriver();
		return baseInstance;
	}
	
	//method to delete instance of the singleton class
	public static void deleteInstance()
	{
		baseInstance = null;
	}
	
	//getter method for driver
	protected WebDriver getDriver() 
	{
		return driver;
	}
	
	//setter method for driver
	protected void setDriver() throws Throwable
	{
		try {			
			//call method to set and get the WebDriver object
			seleniumBaseDriver.driver = setSeleniumBaseDriver(getBrowser());
			log.info("Success! driver set.");
		} 
		catch (Throwable e) {
			e.printStackTrace();
			log.fatal("Failure! driver not set.");
			throw e;
		}
	}
	
	
	//method to provide value to driver as per the browser
	private static WebDriver setSeleniumBaseDriver(String browser) throws Throwable {
		try {
			// return proper WebDriver object
			log.info("Browser is " + browser + "!");
			if (browser.toUpperCase().contains("CHROME")) 
			{
				ChromeOptions options = new ChromeOptions();
				capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);				
				if(browser.toUpperCase().contains("HEADLESS"))
				{
					options.addArguments("--headless");
					options.addArguments("--disable-gpu");
					options.addArguments("--window-size=1920,1080");
				}
				options.merge(capabilities);
				driver = new ChromeDriver(options);
				driver = Waits.implicitWait(driver);
			} 
			else if (browser.toUpperCase().contains("FIREFOX")) 
			{
				FirefoxOptions options = new FirefoxOptions();
				capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);				
				if(browser.toUpperCase().contains("HEADLESS"))
				{
					options.addArguments("--headless");
					options.addArguments("--disable-gpu");
					options.addArguments("--window-size=1920,1080");
				}
				options.merge(capabilities);
				driver = new FirefoxDriver(options);
				driver = Waits.implicitWait(driver);
			}  
			else if (browser.toUpperCase().contains("INTERNET")) 
			{
				capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "internetExplorer");
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				driver = new InternetExplorerDriver();
				driver = Waits.implicitWait(driver);
			} 
			else if (browser.toUpperCase().contains("EDGE")) 
			{
				EdgeOptions options = new EdgeOptions();
				capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "edge");
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				capabilities.setCapability(EdgeOptions.CAPABILITY, options);
				driver = new EdgeDriver(capabilities);
				driver = Waits.implicitWait(driver);
			} 
			else if (browser.toUpperCase().contains("GRID")) 
			{
				String gridBrowser = PageObjects.getConfigKeyValue("gridBrowser");
				String hubAddress = PageObjects.getConfigKeyValue("hubAddress");
				
				log.info("Grid Browser is " + gridBrowser + "!");
				
				capabilities = new DesiredCapabilities();				
				capabilities.setCapability(CapabilityType.BROWSER_NAME, gridBrowser);
				capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				
				driver = new RemoteWebDriver(new URL(hubAddress + "/wd/hub"), capabilities);
				
				driver = Waits.implicitWait(driver);
			} 
			
			// TODO safari
			// TODO for android for appium
			log.info("Browser launched successfully!");
			return driver;
		}
		catch(MalformedURLException e) {
			log.fatal("Failure! URL not proper!");
			e.printStackTrace();
			throw e;
		}
		catch(WebDriverException e) {
			log.fatal("Failure! WebDriver object not set!");
			e.printStackTrace();
			throw e;
		}
		catch (Throwable e) 
		{
			log.fatal("Failure! WebDriver object not set!");
			e.printStackTrace();
			throw e;
		}
	}
}
