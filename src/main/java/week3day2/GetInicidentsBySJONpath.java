package week3day2;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetInicidentsBySJONpath {
@Test
public void GetHardwareCategory() {
	String url = "https://dev203807.service-now.com/api/now/table/{table_name}";
	List<String> list = given()
	           .auth()
	           .basic(PropertiesHandler.getUsername(), PropertiesHandler.getPassword())
	           .pathParam("table_name", "incident")
	           .when()
	           .get(url)
	           .then()
	           .assertThat()
	           .statusCode(200)
	           .contentType(ContentType.JSON)
	           .extract()
	           .jsonPath()
	           .getList("result.findAll{it.category == 'hardware'}.category");
	System.out.println(list.size());
	           for (String category :list) {
	        	   Assert.assertEquals(category, "hardware");
	           }
	           

}
}
