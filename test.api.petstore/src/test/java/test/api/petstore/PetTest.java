package test.api.petstore;

import io.restassured.RestAssured;
import testdataobject.Category;
import testdataobject.Pet;
import testdataobject.Tag;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.apache.http.HttpStatus;
import org.junit.*;


public class PetTest extends BaseTest {

	@BeforeClass
	public static void setUpStore() {
		
		String basePath = System.getProperty("server.base");
        if(basePath==null) {
            basePath = "/pet";
        }
        RestAssured.basePath = basePath;
	}
	
	@Test
	public void getPetNotFoundByIdTest() {
		
		given().pathParam("petId", "1").delete("/{petId}");
		
		given()
		.pathParam("petId", "1")
		.get("/{petId}")
			.then()
				.statusCode(HttpStatus.SC_NOT_FOUND);
	}
	
	@Test
	public void getPetByIdTest() {
		
		given().pathParam("petId", "2").delete("/{petId}");
        Pet pet = new Pet(2, "Barbicha", new Category(1, "Dog"), new String[] { "photo01.jpg" }, new Tag[] {new Tag(1, "small")}, "available");
        given().contentType("application/json").body(pet).post("");
        
		given()
		.pathParam("petId", "2")
		.get("/{petId}")
		.then()
			.statusCode(HttpStatus.SC_OK)
			.body(
		         "id", equalTo(2),
	             "category.id", equalTo(1),
	             "category.name", equalTo("Dog"),
	             "name", equalTo("Barbicha"),
	             "photoUrls[0]", equalTo("photo01.jpg"),
	             "status", equalTo("available"),
	             "tags[0].id", equalTo(1),
	             "tags[0].name", equalTo("small"));
	}	
	
	@Test
	public void getPetByStatusNotProvidedTest() {
		
		given()
			.get("/findByStatus")
			.then()
			.statusCode(HttpStatus.SC_BAD_REQUEST);
	}
	
	@Test
	public void getPetByStatusTest() {
		
		Pet[] pets = given()
			.pathParam("status", "sold")
			.get("/findByStatus?status={status}").as(Pet[].class);
				
		Assert.assertTrue(pets.length == 1);
		Assert.assertEquals(pets[0].id, 5);
		Assert.assertEquals(pets[0].name, "Dog 2");
		Assert.assertEquals(pets[0].category.id, 1);
		Assert.assertEquals(pets[0].category.name, "Dogs");
		Assert.assertEquals(pets[0].photoUrls[0], "url1");
		Assert.assertEquals(pets[0].photoUrls[1], "url2");
		Assert.assertEquals(pets[0].status, "sold");
		Assert.assertEquals(pets[0].tags[0].id, 1);
		Assert.assertEquals(pets[0].tags[0].name, "tag2");
		Assert.assertEquals(pets[0].tags[1].id, 2);
		Assert.assertEquals(pets[0].tags[1].name, "tag3");
	}
	
	@Test
	public void getPetByTagNotFoundTest() {
		
		Pet[] notFoundList = given()
			.pathParam("tag", "notFound")
			.get("/findByTags?tags={tag}").as(Pet[].class);
		
		Assert.assertTrue(notFoundList.length == 0);
	}
	
	@Test
	public void getPetByTagTest() {
		
		given().pathParam("petId", "7").delete("/{petId}");
        Pet pet = new Pet(3, "Barbicha", new Category(1, "Dog"), new String[] { "photo01.jpg" }, new Tag[] {new Tag(1, "tagTest")}, "available");
        given().contentType("application/json").body(pet).post("");
		
		Pet[] pets = given()
			.pathParam("tag", "tagTest")
			.get("/findByTags?tags={tag}").as(Pet[].class);
		
		Assert.assertTrue(pets.length == 1);
		Assert.assertEquals(pets[0].id, 7);
		Assert.assertEquals(pets[0].name, "Barbicha");
		Assert.assertEquals(pets[0].category.id, 1);
		Assert.assertEquals(pets[0].category.name, "Dog");
		Assert.assertEquals(pets[0].photoUrls[0], "photo01.jpg");
		Assert.assertEquals(pets[0].status, "available");
		Assert.assertEquals(pets[0].tags[0].id, 1);
		Assert.assertEquals(pets[0].tags[0].name, "tagTest");
	}
	
	@Test
	public void postAddNewPetTest() {
		
		given().pathParam("petId", "3").delete("/{petId}");
		
		Pet pet = new Pet(3, "Barbicha", new Category(1, "Dog"), new String[] {"photo01.jpg"}, new Tag[] { new Tag(1, "small") }, "available"); 
		given()
		.contentType("application/json")
		.body(pet)
		.post("").then()
			.statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void putUpdatePetTest() {
		
		given().pathParam("petId", "4").delete("/{petId}");
        Pet petUpdate = new Pet(4, "Barbicha", new Category(1, "Dog"), new String[] { "photo01.jpg" }, new Tag[] {new Tag(1, "medium")}, "available");
        given().contentType("application/json").body(petUpdate).post("");
		
		Pet pet = new Pet(4, "CatDog", new Category(2, "Cat"), new String[] {"photo02.jpg"}, new Tag[] { new Tag(2, "big") }, "available"); 
		given()
		.contentType("application/json")
		.body(pet)
		.put("").then()
			.statusCode(HttpStatus.SC_OK);
		
		given()
		.pathParam("petId", "4")
		.get("/{petId}")
		.then()
			.statusCode(HttpStatus.SC_OK)
			.body(
		         "id", equalTo(4),
	             "category.id", equalTo(2),
	             "category.name", equalTo("Cat"),
	             "name", equalTo("CatDog"),
	             "photoUrls[0]", equalTo("photo02.jpg"),
	             "status", equalTo("available"),
	             "tags[0].id", equalTo(2),
	             "tags[0].name", equalTo("big"));
	}
	
	@Test
	public void deletePetTest() {
		
		given().pathParam("petId", "6").delete("/{petId}");
        Pet petDelete = new Pet(6, "Barbicha", new Category(1, "Dog"), new String[] { "photo01.jpg" }, new Tag[] {new Tag(1, "medium")}, "available");
        given().contentType("application/json").body(petDelete).post("");
        
		given()
		.pathParam("petId", "6")
		.delete("/{petId}").then()
			.statusCode(HttpStatus.SC_OK);
	}
	
}
