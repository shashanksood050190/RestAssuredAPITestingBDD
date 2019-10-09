package RestAssuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getFirstName()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		System.out.println("John"+generatedString);
		return ("John"+generatedString);
	}
	
	public static String getLastName()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		System.out.println("Kenedy"+generatedString);
		return ("Kenedy"+generatedString);
	}
	
	public static String getUserName()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		System.out.println("John"+generatedString);
		return "John"+generatedString;
	}
	
	public static String getPassword()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		System.out.println("John"+generatedString);
		return "John"+generatedString;
	}
	
	public static String getEmail()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		System.out.println(generatedString+"gmail.com");
		return generatedString+"gmail.com";
	}
	
	public static String empName()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return "John"+generatedString;
	}
	
	public static String empSal()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public static String empAge()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		return generatedString;
	}

}
