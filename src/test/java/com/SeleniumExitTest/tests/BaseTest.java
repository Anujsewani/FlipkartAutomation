package com.SeleniumExitTest.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.SeleniumExitTest.pages.ScreenShots;
import com.SeleniumExitTest.utils.ReadDataFromExcel;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;



public class BaseTest {
	
	static WebDriver driver;
	static File file=new File("./Resources/config.properties");
	static FileInputStream fis=null;
	static Properties prop=new Properties();
	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	static String Browser;

	public final static Logger logg = Logger.getLogger(BaseTest.class);


	// Excel File Test Data Reader
	public static ReadDataFromExcel reader = null;
	
	
	static {
		try {
			fis=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	// Exception Handling for Excel File
	try {

	reader = new ReadDataFromExcel(prop.getProperty("testDataFileLocation"));
	}
	catch(Exception e)
	{

	logg.error(e.getMessage());
	}
	}
	@BeforeTest(groups = {"LogIn","validLogin","report","sel","abc"})
	public void setExtent() {
		extent = new ExtentReports("./Reports/ExtentReport.html");
		}

		@AfterTest(groups = {"validLogin","LogIn","report","sel","abc"})
		public void endReport() throws InterruptedException {
		//extent.endTest(extentTest);
		extent.flush();
		extent.close();
		}
		
		@AfterMethod(groups = {"validLogin","LogIn","report","sel","abc"})
		public void attachScreenshot(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		String screenshotPath = ScreenShots.CaptureScreenshot(driver, result.getName());
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath) );
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
		extentTest.log(LogStatus.PASS, "Test Successful");
		}
		}



	@BeforeMethod(groups= {"validLogin","abc"})
	public static void initializeWebDriver(){
//		System.setProperty(prop.getProperty("chromeDriverProperty"),prop.getProperty("chromeDriverPath"));
//		driver = new ChromeDriver();
//		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		Browser = prop.getProperty("browser");



		if (Browser.equalsIgnoreCase("chromehl")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1400,600");
		driver = new ChromeDriver(options);
		}
		else if (Browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox")) {
		System.setProperty(prop.getProperty("firefoxDriverProperty"),prop.getProperty("firefoxDriverPath"));
		driver = new FirefoxDriver();
		WebDriverManager.firefoxdriver().setup();
		}
		else if (Browser.equalsIgnoreCase("edge")) {
		System.setProperty(prop.getProperty("edgeDriverProperty"),prop.getProperty("edgeDriverPath"));
		driver = new EdgeDriver();
		WebDriverManager.edgedriver().setup();

		}
		//int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		//driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@BeforeMethod(groups= {"validLogin","abc"})
	public static void openUrl() {
		
		driver.get(prop.getProperty("url"));
			
	}
	
	@AfterMethod(groups= {"validLogin","abc"})
	public static void closeBrowser(ITestResult result) {
		
		//driver.close();
		// for fail test cases
		if(result.getStatus() == ITestResult.FAILURE) {

		extentTest.log(LogStatus.FAIL, "TEST CASE FAILED "+result.getName());
		extentTest.log(LogStatus.FAIL, "TEST CASE FAILED THROWABLE EXC "+result.getThrowable());

		// adding screenshot
		String screenshotPath = ScreenShots.CaptureScreenshot(driver, result.getName());
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}

		else if(result.getStatus() == ITestResult.SKIP) {

		extentTest.log(LogStatus.SKIP, "TEST CASE SKIPPED "+result.getName());
		}

		else if(result.getStatus() == ITestResult.SUCCESS) {

		extentTest.log(LogStatus.PASS, "TEST CASE PASSED "+result.getName());
		}

		// end the testcase in the extent report
		extent.endTest(extentTest);

		// closing the driver
		driver.quit();
	}
	

}
