package sample;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGetCommands {

	WebDriver driver;
	
	public void invokeBrowser(){
		System.setProperty("webdriver.chrome.driver", "/home/prajakta/Documents/Selenium/newDocuments/chromedriver");
	    driver= new ChromeDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		getCommand();
		
		
	}
	
	public void getCommand(){
		driver.get("http://www.amazon.com");                                    //get
		System.out.println("Title of the page is"  +driver.getTitle());         //getTitle()
		driver.findElement(By.linkText("Today's Deals")).click();
		System.out.println("Current URL is " +driver.getCurrentUrl());          //getCurrentUrl()
		//System.out.println("The page source is" + driver.getPageSource());    //getPageSource()
	}
	
	public static void main(String[] args) {
		TestGetCommands obj1=new TestGetCommands();
		obj1.invokeBrowser();

	}

}
