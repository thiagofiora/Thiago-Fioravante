package test.api.petstore;

import io.restassured.RestAssured;
import testdataobject.PetOrder;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.apache.http.HttpStatus;
import org.junit.*;


public class StoreTest extends BaseTest {

	@BeforeClass
	public static void setUpStore() {
		
		String basePath = System.getProperty("server.base");
        if(basePath==null) {
            basePath = "/store";
        }
        RestAssured.basePath = basePath;
	}
	
	@Test
	public void getInventoryTest() {
		
		get("/inventory").then()
			.statusCode(HttpStatus.SC_OK)
			.body("approved", equalTo(5));
	}
	
	@Test
	public void getOrderNotFoundTest() {
		
        given().pathParam("orderId", "1").delete("/order/{orderId}");
		
		given()
		.pathParam("orderId", "1")
		.get("/order/{orderId}").then()
			.statusCode(HttpStatus.SC_NOT_FOUND);
	}
	
	@Test
	public void getOrderTest() {
		
		given().pathParam("orderId", "2").delete("/order/{orderId}");
        PetOrder order = new PetOrder(2, 2, 2, "2021-03-02T19:12:50.567+00:00", "approved", true); 
		given().contentType("application/json").body(order).post("/order");
		
		given()
		.pathParam("orderId", "2")
		.get("/order/{orderId}").then()
			.statusCode(HttpStatus.SC_OK)
			.body(
	             "id", equalTo(2),
	             "petId", equalTo(2),
	             "quantity", equalTo(2),
		         "shipDate", equalTo("2021-03-02T19:12:50.567+00:00"),
	             "status", equalTo("approved"),
	             "complete", equalTo(true));
	}
	
	@Test
	public void postNewOrderTest() {
		
		given().pathParam("orderId", "3").delete("/order/{orderId}");
		
		PetOrder order = new PetOrder(3, 3, 3, "2021-03-02T19:12:50.567Z", "approved", true); 
		given()
		.contentType("application/json")
		.body(order)
		.post("/order").then()
			.statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void deleteOrderTest() {

		given().pathParam("orderId", "4").delete("/order/{orderId}");
		PetOrder order = new PetOrder(4, 2, 2, "2021-03-02T19:12:50.567+00:00", "approved", true); 
		given().contentType("application/json").body(order).post("/order");
		
		given()
		.pathParam("orderId", "4")
		.delete("/order/{orderId}").then()
			.statusCode(HttpStatus.SC_OK);
	}

}