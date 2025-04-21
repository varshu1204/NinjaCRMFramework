package Generic.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	
	public int togetRandomNumber()
	
	{
		Random random=new Random();
		int randomcount = random.nextInt();
		return randomcount;
		
		
		
	}
	
	public String togetSystemDate()
	{
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateobj);
		return date;
		
	}
	
	public String togetRequiredDate(int days)
	
	{
		SimpleDateFormat sim=new SimpleDateFormat();
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String Reqdate = sim.format(cal.getTime());
		return Reqdate;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
