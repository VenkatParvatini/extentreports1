package PostAPIVerificaitons;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

//import com.aventstack.extentreports.model.Test;

import io.restassured.response.Response;
import utilis.extentreport;

public class PostApiVerification extends extentreport{
	
	public static void responseCodeValidation(Response response, int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
		try {
			Assert.assertEquals(response.getStatusCode(), statusCode);
		test.log(Status.PASS, "Successfully validated for status code:"+ response.getStatusCode());
		}
		catch(AssertionError e){
			test.log(Status.FAIL, "Expected status code is :"+statusCode+" , actual status code is :"+response.getStatusCode());
		}
		
	}
	
	public static void responseJSONArray(Response response, String key) {
		
			JSONArray array = new JSONArray(response.getBody().asString());
			for(int i=0;i<array.length();i++) {
				JSONObject obj =array.getJSONObject(i);
				test.log(Status.PASS, "Validated values are "+obj.getString(key));
			}
	}
	public static void responseJSONObject(Response response, String key) {
		
			JSONObject jsonObject = new JSONObject(response.getBody().asString());
			System.out.println(jsonObject.get(key));
			Assert.assertEquals(jsonObject.has(key), true,"Reponse has the required "+key);
			test.log(Status.PASS, "Validated values are "+jsonObject.get(key));
	}
		
	
	

}
