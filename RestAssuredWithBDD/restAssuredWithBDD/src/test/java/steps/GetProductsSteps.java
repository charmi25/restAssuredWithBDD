package steps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class GetProductsSteps {
    private Properties properties;
    private String BaseURI;
    private String endPoint;
    public Response response;
    private int statusCode;
    public RequestSpecification httpRequest;
    public int responseStatusCode;
    public ResponseBody body;

    public void setEndPoint() throws IOException {
//        InputStream inStream =getClass().getClassLoader().getResourceAsStream("config.properties");
        properties = new Properties();
        properties.load(GetProductsSteps.class.getClassLoader().getResourceAsStream("config.properties"));
        RestAssured.baseURI = properties.getProperty("baseUri");
        System.out.println(" ****************** Inside SetEndPoint ");
        System.out.println("******** BaseURI ::" + RestAssured.baseURI);

    }

    public void getProducts() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("products");
        //   System.out.println("Response of get products ::" + response.asString());
        //  System.out.println("Response of get products ::" + response.getBody().asString());
        //  System.out.println("Response of get products ::" + response.prettyPrint()); // prints in json format
    }

    public void verifyStatusCode(int statusCode) {
        responseStatusCode = response.getStatusCode();
        System.out.println("Verifying status code " + responseStatusCode);
        assertEquals(responseStatusCode, statusCode);
    }

    public void verifyProdcutIsPresent(String rate) {
        System.out.println("verifying presence of product" + response.jsonPath().get("rating[0].rate").toString());
        String ratings = response.jsonPath().get("rating[0].rate").toString();
        System.out.println("Ratings :: " + ratings);
        assertEquals(rate, ratings);
//        Assert.assertEquals(rate,ratings,"Rate not found");

//OR
        //JSON Representation from Response Body
        JsonPath jsnpath1 = response.jsonPath();
           String s = jsnpath1.getJsonObject("rating[0].rate").toString();
        System.out.println("s ::"+s);


        // OR
        JsonPath jsonPath=new JsonPath(response.asString());
        String rate1= jsonPath.get("rating[0].rate").toString();
        System.out.println(" rate1 ::"+rate1);

    }
}
