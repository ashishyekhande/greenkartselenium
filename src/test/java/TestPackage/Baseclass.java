package TestPackage;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import Pages.dashboard;
import Pages.sausedemo;

public class Baseclass {

	public WebDriver w;
	public dashboard d;
	public sausedemo s;

	public void initialize() {
		String browserName = "chrome";
		// this line will check the browser name is coming from terminal if from
		// terminal then user name after ? or else after :
		browserName = System.getProperty("browser") != null ? System.getProperty("browser") : browserName;
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--incognito");
			w = new ChromeDriver(op);
		}

		if (browserName.equalsIgnoreCase("edge")) {
			EdgeOptions op = new EdgeOptions();
			op.addArguments("--inprivate");
			w = new EdgeDriver(op);
		}

		if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions op = new FirefoxOptions();
			op.addArguments("-private");
			w = new FirefoxDriver(op);
		}
		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void openURL(String url) {
		initialize();
		w.get(url);

	}

	public dashboard dashobj() {
		d = new dashboard(w);
		return d;
	}

	public sausedemo sauseobj() {
		s = new sausedemo(w);
		return s;
	}

	protected File getScreenshot(WebDriver w, String testname) throws Exception {

		SimpleDateFormat simple = new SimpleDateFormat("MMM dd HH.mm.ss");
		String currentDateTime =simple.format(Calendar.getInstance().getTime());
		
		TakesScreenshot tc = (TakesScreenshot) w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File desti = new File("./screenshot/" + testname +"_"+currentDateTime+".png");
		Files.copy(src, desti);
		return desti;
	}

	@AfterMethod
	public void terminate() {
		w.quit();
	}

	public ExtentReports getextentreports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Report/geenkart.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

	public String datamethod() throws Exception {
		FileInputStream file = new FileInputStream("./Data/veg.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheetAt(0);
		int row = sh.getLastRowNum();
		int col = sh.getRow(0).getLastCellNum();
		String a = "";
		Object o[][] = new Object[row][col];
		for (int i = 0; i < row; i++) {
			XSSFRow rownum = sh.getRow(i + 1);
			for (int j = 0; j < col; j++) {
				o[i][j] = rownum.getCell(j).getStringCellValue();
				a = o[i][j].toString() + "," + a;
			}

		}
		System.out.println(a);
		return a;

	}

}
