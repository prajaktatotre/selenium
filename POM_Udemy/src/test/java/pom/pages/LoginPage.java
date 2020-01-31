package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {

	public WebDriver driver=null;
	public ExtentTest eTest=null;
	
	@FindBy(id = "login_id")
	WebElement UserName;

	@FindBy(id = "nextbtn")
	WebElement nextButton;

	@FindBy(id = "password")
	WebElement passWord;

	@FindBy(id = "nextbtn")
	WebElement submitButton;
	
	public LoginPage(WebDriver driver, ExtentTest eTest){
		this.driver=driver;
		this.eTest=eTest;
	}

	/*public void setUsername(String username) {
		UserName.sendKeys(username);
	}

	public void setPassword(String password) {
		passWord.sendKeys(password);

	}

	public void clickNextButton() {
		nextButton.click();
	}

	public void sumbit() {
		submitButton.click();
	}*/
	
	public void doLogin(String userName, String password){
		eTest.log(LogStatus.INFO, "Enter userName"+userName);
		UserName.sendKeys(userName);
		eTest.log(LogStatus.INFO, "Clicked on next button ");
		nextButton.click();
		eTest.log(LogStatus.INFO, "Refreshing the page to avoid stale Element Exception");
		driver.navigate().refresh();
		eTest.log(LogStatus.INFO, "Enter password"+password);
		passWord.sendKeys(password);
		eTest.log(LogStatus.INFO, "Clicked on submit button");
		submitButton.click();
	}
	
}
