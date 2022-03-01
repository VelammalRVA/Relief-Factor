package SalesOrder;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFile\\SalesOrder.feature",glue="SalesOrder", dryRun = false, monochrome=false,plugin = { "pretty", "html:target/Sales Order Reports Destination/cucumber.html" })

public class RunnerSalesOrder {

}
