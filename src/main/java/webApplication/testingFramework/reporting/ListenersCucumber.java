package webApplication.testingFramework.reporting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class ListenersCucumber extends ExtentReportHandler implements ITestListener {

	private ExtentReports extent = null;
	private static Logger log = LogManager.getLogger(ListenersCucumber.class.getName());

	@Override
	public void onStart(ITestContext context) {
		extent = getExtentObject();
		log.info("Success! ExtentTest object created in onStart().");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		log.debug("Tests started.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Success! Tests passed!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.error("Failure! Tests failed!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.error("Failure! Tests skipped!");
		// ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailedWithTimeout(result);
	}	

	@Override
	public void onFinish(ITestContext context) {
		log.info("Tests fnished execution.");
		log.debug("Generating report.");
		extent.flush();
		log.info("Report generated successfully!");
	}

}
