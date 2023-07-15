package springbootApp;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostNewEmployee {
	

	@Test
	public void test1() {
		
		JSONObject requestBody = new JSONObject();

		requestBody.put("firstName", "Naveena");
		requestBody.put("lastName", "Jannu");
		requestBody.put("salary", "10000");
		requestBody.put("email", "veenajannu315@gmail.com");
		
		RestAssured.baseURI = "http://localhost:8088/employees";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
				                .body(requestBody.toString()).post();
		String body = response.getBody().asString();
		
		System.out.println("The Body string is "+body);
		
		System.out.println("Response code is "+response.statusCode());
		
				
	}

}
