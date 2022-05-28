package simplescript;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentBasicReportCreation {

	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/ExtentBasicReport.html");
		extent.attachReporter(spark);
		extent.createTest("Pass Test Case").pass("Test case is passed!!!");
		extent.createTest("Fail Test Case").fail("Test case is failed!!!");
		extent.createTest("Info Test Case").info("Test case info!!!");
		extent.createTest("Warning Test Case").warning("Test case warning!!!");		
		ExtentTest test = extent.createTest("Basic Test suite");
		ExtentTest node = test.createNode("Test Case 1");		
		node.log(Status.PASS, MarkupHelper.createLabel("Test case is passed!!!", ExtentColor.GREEN));
		node.log(Status.FAIL, "Fail Test Case", MediaEntityBuilder.createScreenCaptureFromPath("../reports/screen6.png").build());
		node.log(Status.INFO, "Test case info!!!");
		node.log(Status.WARNING, "Test case warning!!!");
		node.log(Status.SKIP, "Test case skipped!!!");
		extent.flush();	
	}

}
