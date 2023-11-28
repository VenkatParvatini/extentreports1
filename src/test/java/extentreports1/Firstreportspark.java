package extentreports1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.relevantcodes.extentreports.LogStatus;

@Listeners(extentclass.class)
public class Firstreportspark extends extentclass{
	
	@Test(priority=1)
	public void extentreport1() {
		test = extent.createTest("Testing demo at 1: "+dtf.format(now));
//		test.log(Status.PASS, "Test got started");
		System.out.println("Test 1");
		assertTrue(true);
//		test.log(Status.PASS, "Test got success");
	}
	
	@Test(priority=2)
	public void extentreport2() {
		test = extent.createTest("Testing demo at 2: "+dtf.format(now));
//		test.log(Status.PASS, "Test got started");
		System.out.println("Test 2");
		assertTrue(false);
//		test.log(Status.PASS, "Test got success");
//		try {
			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Test
	public void test3() {
		System.out.println("Test4");
	}
}
