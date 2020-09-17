package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import webApplication.testingFramework.common.GenericFunctions;
import webApplication.testingFramework.common.StringUtilility;
import webApplication.testingFramework.reporting.ExtentReportHandler;
import webApplication.testingFramework.seleniumBaseFramework.seleniumBase;


public class BeforeAfterExecution extends ExtentReportHandler {
	
	private static Logger log = LogManager.getLogger(BeforeAfterExecution.class.getName());
	
	public GenericFunctions gf = null;
	public String scenarioName = null;
	public String featureName = null;
	
	@Before
	public void beforeScenario(Scenario scenario) throws Throwable {
		try {
			scenarioName = scenario.getName();
			System.out.println(scenario.getId());
			System.out.println(Feature.getGherkinName());
			featureName = StringUtilility.getFeatureName(scenario.getId());
			
			log.debug("Before Scenario code execution.");
			
			test = extent.createTest(featureName);
			test = test.createNode(scenarioName);
			
			log.info("Feature: " + featureName);
			
			log.info("Success! ExtentTest object created in beforeScenario().");
			
			//initialize and open browser
			seleniumBase.openBrowser();			
			gf = new GenericFunctions();
			
			Thread.sleep(100);				
		}
		catch(Throwable e) {
			e.printStackTrace();
			log.error("Error in beforeScenario().");
			throw e;
		}
	}
	
	@After
	public void afterScenario(Scenario scenario) throws Throwable {
		try {
			
			  if(scenario.isFailed() == true) 
			  { 
			  log.error("Failure! Scenario failed!"); 
			  test.log(Status.FAIL, "Failure! Scenario failed!");
			  test.fail(MarkupHelper.createLabel("Scenario: " + scenarioName, ExtentColor.RED));
			  }
			  
			  else if(scenario.isFailed() != true) 
			  { 
			  log.info("Success! Scenario passed!"); 
			  test.log(Status.PASS, "Success! Scenario passed!"); 
			  test.pass(MarkupHelper.createLabel("Scenario: " + scenarioName, ExtentColor.GREEN));
			  }			 
			
			Thread.sleep(300);
			seleniumBase.closeBrowser();
		}
		catch(Throwable e) 
		{
			e.printStackTrace();
			log.error("Error in afterScenario().");
			throw e;
		}
	}
}
