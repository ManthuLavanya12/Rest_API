package week3day1;

import io.restassured.RestAssured;
import java.io.File;

public class UpdateExistingIncident {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://dev203807.service-now.com/api/now/table/incident/dffdfd30536052109f261ab0a0490e8e";
		RestAssured.given()
                   .auth()
                   .basic("admin", "K*dXTejf%H08")
		           .header("Content-Type","application/json")
                   .log()
                   .all()
                   .when()
                   .body(new File("src/main/resources/request_payload/update-incident.json"))
		           .put(url)
		           .then()
		           .log()
		           .all();
		           

	}


	
}
