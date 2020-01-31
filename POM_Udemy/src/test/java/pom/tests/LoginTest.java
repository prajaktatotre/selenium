package pom.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.pages.LaunchPage;
import pom.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void testLoginFunctionality() {
		eTest = report.startTest("LoginTest");
		eTest.log(LogStatus.INFO, "Started login test");
		initialization();
		LaunchPage launchPage = new LaunchPage(driver, eTest);
		PageFactory.initElements(driver, launchPage);
		launchPage.goToLoginPage();

		LoginPage loginPage = new LoginPage(driver, eTest);
		PageFactory.initElements(driver, loginPage);

		loginPage.doLogin("seleniumtraining11292017@gmail.com", "SeleniumTester$");
	}

	@AfterMethod
	public void tearDwon() {
		report.endTest(eTest);
		report.flush();
		report.close();
		driver.close();
	}

}
