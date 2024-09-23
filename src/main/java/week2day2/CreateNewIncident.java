package week2day2;

import io.restassured.RestAssured;

public class CreateNewIncident {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String url = "https://dev203807.service-now.com/api/now/table/incident";
	String requestPayload = "{\r\n"
			+ "    \"short_description\" : \"Hi Team\",\r\n"
			+ "    \"description\" : \"joker\",\r\n"
			+ "    \"urgency\" : \"1\",\r\n"
			+ "    \"state\" : \"1\"\r\n"
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
		           .log()
		           .all();
		

	}

}
