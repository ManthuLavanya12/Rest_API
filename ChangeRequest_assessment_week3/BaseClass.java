package ChangeRequest_assessment_week3;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import week3day2.PropertiesHandler;

public class BaseClass {

	  // Define Base URI And Authentication  inside a method
@BeforeMethod
public void setUp(){

		RestAssured.baseURI="https://dev203807.service-now.com/api/now/table/change_request";
			
		RestAssured.authentication= RestAssured.basic(PropertiesHandler.getUsername(), PropertiesHandler.getPassword());
           }


}
