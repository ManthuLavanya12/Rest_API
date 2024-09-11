package ChainingProcess_HomeAssessment;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CRUD_incident extends BaseClass {
	@Test
	public void createincident() {
		sys_Id =RestAssured.given()
        .header("Content-Type","application/json")
        .when()
        .body(new File("src/main/resources/request_payload/create-incident.json"))
        .post()
        .then()
        .assertThat()
        .statusCode(201)
        .extract()
        .jsonPath()
        .getString("result.sys_id");
		System.out.println(sys_Id);
}
	
	@Test(dependsOnMethods = {"createincident"})
	public void updateincident() {
		RestAssured.given()
		        .header("Content-Type","application/json")
		        .pathParam("system id", sys_Id)
		        .when()
		        .body(new File("src/main/resources/request_payload/update-incident.json"))
		        .put("/{system id}")
		        .then()
		        .assertThat()
		        .statusCode(200);      
	}
	
	@Test(dependsOnMethods = {"updateincident"})
	public void deletincident() {
		RestAssured.given()
		        .pathParam("system id", sys_Id)
		        .when()
		        .delete("/{system id}")
		        .then()
		        .assertThat()
		        .statusCode(204);
		     
	}
	@Test(dependsOnMethods = {"deletincident"})
	public void getincidentAfterDelete() {
		String error= RestAssured.given()
        .header("Content-Type","application/json")
        .pathParam("system id", sys_Id)
        .when()
        .get("/{system id}")
        .then()
        .assertThat()
        .statusCode(404)
        .extract()
        .jsonPath()
        .getString("error.message");
		System.out.println(error);
}



	}


