/**
 * 
 */
package com.google.restAPI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonLib.SuperTestScript;
import fileUtilities.PayLoad;
import fileUtilities.Resources;
import fileUtilities.ReusebleMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import javax.mail.Quota.Resource;

/**
 * @author MANISH
 *
 */
public class QA_AddBooks_POST_StaticJson  extends SuperTestScript
{

	@Test
	public void testAddBookPOSTDeleteBookAPI() throws IOException
	{
		
		// Base URL / Host
		
		// Task=1 Grab Response

		//RestAssured.baseURI="http://216.10.245.166";
		String postData =PayLoad.generateStringFromResource("C:\\Users\\MANISH\\workspaceNeon\\LearnRestAssuredAutomation\\DataFile\\AddBookDetails.json");
		RestAssured.baseURI=prop.getProperty("HOST");
		
		
		Response res=given().
				header("Content-Type","application/json").
		body(postData).
		when().
		post(Resources.addBooksPostResourceJsonData()).
		//post(Resources.addPlacePostResourceJsonData()).
		then().log().body().
		assertThat().statusCode(200).and().
		extract().response();
		
		JsonPath js=ReusebleMethods.rawToJson(res);
		js.get("Msg").equals("successfully added");
		String bookId=js.get("ID");
		System.out.println("Book Successfully Added with BookID:  "  + bookId);
		
		
		// Task=2 Enter the BookId in to delete request body
		
				given().
				header("Content-Type","application/json").
				body(PayLoad.deleteBookPostBodyData(bookId)).
				when().
				post(Resources.deleteBooksPostResourceJsonData()).
				then().log().body().
				assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
				body("msg", equalTo("book is successfully deleted"));
				
				
		
		
		
		
	}
	

	
	
}
