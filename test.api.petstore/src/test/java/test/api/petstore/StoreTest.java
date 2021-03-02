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
        if(basePath==null){
            basePath = "/store";
        }
        RestAssured.basePath = basePath;
	}
	
	@Test
	public void pingStoreTest() {
		
		get("/inventory").then()
			.statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void getInventoryStoreTest() {
		
		get("/inventory").then()
			.statusCode(HttpStatus.SC_OK)
			.statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void getOrderFalseStoreTest() {
		
		given()
		.pathParam("orderId", "1")
		.get("/order/{orderId}").then()
			.statusCode(HttpStatus.SC_OK)
			.body(
	             "id", equalTo(1),
	             "petId", equalTo(2001),
	             "quantity", equalTo(1),
	             "complete", equalTo(false));
	}
	
	@Test
	public void getOrderApprovedStoreTest() {
		
		given()
		.pathParam("orderId", "3")
		.get("/order/{orderId}").then()
			.statusCode(HttpStatus.SC_OK)
			.body(
	             "id", equalTo(3),
	             "petId", equalTo(13),
	             "quantity", equalTo(1),
		         "shipDate", equalTo("2021-02-22T16:49:12.810+00:00"),
	             "status", equalTo("approved"),
	             "complete", equalTo(true));
	}
	
	@Test
	public void getOrderNotFoundStoreTest() {
		
		given()
		.pathParam("orderId", "5")
		.get("/order/{orderId}").then()
			.statusCode(HttpStatus.SC_NOT_FOUND)
			.log().all();
	}
	
	@Test
	public void postNewOrderStoreTest() {
		
		PetOrder order = new PetOrder(6, 25, 5, "2021-03-02T19:12:50.567Z", "approved", true); 
		given()
		.contentType("application/json")
		.body(order)
		.post("/order").then()
			.statusCode(HttpStatus.SC_OK)
			.log().all();
	}
	
	@Test
	public void deleteOrderStoreTest() {
		
		given()
		.pathParam("orderId", "6")
		.delete("/order/{orderId}").then()
			.statusCode(HttpStatus.SC_OK)
			.log().all();
	}
	
	
}
