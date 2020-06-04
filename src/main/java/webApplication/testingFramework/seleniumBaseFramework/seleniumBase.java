package webApplication.testingFramework.seleniumBaseFramework;

import org.openqa.selenium.WebDriver;


public final class seleniumBase extends seleniumBaseDriver {

	private WebDriver baseDriver = null;

	
	// launch the browser
	public WebDriver beforeExecution() throws Throwable {
		try {
			// System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			// WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			super.setDriverManager();
			super.setSeleniumBaseDriver(baseDriver);
			Thread.sleep(500);
			baseDriver = getSeleniumBaseDriver();
			Thread.sleep(500);
			return baseDriver;
		} catch (Exception e) {
			System.out.println("Error Occured: beforeExecution()");
			e.printStackTrace();
			return null;
		}
	}

	

	// close browser
	public void afterExecution() throws Throwable {
		try {
			Thread.sleep(1000);
			System.out.println("************Closing Browser**************");
			baseDriver.close();
		} catch (Exception e) {
			System.out.println("Error Occured: afterExecution");
			e.printStackTrace();
		} finally {
			System.out.println("************Quiting Browser**************");
			baseDriver.quit();
		}
	}
}
