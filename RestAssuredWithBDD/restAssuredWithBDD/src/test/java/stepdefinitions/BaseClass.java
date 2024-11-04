package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
//import jdk.internal.misc.FileSystemOption;
//import org.testng.annotations.BeforeClass;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
import java.util.Properties;

public class BaseClass {
    protected RequestSpecification Req_Spec;
    protected Response response;
    protected int ResponseCode;
    protected ResponseBody body;
   protected Scenario scenario;
 // protected   Properties properties;

    @Before   // Before scenarios
    public void BeforeHook(Scenario scenario) {
        this.scenario = scenario;
        scenario.log("********************* Scenario started :: " + scenario.getName());

    }

    @After
    public void AfterHook(Scenario scenario) {
        scenario.log(" **********************Scenario Completed with Status " + scenario.getStatus());
    }

//    @BeforeClass
//    public  void setUp(Scenario scenario) throws IOException {
//        scenario.log("***************** Reading property file***********");
//       InputStream inStream =getClass().getClassLoader().getResourceAsStream("config.properties");
//         properties = new Properties();
//        properties.load(inStream);
//    }
}
