package camp.ConfigAnnotation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseTest.Base_Class;
import Generic.webdriverUtility.UtilityClassObject;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.HomePage;

public class CreateCamp extends Base_Class {
	
	@Test(groups = "smoke")
	public void createCampaign() throws InterruptedException, EncryptedDocumentException, IOException {
		
         UtilityClassObject.getTest().log(Status.INFO, "read data from excel");

        // read from excel file
		String cname = elib.togetDataFromExcel("campaign", 1, 2) + jlib.togetRandomNumber();
		String size = elib.togetDataFromExcel("campaign", 1, 3);

        UtilityClassObject.getTest().log(Status.INFO, "navigate to campaign page");
        HomePage hp=new HomePage(driver);
        hp.campaign();
        UtilityClassObject.getTest().log(Status.INFO, "navigate to createcampaign page");
        CreateCampaignPage ccp=new CreateCampaignPage(driver);
        ccp.createcampaign(cname, size);
        ccp.getCreatebtn().click();
        Thread.sleep(3000);
        
        String message = ccp.getMsg().getText();
		boolean status = message.contains(cname);
	    Assert.assertTrue(status);


}
	
	@Test(groups = "regression")
	public void createCampWithDate() throws InterruptedException, EncryptedDocumentException, IOException {
		// read from excel file
				String cname = elib.togetDataFromExcel("campaign", 1, 2) + jlib.togetRandomNumber();
				String size = elib.togetDataFromExcel("campaign", 1, 3);
				
				String CloseDate = jlib.togetRequiredDate(20);
				Thread.sleep(3000);


				HomePage hp=new HomePage(driver);
		        hp.campaign();

		        CreateCampaignPage ccp=new CreateCampaignPage(driver);
		        ccp.createcampaign(cname, size);
		        
		        ccp.getExpectedCloseDate().sendKeys(CloseDate);
		        ccp.getCreatebtn().click();
		        
				Thread.sleep(3000);

				// validate
				String message = ccp.getMsg().getText();
				boolean status = message.contains(cname);
                Assert.assertTrue(status);



			}

	}

	
	
	
	
	
	
	
	
	
	
	

