
package SampleFinal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {

	WebDriver driver;

	public void invokeBrowser() {

		try {
			System.setProperty("webdriver.chrome.driver", "/home/prajakta/Documents/Selenium/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://www.google.com");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			elementLocatorTechiquesUsingAmazon();
			driver.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void getcommands() {
		driver.get("http://www.amazon.in");
		driver.findElement(By.linkText("Today's Deals")).click();
		System.out.println("Title is : " + driver.getTitle());
		System.out.println("Current URL is : " + driver.getCurrentUrl());
		// System.out.println(driver.getPageSource());

	}

	public void navigateCommands() {
		driver.navigate().to("http://www.amazon.com");
		driver.findElement(By.xpath("//span[starts-with(text(),'Departments')]")).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

	}

	public void elementLocatorTechiquesUsingAmazon() {
		driver.get("http://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("redmi phone");
		driver.findElement(By.className("nav-input")).click();
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Today's")).click();
		driver.findElement(By.linkText("Your Amazon.com")).click();
		driver.findElement(By.name("email")).sendKeys("pqrst");
		/*
		 *  syntax: By.cssSelector("tag#id_value") or  By.cssSelector("tag.classValue") 
		 */
		driver.findElement(By.cssSelector("input#ap_password")).sendKeys("lmnk"); 
		driver.navigate().back();
		/*
		 * xpath:
		 * absolute-> /html reference node
		 * relative-> //any tag name which acts as reference node
		 */
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	public static void main(String[] args) {

		Day1 obj1 = new Day1();
		obj1.invokeBrowser();

	}
}
