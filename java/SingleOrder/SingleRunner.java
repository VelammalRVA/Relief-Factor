package SingleOrder;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFile\\SingleOrder.feature",glue="SingleOrder", dryRun = false, monochrome=true,plugin = { "pretty", "html:target/Single Order Reports Destination/cucumber.html" })
public class SingleRunner {

}
