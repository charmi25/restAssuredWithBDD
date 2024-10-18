package restAssuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class XML_Validation {
	// referefence : https://mocktarget.apigee.net/xml
	@Test
	public void verifysinglecontent() {
		given()
		.when()
		.get("https://mocktarget.apigee.net/xml")
		.then()
		.assertThat().body("root.firstName",equalTo("John"))
		.log().all();
		
	}
	
	@Test
	public void verifysinglecontentUsingXMLPath() {
		given()
		.when()
		.get("https://mocktarget.apigee.net/xml")
		.then()
		//.assertThat().body("root.firstName",equalTo("John"))   // instead of this use below line
		.body(hasXPath("/root/firstName"), containsString("John"))
		.log().all();
		
	}
	
	@Test
	public void verifyMultipleValue() {
		given()
		.when()
		.get("https://mocktarget.apigee.net/xml")
		.then()
		.assertThat().body("root.firstName",equalTo("John"))
		.body("root.lastName", equalTo("Doe"));
	}

	
	@Test
	public void verifyCompleteResponse() {
		given()
		.when()
		.get("https://mocktarget.apigee.net/xml")
		.then()
		.assertThat().body("root.firstName",equalTo("John"))
		.body("root.text()", equalTo("San JoseJohnDoeCA"));
	}
	
	
	//ref : https://thetestrequest.com/authors.xml
	

	 	
}

