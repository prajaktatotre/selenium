import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtables {

	public WebDriver driver;

	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com");
	}

	public void getTableHeading() {

		List<WebElement> tableHeadings = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

		System.out.println("Printing Head of table");
		for (int i = 0; i < tableHeadings.size(); i++) {

			System.out.println(tableHeadings.get(i).getText());

		}
		System.out.println("------------------------------------------");

	}

	public void getCellData() {

		List<WebElement> dataCells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));

		System.out.println("Printing cell data of Table:");
		for (int i = 0; i < dataCells.size(); i++) {

			System.out.println(dataCells.get(i).getText());

		}

		System.out.println("------------------------------------------");
	}

	public void getRows() {

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

		System.out.println("Printing Rows of Table:");

		for (int i = 0; i < rows.size(); i++) {

			System.out.println(rows.get(i).getText());

		}
		System.out.println("------------------------------------------");
	}

	public void getCellDataFromRows() {

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Printing cgetCellDataFromRows:");

		for (int rNum = 0; rNum < rows.size(); rNum++) {

			List<WebElement> cells = rows.get(rNum).findElements(By.tagName("td"));

			for (int cNum = 0; cNum < cells.size(); cNum++) {

				System.out.print(cells.get(cNum).getText() + " ");

			}

			System.out.println(" ");

		}
		System.out.println("------------------------------------------");
	}

	public void getcolumnValue() {

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Printing columnValue of Table:");
		for (int rNum = 0; rNum < rows.size(); rNum++) {

			List<WebElement> cells = rows.get(rNum).findElements(By.tagName("td"));

			for (int cNum = 0; cNum < cells.size(); cNum++) {

				System.out.print(cells.get(cNum).getText() + " ");

			}

			System.out.println(" ");

		}
		System.out.println("------------------------------------------");
	}

	public void getEntireTable() {

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Printing Entire Table :");
		for (int rNum = 0; rNum < rows.size(); rNum++) {

			List<WebElement> cells = rows.get(rNum).findElements(By.tagName("td"));

			for (int cNum = 0; cNum < cells.size(); cNum++) {

				System.out.print(cells.get(cNum).getText() + " ");

			}

			System.out.println(" ");

		}
		System.out.println("------------------------------------------");
	}

	public void tearDown(){
		driver.close();
	}
	
	public static void main(String[] args) {

		Webtables obj = new Webtables();
		obj.setup();
		obj.getEntireTable();
		obj.getTableHeading();
		obj.getCellData();
		obj.getRows();
		obj.getCellDataFromRows();
		obj.getcolumnValue();
		obj.tearDown();
	}
}
