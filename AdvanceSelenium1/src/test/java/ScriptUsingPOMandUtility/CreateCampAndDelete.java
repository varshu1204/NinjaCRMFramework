package ScriptUsingPOMandUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic.FileUtility.ExcelUtility;
import Generic.FileUtility.FileUtility;
import Generic.webdriverUtility.JavaUtility;
import Generic.webdriverUtility.WebDriverUtility;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class CreateCampAndDelete {

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
		
        LoginPage lp=new LoginPage(driver);
        lp.login(USERNAME, PASSWORD);
        
        HomePage hp=new HomePage(driver);
        hp.campaign();

        CreateCampaignPage ccp=new CreateCampaignPage(driver);
        ccp.createcampaign(cname, size);
        WebElement msg = driver.findElement(By.xpath("//div[@role='alert']"));
        wlib.waitForElementPresent(driver, msg);
     
     		
     		if (msg.getText().contains(cname)) {
     			System.out.println("pass");
     		} else {
     			System.out.println("fail");
     		}
        
        WebElement ele = driver.findElement(By.className("form-control"));
        wlib.select(ele, 1);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(cname);
        driver.findElement(By.xpath("//td[text()='"+cname+"']/..//a[@class='delete']")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		hp.getClose().click();
		Thread.sleep(3000);
		hp.getClose().click();
        hp.logoutApp();
        driver.quit();
	}

}
