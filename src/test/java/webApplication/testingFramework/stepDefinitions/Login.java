package webApplication.testingFramework.stepDefinitions;

import webApplication.testingFramework.common.genericFunctions;
import io.cucumber.java.en.Given;

public final class Login {

	 private genericFunctions gf = new genericFunctions();
	
	@Given("^application is launched$")
	public void launchApplication() throws Throwable
	{
		try {
			gf.launchBaseURL();
			gf.maximizeBrowser();
			Thread.sleep(5000);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred: Login()");
		}
	}
}