package stepDefinitions;

import webApplication.testingFramework.common.baseFunctions;
import webApplication.testingFramework.common.genericFunctions;
import webApplication.testingFramework.seleniumBaseFramework.readConfig;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public final class Login{

	private baseFunctions bf = new baseFunctions();
	private genericFunctions gf = new genericFunctions();
	private static readConfig rc = new readConfig();
	//private static WebDriver driver;

	@Given("^application is launched$")
	public void launchApplication() throws Throwable {
		try {
			bf.launchBaseURL();
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
	public void clickSignIn()throws Throwable
	{
		try {
		gf.click("Sign_In", "xpath");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in clickSignIn()");
		}
	}
	
	
	@Then("^provide credentials$")
	public void provideCredentials() throws Throwable
	{
		try {
			gf.clearValue("Email_Field", "xpath");
			String username = rc.getUsername();
			gf.writeValue("Email_Field", "xpath", username);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in provideCredentials()");
		}		
	}
	
	
	@Then("^click Login$")
	public void clickLogin() throws Throwable
	{
		
	}
	
	
	@Then("^verify title of page$")
	public void verifyTitle() throws Throwable
	{
		
	}
}