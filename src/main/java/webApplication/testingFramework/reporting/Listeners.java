package webApplication.testingFramework.reporting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import webApplication.testingFramework.common.Screenshots;

public class Listeners extends Screenshots implements ITestListener {

	private WebDriver driver = null;
	private ExtentReports extent = ExtentReportHandler.getExtentObject();
	private ExtentTest test = null;
	private String testName = null;
	private Logger log = LogManager.getLogger(Listeners.class.getName());

	@Override
	public void onTestStart(ITestResult result) {
		log.debug("Setting the onTestStart method of Listeners.");
		testName = result.getMethod().getMethodName();
		test = extent.createTest(testName);
		log.info("Success! ExtentTest object created in onTestStart().");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Success! Test passed.");
		test.log(Status.PASS, "Success! Test passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			// TODO this using ITestContext
			log.error("Failure! Test failed.");
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
			String imagePath = saveScreenshot(driver, testName);
			test.addScreenCaptureFromPath(imagePath, testName);
			test.fail(result.getThrowable());
			test.log(Status.FAIL, "Failure! Test failed.");
		} 
		catch (Throwable e) {
			e.printStackTrace();
			log.fatal("Error in taking screenshot during failure!");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
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
	public void onStart(ITestContext context) {
		// TODO ITestContext here
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// ITestListener.super.onFinish(context);
	}

}
