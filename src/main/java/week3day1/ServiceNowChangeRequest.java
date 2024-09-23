package week3day1;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ServiceNowChangeRequest extends BaseRequest {
	@Test
	public void shouldUserAbletoCreateIncident(){
		sys_id=RestAssured.given()
		           .header("Content-Type","application/json")
		           .pathParam("table_name", "change_request")
		           .when()
		           .body(new File("src/main/resources/request_payload/create-incident.json"))
		           .post()
		           .then()
		           .log()
		           .all()
		           .statusLine(equalTo("HTTP/1.1 201 Created"))
		           .assertThat()
		           .statusCode(201)
		           .extract()
		           .jsonPath()
		           .getString("result.sys_id");
		           
	}


}
