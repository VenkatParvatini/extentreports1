package APIBuilder;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import Pojo.requestpojo;

public class PostApiBuilder {
	
	
	public  String postrequestbody(String name, String job) {

		requestpojo requestpojo = new requestpojo();
		requestpojo.setName(name);
		requestpojo.setJob(job);

		Gson gson = new Gson();
		return gson.toJson(requestpojo);
		
	}
	
	

}
