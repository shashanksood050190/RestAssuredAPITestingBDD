package serializationDeserialization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class VideoGameAPIWithSerializationXML {
	
	@Test(priority=1)
	public void videoGameSerializationXML() {
		VideoGame myVideoGame=new VideoGame();
		myVideoGame.setId(23);
		myVideoGame.setName("racing");
		myVideoGame.setReleaseDate("2019-06-19");
		myVideoGame.setReviewScore(90);
		myVideoGame.setCategory("driving");
		myVideoGame.setRating("five");
		
		given().contentType("application/json").body(myVideoGame).when().post("http://localhost:8080/app/videogames").
		then().log().all().body(equalTo("{\"status\": \"Record Added Successfully\"}"));
	}
	
	@Test(priority=2)
	public void videoGameDeserializationXML() {
		
		
		VideoGame myVideoGame=RestAssured.get("http://localhost:8080/app/videogames/21").as(VideoGame.class);
		System.out.println(myVideoGame.toString());
		
	}
	
	
	

}
