/**
 * 
 */
package com.google.restAPI;


import org.testng.annotations.Test;

import fileUtilities.ReusebleMethods;
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
public class QA_Automation_REST_Assured_GET {


	@Test
	public void testGETRequestOfGoogleAPI()

	
{
	// Base URL / Host

	RestAssured.baseURI="https://maps.googleapis.com";

	Response res=given().
	param("location","-33.8670522,151.1957362").
	param("radius","1500").
	param("key","AIzaSyCLVzJASmbSbwEjke9d-tDJ1wgm3dw4Img").log().all().
	when().
	get("/maps/api/place/nearbysearch/json").
	then(). 
	assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
	body("results[0].name", equalTo("Sydney")).and().
	body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
	header("Server", "scaffolding on HTTPServer2").extract().response();
	
	JsonPath js=ReusebleMethods.rawToJson(res);
	int count=js.get("results.size()");
	System.out.println(count);
	
	for(int i=0;i<count;i++)
	{
		System.out.println(js.get("results["+i+"].name"));
		
		
	}
	






}

}

