package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utility.Constant;
import utility.ExcelUtils;

public class TestBase {

	public static WebDriver driver = null;

	@BeforeSuite
	public void initialize() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/home/prajakta/Desktop/Resume/selenium/coding/chromedriver");
		driver = new ChromeDriver();
		// To maximize browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);
		ExcelUtils.setExcelFile(Constant.pathTestData+Constant.filename, "Sheet1");

	}

	@AfterSuite
	// Test cleanup
	public void TeardownTest() {
		TestBase.driver.quit();
	}

}