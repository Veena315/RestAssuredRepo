package restAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithFile {
	
	
	@Test
	public void test1() throws IOException {
		
		byte[] dataFile = Files.readAllBytes(Paths.get("data.json"));
	
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
								  .accept(ContentType.JSON)
								  .body(dataFile)
								  .post("/create");
		
		String body = response.getBody().asString();
		
		System.out.println("The Body string is "+body);
		
		System.out.println("Response code is "+response.statusCode());
		
		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
