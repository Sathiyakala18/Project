package api.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PostRegisterunSuccessFul {
	static RequestSpecification reqSpec;
	public static void main(String[] args) {
	reqSpec = RestAssured.given();
	reqSpec = reqSpec.header("Content-Type","application/json");
	reqSpec = reqSpec.body("{\r\n" + 
			"    \"email\": \"sydney@fife\"\r\n" + 
			"}");
	Response response = reqSpec.log().all().post("https://reqres.in/api/register");
	int statusCode = response.getStatusCode();
	System.out.println(statusCode);
	ResponseBody body = response.getBody();
	String asPrettyString = body.asPrettyString();
	System.out.println(asPrettyString);

}
}