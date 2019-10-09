package RestAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class BasicValidationsXML {

	//@Test(priority=1)
	public void testsingleContent()
	{
		given().when().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").then().body("CUSTOMER.ID", equalTo("10")).log().all();
	}
	
	//@Test(priority=2)
	public void testMultipleContent()
	{
		given().when().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").then()
		.body("CUSTOMER.ID", equalTo("10")).
		body("CUSTOMER.FIRSTNAME", equalTo("Sue")).
		body("CUSTOMER.LASTNAME", equalTo("Fuller")).
		body("CUSTOMER.STREET", equalTo("135 Upland Pl.")).
		log().all();
	}
	
	//@Test(priority=3)
	public void testMultipleContentsInOneGo()
	{
		given().when().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").then()
		.body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas")).
		log().all();
	}
	
	//@Test(priority=4)
	public void testUsingXpath1()
	{
		given().when().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").then()
		.body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Sue")).
		log().all();
	}
	
	@Test(priority=5)
	public void testUsingXpath2()
	{
		given().when().get("http://www.thomas-bayer.com/sqlrest/INVOICE/").then()
		.body(hasXPath("/INVOICEList/INVOICE[text()='30']")).
		log().all();
	}
	
	
}
