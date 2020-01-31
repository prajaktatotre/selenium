package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.FbHomePage;
import pages.FbLoginPage;
import utility.ExcelUtils;

public class FbLoginTest extends TestBase{
	
	@Test
	public void init() throws Exception{

			String username= ExcelUtils.getCellData(1, 1);
			String password= ExcelUtils.getCellData(1, 2);
			System.out.println(""+ username+""+password);
			FbLoginPage loginpage = PageFactory.initElements(driver, FbLoginPage.class);
			Thread.sleep(10);
			loginpage.setEmail(username);
			loginpage.setPassword(password);
			loginpage.clickOnLoginButton();
			
		}
	
	@AfterMethod
	public void writeResult(ITestResult result) throws Exception{
		if(ITestResult.SUCCESS==result.getStatus()){
			ExcelUtils.setCellData("Pass", 1, 3);
		}
	}
	
}