package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage {

	public WebDriver driver=null;
	public ExtentTest eTest=null;
	@FindBy(className="zh-login")
	WebElement LogInLink;
	
	public LaunchPage(WebDriver driver,ExtentTest eTest){
		this.driver=driver;
		this.eTest=eTest;
		
	}
	
	public void goToLoginPage(){
		eTest.log(LogStatus.INFO, "Clicking on Link for login");
		LogInLink.click();
		eTest.log(LogStatus.INFO, "Successfully clicked on link");

	}
	
}
