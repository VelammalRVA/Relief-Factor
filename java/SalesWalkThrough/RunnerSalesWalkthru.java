package SalesWalkThrough;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFile\\SalesWalkThrough.feature",glue="SalesWalkThrough", dryRun = false, monochrome=true,plugin = { "pretty", "html:target/Sales Walk Through Reports Destination/cucumber.html" })
public class RunnerSalesWalkthru {

}
