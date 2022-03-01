package OrderWithSubscription;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFile\\With Subscription.feature",glue="OrderWithSubscription", dryRun = false, monochrome=true,plugin = { "pretty", "html:target/With Subscription Reports Destination/cucumber.html" })

public class RunnerClass{
	
}
