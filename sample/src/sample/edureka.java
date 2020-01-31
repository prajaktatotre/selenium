package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class edureka {

	WebDriver driver;
	
	public void invokeBrowser(){
		try {
			System.setProperty("webdriver.chrome.driver", "/home/prajakta/Documents/Selenium/newDocuments/chromedriver");
			driver= new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
			driver.findElement(By.name("q")).sendKeys("selenium");
			driver.findElement(By.name("btnK")).click();
			
			
			//driver.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		
		edureka obj1 = new edureka();
		obj1.invokeBrowser();
	}
}
	