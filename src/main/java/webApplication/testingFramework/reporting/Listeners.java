package webApplication.testingFramework.reporting;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import webApplication.testingFramework.common.Screenshots;

public class Listeners extends Screenshots implements ITestListener {
	
	private WebDriver driver = null;
	private ExtentReports extent  = ExtentReportHandler.getExtentObject();
	private ExtentTest test = null;
	private String testName = null;
	
	@Override
	public void onTestStart(ITestResult result) 
	{		
		testName = result.getMethod().getMethodName();
		test = extent.createTest(testName);		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		try {
			//TODO this using ITestContext
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			String imagePath = saveScreenshot(driver, testName);
			test.addScreenCaptureFromPath(imagePath, testName);
			test.fail(result.getThrowable());
		} 
		catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in taking screenshot during failure!");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO ITestContext here
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}
	
	

}
