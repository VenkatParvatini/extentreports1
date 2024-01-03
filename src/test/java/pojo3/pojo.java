package pojo3;

import com.google.gson.Gson;

public class pojo {
	
	public static void main(String[] args) {
		
		mainpojo obj = new mainpojo();
		obj.setName("venkat");
		obj.setAddress(addresslist.addresslist());
		
		Gson json = new Gson();
		
		System.out.println(json.toJson(obj));
	}

}
