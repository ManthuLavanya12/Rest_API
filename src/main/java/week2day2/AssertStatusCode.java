package week2day2;

import io.restassured.RestAssured;

public class AssertStatusCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		String url = "https://dev203807.service-now.com/api/now/table/incident";
		RestAssured.given()
        .auth()
        .basic("admin", "K*dXTejf%H08")
        .log()
        .all()
        .when()
        .get(url)
        .then()
        .assertThat()
        .statusCode(200);


	}

}
