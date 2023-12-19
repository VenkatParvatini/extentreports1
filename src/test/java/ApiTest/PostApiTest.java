package ApiTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
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
	static ITestContext context;

	@Test
	@Parameters("Environment")
	public static void PostApi(@Optional("stage") String Environment) throws IOException {
		test.log(Status.INFO, "Post Call started");
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri(EnviClass.produri(Environment).get("uri"));
		RequestSpecification reqspec = requestSpecBuilder.build();
		PostApiBuilder postApiBuilder = new PostApiBuilder();
//		headers headers = new headers();
		response = RestAssured
							.given()
							.spec(reqspec)
							.when()
//							.headers(headers.basicheaders())
				 			.body(postApiBuilder.postrequestbody("venkat", "it"))
				 			.post(ApiPath.pathParam.apiPath.CREATE_POST);
		test.log(Status.PASS, "POST call is sucess");

	}

	@Test(dependsOnMethods = "PostApi")
	public static void test1() {
		PostApiVerification.responseCodeValidation(response, 201);
		Assert.assertFalse(true);
	}

	@Test(dependsOnMethods = "test1", alwaysRun = true) //softDependency
	public static void test3() {
//		System.out.println(response.getBody().prettyPrint());
		System.out.println("second reposne is:" + "/ln" + response.body().prettyPrint());
	}

	@Test(dependsOnMethods = "test1") //hardDependency
	public static void test2() {
		PostApiVerification.responseJSONObject(response, "id");
	}
}
