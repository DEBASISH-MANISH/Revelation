/**
 * 
 */
package com.google.restAPI;

import org.testng.annotations.Test;

import commonLib.SuperTestScript;
import fileUtilities.PayLoad;
import fileUtilities.Resources;
import fileUtilities.ReusebleMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author MANISH
 *
 */
public class QA_Automation_REST_Assured_POST_XML  extends SuperTestScript
{

	@Test
	public void testPOSTRequestOfGoogleAPIAddDeleteRequest() throws Exception
	{
		
		// Base URL / Host
		
		// Task=1 Grab Response

		//RestAssured.baseURI="http://216.10.245.166";
		String postData = PayLoad.generateStringFromResource("C:\\Users\\MANISH\\workspaceNeon\\LearnRestAssuredAutomation\\DataFile\\PostData.xml");
		RestAssured.baseURI=prop.getProperty("HOST");
		
		
		Response res=given().
		//queryParam("key", "qaclick123").
		queryParam("key", prop.getProperty("KEY")).
		body(postData).
		when().
		//post("/maps/api/place/add/json").
		post(Resources.addPlacePostResourceXMLData()).
		then().
		assertThat().statusCode(200).and().contentType(ContentType.XML).
		extract().response();
		
		// Task=2 Grab the placeId from Response
		
	/*	// convert the extracted raw format response into string format response.
		String responseString=res.asString();
		System.out.println("Response in XML Format is -   "+responseString);
		// convert the string format response into XML format response because Rest Assured recognize XML .
		XmlPath x= new XmlPath(responseString); */
		
		XmlPath x=ReusebleMethods.rawToXml(res);
		System.out.println(x.get("response.place_id"));
		
		
		/* // Task=2 Enter the placeId in to delete request body
		
		given().
		//queryParam("key", "qaclick123").
		queryParam("key", prop.getProperty("KEY")).
		body(PayLoad.getDeletePlacePostBodyData(placeID)).
		when().
		post(Resources.deletePlacePostResourceJsonData()).
		then().
		assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status", equalTo("OK"));
		
		*/
		
	}
	
	
	
	/*public static String generateStringFromResource(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}*/
	
	
	
	
	
	
	
}
