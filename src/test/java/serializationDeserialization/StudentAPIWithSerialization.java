package serializationDeserialization;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class StudentAPIWithSerialization {

	//@Test(priority=1)
	public void createNewStudentSerialization()
	{
		ArrayList<String> courseList=new ArrayList<String>();
		courseList.add("Java");
		courseList.add("Selenium");
		
		Student stu=new Student();
		stu.setId(101);
		stu.setFirstName("shashank");
		stu.setLastName("Sood");
		stu.setEmail("abc@gmail.com");
		stu.setProgramme("Manager");
		stu.setCourses(courseList);
		
		given().contentType(ContentType.JSON).body(stu).when().post("http://localhost:8085/student").then().
		assertThat().statusCode(201).body("msg", equalTo("Student added"));
	}
	
	@Test(priority=2)
	void getStudentRecordDeserialization()
	{
		Student stu=
				RestAssured.get("http://localhost:8085/student/101").as(Student.class);
	System.out.println(stu.toString());
	Assert.assertEquals(stu.getId(), (Integer)101);
	}
}
