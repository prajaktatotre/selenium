package passwordEncrptnDcrptn;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasswdEncoderDecoder {

	public WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.zoho.com");

	}

	@Test
	public void getLoginPage() {
		String password = "U2VsZW5pdW1UZXN0ZXIk";
		driver.findElement(By.className("zh-login")).click();
		driver.findElement(By.id("login_id")).sendKeys("seleniumtraining11292017@gmail.com");
		driver.findElement(By.id("nextbtn")).click();
		driver.navigate().refresh();
		driver.findElement(By.id("password")).sendKeys(decryptingPassword(password));
		driver.findElement(By.id("nextbtn")).click();
	}

	public String decryptingPassword(String encryptedPassword) {

		byte[] decryptedBytePassword = Base64.getDecoder().decode(encryptedPassword);

		String decryptedStringPassword = new String(decryptedBytePassword);

		return decryptedStringPassword;

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}

/*
 * Use This Method outside of project or check first encoded password using
 * separate program and then use this encoded password in the actual program
 * 
 * public void encoder() { 
 * String passwordText = "SeleniumTester$"; 
 * byte[] passwordTextInBytes = passwordText.getBytes();
 * 
 * String encodedStringPassword =
 * Base64.getEncoder().encodeToString(passwordTextInBytes);
 * System.out.println(encodedStringPassword);
 * 
 * //encodedStringPassword=U2VsZW5pdW1UZXN0ZXIk }
 */