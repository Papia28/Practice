package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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
		}
	}

}
