package pojofiles;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class pojoobj {

	public static void main(String[] args) {
				
			mainpojo mainpojo = new mainpojo();
			
			mainpojo.setName("venkat");
			mainpojo.setAddress(addressalist.addressarraylist());
			
			Gson json = new Gson();
			System.out.println(json.toJson(mainpojo));
			
	}
}
