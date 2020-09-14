package webApplication.testingFramework.common;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowHandler extends BaseFunctions {

	private static Logger log = LogManager.getLogger(WindowHandler.class.getName());
	private static String parent = null;

	public String getParentWindow(WebDriver driver) throws Throwable {
		try {
			parent = driver.getWindowHandle();
			return parent;
		} catch (Throwable e) {
			log.error("Error in getting parent window handle!", e.fillInStackTrace());
			throw e;
		}
	}

	public Set<String> getChildWindows(WebDriver driver) throws Throwable {
		try {
			return driver.getWindowHandles();
		} catch (Throwable e) {
			log.error("Error in getting child window handles!", e.fillInStackTrace());
			throw e;
		}
	}

	public void switchToNthChildWindow(WebDriver driver, int n) throws Throwable {
		int count = 0;
		Set<String> windows = getChildWindows(driver);

		try {
			windows.remove(parent);
			for (String child : windows) {
				driver.switchTo().window(child);
				count++;
				if (count == n)
					break;
			}
		} catch (Throwable e) {
			log.error("Error while switching windows!", e.fillInStackTrace());
			throw e;
		}
	}

	public void switchToWindowWithElement(WebDriver driver, WebElement element) throws Throwable 
	{
		// TODO
	}

	public void openNewTab(WebDriver driver) throws Throwable 
	{
		try {
			// get parent window handle
			String parent = getParentWindow(driver);

			// get body element of the page
			WebElement body = getElement("xpath", "PageBody");

			// open a new tab
			body.sendKeys(Keys.chord(Keys.CONTROL, "t"));

			// get child window handles
			Set<String> set1 = getChildWindows(driver);

			// switch to new tab
			set1.remove(parent);
			for (String child : set1)
				driver.switchTo().window(child);
		} 
		catch (Throwable t) 
		{
			t.printStackTrace();
			log.error("not able to switch to new tab!");
			throw t;
		}
	}
}
