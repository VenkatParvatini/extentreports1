package extentreports1;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class extentclass implements ITestListener{
	
//	static ExtentTest test;
//	static ExtentReports report;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	   LocalDateTime now = LocalDateTime.now();
	   
	   ExtentReports extent = new ExtentReports();
	   ExtentSparkReporter spark;
	   ExtentTest test;

	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest("Testing demo at : "+dtf.format(now),"des");
//		test.log(LogStatus.INFO, "test started");
		test.log(Status.INFO, "TestSuite got Started");
		  
		System.out.println("Test got started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test got success");
//		test.log(LogStatus.INFO, "test success");;
		test.log(Status.PASS, "test success");
	
		}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test got onTestFailure");
		test.log(Status.FAIL, "Test got failed");
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
//		String path = System.getProperty("user.dir")+"/target/ExtentReportResults.html";
//		 report = new ExtentReports(path, true);
		
		System.out.println("Test suite started");
		
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/Spark.html");
		extent.attachReporter(spark);
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test suite finished");
		test.log(Status.INFO, "test finished");
//		report.flush();
		extent.flush();
		try {
			Desktop.getDesktop().browse(new File("Spark.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			Desktop.getDesktop().browse(new File("Spark.html").toURI());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	

}
