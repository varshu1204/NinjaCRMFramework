package ScriptBasedOnUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic.FileUtility.ExcelUtility;
import Generic.FileUtility.FileUtility;
import Generic.webdriverUtility.JavaUtility;
import Generic.webdriverUtility.WebDriverUtility;

public class CreateCampaign {

	public static void main(String[] args) throws IOException, InterruptedException {


		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();

		//read from Properties file
		String BROWSER = flib.getDataFomPropertiesFile("Browser");
		String URL = flib.getDataFomPropertiesFile("Url");
		String USERNAME = flib.getDataFomPropertiesFile("Username");
		String PASSWORD = flib.getDataFomPropertiesFile("Password");



		// read from excel file
		String cname = elib.togetDataFromExcel("campaign", 1, 2) + jlib.togetRandomNumber();
		String size = elib.togetDataFromExcel("campaign", 1, 3);

		WebDriver driver = null;
		if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// login to app

		driver.manage().window().maximize();
        wlib.waitForPagetoLoad(driver);
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();

		// create campaign
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();

		// enter mandatory fields
		driver.findElement(By.name("campaignName")).sendKeys(cname);
		driver.findElement(By.name("targetSize")).sendKeys(size);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		Thread.sleep(3000);

		// validate
		String message = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if (message.contains(cname)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

		// logout
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@class='user-icon']"))).click().perform();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();

	}

}
