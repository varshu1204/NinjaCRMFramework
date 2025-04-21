package ScriptBasedOnUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContact {

	public static void main(String[] args) throws InterruptedException, IOException {



		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();

		// read data from properties file

		String BROWSER = flib.getDataFomPropertiesFile("Browser");
		String URL = flib.getDataFomPropertiesFile("Url");
		String USERNAME = flib.getDataFomPropertiesFile("Username");
		String PASSWORD = flib.getDataFomPropertiesFile("Password");
	
				
				//read from excel
		String org = elib.togetDataFromExcel("Contact",1,2);
		String title = elib.togetDataFromExcel("Contact",1,3);
		String mobile = elib.togetDataFromExcel("Contact",1,4);
		String cname = elib.togetDataFromExcel("Contact",1,5);



				    WebDriver driver=null;
				    if(BROWSER.equals("Chrome"))
				    {
				    	driver=new ChromeDriver();
				    }
				    else if(BROWSER.equals("Edge"))
				    {
				    	driver=new EdgeDriver();
				    }
				    else {
				    	driver=new ChromeDriver();
				    }
					
				   //login to app
					
					driver.manage().window().maximize();
                    wlib.waitForPagetoLoad(driver);
					driver.get(URL);
					driver.findElement(By.id("username")).sendKeys(USERNAME);
					driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
					driver.findElement(By.xpath("//button[text()='Sign In']")).click();
				
				  //click on contact
					driver.findElement(By.linkText("Contacts")).click();
					driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
				
				  //enter mandatory details
					driver.findElement(By.name("organizationName")).sendKeys(org);
					driver.findElement(By.name("title")).sendKeys(title);
					driver.findElement(By.name("contactName")).sendKeys(cname);
					driver.findElement(By.name("mobile")).sendKeys(mobile);
					
				    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
				    
				   //switching
				    wlib.switchToBrowser(driver);

				    //select class usage
                    WebElement ref = driver.findElement(By.id("search-criteria"));
                    wlib.select(ref, 1);
				   
				    driver.findElement(By.id("search-input")).sendKeys(org);
				    driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
				    
				    //switch back
				    wlib.switchBack(driver);
                    
				    driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
				    Thread.sleep(2000);
				    
				    //mousehover
				  WebElement logout = driver.findElement(By.xpath("//div[@class='user-icon']"));
				    wlib.mouseHover(driver, logout);
                   driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();

			}

	
	
		
		
		
		
		
		
		
		
		
	}


