package HomeAssessment_Week2day2;

import io.restassured.RestAssured;

public class CreateChangeRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://dev203807.service-now.com/api/now/table/change_request";
		String requestPayload = "{\r\n"
				+ "    \"short_description\" : \"Change Request\",\r\n"
				+ "    \"description\" : \"Done\",\r\n"
				+ "    \"urgency\" : \"2\",\r\n"
				+ "    \"state\" : \"-5\"\r\n"
				+ "}";
			RestAssured.given()
			           .auth()
			           .basic("admin", "K*dXTejf%H08")
			           .header("Content-Type","application/json")
			           .log()
			           .all()
			           .when()
			           .body(requestPayload)
			           .post(url)
			           .then()
			           .assertThat()
			           .statusCode(201)
			           .log()
			           .all();
			

		
	}

}
