package webApplication.testingFramework.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import webApplication.testingFramework.seleniumBaseFramework.seleniumBase;

public final class baseFunctions {

	private static WebDriver driver;
	private static final seleniumBase sb = new seleniumBase();

	@BeforeSuite
	public static void openBrowser() throws Throwable {
		try {
			driver = sb.beforeExecution();
		} catch (Exception e) {
			System.out.println("Error occurred: openBrowser()");
			e.printStackTrace();
		}
	}

	@AfterSuite
	public static void closeBrowser() throws Throwable {
		try {
			sb.afterExecution();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred: closeBrowser()");
		}
	}

	// method to launch the URL of the application
	public WebDriver launchBaseURL() throws Throwable {
		try {
			String URL = sb.rc.getURL();
			if (URL != "") {
				driver.get(URL);
				Thread.sleep(2000);
				System.out.println("URL launched successfully.");
			} else if (URL == "") {
				System.out.println("URL cannot be empty!");
				throw new NullPointerException();
			}
			return driver;
		} catch (Exception e) {
			System.out.println("Error Occured: launchURL()");
			e.printStackTrace();
			return null;
		}
	}

	// method to maximize opened browser window
	public void maximizeBrowser() throws Throwable {
		try {
			driver.manage().window().maximize();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Error occurred: maximizeBrowser()");
			e.printStackTrace();
		}
	}
}
