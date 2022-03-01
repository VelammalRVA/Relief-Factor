package Calm;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFile\\Calm.feature",glue="Calm", dryRun = false, monochrome=true,plugin = { "pretty", "html:target/Calm reports/Cucumber.html" })

public class CalmRunnerClass {
	
}
