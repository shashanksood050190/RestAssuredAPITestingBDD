package RestAssuredTests;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class BasicValidationsJson {
	
	
	//Test code
	//@Test(priority=1)
	public void testStatusCode()
	{
		given().when().get("https://jsonplaceholder.typicode.com/posts/5").then().statusCode(200);
		//.log().all();
	}
	
	//@Test(priority=2)
	public void testLogging()
	{
		given().when().get("http://services.groupkt.com/country/get/iso2code/IN").then().statusCode(200).log().all();
	}

	
	//@Test(priority=3)
	public void testSingleContent()
	{
		given().when().get("https://jsonplaceholder.typicode.com/posts/5").then().assertThat().body("title", equalTo("nesciunt quas odio"));
		
	}
	
	@Test(priority=4)
	public void testMultipleContent()
	{
		given().when().get("https://jsonplaceholder.typicode.com/posts").then().assertThat().body("title", hasItems("sunt aut facere repellat provident occaecati excepturi optio reprehenderit","nesciunt quas odio"));
		
	}
	
	@Test(priority=5)
	public void testParamsAndHeaders()
	{
		given().param("MyName","shashank").header("MyHeader","Indian").when().get("https://jsonplaceholder.typicode.com/posts/5").then().statusCode(200).log().all();
		
	}
}
