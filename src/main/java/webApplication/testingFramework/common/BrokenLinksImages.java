package webApplication.testingFramework.common;

import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class BrokenLinksImages {
	
	public static Logger log = LogManager.getLogger(BrokenLinksImages.class.getName()); 
	
	public static boolean isBrokenImage(WebElement element) throws Throwable
	{
		try {			
				URL url = new URL(element.getAttribute("src"));
				int responseCode = HttpFunctions.getResponseCode(url);
				if(responseCode != 200)
					return true;
				else 
					return false;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in verifying broken image.");
			throw t;
		}
	}
	
	public static boolean isBrokenLink(WebElement element) throws Throwable
	{
		try {			
				URL url = new URL(element.getAttribute("href"));
				int responseCode = HttpFunctions.getResponseCode(url);
				if(responseCode != 200)
					return true;
				else 
					return false;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in verifying broken image.");
			throw t;
		}
	}
}
