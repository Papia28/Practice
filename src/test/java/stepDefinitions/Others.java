package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.common.GenericFunctions;

public class Others {
	
	public static GenericFunctions gf;

	@Then("^Others option is visible$")
	public void othersVisible() throws Throwable {
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "Others");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in othersVisible().");
			throw e;
		}
	}
	
	@When("^user clicks Others$")
	public void clickOthers() throws Throwable {
		try {
			Thread.sleep(100);
			gf.click("xpath", "Others");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in clickOthers().");
			throw e;
		}
	}
	
	@Then("^Others dropdown opens$")
	public void dropdownOthers() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "OthersDropDown");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in dropdownOthers().");
			throw e;
		}
	}
}
