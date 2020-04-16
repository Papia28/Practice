package webApplication.testingFramework.common;

import org.openqa.selenium.WebDriver;
import webApplication.testingFramework.seleniumBaseFramework.seleniumBase;


public class genericFunctions extends seleniumBase {

	private WebDriver driver = null;

	// method to launch the URL of the application
	public void launchBaseURL() throws Exception {
		try {
			//TODO assign driver to something so that beforetest runs
			driver = super.baseDriver;
			String URL = rc.getURL();
			if (URL != "") {
				driver.get(URL);
				Thread.sleep(2000);
				System.out.println("URL launched successfully.");
			}
			else if(URL== "") {
				System.out.println("URL cannot be empty!");
				throw new NullPointerException();
			}
		} catch (Exception e) {
			System.out.println("Error Occured: launchURL()");
			e.printStackTrace();
		}
	}

	// method to maximize opened browser window
	public void maximizeBrowser() throws Exception {
		try {
			driver.manage().window().maximize();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Error occurred: maximizeBrowser()");
			e.printStackTrace();
		}
	}
}
