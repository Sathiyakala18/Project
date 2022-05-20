package api.task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONArray {
	
	public static void main(String[] args) throws IOException, ParseException {
		FileReader reader = new FileReader
				("C:\\Users\\Sathiyakala\\eclipse-workspace\\APIProject\\src\\test\\resources\\JSONFile\\Array.json");
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(reader);
		JSONObject j = (JSONObject)obj; 
		Object objStudentDetail = j.get("studentDetails");
		org.json.simple.JSONArray a = (org.json.simple.JSONArray) objStudentDetail;
		for (int i = 0; i < a.size(); i++) {
		Object allCourseDetail = a.get(i);
		JSONObject	j2 = (JSONObject) allCourseDetail;
		System.out.println(j2.get("firstName"));
		System.out.println(j2.get("course"));
		System.out.println(j2.get("Address"));
			
		}
	
		
	}

}
