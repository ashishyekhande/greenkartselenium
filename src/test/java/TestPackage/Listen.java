package TestPackage;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listen extends Baseclass implements ITestListener {

	public WebDriver w; /// most important when you make thread safe each test should have webdriver instance
	ExtentReports extent = getextentreports();
	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("test started");
		test =extent.createTest(result.getMethod().getMethodName());
		thread.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
			try {
				w=(WebDriver)result.getTestClass().getRealClass().getField("w").get(result.getInstance());
				
				thread.get().addScreenCaptureFromPath(getScreenshot(w, result.getMethod().getMethodName()).getAbsolutePath());
				
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
		thread.get().fail( result.getThrowable());
		System.out.println("test Failed");
		extent.flush();
	}

	
}
