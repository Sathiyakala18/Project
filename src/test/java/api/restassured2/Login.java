package api.restassured2;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Login extends BaseClass{
	String logtoken;
	int jSonPathNumber;
	@Test(priority = 1)
	private void logvels() throws IOException {																									
	
	addHeader("Context-Type", "application/json");
	basicAuth(getPropertyValue("email"), getPropertyValue("password"));
	Response requestType = requestType("POST", api.restassured2.Endpoint.LOGIN);
	int responseCode = getResponseCode(requestType);
	System.out.println(responseCode);
	String bodyAsPrettyString = getBodyAsPrettyString(requestType);
	System.out.println(bodyAsPrettyString);
	
	logtoken = JsonPath("data.logtoken",response);
	System.out.println(logtoken);
	}
	@Test(priority=2)
	private void CreateAddress() {
	java.util.List<Header> header = new ArrayList<>();
	Header h1 = new Header ("accept", "application/json");
	Header h2 = new Header("Authorization", "Bearer "+logtoken);
	Header h3 = new Header("Content-Type", "application/json");
	header.add(h1);
	header.add(h2);
	header.add(h3);
	
	Headers headers = new Headers(header);
	addHeaders(headers);
	
	addpayload("{\r\n" + 
			"  \"first_name\": \"sathi\",\r\n" + 
			"  \"last_name\": \"Ravi\",\r\n" + 
			"  \"mobile\": \"1234567898\",\r\n" + 
			"  \"apartment\": \"apartment\",\r\n" + 
			"  \"state\": 33,\r\n" + 
			"  \"city\": 3378,\r\n" + 
			"  \"country\": 101,\r\n" + 
			"  \"zipcode\": \"202020\",\r\n" + 
			"  \"address\": \"64/63 partap nagar\",\r\n" + 
			"  \"address_type\": \"home\"\r\n" + 
			"}");
	
	Response response2 = requestType("POST",api.restassured2.Endpoint.ADD_ADDRESS);
	System.out.println(getResponseCode(response));
	System.out.println(getBodyAsPrettyString(response));
	String msg = JsonPath("message", response2);
	Assert.assertEquals(msg, "Address added successfully", "verify address creation");
	}
	@Test(priority=3)
	private void UpdateAddress() {
	java.util.List<Header> header = new ArrayList<>();
	Header h1 = new Header ("accept", "application/json");
	Header h2 = new Header("Authorization", "Bearer "+logtoken);
	Header h3 = new Header("Content-Type", "application/json");
	header.add(h1);
	header.add(h2);
	header.add(h3);
	
	Headers headers = new Headers(header);
	addHeaders(headers);
	
	addpayload("{\r\n" + 
			"  \"address_id\": \""+jSonPathNumber+"\",\r\n" + 
			"  \"first_name\": \"Sathi\",\r\n" + 
			"  \"last_name\": \"Ravi\",\r\n" + 
			"  \"mobile\": \"1234567898\",\r\n" + 
			"  \"apartment\": \"apartment\",\r\n" + 
			"  \"state\": 33,\r\n" + 
			"  \"city\": 3378,\r\n" + 
			"  \"country\": 101,\r\n" + 
			"  \"zipcode\": \"202020\",\r\n" + 
			"  \"address\": \"64/63 partap nagar\",\r\n" + 
			"  \"address_type\": \"home\"\r\n" + 
			"}");
	
	Response response2 = requestType("PUT",api.restassured2.Endpoint.UPDATE_ADDRESS);
	System.out.println(getResponseCode(response));
	System.out.println(getBodyAsPrettyString(response));
	String msg = JsonPath("message", response2);
	Assert.assertEquals(msg, "Address added successfully", "verify address updated successfully");
	}
	@Test(priority=4)
	private void GetAddress() {
	java.util.List<Header> header = new ArrayList<>();
	Header h1 = new Header("Authorization", "Bearer "+logtoken);
	Header h2 = new Header("Content-Type", "application/json");
	header.add(h1);
	header.add(h2);
	
	Headers headers = new Headers(header);
	addHeaders(headers);
	
	Response response2 = requestType("GET",api.restassured2.Endpoint.GET_ADDRESS);
	System.out.println(getResponseCode(response));
	System.out.println(getBodyAsPrettyString(response));
	String msg = JsonPath("message", response2);
	Assert.assertEquals(msg, "OK", "Verify address got successfully");
	}
	@Test(priority=5)
	private void DeleteAddress() {
	java.util.List<Header> header = new ArrayList<>();
	Header h1 = new Header("Authorization", "Bearer "+logtoken);
	Header h2 = new Header("Content-Type", "application/json");
	header.add(h1);
	header.add(h2);
	
	Headers headers = new Headers(header);
	addHeaders(headers);
	
	addpayload("{\\r\\n\"\r\n" + 
			"+ \"  \\\"address_id\\\": \\\"\""+jSonPathNumber+"\"\\\",\\r\\n\"\r\n" + 
			"+ \"  \\\"first_name\\\": \\\"Raj\\\",\\r\\n\"\r\n" + 
			"+ \"  \\\"last_name\\\": \\\"Khundra\\\",\\r\\n\"\r\n" + 
			"+ \"  \\\"mobile\\\": \\\"1234567898\\\",\\r\\n\"\r\n" + 
			"+ \"  \\\"apartment\\\": \\\"apartment\\\",\\r\\n\"\r\n" + 
			"+ \"  \\\"state\\\": 33,\\r\\n\"\r\n" + 
			"+ \"  \\\"city\\\": 3378,\\r\\n\"\r\n" + 
			"+ \"  \\\"country\\\": 101,\\r\\n\"\r\n" + 
			"+ \"  \\\"zipcode\\\": \\\"202020\\\",\\r\\n\"\r\n" + 
			"+ \"  \\\"address\\\": \\\"64/63 partap nagar\\\",\\r\\n\"\r\n" + 
			"+ \"  \\\"address_type\\\": \\\"home\\\"\\r\\n\"\r\n" + 
			"+ \"}");
	
	Response response2 = requestType("DELETE",api.restassured2.Endpoint.DELETE_ADDRESS);
	System.out.println(getResponseCode(response));
	System.out.println(getBodyAsPrettyString(response));
	String msg = JsonPath("message", response2);
	Assert.assertEquals(msg,"address_id key is missing", "Verify address deleted successfully");
	}
	
}