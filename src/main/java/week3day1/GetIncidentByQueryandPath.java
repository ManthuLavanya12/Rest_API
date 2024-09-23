package week3day1;

import io.restassured.RestAssured;

public class GetIncidentByQueryandPath {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String url = "https://dev203807.service-now.com/api/now/table/{table_name}";
		RestAssured.given()
		           .auth()
		           .basic("admin", "K*dXTejf%H08")
		           .queryParam("sysparm_fields", "number,sys_id,description,category")
		           .queryParam("sysparm_limit", 2)
		           .queryParam("sysparm_query","category=software")
		           .pathParam("table_name", "incident")
		           .log()
		           .all()
		           .when()
		           .get(url)
		           .then()
		           .log()
		           .all();
		

	}

}
