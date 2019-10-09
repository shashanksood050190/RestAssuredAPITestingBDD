package RestAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PUTRequest {
	
	public static HashMap<String,String> map;
	int emp_id=81848;

	@BeforeClass
	public void putData()
	{
		map=new HashMap<String,String>();
		map.put("name",RestUtils.empName());
		map.put("salary",RestUtils.empSal());
		map.put("age",RestUtils.empAge());
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
	}
	
	@Test
	public void testPut()
	{
		given().contentType("application/json").body(map).
		when().put().then().assertThat().statusCode(200).log().all();
		
		
		
	}
}
