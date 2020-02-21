/**
 * 
 */
package com.google.restAPI;

import org.testng.annotations.Test;

import commonLib.SuperTestScript;
import fileUtilities.PayLoad;
import fileUtilities.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author MANISH
 *
 */
public class QA_Automation_REST_Assured_POST  extends SuperTestScript
{

	@Test
	public void testPOSTRequestOfGoogleAPIAddDeleteRequest()
	{
		
		// Base URL / Host
		
		// Task=1 Grab Response

		//RestAssured.baseURI="http://216.10.245.166";
		
		RestAssured.baseURI=prop.getProperty("HOST");
		
		
		Response res=given().
		//queryParam("key", "qaclick123").
		queryParam("key", prop.getProperty("KEY")).
		body(PayLoad.getAddPlacePostBodyData()).
		when().
		//post("/maps/api/place/add/json").
		post(Resources.addPlacePostResourceJsonData()).
		then().
		assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status", equalTo("OK")).
		extract().response();
		
		// Task=2 Grab the placeId from Response
		
		// convert the extracted raw format response into string format response.
		
		String responseString=res.asString();
		System.out.println(responseString);
		// convert the string format response into json format response because Rest Assured recognize json object array.
		JsonPath js= new JsonPath(responseString);
		String placeID=js.get("place_id");
		System.out.println("Place ID is -  "+ placeID);
		
		// Task=2 Enter the placeId in to delete request body
		
		given().
		//queryParam("key", "qaclick123").
		queryParam("key", prop.getProperty("KEY")).
		body(PayLoad.getDeletePlacePostBodyData(placeID)).
		when().
		post(Resources.deletePlacePostResourceJsonData()).
		then().
		assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status", equalTo("OK"));
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
