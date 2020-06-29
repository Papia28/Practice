package webApplication.testingFramework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportHandler {
	
	private static String path = System.getProperty("user.dir") + "\\reports\\index.html";
	private static ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	private static ExtentReports extent = new ExtentReports();
	
	public static ExtentReports getExtentObject()
	{
		//configure the ExtentSparkReporter object 
		reporter.config().setReportName("Test Results");
		reporter.config().setDocumentTitle("Web Automation Results");
		
		//attach the reporter object to ExtentReports object and configure it
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Papia Nandi");
		
		//return the ExtentReports object
		return extent;
	}
	

}
