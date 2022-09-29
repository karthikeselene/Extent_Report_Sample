package simplescript;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SimpleReportCreation {

	public static void main(String[] args) {
		
		//Create the object for ExtentReports Class to create extent html report
		ExtentReports extent = new ExtentReports();
		
		//Create the object for ExtentSparkReporter Class to create spark report
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/SimpleSparkReport.html");
		
		//Attached the instance of the ExtentSparkReporter to the ExtentReports
		extent.attachReporter(spark);
		
		//CreateTest - Below is how a test would be created with 1 passing log.
		extent.createTest("My First Demo Pass Test").log(Status.PASS, "This is a logging event for My First Demo Pass Test, and it passed!");
		
		//CreateTest - Below is how a test would be created with 1 failing log.
		extent.createTest("My First Demo Fail Test").log(Status.FAIL, "This is a logging event for My First Demo Fail Test, and it falied!");
		
		//CreateTest - Below is how a test would be created with 1 warning log.
		extent.createTest("My First Demo Warning Test").log(Status.WARNING, "This is a logging event for My First Demo Warning Test, and it warned!");
		
		//CreateTest - Below is how a test would be created with 1 Skipping log.
		extent.createTest("My First Demo Skipping Test").log(Status.SKIP, "This is a logging event for My First Demo Skipping Test, and it skipped!");
				
		//CreateTest - Below is how a test would be created with 1 info log.
		extent.createTest("My First Demo Info Test").log(Status.INFO, "This is a logging event for My First Demo Info Test, and it info!");	
		
		ExtentTest test = extent.createTest("My First Demo Test");
		test.log(Status.PASS, "This is a logging event for My First Demo Pass Test, and it passed!");
		test.log(Status.FAIL, "This is a logging event for My First Demo Fail Test, and it falied!");
		test.log(Status.WARNING, "This is a logging event for My First Demo Warning Test, and it warned!");
		test.log(Status.SKIP, "This is a logging event for My First Demo Skipping Test, and it skipped!");
		test.log(Status.INFO, "This is a logging event for My First Demo Info Test, and it info!");	
		
		
		//flush - Writes test information from the started reporters to their output view
		extent.flush();
		System.out.println("Spark Report successfully created in the ./reports folder with the name of SimpleSparkReport.html");
	}

}