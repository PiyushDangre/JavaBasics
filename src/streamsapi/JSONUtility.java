package streamsapi;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONUtility {
	
	public static ArrayList getCollectionFromFile() {
		 JSONParser parser = new JSONParser();
		 ArrayList<UserDetails> users = new ArrayList<>();
	      try {
	         Object obj = parser.parse(new FileReader("/Users/User/Downloads/MOCK_DATA.json"));
	         JSONArray jsonArray = (JSONArray)obj;
	         Logger.getLogger(JSONUtility.class.getName()).info(jsonArray.toJSONString());
	         Iterator itr = jsonArray.iterator();
	         while(itr.hasNext()) {
	        	 	UserDetails user = new UserDetails();
	        	 	JSONObject jsonObject = (JSONObject) itr.next();
	        	 	user.setId(Integer.parseInt((jsonObject.get("id").toString())));
	        	 	user.setFirstName(jsonObject.get("first_name").toString());
	        	 	user.setLastName(jsonObject.get("last_name").toString());
	        	 	user.setGender(jsonObject.get("gender").toString());
	        	 	user.setEmail(jsonObject.get("email").toString());
	        	 	user.setIpAddress(jsonObject.get("ip_address").toString());
	        	 	users.add(user);
	         }
	         System.out.println(users);
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		
		return users ;
	}

}
