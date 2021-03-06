package Energy;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFile\\Energy.feature",glue="Energy", dryRun = false, monochrome=true,plugin = { "pretty", "html:target/cucumber-reports/Cucumber.html" })
public class EnergyRunner {

}
