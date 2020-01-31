import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCookiesHandling {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.zoho.com");
		driver.manage().window().maximize();

		driver.findElement(By.className("zh-login")).click();
		driver.findElement(By.id("login_id")).sendKeys("seleniumtraining11292017@gmail.com");
		driver.findElement(By.id("nextbtn")).click();
		/*
		 * driver.navigate().refresh();
		 * driver.findElement(By.id("password")).sendKeys("SeleniumTester$");
		 * driver.findElement(By.id("nextbtn")).click();
		 */

		Set<Cookie> cookie = driver.manage().getCookies();
		Iterator<Cookie> itr = cookie.iterator();

		while (itr.hasNext()) {
			Cookie cookiex = itr.next();
			System.out.println(cookiex.getName() + "" + cookiex.getValue() + "" + cookiex.getDomain() + "" + cookiex.getPath());

		}

		System.out.println("-----------------------");
		Cookie newCookie = new Cookie("Prajakta", "SeleniumTester");
		driver.manage().addCookie(newCookie);

		Set<Cookie> cookie1 = driver.manage().getCookies();
		Iterator<Cookie> itr1 = cookie1.iterator();

		while (itr1.hasNext()) {
			Cookie cookiey = itr1.next();
			System.out.println(
					cookiey.getName() + "" + cookiey.getValue() + "" + cookiey.getDomain() + "" + cookiey.getPath());
		}
		System.out.println("-----------------------");
		driver.manage().deleteAllCookies();
		Set<Cookie> cookie2 = driver.manage().getCookies();
		Iterator<Cookie> itr2 = cookie2.iterator();

		while (itr1.hasNext()) {
			Cookie cookiez = itr2.next();
			System.out.println(
					cookiez.getName() + "" + cookiez.getValue() + "" + cookiez.getDomain() + "" + cookiez.getPath());
		}
		System.out.println("-----------------------");
		
		driver.quit();

	}
}
