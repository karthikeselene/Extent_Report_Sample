package sample.report;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateSimpleExtentReport {

	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter html = new ExtentSparkReporter(new File("./reports/SampleReports.html"));
		extent.attachReporter(html);
		
		extent.createTest("MyPassTest").log(Status.PASS, "This is logging event for MyPassTest, and it's PASSED!!!");
		extent.createTest("MyFailTest").log(Status.FAIL, "This is logging event for MyFailTest, and it's FAILED!!!");
		extent.createTest("MyInfoTest").log(Status.INFO, "This is logging event for MyInfoTest, and it's INFO!!!");
		
		ExtentTest test = extent.createTest("My Sampel Test case");
		test.log(Status.PASS, "This is logging event for My Sampel Test case, and it's PASSED!!!");
		test.log(Status.FAIL, "This is logging event for My Sampel Test case, and it's FAILED!!! "+test.addScreenCaptureFromPath("./reports/images/embedded1.png"));		
		test.log(Status.INFO, "This is logging event for My Sampel Test case, and it's INFO!!!");
		
		ExtentTest test1 = extent.createTest("My Sampel Test case - 2");
		ExtentTest node1 = test1.createNode("My Node 1");
		node1.log(Status.PASS, "This is logging event for My Sampel Test case, and it's PASSED!!!");
		node1.log(Status.FAIL, "This is logging event for My Sampel Test case, and it's FAILED!!!");
		node1.log(Status.INFO, "This is logging event for My Sampel Test case, and it's INFO!!!");
		ExtentTest node2 = test1.createNode("My Node 2");
		node2.log(Status.PASS, "This is logging event for My Sampel Test case, and it's PASSED!!!");
		node2.log(Status.FAIL, "This is logging event for My Sampel Test case, and it's FAILED!!!");
		node2.log(Status.INFO, "This is logging event for My Sampel Test case, and it's INFO!!!");
		
		extent.flush();
	}

}