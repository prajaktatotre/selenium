package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FbLoginPage {

	WebDriver driver;

        public FbLoginPage(WebDriver driver){ 
                 this.driver=driver; 
        }

	//Using FindBy for locating elements
	/*@FindBy(how=How.XPATH, using="//input[@type='email'][@name='email']") WebElement emailTextBox;
	@FindBy(how=How.XPATH, using="//input[@type='password'][@name='pass']") WebElement passwordTextBox;
	@FindBy(how=How.XPATH, using="//input[@type='submit']") WebElement signinButton;
	*/
        
        @FindBy(xpath = "//input[@type='email']")
    	WebElement emailTextBox;
        
        @FindBy(id = "pass")
    	WebElement passwordTextBox;

    	@FindBy(id = "loginbutton")
    	WebElement loginButton;
        
        // Defining all the user actions (Methods) that can be performed in the Facebook home page

        // This method is to set Email in the email text box
	public void setEmail(String strEmail){
		System.out.println("Setting email to: "+ strEmail);
		emailTextBox.sendKeys(strEmail);
	}
	// This method is to set Password in the password text box
	public void setPassword(String strPassword){
		System.out.println("Setting email to: "+ strPassword);
		passwordTextBox.sendKeys(strPassword);
	}
	// This method is to click on Login Button
	public void clickOnLoginButton(){
		loginButton.click();
	}	
}