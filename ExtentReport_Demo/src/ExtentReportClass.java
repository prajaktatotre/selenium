import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportClass {

	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeTest
	public void StartReport() {

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);
		extent.addSystemInfo("HostName", "Prajakta machine").addSystemInfo("Environment", "Automation Testing");

		extent.loadConfig(new File(System.getProperty("user.dir") + "/config.xml"));
				
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	@Test
	public void passTest() {
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		// To generate the log when the test case is passed
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}

	@Test
	public void failTest() {
		logger = extent.startTest("failTest");
		System.setProperty("webdriver.chrome.driver", "/home/prajakta/Desktop/Resume/selenium/coding/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "NoTitle");
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	}

	@Test
	public void skipTest() {
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			
            String screenshotPath = ExtentReportClass.getScreenhot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));

			
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		// ending test
		// endTest(logger) : It ends the current test and prepares to create
		// HTML report
		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() {
		// writing everything to document
		// flush() - to write or update test information to your report.
		extent.flush();
		// Call close() at the very end of your session to clear all resources.
		// If any of your test ended abruptly causing any side-affects (not all
		// logs sent to ExtentReports, information missing), this method will
		// ensure that the test is still appended to the report with a warning
		// message.
		// You should call close() only once, at the very end (in @AfterSuite
		// for example) as it closes the underlying stream.
		// Once this method is called, calling any Extent method will throw an
		// error.
		// close() - To close all the operation
		extent.close();
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}

}
