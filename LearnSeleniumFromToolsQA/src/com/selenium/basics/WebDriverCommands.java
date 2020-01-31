package com.selenium.basics;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommands {

	WebDriver driver;

	public void setup() {

		System.setProperty("webdriver.chrome.driver", "/home/prajakta/Desktop/Resume/selenium/coding/chromedriver");
		driver = new ChromeDriver();
		// driver.get("https://www.google.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	public void getCommands() {
		driver.get("https://www.toolsqa.com");
		String title = driver.getTitle();
		System.out.println("Title of the page is : " + title);
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is : " + currentURL);
		String pageSource = driver.getPageSource();
		// System.out.println(" Page source is : " + pageSource); --- Huge
		// information

	}

	public void navigationCommands() {
		driver.navigate().to("https://www.google.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

	}

	public void webElementCommands() {

		WebElement element = driver.findElement(By.name("q"));

		element.clear(); // driver.findElement(By.name("q")).clear(); syntax
							// applicable for other below commands
		element.click();
		element.submit(); // This method works well/better than the click() if
							// the current element is a form, or an element
							// within a form
		element.sendKeys("selenium tutorials");
		boolean status = element.isDisplayed();
		String text = element.getText();
		String tagname = element.getTagName();
		String attribute = element.getAttribute("name");
		System.out.println(" element is displayed ?: " + status + "\n text of element: " + text + "\n tagname: "
				+ tagname + "\n name attribute is: " + attribute);

		Dimension dimension = element.getSize();
		int height = dimension.height;
		System.out.println(" height of element: " + height + "\t width of elementis: " + dimension.width);

		Point point = element.getLocation();
		int xCordinate = point.x;
		System.out.println(" x cordinate is:" + xCordinate + "\t y cordiante is:" + point.y);

		// String cssval = element.getCssValue(); don't know right syntax

		driver.get("https://www.rediffmail.com");
		driver.findElement(By.className("signin")).click();

		boolean isSelected = driver.findElement(By.id("remember")).isSelected();
		boolean isEnabled = driver.findElement(By.id("remember")).isEnabled();

		System.out.println(" element isSelected? :" + isSelected + "\n element isEnabled? :" + isEnabled);
	}

	public void elementLocatorCommands() {
		// also findElement() or findElements() commands

		driver.get("http://www.amazon.com");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("redmi phone");
		driver.findElement(By.className("nav-input")).click();
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Today's")).click();
		driver.findElement(By.linkText("Today's Deals")).click();
		driver.findElement(By.name("field-keywords")).sendKeys("selenium ");
		/*
		 * syntax: By.cssSelector("tag#id_value") or
		 * By.cssSelector("tag.classValue") or By.cssSelector("tag[value='']")
		 */
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("books");
		/*
		 * xpath: absolute-> /html reference node relative-> //any tag name
		 * which acts as reference node
		 */
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	// we will use http://toolsqa.com/automation-practice-form for
	// radiobutton,checkbox, dropdrown and mutliple selection commands
	public void radioButtonCommands() {
		driver.get("http://toolsqa.com/automation-practice-form");
		List<WebElement> radioButtons = driver.findElements(By.name("sex"));
		boolean bvalue = false;
		bvalue = radioButtons.get(0).isSelected();
		if (bvalue == true) {
			radioButtons.get(1).click();
		} else {
			radioButtons.get(0).click();
		}

		WebElement radioButtonExp = driver.findElement(By.id("exp-2"));
		radioButtonExp.click();

	}

	public void checkBoxCommands() {

		driver.findElement(By.xpath("//input[@id='profession-1']")).click();

		// OR

		List<WebElement> chkBx_Profession = driver.findElements(By.name("profession"));

		// This will tell you the number of Check Boxes are present
		int iSize = chkBx_Profession.size();

		// Start the loop from first Check Box to last Check Boxe
		for (int i = 0; i < iSize; i++) {
			// Store the Check Box name to the string variable, using 'Value'
			// attribute
			String sValue = chkBx_Profession.get(i).getAttribute("value");

			// Select the Check Box it the value of the Check Box is same what
			// you are looking for
			if (sValue.equalsIgnoreCase("Automation Tester")) {
				chkBx_Profession.get(i).click();
				// This will take the execution out of for loop
				break;
			}
		}

		WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
		oCheckBox.click();

	}

	public void dropDownCommands() throws InterruptedException {

		// select the dropdown
		Select continents = new Select(driver.findElement(By.id("continents")));

		// select by VisibleText
		continents.selectByVisibleText("Europe");
		Thread.sleep(2000);

		// select by Index
		continents.selectByIndex(2);
		Thread.sleep(2000);

		// getOptions
		List<WebElement> numberOfOptions = continents.getOptions();// int
																	// numberOfOptionsInDropdrown
																	// =
																	// continents.getOptions().size();
		int numberOfOptionsInDropdrown = numberOfOptions.size();

		// print all options
		for (int i = 0; i < numberOfOptionsInDropdrown; i++) {
			String name = continents.getOptions().get(i).getText();
			System.out.println("name is: " + name);

			if (name.equals("Australia")) {
				continents.selectByIndex(i);
				break;
			}
		}

	}

	public void MultipleSelectionCommands() throws InterruptedException {

		WebElement selCommands = driver.findElement(By.name("selenium_commands"));
		Select mulitpleSelectionBox = new Select(selCommands);

		// OR : Select mulitpleSelectionBox = new
		// Select(driver.findElement(By.name("selenium_commands")));

		// Select option 'Browser Commands' and then deselect it
		mulitpleSelectionBox.selectByIndex(0);
		Thread.sleep(2000);
		mulitpleSelectionBox.deselectByIndex(0);

		// Select option 'Navigation Commands' and then deselect it
		mulitpleSelectionBox.selectByVisibleText("Navigation Commands");
		Thread.sleep(2000);
		mulitpleSelectionBox.deselectByVisibleText("Navigation Commands");
		mulitpleSelectionBox.deselectAll();
		Thread.sleep(2000);

		// selecting all elements one by one
		int size = mulitpleSelectionBox.getOptions().size();
		System.out.println("size is: " + size);
		for (int i = 0; i < size; i++) {

			mulitpleSelectionBox.selectByIndex(i);
		}
		Thread.sleep(2000);
	}

	public void dynamicWebTablesCommands() {

		driver.get("http://toolsqa.com/automation-practice-table");

		// if row and column number is known
		String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[2]")).getText();
		System.out.println("data in row 1 and col 2:" + sCellValue);

		// click on link at row 1 and last col
		driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[6]/a")).click();
		System.out.println("Link has been clicked otherwise an exception would have thrown");

	}

	public void switchWindowCommands() throws InterruptedException {
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");

		// get window handle of current page
		String handle = driver.getWindowHandle();
		System.out.println("Name of first window: " + handle);

		driver.findElement(By.xpath("//button[contains(text(),'New Message Window')]")).click();

		// store and print the name of all the window open
		Set<String> handles = driver.getWindowHandles();
		System.out.println("Name of windows: " + handles);

		// pass the window handle to other window
		for (String handle1 : driver.getWindowHandles()) {

			driver.switchTo().window(handle1);

		}

		/*
		 * driver.findElement(By.id("alert")).click(); //switch to javaScript
		 * alert window Alert myAlert = driver.switchTo().alert();
		 * myAlert.accept();
		 */

	}

	public void iFrames() throws InterruptedException {
		// iFrame is a HTML document embedded inside an HTML document.iFrame is
		// defined by an <iframe></iframe> tag in HTML.

		driver.get("https://www.toolsqa.com/iframe-practice-page/");

		// 1.get total number of iframes on webpage

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(" Total number of iframes :" + size);

		// 2. switch to frame by index
		driver.switchTo().frame(0);

		// 3. switch to main page from frame
		driver.switchTo().defaultContent();

		// 4. switch to frame by name
		driver.switchTo().frame("iframe1");

		driver.switchTo().defaultContent();
		// 5.switch by frame Id
		driver.switchTo().frame("IF1");

	}

	public void AlertsAndPopups() {
		driver.get("http://jsbin.com/usidix/1");
		driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
		driver.switchTo().alert().accept();
		// coming soon

	}

	public void waitCommands() {
		// 1. already use implicit wait in setup function
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 2. pageLoadTimeout command
		// driver.manage().timeouts().pageLoadTimeout(100, SECONDS);

		// 3. thread.sleep command

		// 4. SetScriptTimeout Command: Sets the amount of time to wait for an
		// asynchronous script to finish execution before throwing an error.
		// driver.manage().timeouts().setScriptTimeout(100,SECONDS);

		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.findElement(By.id("timingAlert")).click();
		// Create new WebDriver wait

		WebDriverWait wait = new WebDriverWait(driver, 10);

		Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());

		myAlert.accept();

	}

	public void ActionAndRobotClass() throws InterruptedException {

		Actions actions = new Actions(driver);

		// Mouse Events
		// 1. Right click
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightClickButton = driver.findElement(By.xpath("//*[text()='right click me']"));
		actions.contextClick(rightClickButton).build().perform();
		
		//2. Drag and Drop
		driver.get("https://jqueryui.com/droppable/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		WebElement source = driver.findElement(By.cssSelector("#draggable"));
		WebElement destination = driver.findElement(By.cssSelector("#droppable"));
		actions.dragAndDrop(source, destination).build().perform();
		// actions.dragAndDrop(source,destination).perform(); -- bcoz single
		// funcion dragAndDrop no need to build it
		
		//3. double click
		//actions.doubleClick(element).build().perform();
		
		//4. Mouse moveToElement
		driver.get("http://demoqa.com/menu/");
		WebElement elementToMove = driver.findElement(By.xpath("//*[text()='Music']"));
    	actions.moveToElement(elementToMove).perform();
    	WebElement subMenuOption = driver.findElement(By.xpath(".//div[contains(text(),'Rock')]")); 
    	actions.moveToElement(subMenuOption).perform();

	}

	public void tearDown() {

		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverCommands obj = new WebDriverCommands();
		obj.setup();
		/*
		 * obj.getCommands(); obj.navigationCommands();
		 * obj.webElementCommands(); obj.elementLocatorCommands();
		 * obj.radioButtonCommands(); obj.checkBoxCommands();
		 * obj.dropDownCommands(); obj.MultipleSelectionCommands();
		 * obj.dynamicWebTablesCommands(); obj.waitCommands();
		 * obj.switchWindowCommands(); obj.iFrames(); obj.AlertsAndPopups();
		 */
		obj.ActionAndRobotClass();
		obj.tearDown();

	}

}
