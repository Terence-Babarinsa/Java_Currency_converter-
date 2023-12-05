package java_currecny_converter;
import org.json.JSONObject;



public class ApiParser {
	
	public String api_parser(String apiResponse) {
		//parse json string
		JSONObject jsonResponse = new JSONObject(apiResponse);
		
		//desired key
		String desiredKey = "AED";
		//desired vlaue
		String desiredValue = null;
		//check if desired key exists within JSON
		if (jsonResponse.has(desiredKey)) {
			
			 desiredValue = jsonResponse.getString(desiredKey);
		}
		return desiredValue;
	}
	

}
