package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import webApplication.testingFramework.base.GenericFunctions;

public final class BookStoreApplication {

	public GenericFunctions gf = new GenericFunctions();

	@Given("^application is launched$")
	public void launchApplication() throws Throwable {
		try {
			GenericFunctions.launchBaseURL();
			gf.maximizeBrowser();
			Thread.sleep(50);
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

	@Then("^user provides \"(.*)\" and \"(.*)\"$")
	public void provideCredentials(String username, String password) throws Throwable {
		try {
			//String username = gf.returnUsername();
			//String password = gf.returnPassword();
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



