package ChangeRequest_assessment_week3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;

public class ChangeRequest extends BaseClass {
	
	@Test 
	public  void ChangeRequesttest() {
	String requestPayload = "{\r\n"
			+ "    \"short_description\" : \"Hi Team\",\r\n"
			+ "    \"description\" : \"joker\",\r\n"
			+ "    \"urgency\" : \"1\",\r\n"
			+ "    \"state\" : \"1\"\r\n"
			+ "}";
	Response response=RestAssured.given()
                   .contentType(ContentType.JSON)		   
		           .when()
		           .body(requestPayload)
		           .post();
	response.prettyPrint();
	}          
		           
	
	}


