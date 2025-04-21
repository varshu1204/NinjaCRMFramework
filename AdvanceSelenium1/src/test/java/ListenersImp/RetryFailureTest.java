package ListenersImp;

import org.testng.annotations.Test;

import BaseTest.Base_Class;



public class RetryFailureTest {
	
	@Test(retryAnalyzer =ListenerUtility.RetryImp.class)
	public void activatesim()
	{
		System.out.println("RetryFailuretest");
       // org.testng.Assert.assertEquals("", "Login");
        System.out.println("step 1");
        System.out.println("step 2");
        System.out.println("step 3");
        System.out.println("step 4");

		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
