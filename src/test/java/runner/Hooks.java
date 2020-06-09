package runner;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import webApplication.testingFramework.common.baseFunctions;


public class Hooks extends baseFunctions{

	//class to define certain statements which will be executed before and after each and every scenario
	
	private static WebDriver driver = baseFunctions.driver;
	
	@Before
	public void beforeScenario() throws Throwable {
		try {
			if (driver == null)
				openBrowser();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in beforeScenario().");
			throw e;
		}
	}
	
	@After
	public void afterScenario() throws Throwable {
		try {
			closeBrowser();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in afterScenario().");
			throw e;
		}
	}
}
