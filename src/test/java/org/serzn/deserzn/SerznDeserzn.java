package org.serzn.deserzn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.restassured2.BaseClass;
import api.restassured2.Endpoint;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
public class SerznDeserzn extends BaseClass {

	String logtoken;
	int jSonPathNumber;
	int address_id;
	@Test(priority = 1)
	private void LoginDetails() throws IOException {																									
	
	addHeader("Context-Type", "application/json");
	basicAuth(getPropertyValue("email"), getPropertyValue("password"));
	Response response = requestType("POST", api.restassured2.Endpoint.LOGIN);
	Login_Output_Pojo Login_Output_Pojo = response.as(Login_Output_Pojo.class);
	int responseCode = getResponseCode(response);
	System.out.println(responseCode);
	String bodyAsPrettyString = getBodyAsPrettyString(response);
	System.out.println(bodyAsPrettyString);
	
	logtoken = JsonPath("data.logtoken",response);
	System.out.println(logtoken);
	Assert.assertEquals(Login_Output_Pojo.getMessage(), "Login successfully", "Verify Login successfully");
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
	AddAddress_Input_Pojo AddAddress_Input_Pojo = new AddAddress_Input_Pojo("Sathiyakala", "Ravi", "9940447853", "VaikasiKudil", 33, 3378, 91, "600015", "S2 Narayanasamy", "Home");
	addpayload(AddAddress_Input_Pojo);
	Response response = requestType("POST",api.restassured2.Endpoint.ADD_ADDRESS);
	System.out.println(getResponseCode(response));
	System.out.println(getBodyAsPrettyString(response));
	String msg = JsonPath("message", response);
	AddAddress_Output_Pojo AddAddress_Output_Pojo = response.as(AddAddress_Output_Pojo.class);
	System.out.println(AddAddress_Output_Pojo);
	address_id  = AddAddress_Output_Pojo.getAddress_id();	
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
	
	Response response = requestType("PUT",api.restassured2.Endpoint.UPDATE_ADDRESS);
	System.out.println(getResponseCode(response));
	System.out.println(getBodyAsPrettyString(response));
	String msg = JsonPath("message", response);
	Assert.assertEquals(msg, "Address added successfully", "verify address updated successfully");
	}
//	@Test(priority=4)
//	private void GetAddress() {
//	List<Header> header = new ArryLisy<>();
//	Header h1 = new Header()
//
	@Test(priority=4)
	private void GetAddress() {
	java.util.List<Header> header = new ArrayList<>();
	Header h1 = new Header("Content-Type", "application/json");
	Header h2 = new Header("Authorization", "Bearer "+logtoken);
	header.add(h1);
	header.add(h2);
	
	Headers headers = new Headers(header);
	addHeaders(headers);
	
	Response response2 = requestType("GET",Endpoint.GET_ADDRESS);
	GetAddress_Output_Pojo getAddress_Output_Pojo = response.as(GetAddress_Output_Pojo.class);	
	int responseCode = getResponseCode(response2);
	System.out.println(responseCode);
	System.out.println(getBodyAsPrettyString(response2));
	Assert.assertEquals(getAddress_Output_Pojo.getMessage(), "OK", "Verify address got successfully");
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
	
	Response response2 = requestType("DELETE",api.restassured2.Endpoint.DELETE_ADDRESS);
	DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(""+address_id+"");
	addpayload(deleteAddress_Input_Pojo);
	System.out.println(getResponseCode(response2));
	System.out.println(getBodyAsPrettyString(response2));
	String msg = JsonPath("message", response2);
	Assert.assertEquals(msg,"address_id key is missing", "Verify address deleted successfully");
	}
//	@Test(priority=6)
//	private void ChangeProfilePic() {
//	java.util.List<Header> header = new ArrayList<>();
//	Header h1 = new Header("Authorization", "Bearer "+logtoken);
//	Header h2 = new Header("Content-Type", "application/json");
//	header.add(h1);
//	header.add(h2);
//		
//	Headers headers = new Headers(header);
//	addHeaders(headers);
//	
//	multipart();
//	
//	Response response = requestType("POST", Endpoint.CHANGE_PROFILE_PIC);
//	System.out.println(getResponseCode(response));
//	System.out.println(getBodyAsPrettyString(response));
//	
//	}
}	
	
	
	

