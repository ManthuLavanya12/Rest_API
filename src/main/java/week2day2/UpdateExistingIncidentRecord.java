package week2day2;

import io.restassured.RestAssured;

public class UpdateExistingIncidentRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://dev203807.service-now.com/api/now/table/incident/ef4225a40a0a0b5700d0b8a790747812";
		String UpdatePayload = "{\r\n"
				+ "    \"short_description\" : \"rest api session\",\r\n"
				+ "    \"description\" : \"good night\",\r\n"
				+ "    \"urgency\" : \"2\",\r\n"
				+ "    \"state\" : \"2\"\r\n"
				+ "}";
		RestAssured.given()
                   .auth()
                   .basic("admin", "K*dXTejf%H08")
		           .header("Content-Type","application/json")
                   .log()
                   .all()
                   .when()
                   .body(UpdatePayload)
		           .put(url)
		           .then()
		           .log()
		           .all();
		           

	}

}
