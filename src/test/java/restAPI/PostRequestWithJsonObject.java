package restAPI;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJsonObject {

	@Test
	public void test1() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Shiveena");
		jobj.put("salary", "1000000");
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
								  .accept(ContentType.JSON)
								  .body(jobj.toString())
								  .post("/create");
		
		String body = response.getBody().asString();
		
		System.out.println("The Body string is "+body);
		
		System.out.println("Response code is "+response.statusCode());
		
		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
