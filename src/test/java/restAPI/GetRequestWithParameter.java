package restAPI;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParameter {
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get("/1");
		
		String body = response.getBody().asString();
		
		System.out.println("The Body string is "+body);
		
		System.out.println("Response code is "+response.statusCode());
		
		System.out.println("Response headers are "+response.getHeaders().asList());
		
		System.out.println("Response Headers are "+response.getHeader("Content-Type"));
		
		Assert.assertTrue(body.contains("Pankaj"));
		
		JsonPath json = response.jsonPath();
		
		String names = json.get("name");
		
		Assert.assertEquals(names, "Pankaj");
	}

}
