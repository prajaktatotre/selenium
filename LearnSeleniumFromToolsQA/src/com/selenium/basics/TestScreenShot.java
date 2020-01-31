package com.selenium.basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScreenShot {

	WebDriver driver;

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/prajakta/Desktop/Resume/selenium/coding/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void getScreenShot() throws IOException{
		driver.get("http://www.facebook.com");
		WebElement element=driver.findElement(By.id("email"));
		File file=element.getScreenshotAs(OutputType.FILE);
		
		// Copy file to Desired Location
		File DestFile = new File("/home/prajakta/workspace/selenium_workspace/ScreenShot/ElementScreenshot.png");
		FileUtils.copyFile(file, DestFile);
		System.out.println("done");
	}
	public void takeScreenShot() throws IOException {

		driver.get("http://www.facebook.com");
		WebElement element=driver.findElement(By.id("email"));
		// convert webdriver object driver to TakesScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Copy file to Desired Location
		File DestFile = new File("/home/prajakta/workspace/selenium_workspace/ScreenShot/ElementScreenshot.png");
		FileUtils.copyFile(SrcFile, DestFile);
		System.out.println("done");
	}

	public static void main(String[] args) throws IOException {
		TestScreenShot obj = new TestScreenShot();
		obj.setup();
		obj.getScreenShot();

	}

}
