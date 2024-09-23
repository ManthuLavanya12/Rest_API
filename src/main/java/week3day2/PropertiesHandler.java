package week3day2;

import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PropertiesHandler {
	private static Properties prop;
	static {
		 prop=new Properties();
		 try {
			 
	prop.load(new FileInputStream(new File("src/main/resources/request_payload/config.properties")));
	


	}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
public static String getUsername()
{		

	
 return prop.getProperty("service.now.username");	
	


}
public static String getPassword()
{		

	 return prop.getProperty("service.now.password");	


}
public static String getClientID()
{		

return prop.getProperty("service.now.client.Id");	
}	
public static String getClientSecret()
{		

	return prop.getProperty("service.now.client.secret");	

}


}
