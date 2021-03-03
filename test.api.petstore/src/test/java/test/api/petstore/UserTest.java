package test.api.petstore;

import io.restassured.RestAssured;
import testdataobject.Category;
import testdataobject.Pet;
import testdataobject.Tag;
import testdataobject.User;

import static org.hamcrest.Matchers.*;

import java.util.*;

import static io.restassured.RestAssured.*;
import org.apache.http.HttpStatus;
import org.junit.*;


public class UserTest extends BaseTest {

	@BeforeClass
	public static void setUpStore() {
		
		String basePath = System.getProperty("server.base");
        if(basePath==null) {
            basePath = "/user";
        }
        RestAssured.basePath = basePath;
                
        
        given().pathParam("username", "thiagoN26").delete("/{username}"); //create user test
        
        given().pathParam("username", "thiagoN26_02").delete("/{username}"); //create user list test
        given().pathParam("username", "thiagoN26_03").delete("/{username}"); //create user list test
        		
		given().pathParam("username", "thiagoN26_04").delete("/{username}"); // get user test
		User user4 = new User(4, "thiagoN26_04", "Thiago4", "Fioravante4", "thiago4@n26.es", "1234564", "+34112233444", 1); 
		given().contentType("application/json").body(user4).post("");
		
		User user5 = new User(5, "thiagoN26_05", "Thiago5", "Fioravante5", "thiago5@n26.es", "1234565", "+34112233445", 1); // delete user test
		given().contentType("application/json").body(user5).post("");
		
		User user6 = new User(6, "thiagoN26_06", "Thiago6", "Fioravante6", "thiago6@n26.es", "1234566", "+34112233446", 1); //login test
		given().contentType("application/json").body(user6).post("");
		
		User user8 = new User(8, "thiagoN26_08", "Thiago8", "Fioravante8", "thiago8@n26.es", "1234568", "+34112233448", 1); //update test
		given().contentType("application/json").body(user8).post("");
	}
	
	@Test
	public void postCreateNewUserTest() {
		
		User user = new User(1, "thiagoN26", "Thiago", "Fioravante", "thiago@n26.es", "123456", "+3411223344", 1); 
		given()
		.contentType("application/json")
		.body(user)
		.post("").then()
			.statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void postCreateNewUserListTest() {
		
		User user2 = new User(2, "thiagoN26_02", "Thiago2", "Fioravante2", "thiago2@n26.es", "1234562", "+34112233442", 1); 
		User user3 = new User(3, "thiagoN26_03", "Thiago3", "Fioravante3", "thiago3@n26.es", "1234563", "+34112233443", 1);
		
		List<User> userList = new ArrayList<User>();
		userList.add(user2);
		userList.add(user3);;
		
		given()
		.contentType("application/json")
		.body(userList)
		.post("/createWithList").then()
			.statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void getUserByUsernameTest() {
		
		given()
		.pathParam("username", "thiagoN26_04")
		.get("/{username}").then()
			.statusCode(HttpStatus.SC_OK)
			.body(
	             "id", equalTo(4),
	             "username", equalTo("thiagoN26_04"),
	             "firstName", equalTo("Thiago4"),
		         "lastName", equalTo("Fioravante4"),
	             "email", equalTo("thiago4@n26.es"),
	             "password", equalTo("1234564"),
	             "phone", equalTo("+34112233444"),
	             "userStatus", equalTo(1));
	}
	
	@Test
	public void deleteUserTest() {
		
		given()
		.pathParam("username", "thiagoN26_05")
		.delete("/{username}").then()
			.statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void getLoginSuccesfullTest() {
		
		given()
		.pathParam("username", "thiagoN26_06")
		.pathParam("password", "1234566")
		.get("/login?username={username}&password={password}").then()
			.statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void getLoginWrongPasswordTest() {
	
		given()
		.pathParam("username", "thiagoN26_06")
		.pathParam("password", "77777")
		.get("/login?username={username}&password={password}").then()
			.statusCode(HttpStatus.SC_BAD_REQUEST);
	}
	
	@Test
	public void getLoginWrongUsernameTest() {
	
		given()
		.pathParam("username", "thiagoN26_07")
		.pathParam("password", "1234566")
		.get("/login?username={username}&password={password}").then()
			.statusCode(HttpStatus.SC_BAD_REQUEST);
	}
	
	@Test
	public void getLogout() {
		
		given()
		.get("/logout").then()
			.statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void putUpdateUserTest() {
		
		User user8 = new User(8, "thiagoN26_09", "Thiago9", "Fioravante9", "thiago9@n26.es", "1234569", "+34112233449", 2); //update test
		
		given()
		.contentType("application/json")
		.pathParam("username", "thiagoN26_08")
		.body(user8)
		.put("/{username}").then()
			.statusCode(HttpStatus.SC_OK);
		
		given()
		.pathParam("username", "thiagoN26_09")
		.get("/{username}").then()
			.statusCode(HttpStatus.SC_OK)
			.body(
	             "id", equalTo(8),
	             "username", equalTo("thiagoN26_09"),
	             "firstName", equalTo("Thiago9"),
		         "lastName", equalTo("Fioravante9"),
	             "email", equalTo("thiago9@n26.es"),
	             "password", equalTo("1234569"),
	             "phone", equalTo("+34112233449"),
	             "userStatus", equalTo(2));
	}
}
