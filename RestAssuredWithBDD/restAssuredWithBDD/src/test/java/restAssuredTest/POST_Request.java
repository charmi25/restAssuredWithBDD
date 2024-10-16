package restAssuredTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import utilities.utils;
import io.restassured.*;

import static io.restassured.RestAssured.*; // static

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

import java.util.HashMap;


public class POST_Request {
	public static HashMap<String, String> usermap = new HashMap<String,String>();
	

	
	
	//// *************** POST *****************
	
	@BeforeClass
	public void createUserData()
	{
		usermap.put("name", utils.getName());
		usermap.put("job", "QA");
        RestAssured.baseURI = "https://reqres.in/api";
		//RestAssured.basePath= "/user";
		
		System.out.print(usermap);
		
	}
	
	@Test
	public void createUser() {
		given()
		   .contentType("application/json")
		   .body(usermap)    // need to use jackson librry to pass map to body
		.when()
		     .post("/user")
		 .then()
		   .statusCode(201)
		   .body("job",equalTo("QA")); 
//		   .log().all();
	}
	
}
