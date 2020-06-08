package stepDefinitions;

import webApplication.testingFramework.common.genericFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectDropdownList {
	
	private static final genericFunctions gf = new genericFunctions();
	
	@Then("^user selects Select Dropdown List$")
	public void selectOption() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "SelectDropdownList");
			Thread.sleep(100);
			gf.click("xpath", "SelectDropdownList");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectOption()");
			throw e;
		}		
	}
	
	@When("^user selects single day$")
	public void selectDay() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "SelectDay");
			Thread.sleep(100);
			gf.selectDropdownByText("xpath", "SelectDay", "Day");
			//gf.selectDropdownByValue("xpath", "SelectDay", "Day");
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectDay()");
			throw e;
		}
	}
	
	@Then("^selected day is displayed$")
	public void selecetedDayDisplayed() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "DisplayDay");
			Thread.sleep(100);
			gf.verifySingleSelected("xpath", "DisplayDay", "Day");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selecetedDayDisplayed()");
			throw e;
		}
	}
	
	@When("^user selects single state$")
	public void selectSingleState() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "SelectStates");
			Thread.sleep(100);
			gf.selectDropdownByValue("xpath", "SelectStates", "State");
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectSingleState()");
			throw e;
		}
	}
	
	@When("^user clicks First Selected$")
	public void firstSelectedButtonClick() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "FirstSelectedBtn");
			Thread.sleep(100);
			gf.click("xpath", "FirstSelectedBtn");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in firstSelectedButtonClick()");
			throw e;
		}
	}
	
	@Then("^first selected state is displayed$")
	public void firstSelectedStateDisplayed() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "DisplayStates");
			Thread.sleep(100);
			gf.verifySingleSelected("xpath", "DisplayStates", "State");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in firstSelectedStateDisplayed()");
			throw e;
		}
	}

	@When("^user clicks Get All Selected$")
	public void getAllSelectedButtonClick() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "GetAllSelectedBtn");
			Thread.sleep(100);
			gf.click("xpath", "GetAllSelectedBtn");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getAllSelectedButtonClick()");
			throw e;
		}
	}
	
	@Then("^all selected state is displayed$")
	public void allSelectedStatesDisplayed() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "DisplayResult");
			Thread.sleep(100);
			gf.verifyMultipleSelected("xpath", "DisplayResult", "Places");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectOption()");
			throw e;
		}
	}
	
	@When("^user selects multiple places$")
	public void selectMultiplePlaces() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "SelectPlaces");
			Thread.sleep(100);
			gf.selectDropdownByValue("xpath", "SelectPlaces", "Places");
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectMultiplePlaces()");
			throw e;
		}
	}
}
