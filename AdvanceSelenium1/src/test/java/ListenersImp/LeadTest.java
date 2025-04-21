package ListenersImp;

import org.jspecify.annotations.Nullable;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.Base_Class;


@Listeners(ListenerUtility.ListenerImp.class)

public class LeadTest extends Base_Class {
	
	@Test
	public void createLead() {
		
		System.out.println("createLead");
        String actualtit = driver.getTitle();
        org.testng.Assert.assertEquals(actualtit, "Login");
        System.out.println("step 1");
        System.out.println("step 2");
        System.out.println("step 3");
        System.out.println("step 4");

		}
	
	@Test
	public void createLeadwithCampaign() {
		
		    System.out.println("createLead with campaign");
		    System.out.println("step 1");
	        System.out.println("step 2");
	        System.out.println("step 3");
	        System.out.println("step 4");

		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
