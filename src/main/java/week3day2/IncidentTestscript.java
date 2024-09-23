package week3day2;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.restassured.RestAssured;

public class IncidentTestscript {
	@DataProvider(name="getdata1")
	public String[][] getdata(){
		return DataHandler.readDatafromCSV("incident CSV");
	}
	
@Test(dataProvider="getdata1")
public void CreateNewInicident(String short_description, String urgency,String description, String state ) {
	CreateIncidentModal payload =new CreateIncidentModal();
	payload.setShort_description(short_description);
	payload.setDescription(description);
	payload.setUrgency(urgency);
	payload.setState(state);

String url = "https://dev203807.service-now.com/api/now/table/incident";
RestAssured.given()
           .auth()
           .basic(PropertiesHandler.getUsername(), PropertiesHandler.getPassword())
           .header("Content-Type","application/json")
           .log()
           .all()
           .when()
           .body(payload)
           .post(url)
           .then()
           .log()
           .all()
           .assertThat()
           .statusCode(201);


}



}
