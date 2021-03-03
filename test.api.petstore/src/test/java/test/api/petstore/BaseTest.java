package test.api.petstore;

import org.junit.BeforeClass;
import io.restassured.RestAssured;

public class BaseTest {

	@BeforeClass
    public static void setup() 
	{        
        String baseHost = System.getProperty("server.host");
        if(baseHost == null){
            baseHost = "http://localhost:8080/api/v3";
        }
        RestAssured.baseURI = baseHost;
    }
}