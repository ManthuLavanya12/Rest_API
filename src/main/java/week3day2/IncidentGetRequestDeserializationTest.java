package week3day2;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class IncidentGetRequestDeserializationTest {
@Test
public void FetchAllincidentsRecords() {
	String url = "https://dev203807.service-now.com/api/now/table/{table_name}";
	         List<ResultModal> response=   given()
	                                       .auth()
	                                       .basic(PropertiesHandler.getUsername(), PropertiesHandler.getPassword())
	                                       .pathParam("table_name", "incident")
	                               		   .queryParam("sysparm_limit", 3)
	                                       .queryParam("sysparm_fields", "number,sys_id,description,category,short_description,opened_at,caller_id")
	                                       .queryParam("sysparm_query", "category=software")
	                                       .when()
	                                       .get(url)
	                                       .then()
	                                       .extract()
	                                       .jsonPath()
	                                       .getList("result",ResultModal.class);
	                                   for(ResultModal result : response) {
	                                	 System.out.println(result.getCaller_id());
	                                	 System.out.println(result.getCategory());
	                                	 System.out.println(result.getDescription());
	                                	 System.out.println(result.getNumber());
	                                	 System.out.println(result.getOpened_at());
	                                	 System.out.println(result.getShort_description());
	                                	 System.out.println(result.getSys_id());
	                                	 System.out.println(result.getCaller_id().getLink());
	                                	 System.out.println(result.getCaller_id().getValue());
	                                	 assertThat(result.getCategory(),equalTo("software"));
	                                	 
	                                   }
	                                   


}
}
