package webApplication.testingFramework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportHandler {
	
	private static String path = System.getProperty("user.dir") + "\\reports\\Extent.html";
	private static ExtentSparkReporter reporter = null;
	private static ExtentReports extent = null;
	
	public static ExtentReports getExtentObject()
	{
		reporter = new ExtentSparkReporter(path);
		
		//configure the ExtentSparkReporter object 
		reporter.config().setReportName("Test Results");
		reporter.config().setDocumentTitle("Web Automation Results");
		
		//attach the reporter object to ExtentReports object and configure it
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Papia Nandi");
		
		//return the ExtentReports object
		return extent;
	}
	

}
