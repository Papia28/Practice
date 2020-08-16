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

public class Listeners implements ITestListener {

	private ExtentReports extent = ExtentReportHandler.getExtentObject();
	private ExtentTest test = null;
	private String testName = null;
	private Logger log = LogManager.getLogger(Listeners.class.getName());
	private WebDriver driver = null;

	@Override
	public void onStart(ITestContext context) {
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		log.debug("Setting the onTestStart method of Listeners.");
		//testName = result.getMethod().getMethodName();
		testName = result.getName();
		test = extent.createTest(testName);
		log.info("Success! ExtentTest object created in onTestStart().");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
		log.info("Success! Test passed.");
		String imagePath = Screenshots.saveScreenshot(driver, testName);
		test.addScreenCaptureFromPath(imagePath, testName);
		test.pass("Success! Test passed.");
		test.log(Status.PASS, "Success! Test passed.");
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			log.fatal("Error in taking screenshot during success!");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			log.error("Failure! Test failed.");
			String imagePath = Screenshots.saveScreenshot(driver, testName);			
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
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
