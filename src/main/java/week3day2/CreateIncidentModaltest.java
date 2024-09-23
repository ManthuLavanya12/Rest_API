package week3day2;

import com.google.gson.Gson;

public class CreateIncidentModaltest {
	public static void main(String[] args) {
		CreateIncidentModal payload =new CreateIncidentModal();
		payload.setShort_description("Hi Team");
		payload.setDescription("joker");
		payload.setUrgency("1");
		payload.setState("2");
		
		Gson gson=new Gson();
		String json=gson.toJson(payload);
		System.out.println(json);
				
	}

}
