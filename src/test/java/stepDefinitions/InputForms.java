package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.base.GenericFunctions;

public class InputForms {
	
	public GenericFunctions gf = new GenericFunctions();
	
	@Given("^popups have been closed$")
	public void popupsClosed() throws Throwable {
		try {
		Thread.sleep(100);
		gf.click("xpath", "CloseButton");
		Thread.sleep(100);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in popupsClosed().");
			throw e;
		}
	}

	@Given("^Input Forms is visible$")
	public void visibleInputForms() throws Throwable {
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "InputForms");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in visibleInputForms().");
			throw e;
		}
	}
	
	@When("^user selects Input Forms$")
	public void selectsInputForms() throws Throwable {
		try {
			Thread.sleep(100);
			gf.click("xpath", "InputForms");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectsInputForms().");
			throw e;
		}
	}
	
	@Then("^Input Forms dropdown is displayed$")
	public void dropdownInputForms() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "InputFormsDropDown");
			Thread.sleep(50);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in dropdownInputForms().");
			throw e;
		}
	}
}
