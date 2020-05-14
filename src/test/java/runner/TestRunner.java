package runner;

//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import webApplication.testingFramework.seleniumBaseFramework.seleniumBase;


@CucumberOptions(features = "src/test/java/features/", glue = "stepDefinitions", plugin = { "pretty",
"html:target/cucumber" })


@Test
public class TestRunner extends AbstractTestNGCucumberTests {
	
	/*
	 * static WebDriver driver; private final seleniumBase sb = new seleniumBase();
	 * 
	 * @BeforeSuite public void openBrowser()throws Throwable { try { driver =
	 * sb.beforeExecution(); } catch(Exception e) {
	 * System.out.println("Error occurred: openBrowser()"); e.printStackTrace(); } }
	 * 
	 * 
	 * 
	 * @AfterSuite public void closeBrowser() throws Throwable { try {
	 * sb.afterExecution(); } catch (Exception e) { e.printStackTrace();
	 * System.out.println("Error occurred: closeBrowser()"); } }
	 */
	
}
