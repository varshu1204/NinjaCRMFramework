package Generic.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	
	public String getDataFomPropertiesFile(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream("./ConfigAppData/ninjaCommondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
	    return data;
		
		
	}
	
	
	

}
