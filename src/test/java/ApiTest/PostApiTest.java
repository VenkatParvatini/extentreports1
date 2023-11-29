package ApiTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import APIBuilder.PostApiBuilder;
import PostAPIVerificaitons.PostApiVerification;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilis.*;
@Listeners(extentreport.class)
public class PostApiTest extends extentreport {
	static Response response;
	@Test
	public static void PostApi() {
		test.log(Status.INFO, "Post Call started");
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://reqres.in");
		RequestSpecification reqspec = requestSpecBuilder.build();

		PostApiBuilder postApiBuilder = new PostApiBuilder();
//		headers headers = new headers();
		
		
		response = RestAssured.given()
							.spec(reqspec)
							.when()
//							.headers(headers.basicheaders())
							.body(postApiBuilder.postrequestbody("venkat", "it"))
							.post(ApiPath.pathParam.apiPath.CREATE_POST);
		
							
		
							
		test.log(Status.PASS, "POST call is sucess");				

	}
	
	@Test
	public static void test1() {
		PostApiVerification.responseCodeValidation(response, 201);
		
	}
//	@SuppressWarnings("unlikely-arg-type")
	@Test
	public static void test3() {
		
//		System.out.println(response.getBody().asString());
		
		System.out.println(response.getBody().prettyPrint());
	}
	@Test
	public static void test2() {
		PostApiVerification.responseJSONObject(response, "id");
	}
}
