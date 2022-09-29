package step.definitions;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.GenericProperties;

public class Hooks {
	
	ChromeDriver driver;
	
	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println(scenario.getUri().toString().split("/"));
		System.out.println(scenario.getName());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@BeforeStep
	public void beforeEachStep(Scenario scenario) {
		System.out.println(scenario.getLine());
		System.out.println(scenario.getName());
	}
	
	@AfterStep
	public void afterEachStep(Scenario scenario) {
		scenario.attach(GenericProperties.screenshot(driver), "image/png", "screenshot name");
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		System.out.println(scenario.getId());
		System.out.println(scenario.getName());
		System.out.println(scenario.getStatus());
		if (scenario.isFailed()) {
			scenario.attach(GenericProperties.screenshot(driver), "image/png", "screenshot name");
		}		
		driver.close();
	}	

}
