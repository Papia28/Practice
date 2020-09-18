package webApplication.testingFramework.reporting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportHandler {
	
	private static String path = System.getProperty("user.dir") + "\\reports\\Extent.html";
	public static ExtentSparkReporter reporter = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	public static Logger log = LogManager.getLogger(ExtentReportHandler.class.getName());
	
	public static ExtentReports getExtentObject() {
		try {
			
			/**Month: If the number of pattern letters is 3 or more, 
			 * the month is interpreted as text; 
			 * otherwise, it is interpreted as a number. 
			 */			
			
			// configure the ExtentSparkReporter object
			reporter = new ExtentSparkReporter(path);
			
			log.debug("Configuring the extent object.");
			
			//these are present in the top right corner of the report
			reporter.config().setReportName("Test Results");
			reporter.config().setTimeStampFormat("dd MMMM yyyy hh:mm:ss:SSS a z");
			
			//this is the title of the report webpage
			reporter.config().setDocumentTitle("Web Automation Results");
			
			//this is present in the dashboard
			reporter.config().enableTimeline(true);
			
			//this enables either a white standard or a dark theme
			reporter.config().setTheme(Theme.DARK);
			
			//starts passing run information to the reporter			
			reporter.start();

			/** attach the reporter object to ExtentReports object and configure it
			 * This information is displayed on the dashboard of the report
			 */
			
			log.debug("Creating extent report object.");
			extent = new ExtentReports();
			log.info("Extent report object created.");
			extent.attachReporter(reporter);
			extent.setSystemInfo("Application Name", "ToolsQA Demo");
			extent.setSystemInfo("Tester", "Papia Nandi");
			extent.setSystemInfo("Username", System.getProperty("user.name"));
			extent.setSystemInfo("Operating System", System.getProperty("os.name"));

			// return the ExtentReports object
			return extent;
		} 
		catch (Throwable t) {
			t.printStackTrace();
			log.error("Extent object creation failed!");
			throw t;
		}
	}
	
	public static void testStepStatus(String status,String stepName, ExtentTest test, Throwable errorThrown) throws Throwable
	{
		try {
			switch(status.toUpperCase())
			{
			case "PASS":
				log.info(stepName + ": Step passed!");
				test.log(Status.PASS, "Success! Step passed!");
				test.pass(MarkupHelper.createLabel(stepName, ExtentColor.GREEN));
				break;
				
			case "FAIL":
				log.error(stepName + ": Step failed!");
				test.log(Status.FAIL, "Failure! Step failed!");
				test.fail(MarkupHelper.createLabel(stepName, ExtentColor.RED));
				test.error(errorThrown.fillInStackTrace());
				break;
				
			default:
				log.error(stepName + ": Unknown error!");
				break;
			}
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in capturing setting test step status!");
			throw t;
		}
	}
	
	public static ExtentTest createStepInfo(String keyword, String stepName) throws Throwable
	{
		try {
			log.info("Creating step info.");
			ExtentTest stepInfo = null;
			stepInfo = test.createNode(new GherkinKeyword(keyword), "Step: " + stepName);
			return stepInfo;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in creating step info!");
			throw t;
		}
	}
}
