package api.task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonParser;

public class APIDayOneTask {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader reader = new FileReader("C:\\Users\\Sathiyakala\\eclipse-workspace\\APIProject\\src\\test\\resources\\JSONFile\\reqres.json");
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(reader);
		JSONObject j = (JSONObject)obj;
		Object objData = j.get("data");
		System.out.println(objData);
		Object objSupport = j.get("support");
		System.out.println(objSupport);
		JSONObject j1 = (JSONObject)objSupport;
		Object objUrl = j1.get("url");
		System.out.println(objUrl);
		Object objText = j1.get("text");
		System.out.println(objText);	
	}
}
