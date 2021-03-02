package test.api.petstore;

import org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
//import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.junit.Test;

public class StoreTest  {// extends BaseTest {

	/*@BeforeClass
	public static void setUpStore() {
		String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/store";
        }
        RestAssured.basePath = basePath;
	}*/
	
	@Test
	public void basicPingTest() {
		/*Response response = given().when()
                .get("https://petstore3.swagger.io/api/v3/store/inventory")
                .andReturn();
		int status = response.getStatusCode();*/
		String baseURI = RestAssured.baseURI;
		int port = RestAssured.port;
		String path = RestAssured.basePath;
		given().
		when().
		//get("https://petstore3.swagger.io/api/v3/store/inventory").then().log().all();
		get("https://petstore3.swagger.io/api/v3/store/inventory").then().assertThat().statusCode(500);
		
		
	}

	
	
	//@Test
	public void getResponseBody(){

		String url="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";
		given().when().get(url).then().log().all();

		given().queryParam("CUSTOMER_ID","68195")
				.queryParam("PASSWORD","1234!")
				.queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
	}
	
}
