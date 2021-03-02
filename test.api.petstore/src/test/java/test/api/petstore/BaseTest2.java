package test.api.petstore;

import org.junit.BeforeClass;
import io.restassured.RestAssured;

public class BaseTest2 {

	@BeforeClass
    public static void setup() 
	{
        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "https://petstore3.swagger.io/api/v3";
        }
        RestAssured.baseURI = baseHost;
    }
}