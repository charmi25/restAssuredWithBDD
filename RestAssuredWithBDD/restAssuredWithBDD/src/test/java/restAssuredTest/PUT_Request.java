package restAssuredTest;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import utilities.utils;
import io.restassured.*;

import static io.restassured.RestAssured.*; // static

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import io.restassured.RestAssured;

import java.util.HashMap;
public class PUT_Request {
	
	public static  HashMap<String, String> updateusermap  =new HashMap<>();
	int userId= 2;
	
	@BeforeClass
	public void updateuserdata() {
		updateusermap.put("name", utils.getName());
		updateusermap.put("job", "updated");
		
	}
	
	@Test
	public void updateUserRequest()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath ="/user/"+userId;
		
		Response response =
		given()
		  .contentType("application/json")
		  .body(updateusermap)
		.when()
		 .put()
		//.put("/user/2")    // since we have used baseuri+ basepath, no need to specify end point in put()  
		.then()
		 .statusCode(200)
		 .assertThat().body("name",equalTo(updateusermap.get("name")))
		 //.and()
		 .assertThat().body("job", equalTo(updateusermap.get("job")))
		 .log().all()
		 .extract().response(); // extract response and store in Response variable
		
		
		
		System.out.println(" RESPONSE ==== " +response.asString()); // get body as string
		
		System.out.println(" RESPONSE ==== " +response.toString());  // string represntation of object 
		//o/p : ESPONSE ==== io.restassured.internal.RestAssuredResponseImpl@1a21f43fPASSED: restAssuredTest.PUT_Request.updateUserRequestESPONSE ==== io.restassured.internal.RestAssuredResponseImpl@1a21f43fPASSED: restAssuredTest.PUT_Request.updateUserRequest
		 
	Boolean updated=	response.body().asString().contains("updatedAt");
	System.out.println("*** status of updated ****  "+ updated);
		//Assert.assertEquals(response.contains("updatedAt"),true);
		 Assert.assertEquals(updated, true);
	}

}
