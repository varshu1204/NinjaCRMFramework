package Generic.FileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import jdk.internal.org.jline.reader.Parser;

public class JsonUtility {
	
	public String togetDataFromJson(String key) throws IOException, ParseException {
		
	
	FileReader fir=new FileReader("./ConfigAppData/Commondata.json");
	JSONParser parser=new JSONParser();
	Object obj = parser.parse(fir);
	JSONObject map=(JSONObject) obj;
	String data = (String) map.get(key);
	return data;
	
	


	
	
	}
	
	
	
	
	
	

}
