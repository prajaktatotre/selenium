package com.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RunFireFox {

	public static void main(String[] args) throws InterruptedException {

		/*System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/Driver/geckodriver");
	    DesiredCapabilities capabilities = DesiredCapabilities.firefox();  
	    capabilities.setCapability("marionette",true);  
	    WebDriver driver= new FirefoxDriver(capabilities);  
		driver.get("http://www.google.com");

		Thread.sleep(5000);
		driver.quit();*/
		
		
		System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Driver/geckodriver");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver();
		driver.get("www.google.com");
	}
}
