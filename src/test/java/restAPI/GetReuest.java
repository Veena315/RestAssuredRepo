package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetReuest {
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		
		String body = response.getBody().asString();
		
		System.out.println("The Body string is "+body);
		
		System.out.println("Response code is "+response.statusCode());
		
		System.out.println("Response headers are "+response.getHeaders().asList());
		
		System.out.println("Response Headers are "+response.getHeader("Content-Type"));
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Print all names of employees on the console
		
		JsonPath json = response.jsonPath();
		
		//System.out.println("ID "+json.get("ID")+" Name "+json.get("Name")+" Salary "+json.get("Salary"));
		
		List<String> names = json.get("name");
		
		for(String name:names) {
			
			System.out.println("The name is "+name);
			
		}
	}

}
