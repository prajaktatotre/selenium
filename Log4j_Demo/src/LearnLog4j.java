import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLog4j {

	//public static Logger log = Logger.getLogger(LearnLog4j.class.getName());

	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public static void main(String[] args){
		
		//PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/log4j.properties");
		
		System.setProperty("webdriver.chrome.driver", "/home/prajakta/Desktop/Resume/selenium/coding/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		log.info("google.com got opened");
		log.debug("Brower with specified url got opened");
		
	}
}
