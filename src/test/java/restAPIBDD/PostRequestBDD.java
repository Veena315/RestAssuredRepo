package restAPIBDD;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequestBDD {
	
	
	@Test
	public void test1() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Honey");
		jobj.put("salary", "60000");
		
		RestAssured.given()
				   .baseUri("http://localhost:3000/employees")
				   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
				   .body(jobj.toString())
				   .when()
				   .post("/create")
				   .then()
				   .statusCode(201)
				   .log()
				   .body();
	}

}
