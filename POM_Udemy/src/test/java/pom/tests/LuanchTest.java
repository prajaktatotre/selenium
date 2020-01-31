package pom.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.pages.LaunchPage;

public class LuanchTest extends BaseTest {
	
	@Test
	public void testLauchPage(){
		eTest=report.startTest("LuanchTest");
		eTest.log(LogStatus.INFO, "Initialization Started");
		initialization();
		LaunchPage launchpage= new LaunchPage(driver, eTest);
				PageFactory.initElements(driver, launchpage);
		launchpage.goToLoginPage();
		
	}
	@AfterMethod
	public void tearDwon(){
		report.endTest(eTest);
		report.flush();
		report.close();
		driver.close();
	}

}
