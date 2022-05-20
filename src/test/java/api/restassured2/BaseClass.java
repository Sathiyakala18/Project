	package api.restassured2;
	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;	
	import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
	import io.restassured.response.ResponseBody;
	import io.restassured.specification.RequestSpecification;
	
	public class BaseClass {
	
	RequestSpecification reqSpec;
	public Response response;
	
	public void addHeader(String key , String value) {
	reqSpec = RestAssured.given().header(key,value);
	}
	
	public void queryParam(String key , String value) {
	reqSpec = reqSpec.queryParam(key,value);
	}
	
	public void pathParam(String key , String value) {
	reqSpec = reqSpec.pathParam(key,value);
	}
	public void basicAuth(String key, String value) {
	reqSpec = reqSpec.auth().preemptive().basic(key, value);
	}
	
	public void addpayload(String s) {
	reqSpec = reqSpec.body(s);
	}
	public void addpayload(Object s) {
		reqSpec = reqSpec.body(s);
		}
	
	public Response requestType(String type, String endppoint) {
	switch (type) {
	case "GET":
	response = reqSpec.log().all().get(endppoint);
	break;
	case "POST":
	response = reqSpec.log().all().post(endppoint);
	break;
	case "PUT":
	response = reqSpec.log().all().put(endppoint);
	break;
	case "DELETE":
	response = reqSpec.log().all().delete(endppoint);
	break;
	
	default:
	break;
	}
	return response;
	
	}
	
	public int getResponseCode(Response response) {
	int statusCode = response.getStatusCode();
	return statusCode;
	}
	public ResponseBody getResBody(Response response) {
	ResponseBody body = response.getBody();
	return body;
	}
	
	public String getBodyAsString(Response response) {
	String asString = getResBody(response).asString();
	return asString;
	}
	public String getBodyAsPrettyString(Response response) {
	String asString = getResBody(response).prettyPrint();
	return asString;	
	}	
	public String getPropertyValue(String key) throws IOException {
	FileInputStream stream = new FileInputStream("C:\\Users\\Sathiyakala\\eclipse-workspace\\APIProject\\src\\test\\resources\\credential.properties");
	Properties properties = new Properties();
	properties.load(stream);
	Object obj = properties.get(key);
	String s = (String) obj;
	return s;	
	}	
	public String JsonPath(String key, Response response) {
	JsonPath jsonPath = getResBody(response).jsonPath();
	Object object = jsonPath.get(key);
	String value = (String)object;
	return value;
	}
	public int JsonPathNumber(String key, Response response) {
	JsonPath jsonPath = getResBody(response).jsonPath();
	Object object = jsonPath.get(key);
	Integer value = (Integer)object;
	return value;
	}
	public void addHeaders(Headers header) {
	reqSpec = RestAssured.given().headers(header);
	}
	public void multipart() {
	reqSpec =  reqSpec.multiPart("Profile_Picture", new File("C:\\Users\\Sathiyakala\\Desktop\\PappuPic"));
	}
	}
