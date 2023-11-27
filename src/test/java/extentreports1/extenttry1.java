package extentreports1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extenttry1 {
	
	ExtentReports extent = new ExtentReports();
	   ExtentSparkReporter spark;
	   ExtentTest test;
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	   LocalDateTime now = LocalDateTime.now();
	@BeforeTest
	public void extent() {
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/Spark.html");
		extent.attachReporter(spark);
		test = extent.createTest("Testing demo at : "+dtf.format(now));
	}
	
	@Test
	public void method1() {
		test.log(Status.INFO, "TestSuite got Started");
		System.out.println("Test 1 Successfull");
		test.log(Status.PASS, "Test is passed");
	}

	@Test
	public void mehtod2() {
		test.log(Status.INFO, "TestSuite got Started");
		System.out.println("Test 2 Successfull");
		test.log(Status.PASS, "Test is passed");
	}
	
	@AfterTest
	public void exist() {
		extent.flush();
	}
}
