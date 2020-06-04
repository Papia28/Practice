package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.common.genericFunctions;

public class InputForms {
	
	private static final genericFunctions gf = new genericFunctions();
	
	@Given("^popups have been closed$")
	public void popupsClosed() throws Throwable {
		Thread.sleep(100);
		gf.click("CloseButton", "xpath");
		Thread.sleep(100);
	}

	@Given("^Input Forms is visible$")
	public void visibleInputForms() {
		//TODO
	}
	
	@When("^user selects Input Forms$")
	public void selectsInputForms() {
		//TODO
	}
	
	@Then("^Input Forms dropdown is displayed$")
	public void dropdownDisplayed() {
		//TODO
	}
}
