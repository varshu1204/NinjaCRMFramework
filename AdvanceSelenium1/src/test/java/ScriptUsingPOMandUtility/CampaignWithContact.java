package ScriptUsingPOMandUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Generic.FileUtility.ExcelUtility;
import Generic.FileUtility.FileUtility;
import Generic.webdriverUtility.JavaUtility;
import Generic.webdriverUtility.WebDriverUtility;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class CampaignWithContact {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {



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
        

		Thread.sleep(3000);

		// validate
		String message = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if (message.contains(cname)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
     
		//contact creating
        hp.getContacts().click();
        ContactPage cp=new ContactPage(driver);
        Thread.sleep(3000);
        cp.getCreateContct().click();
        
        
		Thread.sleep(3000);


		String org = elib.togetDataFromExcel("Contact", 1, 2);
		String title = elib.togetDataFromExcel("Contact",1,3);
		String mobile = elib.togetDataFromExcel("Contact",1,4);
		String cname1 = elib.togetDataFromExcel("Contact",1,5);

        cp.getOrg().sendKeys(org);
        cp.getTitle().sendKeys(title);
        cp.getMobile().sendKeys(mobile);
        cp.getCname1().sendKeys(cname1);
        cp.getButton().click();

        

		// enter mandatory details
		
		 wlib.switchToBrowser(driver);

		    //select class usage
         WebElement ref = driver.findElement(By.id("search-criteria"));
         wlib.select(ref, 1);
		   
		    driver.findElement(By.id("search-input")).sendKeys(org);
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
		    
		    //switch back
		    wlib.switchBack(driver);
		    Thread.sleep(3000);
            cp.getCreateContactButton().click();

		    
		   Thread.sleep(2000);
		    hp.getClose();
			Thread.sleep(3000);
			 hp.logoutApp();


	}


	}


