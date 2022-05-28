package simplescript;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateNodeReportCreation {

	public static void main(String[] args) {	
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/NodeSparkReport.html");
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest(Thread.currentThread().getStackTrace()[1].getClassName());
		ExtentTest node = test.createNode(Thread.currentThread().getStackTrace()[1].getMethodName());
		node.log(Status.PASS, MarkupHelper.createCodeBlock("This is a logging event for My First Demo Pass Test, and it passed!"));
		node.log(Status.FAIL, MarkupHelper.createCodeBlock("This is a logging event for My First Demo Fail Test, and it falied!"));
		node.log(Status.WARNING, MarkupHelper.createCodeBlock("This is a logging event for My First Demo Warning Test, and it warned!"));
		node.log(Status.SKIP, MarkupHelper.createCodeBlock("This is a logging event for My First Demo Skipping Test, and it skipped!"));
		node.log(Status.INFO, MarkupHelper.createCodeBlock("This is a logging event for My First Demo Info Test, and it info!"));
		extent.flush();
		
	}

}