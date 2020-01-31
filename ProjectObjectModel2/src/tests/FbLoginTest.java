package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.FbHomePage;
import pages.FbLoginPage;

public class FbLoginTest extends TestBase{
	
	@Test
	public void init() throws Exception{

			//driver.get("https://www.facebook.com");
			FbLoginPage loginpage = PageFactory.initElements(driver, FbLoginPage.class);
			Thread.sleep(10);
			loginpage.setEmail("rajkumarsmonline@gmail.com");
			loginpage.setPassword("raj123456");
			loginpage.clickOnLoginButton();
			
			/*FbHomePage homepage = PageFactory.initElements(driver, FbHomePage.class);
			homepage.clickOnProfileDropdown();
			homepage.verifyLoggedInUserNameText();
			homepage.clickOnLogoutLink();	*/
		}
	
}