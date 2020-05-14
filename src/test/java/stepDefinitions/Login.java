package stepDefinitions;

import webApplication.testingFramework.common.baseFunctions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;



public final class Login{

	private baseFunctions bf = new baseFunctions();
	private static WebDriver driver;

	@Given("^application is launched$")
	public void launchApplication() throws Throwable {
		try {
			driver = bf.launchBaseURL();
			bf.maximizeBrowser();
			Thread.sleep(5000);
		} catch (PendingException n) {
			System.out.println("Steps not found.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred: launchApplication()");
		}

	}
}