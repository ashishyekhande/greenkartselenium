package TestPackage;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listen extends Baseclass implements ITestListener {

	ExtentReports extent = getextentreports();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("test started");
		test =extent.createTest(result.getMethod().getMethodName());
		test.pass("test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
			try {
				w=(WebDriver)result.getTestClass().getRealClass().getField("w").get(result.getInstance());
				
				test.addScreenCaptureFromPath(getScreenshot(w, result.getMethod().getMethodName()).getAbsolutePath());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		extent.flush();
		
		System.out.println("test successfull");
	}

	

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		System.out.println("test Failed");
		extent.flush();
	}

	
}
