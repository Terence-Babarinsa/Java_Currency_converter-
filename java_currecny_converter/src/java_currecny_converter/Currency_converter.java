package java_currecny_converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Currency_converter {
	
	public static void main(String[] args) {
		try {
			prinitString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void prinitString() throws IOException {
		
		String country_code = "GBP";
	//object with API endpoint	
	URL url = new URL("https://open.er-api.com/v6/latest/" + country_code);
	
	//open connection to API
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	connection.setRequestMethod("GET");
	connection.connect();
	
	
	//reading response for api
	BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

	String line;
	StringBuilder response = new StringBuilder();
	
	while((line = reader.readLine()) !=null)
	{
		response.append(line);
	}
	reader.close();
	
	//calling api parser to find exchange to desired currency stated in class 
	ApiParser ApiParser = new ApiParser();
	
	String result = ApiParser.api_parser(response.toString());
	
	
	
	System.out.println(result);
	}
	
	}
	

