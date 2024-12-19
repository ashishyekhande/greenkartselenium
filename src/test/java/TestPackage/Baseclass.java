package TestPackage;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import Pages.dashboard;

public class Baseclass {

	
	public WebDriver w;
	
	
	public void initialize()
	{
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		w= new ChromeDriver(op);
		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	public dashboard openURl(String url)
	{
		initialize();
		w.get(url);
		dashboard d = new dashboard(w);
		return d;
	}
	
	protected File getScreenshot(WebDriver w, String testname) throws Exception {
		
		TakesScreenshot tc = (TakesScreenshot)w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File desti = new File("./screenshot/"+testname+".png");
		Files.copy(src, desti);
		return desti ;
	}
	
	@AfterTest
	public void terminate()
	{
		w.quit();
	}
	
	public ExtentReports getextentreports()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Report/geenkart.html");
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
}
