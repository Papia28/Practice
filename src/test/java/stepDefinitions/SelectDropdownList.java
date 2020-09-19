package stepDefinitions;

import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.base.PageObjects;
import webApplication.testingFramework.common.SelectFunctions;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectDropdownList 
{
	public static GenericFunctions gf = new GenericFunctions();
	//private static Select multiDropdown = null;
	
	//--------------------------------------------------Select Dropdown List----------------------------------------------
	
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
	
	//------------------------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------Single Day Selector---------------------------------------------------
	
	@When("^user selects single day$")
	public void selectDay() throws Throwable{
		try {
			Thread.sleep(100);
			gf.isElementVisible("xpath", "SelectDay");
			Thread.sleep(100);
			//actual
			WebElement element = GenericFunctions.getElement("xpath", "SelectDay");
			String text = PageObjects.getActualLocatorValue("Day");
			SelectFunctions.singleSelectByText(element, text);
			//SelectFunctions.singleSelectByValue("xpath", "SelectDay", "Day");
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
			//gf.verifySingleDropdownResult("xpath", "DisplayDay", "Day");
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
			gf.isElementVisible("xpath", "SelectStates");
			Thread.sleep(100);
			//gf.checkMultiSelect("xpath", "SelectStates");
			Thread.sleep(100);
			//multiDropdown = gf.multiSelectByValue("xpath", "SelectStates", "States");
			//gf.multiSelectByText("xpath", "SelectStates", "State");
			//gf.multiSelectByText("xpath", "SelectStates", "States");
			//gf.multiSelectByValue("xpath", "SelectStates", "State");
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
			//gf.verifyFirstSelected("xpath", "DisplayStates", multiDropdown, "States");
			//gf.verifyFirstSelected("xpath", "DisplayStates", "State");
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
	
	@Then("^all selected states are displayed$")
	public void allSelectedStatesDisplayed() throws Throwable{
		try {
			Thread.sleep(1000);
			gf.isElementVisible("xpath", "DisplayStates");
			Thread.sleep(100);
			//gf.verifyAllSelected("xpath", "DisplayStates", multiDropdown, "States");
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
