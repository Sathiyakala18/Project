package org.read.pojo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadPOJO {
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		File file = new File("C:\\Users\\Sathiyakala\\eclipse-workspace\\APIProject\\src\\test\\resources\\JSONFile\\POJO.json");
		ObjectMapper mapper = new ObjectMapper();
		Root r = mapper.readValue(file, Root.class);
		int page = r.getPage();
		System.out.println(page);
		
		int per_page = r.getPer_page();
		System.out.println(per_page);
		
		int total = r.getTotal();
		System.out.println(total);
		
		int total_pages = r.getTotal_pages();
		System.out.println(total_pages);
		
		Support support = r.getSupport();
		System.out.println(support.getUrl());
		System.out.println(support.getText());
		
		ArrayList<Datum> data = r.getData();
		for (Datum datum : data) {
			System.out.println(datum.getId());
			System.out.println(datum.getEmail());
			System.out.println(datum.getFirst_name());
			System.out.println(datum.getLast_name());
			System.out.println(datum.getAvatar());

		}
		
		
		
		
		
		
	
	
	}

}
  