package test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features  = "src/main/java/features/LoginFeature.feature",		
		glue = "step.definitions",
		dryRun = false,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class TestRunnerClass extends AbstractTestNGCucumberTests {
	
	

}
