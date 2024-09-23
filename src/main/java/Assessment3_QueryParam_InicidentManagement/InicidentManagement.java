package Assessment3_QueryParam_InicidentManagement;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class InicidentManagement extends BaseClass{
@Test
public void GetInicidentByQuery() {
	Map <String ,String> queryparam=new HashMap<String,String>();
	queryparam.put("sysparm_fields","sys_id,short_description");
	queryparam.put("sysparm_limit","3");
	
	Response status  =RestAssured.given()
			.queryParams(queryparam)
	        .when()
	        .get();
	     
	Assert.assertEquals(status.getStatusCode(), 200);
	System.out.println(status.getStatusCode());        
	sys_Id= status.body().jsonPath().getString("result[0].sys_id");	
	System.out.println(sys_Id);
			                        
}
@Test
public void UpdateIncident() {
	
	Response status=RestAssured.given()
             .header("Content-Type","application/json")
             .pathParam("system id", sys_Id)
	         .when()
	         .body(new File("src/main/resources/request_payload/update-incident.json"))
	         .put("/{system id}");
	System.out.println(status.getStatusCode());        

	    			                        
}
@Test(dependsOnMethods= {"UpdateIncident"})
public void DeleteIncident() {
	
	Response status=RestAssured.given()
             .pathParam("system id", sys_Id)
	         .when()
	         .delete("/{system id}");
	System.out.println(status.getStatusCode()); 
	Assert.assertEquals(status.getStatusCode(), 204);


	    			                        
}


	

}
