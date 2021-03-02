package test.api.petstore;

import org.junit.BeforeClass;
import io.restassured.RestAssured;

public class BaseTest {

	@BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }        

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "https://petstore3.swagger.io/api/v3";
        }
        RestAssured.baseURI = baseHost;
    }
}