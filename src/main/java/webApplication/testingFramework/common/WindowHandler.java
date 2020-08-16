package webApplication.testingFramework.common;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowHandler extends BaseFunctions{
	
	private static Logger log = LogManager.getLogger(WindowHandler.class.getName());
	private static String parent = null;
	
	public String getParentWindow(WebDriver driver)throws Throwable {
		try {
			parent = driver.getWindowHandle();
			return parent;
		}
		catch(Throwable e)
		{
			log.error("Error in getting parent window handle!" , e.fillInStackTrace());
			throw e;
		}
	}
	
	public Set<String> getChildWindows(WebDriver driver)throws Throwable {
		try {
			return driver.getWindowHandles();
		}
		catch(Throwable e)
		{
			log.error("Error in getting child window handles!" , e.fillInStackTrace());
			throw e;
		}
	}

	public void switchToNthChildWindow(WebDriver driver, int n)throws Throwable
	{
		int count = 0;		
		Set<String> windows = getChildWindows(driver);
		
		try {		
			windows.remove(parent);
			for(String child : windows)
			{
					driver.switchTo().window(child);
					count++;
					if(count == n)
						break;
			}
		}
		catch(Throwable e)
		{
			log.error("Error while switching windows!" , e.fillInStackTrace());
			throw e;
		}
	}
	
	public void openNewTab(WebDriver driver) throws Throwable
	{
		WebElement body = getElement("xpath", "PageBody");
	}
}
