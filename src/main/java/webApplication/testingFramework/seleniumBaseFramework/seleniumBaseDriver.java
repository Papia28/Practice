package webApplication.testingFramework.seleniumBaseFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.safari.SafariDriver;

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
		catch (Exception e) {
			e.printStackTrace();
			log.fatal("Failure! driver not set.");
			throw e;
		}
	}
	
	
	//method to provide value to driver as per the browser
	private static WebDriver setSeleniumBaseDriver(String browser) throws Throwable {
		try {
			// return proper WebDriver object
			if ("Chrome".equalsIgnoreCase(browser)) {
				capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				driver = new ChromeDriver();
				driver = Waits.implicitWait(driver);
			} 
			else if ("Chrome Headless".equalsIgnoreCase(browser)) {
				log.info("Browser is Chrome Headless!");
				capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome Headless");
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				ChromeOptions ch = new ChromeOptions();
				ch.addArguments("--headless");
				//ch.setHeadless(true);
				ch.merge(capabilities);
				driver = new ChromeDriver(ch);
				driver = Waits.implicitWait(driver);
			} 
			else if ("Firefox".equalsIgnoreCase(browser)) {
				log.info("Browser is Firefox!");
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Firefox");
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				driver = new FirefoxDriver();
				driver = Waits.implicitWait(driver);
			} 
			else if ("Firefox Headless".equalsIgnoreCase(browser)) {
				log.info("Browser is Firefox Headless");
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Firefox Headless");
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				FirefoxOptions ff = new FirefoxOptions();
				ff.setHeadless(true);
				ff.merge(capabilities);
				driver = new FirefoxDriver(ff);
				driver = Waits.implicitWait(driver);
			} 
			else if ("Internet Explorer".equalsIgnoreCase(browser)) {
				log.info("Browser is Internet Explorer!");
				capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Internet Explorer");
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				driver = new InternetExplorerDriver();
				driver = Waits.implicitWait(driver);
			} 
			else if ("Microsoft Edge".equalsIgnoreCase(browser)) {
				log.info("Browser is Microsoft Edge!");
				capabilities = DesiredCapabilities.edge();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Edge Chromium");
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				driver = new EdgeDriver();
				driver = Waits.implicitWait(driver);
			} 
			else if ("Headless".equalsIgnoreCase(browser)) {
				log.info("Browser is Headless!");
				capabilities = DesiredCapabilities.htmlUnit();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "HTML Unit Driver");
				capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
				driver = new HtmlUnitDriver();
				driver = Waits.implicitWait(driver);
			}

			// TODO safari
			// TODO selenium grid
			// TODO for android for appium

			return driver;
		}
		catch(WebDriverException e) {
			log.fatal("Failure! WebDriver object not set.");
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) 
		{
			log.fatal("Failure! driver not set.");
			e.printStackTrace();
			throw e;
		}
	}
}
