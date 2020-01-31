package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropbox {

	
	public void invokeBrowser(){
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "/home/prajakta/Documents/Selenium/newDocuments/chromedriver");
	    driver= new ChromeDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("http://www.dropbox.com/developers");	
        driver.findElement(By.linkText("Create your app")).click();
        driver.findElement(By.xpath("//input[@name='login_email']")).sendKeys("kpdhir@gmail.com");
        driver.findElement(By.xpath("//input[@name='login_password']")).sendKeys("$@nshodhak");
        driver.findElement(By.xpath("//input[@name='remember_me']")).click();
        
	}
	
	public static void main(String[] args) {
		Dropbox obj1= new Dropbox();
		obj1.invokeBrowser();
		

	}

}
