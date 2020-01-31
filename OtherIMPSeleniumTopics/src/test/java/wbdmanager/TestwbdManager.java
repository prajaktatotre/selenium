package wbdmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestwbdManager {

	public static WebDriver  driver;
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("http://www.qafox.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("s")).sendKeys("Contact");
		
		driver.findElement(By.id("search-submit")).click();
		System.out.println("Successful");
		
		driver.quit();
		
		
	}
}
