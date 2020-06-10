package webApplication.testingFramework.seleniumBaseFramework;

import org.openqa.selenium.WebDriver;


public final class seleniumBase extends seleniumBaseDriver {

	private static WebDriver driver = null;
	
	// launch the browser
	public WebDriver beforeExecution() throws Throwable {
		try {
			
			/*
			 * System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			 * WebDriverManager.chromedriver().setup(); 
			 * driver = new ChromeDriver();
			 */
			
			//set the webDriverManager as per the browser
			setDriverManager();
			
			//set the WebDriver driver object
			//setBaseDriver(driver);
			setBaseDriver();
			Thread.sleep(500);
			
			//get the WebDriver driver object
			driver = getBaseDriver();
			Thread.sleep(500);
			
			//return the driver
			return driver;
		} 
		catch (Exception e) {
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
			//driver.close();
		} 
		catch (Exception e) {
			System.out.println("Error Occured: afterExecution");
			e.printStackTrace();
		} 
		finally {
			System.out.println("************Quiting Browser**************");
			driver.quit();
		}
	}
}
