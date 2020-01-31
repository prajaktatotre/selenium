package com.testng.annotations.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.testng.annotations.practice.TestListenersTestNG.class)
public class ListenerTestCase {

	WebDriver driver;

	@BeforeSuite
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "/home/prajakta/Desktop/Resume/selenium/coding/chromedriver");
		driver = new ChromeDriver();
		// driver.get("https://www.google.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	@Test(priority = 0)
	public void testTOPass() {
		driver.get("https://www.google.com");
		System.out.println("testcase passed");
		driver.quit();
	}

	@Test(priority = 1)
	public void TestToSkip() {
		System.out.println("Test skipped");
		throw new SkipException("thhis method is not ready yet");
	}

	@Test(priority = 2)
	public void TestToFail() {
		driver.getTitle();
		System.out.println("Test Failed");
	}

}
