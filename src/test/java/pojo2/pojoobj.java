package pojo2;

import com.google.gson.Gson;

public class pojoobj {
	
	public static void main(String[] args) {
		main main1 = new main();
		main1.setAddress(arraylist.addresslist());
		
		mainpojo mainpojo = new mainpojo();
		mainpojo.setName("venkat");
		mainpojo.setMain(main1);
		
		Gson json = new Gson();
		System.out.println(json.toJson(mainpojo));
	}

}
