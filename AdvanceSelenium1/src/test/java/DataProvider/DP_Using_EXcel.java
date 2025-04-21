package DataProvider;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.FileUtility.ExcelUtility;

public class DP_Using_EXcel {
	@Test(dataProvider = "getdata")
	public void sample(String brandname, String productname) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys(brandname, Keys.ENTER);
		WebElement price = driver
				.findElement(By.xpath("//div[text()='" + productname + "']/../../div[2]/div[1]/div[1]/div[1]"));
		System.out.println(price.getText());
	}

	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException {
		ExcelUtility elib = new ExcelUtility();
		int rowcount = elib.togetRowCount("Flip");
		Object[][] objarr = new Object[rowcount][2];
		for (int i = 0; i < rowcount; i++) {
			objarr[i][0] = elib.togetDataFromExcel("Flip", i + 1, 0);
			objarr[i][1] = elib.togetDataFromExcel("Flip", i + 1, 1);
		}
		return objarr;

	


}
	
		
}


