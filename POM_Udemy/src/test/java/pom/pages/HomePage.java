package pom.pages;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class HomePage {

	WebDriver driver;
	ExtentReports report;
	
	HomePage(WebDriver driver,ExtentReports report){
		this.driver=driver;
		this.report= report;
	}
}
