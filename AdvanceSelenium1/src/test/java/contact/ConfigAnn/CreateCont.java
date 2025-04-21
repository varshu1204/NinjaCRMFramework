package contact.ConfigAnn;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseTest.Base_Class;
import ObjectRepository.ContactPage;
import ObjectRepository.HomePage;

public class CreateCont extends Base_Class {

	@Test(groups = "smoke")
	public void createContact() throws InterruptedException, EncryptedDocumentException, IOException {
        
		
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.getContacts().click();
		ContactPage cp = new ContactPage(driver);
		Thread.sleep(3000);
		cp.getCreateContct().click();

		Thread.sleep(3000);

		String org = elib.togetDataFromExcel("Contact", 1, 2);
		String title = elib.togetDataFromExcel("Contact", 1, 3);
		String mobile = elib.togetDataFromExcel("Contact", 1, 4);
		String cname1 = elib.togetDataFromExcel("Contact", 1, 5);

		cp.getOrg().sendKeys(org);
		cp.getTitle().sendKeys(title);
		cp.getMobile().sendKeys(mobile);
		cp.getCname1().sendKeys(cname1);
		cp.getButton().click();

		wlib.switchToBrowser(driver);

		// select class usage
		WebElement ref = driver.findElement(By.id("search-criteria"));
		wlib.select(ref, 1);

		driver.findElement(By.id("search-input")).sendKeys(org);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();

		// switch back
		wlib.switchBack(driver);
		Thread.sleep(3000);
		cp.getCreateContactButton().click();

	}

}
