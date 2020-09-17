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
			reporter = new ExtentSparkReporter(path);

			// configure the ExtentSparkReporter object
			log.debug("Configuring the extent object.");
			reporter.config().setReportName("Test Results");
			reporter.config().setDocumentTitle("Web Automation Results");
			reporter.config().enableTimeline(true);
			reporter.config().setTheme(Theme.DARK);
			reporter.config().setTimeStampFormat("dd.MM.yyyy hh:mm:ss.ms a");
			reporter.start();

			// attach the reporter object to ExtentReports object and configure it
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
	
	public static void testStepStatus(String status,String message, ExtentTest test, Throwable errorThrown) throws Throwable
	{
		try {
			switch(status.toUpperCase())
			{
			case "PASS":
				test.log(Status.PASS, "Success! Step passed!");
				test.pass(MarkupHelper.createLabel("Step: " + message, ExtentColor.GREEN));
				break;
				
			case "FAIL":
				test.log(Status.FAIL, "Failure! Step failed!");
				test.fail(MarkupHelper.createLabel("Step: " + message, ExtentColor.RED));
				test.error(errorThrown.fillInStackTrace());
				break;
				
			default:
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
			ExtentTest stepInfo = null;
			stepInfo = test.createNode(new GherkinKeyword(keyword), stepName);
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
