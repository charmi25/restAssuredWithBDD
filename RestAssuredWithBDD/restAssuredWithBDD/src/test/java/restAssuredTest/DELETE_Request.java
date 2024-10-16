package restAssuredTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test
public class DELETE_Request {
	public void deleteUser() {
		int userId=2;
		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/users/"+userId;
	Response response =	
		given()
		.when()
		.delete()
		.then()
		.statusCode(204)
		.log().all()
		.extract().response();
		
		}

}
