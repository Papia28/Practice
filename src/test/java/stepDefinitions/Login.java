package stepDefinitions;

import webApplication.testingFramework.common.genericFunctions;

//import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public final class Login {

	private static final genericFunctions gf = new genericFunctions();
	
	@Before
	public void beforeScenario() throws Throwable {
		try {
			if (gf.getDriver() == null)
			{
				genericFunctions.openBrowser();
				Thread.sleep(300);
			}			
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
			Thread.sleep(300);
			genericFunctions.closeBrowser();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in afterScenario().");
			throw e;
		}
	}

	@Given("^application is launched$")
	public void launchApplication() throws Throwable {
		try {
			gf.launchBaseURL();
			gf.maximizeBrowser();
			Thread.sleep(5000);
		} catch (PendingException n) {
			System.out.println("Steps not found.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred: launchApplication()");
		}
	}

	@Then("^click Sign In$")
	public void clickSignIn() throws Throwable {
		try {
			gf.click("Sign_In_Btn", "xpath");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in clickSignIn()");
		}
	}

	@Then("^provide credentials$")
	public void provideCredentials() throws Throwable {
		try {
			String username = gf.returnUsername();
			String password = gf.returnPassword();
			gf.clearValue("Username_txt", "xpath");
			gf.writeValue("Username_txt", "xpath", username);
			gf.click("Continue_Btn", "xpath");
			Thread.sleep(500);
			gf.clearValue("Password_txt", "xpath");
			gf.writeValue("Password_txt", "xpath", password);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in provideCredentials()");
		}
	}

	@Then("^click Login$")
	public void clickLogin() throws Throwable {
		try {
			gf.click("Login_Btn", "xpath");
			Thread.sleep(300);
			gf.click("OTP_Continue_Btn", "xpath");
			Thread.sleep(10000);
			Thread.sleep(10000);
			Thread.sleep(10000);
			Thread.sleep(10000);
			gf.click("OTP_Continue_Btn_2", "xpath");
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in clickLogin()");
		}
	}
}



