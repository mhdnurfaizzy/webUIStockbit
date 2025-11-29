package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features", // Path to your feature files
        glue = "stepdefinitions",                // Package name for your step definitions
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReport.json"}
)
public class testRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true) // Optional: for running scenarios in parallel
    public Object[][] scenarios() {
        return super.scenarios();
    }
}