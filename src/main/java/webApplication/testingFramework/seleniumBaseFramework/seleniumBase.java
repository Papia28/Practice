package webApplication.testingFramework.seleniumBaseFramework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;

public class seleniumBase extends seleniumBaseDriver {

	protected WebDriver baseDriver = null;

	// launch the browser
	@BeforeSuite(alwaysRun = true)
	public void openBrowser() throws Exception {
		try {
			// System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			// WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			super.setDriverManager();
			super.setSeleniumBaseDriver(baseDriver);
			Thread.sleep(2000);
			baseDriver = super.getSeleniumBaseDriver();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Error Occured: launchBrowser()");
			e.printStackTrace();
		}
	}

	

	// method to be executed after each test is finished running
	@AfterSuite(alwaysRun = true)
	public void closeBrowser() throws Exception {
		try {
			Thread.sleep(3000);
			System.out.println("************Closing Browser**************");
			baseDriver.close();
		} catch (Exception e) {
			System.out.println("Error Occured in closeBrowser");
			e.printStackTrace();
		} finally {
			System.out.println("************Quiting Browser**************");
			baseDriver.quit();
		}
	}
}
