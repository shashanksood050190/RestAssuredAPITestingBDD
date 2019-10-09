package serializationDeserialization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import org.testng.annotations.Test;

public class StudentAPINoSerialization {
	
	public HashMap map=new HashMap();
	
	//@Test
	public void createNewStudent()
	{
		map.put("id", 101);
		map.put("firstName", "Shashank");
		map.put("lastName", "Sood");
		map.put("email", "abc@def.edu");
		map.put("programme", "Mannager");
		
		ArrayList<String> coursesList=new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		map.put("courses",coursesList);
		
		given().contentType("application/json").body(map).when().post("http://localhost:8085/student").
		then().statusCode(201).assertThat().body("msg", equalTo("Student added"));
		
	}
	
	@Test
	public void getStudentRecord()
	{
		
		
		given().when().get("http://localhost:8085/student/101").
		then().statusCode(200).assertThat().body("id", equalTo(101));
		
	}

}
