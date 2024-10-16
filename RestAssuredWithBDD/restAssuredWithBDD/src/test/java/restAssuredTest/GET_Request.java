package restAssuredTest;  // https://www.youtube.com/watch?v=x4BKSAKZ-Xg&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=4

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import utilities.utils;
import io.restassured.*;

import static io.restassured.RestAssured.*; // static
import org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

import java.util.HashMap;


public class GET_Request {
	public static HashMap usermap = new HashMap();
	

	
	// *************** GET *****************
	@Test
	public void getUserDetails() {
    given()
    .when()
    .get("https://reqres.in/api/users/2")
    .then()
    .statusCode(200)
    .statusLine("HTTP/1.1 200 OK")
    .log().all();
    
		
	}
	
	@Test
	public void verifyHeaderDetails() {
	    given()
	    .when()
	     .get("https://reqres.in/api/users/2")
	     .then()
	     .assertThat().headers("Content-Type", "application/json; charset=utf-8");
	   
		}

//	//TO-DO : check on asserting jsonpath
////	
//	@Test
//	public void verifyuserDetails() {
//	    given()
//	    .when()
//	     .get("https://reqres.in/api/users/2")
//	     .then()
//	     .assertThat()
//	    .body("data.id", equalTo(2));
//	   
//		}
//	
	
	
	//// *************** POST *****************
	
	@BeforeClass
	public void createUserData()
	{
		usermap.put("name", utils.getName());
		usermap.put("job", "QA");
        RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath= "/user";
		
	}
	
	@Test
	public void createUser() {
		given()
		   .contentType("application/json")
		   .body(usermap)
		.when()
		     .post()
		 .then()
		   .statusCode(201);
	}
	
}
