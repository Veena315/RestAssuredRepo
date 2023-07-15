package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
								  .accept(ContentType.JSON)
								  .body("{\r\n"
								  		+ "    \"name\": \"Naveena\",\r\n"
								  		+ "    \"salary\": \"12000\"\r\n"
								  		+ "}")
								  .post("/create");
		
		String body = response.getBody().asString();
		
		System.out.println("The Body string is "+body);
		
		System.out.println("Response code is "+response.statusCode());
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
		JsonPath json = response.jsonPath();
		
		json.get("ID");
	}

}
