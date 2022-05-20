package api.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteDelete {
	static RequestSpecification reqSpec;
	public static void main(String[] args) {
		 reqSpec = RestAssured.given();
		 reqSpec = reqSpec.header("Content-Type","application/json");
		 Response response = reqSpec.log().all().delete("https://reqres.in/api/users/2");
		 int statusCode = response.getStatusCode();
		 System.out.println(statusCode);
		 
	}

}
