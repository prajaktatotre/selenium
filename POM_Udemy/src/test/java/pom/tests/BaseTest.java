package pom.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pom.util.ExtentManager;

public class BaseTest {

	WebDriver driver=null;
	ExtentReports report = ExtentManager.getInstance();
	ExtentTest eTest=null;
	
	public void initialization(){
		
		eTest.log(LogStatus.INFO, "Setting propeties of broswer");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver");
		eTest.log(LogStatus.INFO, "Opening chrome broswer");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eTest.log(LogStatus.INFO, "Opening ZOHO url");
		driver.get("https://www.zoho.com");
	}
	

}
