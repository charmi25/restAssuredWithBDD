package restAssuredTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

 
public class JSON_Validation {
	
	@Test(priority=1)
	public void testStatusCod() {
		RestAssured.baseURI = "https://reqres.in/api";
	Response response =	given()
		.when()
		  .get("/users?page=2")
		.then()
		.statusCode(200)
		.log().all().extract().response();
	
	System.out.println(" Response :: "+response);
		
	}
	
	
	@Test(priority=2)
	public void getSingleResponse_1() {
		RestAssured.baseURI = "https://reqres.in/api";
	Response response =	given()
		.when()
		  .get("/user/2")
		.then()
		.statusCode(200)
		.log().all().extract().response();
	
	System.out.println(" Response :: "+response);
	
	System.out.println ("JSON PATH :: " +response.body().jsonPath().get("data.id"));
	int userId = response.body().jsonPath().get("data.id");
	
	Assert.assertEquals(userId, 2);
		
	
	
	}
	
	//OR 
	
	@Test(priority=3)
	public void getSingleResponse_2() {
		RestAssured.baseURI = "https://reqres.in/api";

	given()
	.when()
	  .get("/user/2")
	.then()
	.statusCode(200)
	.assertThat().body("data.id", equalTo(2));
	}

	
	@Test(priority=4)
	public void getMultipleResponse() {
		RestAssured.baseURI = "https://reqres.in/api";

	given()
//	.param("abc")                         //params and headers
//	.headers("abc","xyz")
	.when()
	  .get("/users?page=2")
	.then()
//	.statusCode(200)
	.body("data.first_name", hasItems("Michael","Rachel"));
	}

}
