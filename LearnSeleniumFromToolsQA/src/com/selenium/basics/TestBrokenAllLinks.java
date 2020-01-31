package com.selenium.basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBrokenAllLinks {

	WebDriver driver;

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/prajakta/Desktop/Resume/selenium/coding/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	/*public static List findAllLinks() {

	}*/

	public void verifyLinks() throws InterruptedException, IOException {

		driver.get("https://www.toolsqa.com/selenium-webdriver");
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links are " + links.size());

		String response = "";
		int statusCode =200;
		
		for (int i = 0; i < links.size(); i++) {
			
			WebElement element = links.get(i);
			String url = element.getAttribute("href");

			try{
				URL link = new URL(url);
				// Create a connection using URL object (i.e., link)
				HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
				httpConn.setRequestMethod("HEAD");
				// Set the timeout for 2 seconds
				//httpConn.setConnectTimeout(2000);
				// connect using connect method
				httpConn.connect();
				// use getResponseCode() to get the response code.
				//response = httpConn.getResponseMessage();
				statusCode= httpConn.getResponseCode();
				if(statusCode == 404){
					System.out.println("test" + statusCode + link);
				}
				httpConn.disconnect();
			}catch(Exception e){
				
			}

		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		TestBrokenAllLinks obj = new TestBrokenAllLinks();
		obj.setup();
		obj.verifyLinks();
		System.out.println("Verification done");
	}

}
