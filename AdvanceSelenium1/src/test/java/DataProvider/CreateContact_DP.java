package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP {
	
	
	@Test(dataProvider = "getdata")
	public void createContact(String Firstname,String Lastname,long phoneno) {
		System.out.println("Firstname:"+ Firstname + ",Lastname:"+ Lastname + ",phoneno:"+phoneno);
	}
	
	@DataProvider
	public Object[][] getdata() {
		
		Object[][] objarr=new Object[3][3];
		objarr[0][0]= "deepak";
	    objarr[0][1]= "kumar";
	    objarr[0][2]= 1234567890l;
		
	    objarr[1][0]= "varsh";
	    objarr[1][1]= "raj";
	    objarr[1][2]=1234567899l;

		
	    objarr[2][0]= "Ammu";
	    objarr[2][1]= "manoj";
	    objarr[2][2]=1234567898l;

		
		return objarr;
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
