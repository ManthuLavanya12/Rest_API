package week3day1;

import java.io.File;
import java.net.URI;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class ServiceNowIncidentTest extends BaseRequest{
	
	@Test(priority=0)
	public void shouldUserAbletoCreateIncident(){
		sys_id=RestAssured.given()
		           .header("Content-Type","application/json")
		           .pathParam("table_name", "incident")
		           .when()
		           .body(new File("src/main/resources/request_payload/create-incident.json"))
		           .post()
		           .then()
		           .log()
		           .all()
		           .statusLine(equalTo("HTTP/1.1 201 Created"))
		           .body("result.short_description", equalTo("Hi Team"))
		           .body("result.description",equalTo("joker"))
		           .assertThat()
		           .statusCode(201)
		           .extract()
		           .jsonPath()
		           .getString("result.sys_id");
		           
	}
	@Test(priority=1)
	public void shouldUserAbleGetAllIncidents() {
		RestAssured.given()
        .pathParam("table_name", "incident")
        .when()
        .get()
        .then()
        .log()
        .all()
        .statusLine(equalTo("HTTP/1.1 200 OK"))
        .assertThat()
        .statusCode(200);


		
	}
	@Test(priority=2)
	public void UpdateSingleIncident(){
		RestAssured.given()
		           .header("Content-Type","application/json")
		           .pathParam("table_name", "incident")
		           .pathParam("sys_id",sys_id)
		           .when()
		           .body(new File("src/main/resources/request_payload/update-incident.json"))
		           .put("/{sys_id}")
		           .then()
		           .log()
		           .all()
		           .statusLine(equalTo("HTTP/1.1 200 OK"))
		           .assertThat()
		           .statusCode(200);
		           
	}
	@Test(priority=3)
	public void shouldbeAbleToGetSingleIncident() {
		RestAssured.given()
        .pathParam("table_name", "incident")
        .pathParam("sys_id", sys_id)
        .when()
        .get("/{sys_id}")
        .then()
        .log()
        .all()
        .statusLine(equalTo("HTTP/1.1 200 OK"))
        .assertThat()
        .statusCode(200);
		
	}
	
	@Test(priority=4)
	public void DeleteSingleIncident(){
		RestAssured.given()
		           .pathParam("table_name", "incident")
		           .pathParam("sys_id", sys_id)
		           .when()
		           .delete("/{sys_id}")
		           .then()
		           .log()
		           .all()
		           .statusLine(equalTo("HTTP/1.1 204 No Content"))
		           .statusLine(containsString("Content"))
		           .assertThat()
		           .statusCode(204);
		           
	}
	



}
