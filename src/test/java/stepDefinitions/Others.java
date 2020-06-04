package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.common.genericFunctions;

public class Others {
	
	private static final genericFunctions gf = new genericFunctions();

	@Then("^Others option is visible$")
	public void othersVisible() throws Throwable {
		try {
			Thread.sleep(50);
			gf.isElementVisible("xpath", "Others");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in othersVisible().");
		}
	}
	
	@When("^user clicks Others$")
	public void clickOthers() throws Throwable {
		try {
			Thread.sleep(50);
			gf.click("xpath", "Others");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in clickOthers().");
		}
	}
	
	@Then("^Others dropdown opens$")
	public void dropdownOpen() throws Throwable{
		try {
			Thread.sleep(50);
			gf.isElementVisible("xpath", "OthersDropdown");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in dropdownOpen().");
		}
	}
}
