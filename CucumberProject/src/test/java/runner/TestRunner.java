package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="./features/OrangeHRM.feature", glue="step", monochrome=true)

public class TestRunner {
	

}
