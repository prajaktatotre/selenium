import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunFirefoxTest {


	public static void main(String[] args) throws Exception {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver1 = new FirefoxDriver();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.get("http://www.tutorialsninja.com/demo");
		
		Thread.sleep(300);
		driver1.close();
		
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.tutorialsninja.com/demo");
		Thread.sleep(200);
		driver.close();*/
	
	}
}
