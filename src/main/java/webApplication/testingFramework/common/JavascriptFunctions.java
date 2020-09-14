package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptFunctions {
	
	private static Logger log = LogManager.getLogger(JavascriptFunctions.class.getClass());
	
	public static void scrollToLast(WebDriver driver)throws Throwable
	{
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(500);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in scrolling!");
			throw t;
		}
	}
	
	public static void javascriptClick(WebDriver driver, WebElement element)throws Throwable
	{
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click;", element);
		Thread.sleep(500);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in clicking!");
			throw t;
		}
	}
	
	public static void scrollUpByPixelValue(WebDriver driver, int value)throws Throwable
	{
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-arguments[0])", value);
		Thread.sleep(500);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in scrolling!");
			throw t;
		}
	}
	
	public static void highlightElement(WebDriver driver, WebElement element)throws Throwable
	{
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: lime; border: 2px solid red; font-weight: bolder;');", element);
		Thread.sleep(500);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in highlighting!");
			throw t;
		}
	}
	
	public static void scrollDownByPixelValue(WebDriver driver, int value)throws Throwable
	{
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,arguments[0])", value);
		Thread.sleep(500);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in scrolling!");
			throw t;
		}
	}

}
