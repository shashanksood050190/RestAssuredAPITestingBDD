package RestAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class POSTRequest {

	public static HashMap<String, String> map;

	@BeforeClass
	public void postData() {
		map = new HashMap<String, String>();
		map.put("FirstName", RestUtils.getFirstName());
		map.put("LastName", RestUtils.getLastName());
		map.put("UserName", RestUtils.getUserName());
		map.put("Password", RestUtils.getPassword());
		map.put("Email", RestUtils.getEmail());
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
			
	}

	@Test
	public void testPost() {
		


		given().contentType("application/json").body(map).
		when().post("http://restapi.demoqa.com/customer/register")
				.then().statusCode(201).and().body("SuccessCode", equalTo("OPERATION_SUCCESS"))
				.body("Message", equalTo("Operation completed successfully"));
	}
}
