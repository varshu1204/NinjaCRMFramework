package DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP_Amazon {
	

	@Test(dataProvider = "getdata")
	public void getProductInfo(String brandname,String productname)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		
		//capture product info
		String x="//span[text()='"+productname+"']/../../../../div[2]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[1]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		
	}
	
	@DataProvider
	public Object[][] getdata(){
		
		Object[][] objarr=new Object[3][2];
		objarr[0][0]="iphone";
		objarr[0][1]="Apple iPhone 15 (128 GB) - Black";

		objarr[1][0]="iphone";
		objarr[1][1]="Apple iPhone 15 (128 GB) - Black";

		objarr[2][0]="iphone";
		objarr[2][1]="Apple iPhone 13 (128GB) - Blue";
		
		return objarr;
	}



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


