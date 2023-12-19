package utilis;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreport implements ITestListener {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	protected static ExtentReports extent = new ExtentReports();
	protected static ExtentSparkReporter spark;
	protected static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test =   extent.createTest(result.getName())//sssssssss  
				.assignAuthor("Venkat Framework")
				.assignCategory("API RestAssured Automation");
		test.log(Status.PASS, "TestSuite got Started");
		System.out.println("Test got started: "+result.getName());
	}


	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("Test got success: "+result.getName());
		test.log(Status.PASS, "test success: "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test got onTestFailure: "+result.getName());
		test.log(Status.FAIL, "Test got failed: "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test got onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test got onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test got onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test suite started: "+context.getName());
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/Spark1.html");
		extent.attachReporter(spark);

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test suite finished: "+context.getName());
		test.log(Status.INFO, "test finished");
		extent.flush();
	}

}
