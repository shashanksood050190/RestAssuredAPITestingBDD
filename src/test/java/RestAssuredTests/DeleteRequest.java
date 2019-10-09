package RestAssuredTests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest {
	
	int emp_id=82161;
	
	@Test
	public void testDelete()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
		RestAssured.basePath="/delete/"+emp_id;
		
		Response response=given().when().delete().then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK").log().all().extract().response();
		String jsonAsString=response.asString();
		Assert.assertEquals(jsonAsString.contains("successfully! deleted Records"), true);
	}

}
