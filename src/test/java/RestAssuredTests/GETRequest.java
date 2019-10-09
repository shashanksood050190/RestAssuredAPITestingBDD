package RestAssuredTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GETRequest {
	
	@Test
	public void getWeatherDetails()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RestAssured.basePath="/Hyderabad";
		
		given()
		.when().get()
		.then().statusCode(200).statusLine("HTTP/1.1 200 OK").
		assertThat().body("City", equalTo("Hyderabad"))
		.header("Content-Type", "application/json");
	}

}
