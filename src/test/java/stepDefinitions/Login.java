package stepDefinitions;

import webApplication.testingFramework.common.genericFunctions;

//import org.junit.runner.RunWith;
//import cucumber.api.junit.Cucumber;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;


//@RunWith(Cucumber.class)
public final class Login{

	private genericFunctions gf = new genericFunctions();

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
			System.out.println("Error occurred: Login()");
		}

	}
}