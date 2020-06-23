package stepDefinitions;

import webApplication.testingFramework.common.selectFunctions;

import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectDropdownList 
{
	//Start of class
	//genericFunctions are inherited by selectFunctions
	//hence no need to create genericFunctions object separately.
	private static final selectFunctions sf = new selectFunctions();
	private static Select multiDropdown = null;
	
	//--------------------------------------------------Select Dropdown List----------------------------------------------
	
	@Then("^user selects Select Dropdown List$")
	public void selectOption() throws Throwable{
		try {
			Thread.sleep(100);
			sf.isElementVisible("xpath", "SelectDropdownList");
			Thread.sleep(100);
			sf.click("xpath", "SelectDropdownList");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectOption()");
			throw e;
		}		
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------Single Day Selector---------------------------------------------------
	
	@When("^user selects single day$")
	public void selectDay() throws Throwable{
		try {
			Thread.sleep(100);
			sf.isElementVisible("xpath", "SelectDay");
			Thread.sleep(100);
			//sf.singleSelectByText("xpath", "SelectDay", "Day");
			sf.singleSelectByValue("xpath", "SelectDay", "Day");
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
			sf.isElementVisible("xpath", "DisplayDay");
			Thread.sleep(100);
			sf.verifySingleDropdownResult("xpath", "DisplayDay", "Day");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selecetedDayDisplayed()");
			throw e;
		}
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	
	
	
	//------------------------------------------------MULTI STATE SELECTOR----------------------------------------------------
	
	@When("^user selects multiple states$")
	public void selectMultipleStates() throws Throwable{
		try {
			Thread.sleep(100);
			sf.isElementVisible("xpath", "SelectStates");
			Thread.sleep(100);
			sf.checkMultiSelect("xpath", "SelectStates");
			Thread.sleep(100);
			multiDropdown = sf.multiSelectByValue("xpath", "SelectStates", "States");
			//sf.multiSelectByText("xpath", "SelectStates", "State");
			//sf.multiSelectByText("xpath", "SelectStates", "States");
			//sf.multiSelectByValue("xpath", "SelectStates", "State");
			Thread.sleep(100);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectMultiplePlaces()");
			throw e;
		}
	}
	
	@When("^user clicks First Selected$")
	public void firstSelectedButtonClick() throws Throwable{
		try {
			Thread.sleep(100);
			sf.isElementVisible("xpath", "FirstSelectedBtn");
			Thread.sleep(100);
			sf.click("xpath", "FirstSelectedBtn");
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
			sf.isElementVisible("xpath", "DisplayStates");
			Thread.sleep(100);
			sf.verifyFirstSelected("xpath", "DisplayStates", multiDropdown, "States");
			//sf.verifyFirstSelected("xpath", "DisplayStates", "State");
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
			sf.isElementVisible("xpath", "GetAllSelectedBtn");
			Thread.sleep(100);
			sf.click("xpath", "GetAllSelectedBtn");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getAllSelectedButtonClick()");
			throw e;
		}
	}
	
	@Then("^all selected states are displayed$")
	public void allSelectedStatesDisplayed() throws Throwable{
		try {
			Thread.sleep(1000);
			sf.isElementVisible("xpath", "DisplayStates");
			Thread.sleep(100);
			sf.verifyAllSelected("xpath", "DisplayStates", multiDropdown, "States");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in selectOption()");
			throw e;
		}
	}
	
	//------------------------------------------------------------------------------------------------------------------------
		
//End of class	
}
