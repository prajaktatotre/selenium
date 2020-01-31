package sikuli;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class TestSikuli {
	
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		
		Screen screen=new Screen();
		Pattern email = new Pattern(System.getProperty("user.dir") + "/imageFiles/emailField");
		Pattern password = new Pattern(System.getProperty("user.dir") + "/imageFiles/PasswordField");
		Pattern login = new Pattern(System.getProperty("user.dir") + "/imageFiles/LoginButton");

		screen.type(email, "ravi.kiran1@gmail.com");
		screen.type(password, "rkiran");
		screen.click(login);
	}

}
