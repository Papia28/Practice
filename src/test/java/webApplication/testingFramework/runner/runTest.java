package webApplication.testingFramework.runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/java/webApplication/testingFramework/features"},
				glue = {"src/test/java/webApplication/testingFramework/stepDefinitions"},
				plugin = {"pretty", "html:report/cucumber"})
@Test
public class runTest extends AbstractTestNGCucumberTests{
	
}

