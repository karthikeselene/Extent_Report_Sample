package step.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println(scenario.getUri().toString().split("/"));
		System.out.println(scenario.getName());
	}
	
	@BeforeStep
	public void beforeEachStep(Scenario scenario) {
		System.out.println(scenario.getLine());
		System.out.println(scenario.getName());
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		System.out.println(scenario.getId());
		System.out.println(scenario.getName());
		System.out.println(scenario.getStatus());
	}

}
