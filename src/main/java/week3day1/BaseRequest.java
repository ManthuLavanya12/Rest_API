package week3day1;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import week3day2.PropertiesHandler;

public class BaseRequest {
	
		 String sys_id;
			@BeforeMethod
			public void BeforMethod() {
				RestAssured.baseURI="https://dev203807.service-now.com";
				 RestAssured.basePath="/api/now/table/{table_name}";
				 RestAssured.authentication= RestAssured.basic(PropertiesHandler.getUsername(), PropertiesHandler.getPassword());
			}

}
