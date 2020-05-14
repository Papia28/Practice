package runner;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;



@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", plugin = { "pretty",
		"html:target/cucumber" })

@Test
public class runTest {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeTest(alwaysRun = true)
	public void setUpClass() throws Throwable {
		try {
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(description = "Runs cucumber feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) throws Throwable {
		try {
			testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
			// System.out.println("Test method reached");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] features() throws Throwable {
		try {
			return testNGCucumberRunner.provideFeatures();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@AfterTest(alwaysRun = true)
	public void tearDownClass() throws Throwable {
		try {
			testNGCucumberRunner.finish();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
