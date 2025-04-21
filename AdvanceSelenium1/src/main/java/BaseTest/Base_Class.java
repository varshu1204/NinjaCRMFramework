package BaseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Generic.FileUtility.ExcelUtility;
import Generic.FileUtility.FileUtility;
import Generic.webdriverUtility.JavaUtility;
import Generic.webdriverUtility.UtilityClassObject;
import Generic.webdriverUtility.WebDriverUtility;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class Base_Class {
	
	public FileUtility flib=new FileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	
	public WebDriver driver = null;
	public static WebDriver sdriver=null;
	

	@BeforeSuite(groups={"smoke","regression"})
	public void beforeSuite() {
		
		Reporter.log("DB open and Report Config",true);
		
	}
	
	
//	@Parameters("BROWSER")
	@BeforeClass(groups={"smoke","regression"})
//	public void beforeClass(String browser) throws IOException {
//		
//		String BROWSER=browser;
	public void beforeClass() throws IOException {
		String BROWSER = flib.getDataFomPropertiesFile("Browser");
		
		if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		} else if(BROWSER.equals("Firefox")){
			driver = new FirefoxDriver();
		} else {
			driver=new ChromeDriver();
		}
		sdriver=driver; //listener purpose
		UtilityClassObject.setDriver(driver);
		
	}
	
	@BeforeMethod(groups={"smoke","regression"})
	public void beforeMethod() throws IOException {
		
		String URL = flib.getDataFomPropertiesFile("Url");
		String USERNAME = flib.getDataFomPropertiesFile("Username");
		String PASSWORD = flib.getDataFomPropertiesFile("Password");
		driver.manage().window().maximize();
        wlib.waitForPagetoLoad(driver);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("login");

		

	}
	

	@AfterSuite(groups={"smoke","regression"})
	public void afterSuite() {
		
		System.out.println("DB close and ReportBAckup");
		
		
	}
	
	@AfterClass(groups={"smoke","regression"})
	public void afterClass() {
		
		driver.quit();
		System.out.println("close browser");
		
	}
	
	@AfterMethod(groups={"smoke","regression"})
	public void afterMethod() {
		
		HomePage hp=new HomePage(driver);
		hp.logoutApp();
		System.out.println("logout");
		
	}

}
