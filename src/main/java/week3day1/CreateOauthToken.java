package week3day1;

import io.restassured.RestAssured;
import week3day2.PropertiesHandler;



public class CreateOauthToken  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://dev203807.service-now.com/oauth_token.do";
		String access_token=RestAssured.given()
		           .header("Content-Type","application/x-www-form-urlencoded")
		           .formParam("grant_type", "password")
		           .formParam("client_id",PropertiesHandler.getClientID())
		           .formParam("client_secret",PropertiesHandler.getClientSecret())
		           .formParam("username",PropertiesHandler.getUsername())
		           .formParam("password",PropertiesHandler.getPassword())
		           .when()
		           .post(url)
		           .then()
		           .log()
		           .all()
		           .extract()
		           .jsonPath()
		           .getString("access_token");
		
		System.out.println(access_token);
		           	
		           		


	}

}
