import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotDemo {

	public WebDriver driver;

	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.tutorialsninja.com/demo");
	}

	public void PressEnterKey() throws Exception {
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Samsung SyncMaster");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void moveMouseTest() throws Exception {
		
		Robot robot = new Robot();
		robot.mouseMove(146, 270);
	}

	public void screenShot() throws Exception {

		Robot robot = new Robot();

		Rectangle area = new Rectangle(10, 10, 1000, 800);

		BufferedImage bufferedImage = robot.createScreenCapture(area);

		File imageFile = new File(System.getProperty("user.dir") + "/files/capturedImage.png");

		Thread.sleep(5000);

		ImageIO.write(bufferedImage, "png", imageFile);
	}

	public void getFullPageScreenShot() throws Exception {

		Robot robot = new Robot();

		Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		BufferedImage bufferedImage = robot.createScreenCapture(area);

		File imageCaptured = new File(System.getProperty("user.dir") + "/files/capturedImage1.png");

		ImageIO.write(bufferedImage, "png", imageCaptured);
		Thread.sleep(5000);

		System.out.println("Full desktop screenshot saved");
	}

	public void scrollPageUpDwon() throws Exception {
		
		Robot robot = new Robot();
		robot.mouseWheel(40);
		Thread.sleep(300);
		robot.mouseWheel(-40);
	}

	public void clickMouseLeftButton() throws Exception {

		Robot robot = new Robot();

		robot.mouseMove(900, 190);

		Thread.sleep(2000);

		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	public void clickMouseRightButton() throws Exception {
		 
		Robot robot = new Robot();

		robot.mouseMove(170, 250);

		Thread.sleep(2000);

		robot.mousePress(InputEvent.BUTTON3_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_MASK);
	}

	public void tearDown(){
		driver.close();
	}
	public static void main(String[] args) throws Exception {

		RobotDemo obj = new RobotDemo();
		obj.setup();
		
		 obj.PressEnterKey();
		 obj.moveMouseTest(); 
		 obj.screenShot();
		 obj.getFullPageScreenShot();
		obj.scrollPageUpDwon();
		Thread.sleep(200);
		obj.clickMouseLeftButton();
		Thread.sleep(200);
		obj.clickMouseRightButton();
		Thread.sleep(200);
		obj.tearDown();
	}
}
