package HomeAssessment_Week2day2;

import io.restassured.RestAssured;

public class Get_Single_ChangeRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://dev203807.service-now.com/api/now/table/change_request/a4cffe9c53acd2109f261ab0a0490e38";
		RestAssured.given()
		           .auth()
		           .basic("admin", "K*dXTejf%H08")
		           .log()
		           .all()
		           .when()
		           .get(url)
		           .then()
		           .assertThat()
		           .statusCode(200)
		           .log()
		           .all();
		


	}

}
