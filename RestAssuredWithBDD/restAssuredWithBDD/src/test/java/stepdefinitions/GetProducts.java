package stepdefinitions;

import static org.testng.Assert.assertEquals;

//import java.net.http.HttpRequest;

import org.json.simple.JSONObject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import steps.GetProductsSteps;

import java.util.HashMap;

public class GetProducts {


    public int StatusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    public JSONObject requestParams;
    public JsonPath jsnpath;
    public String s;
    //	    static ExtentReports report;
//	    public static ExtentTest test;
//	    public static ExtentReports extent = new ExtentReports();
    GetProductsSteps getProducts = new GetProductsSteps();

    @Given("^I hit the url of get products api endpoint$")
    public void i_hit_the_url_of_get_products_api_endpoint() throws Throwable {
//	        test = extent.createTest("Validate Shoe Titles on Products Page","This test validates that the different Shoetypes are correct on Online Products Page");
//	        RestAssured.baseURI = "https://fakestoreapi.com/";
//        RestAssured.baseURI = getProducts.setEndPoint();
        getProducts.setEndPoint();
    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        getProducts.getProducts();

    }

    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(int statusCode) {
        getProducts.verifyStatusCode(statusCode);
    }

    @Then("I verify that the rate of the first product is {}")
    public void i_verify_that_the_rate_of_the_first_product_is(String rate) {
        getProducts.verifyProdcutIsPresent(rate);

    }

    @Given("I hit the url of post product api endpoint")
    public void iHitTheUrlOfPostProductApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = RestAssured.given();
        requestParams = new JSONObject();
    }

    @And("I pass the request body of product title {}")
    public void iPassTheRequestBodyOfProductTitle(String title) {
        requestParams.put("title", title);
        requestParams.put("price", 13.5);
        requestParams.put("description", "lorem ipsum set");
        requestParams.put("image", "https://i.pravatar.cc");
        requestParams.put("cateogry", "electronic");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.post("products");
         body = response.getBody();
        JsonPath jsnpath = response.jsonPath();
        s = jsnpath.getJsonObject("id").toString();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }

    @Then("I receive the response body with id as {}")
    public void iReceiveTheResponseBodyWithIdAs(String id) {
        assertEquals(id, s);
    }

    @Given("I hit the url of put product api endpoint")
    public void iHitTheUrlOfPutProductApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        requestParams = new JSONObject();
    }

    @When("I pass the url of products in the request with {}")
    public void iPassTheUrlOfProductsInTheRequestWith(String productnumber) {
        httpRequest = RestAssured.given();
        requestParams.put("title", "test product");
        requestParams.put("price", "13.5");
        requestParams.put("description", "lorem ipsum set");
        requestParams.put("image", "https://i.pravatar.cc");
        requestParams.put("cateogry", "electronic");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.put("products/" + productnumber);
        ResponseBody body = response.getBody();
        JsonPath jsnpath = response.jsonPath();
        s = jsnpath.getJsonObject("id").toString();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());


        //OR use HashMap
//			HashMap<String,Object> requestParams = new HashMap<String,Object>();
//			requestParams.put("products/",productnumber);

    }

    @Given("I hit the url of delete product api endpoint")
    public void iHitTheUrlOfDeleteProductApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        requestParams = new JSONObject();
    }

    @When("I pass the url of delete products in the request with {}")
    public void iPassTheUrlOfDeleteProductsInTheRequestWith(String productnumber) {
        httpRequest = RestAssured.given();
        requestParams.put("title", "test product");
        requestParams.put("price", "13.5");
        requestParams.put("description", "lorem ipsum set");
        requestParams.put("image", "https://i.pravatar.cc");
        requestParams.put("cateogry", "electronic");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.delete("products/" + productnumber);
        ResponseBody body = response.getBody();
        JsonPath jsnpath = response.jsonPath();
        s = jsnpath.getJsonObject("id").toString();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }
}