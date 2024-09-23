package Assessment3_QueryParam_InicidentManagement;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import week3day2.PropertiesHandler;

public class BaseClass {
	public String sys_Id ;

	  // Define Base URI And Authentication  inside a method
@BeforeMethod
public void setUp(){

		RestAssured.baseURI="https://dev203807.service-now.com/api/now/table/incident";
			
		RestAssured.authentication= RestAssured.basic(PropertiesHandler.getUsername(), PropertiesHandler.getPassword());
           }

}
