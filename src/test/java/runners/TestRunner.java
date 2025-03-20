package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/urbanladder.feature",
    glue = "stepDefinitions",
    //plugin = {"pretty", "html:target/cucumber-reports"},
    plugin = {"pretty", "json:target/cucumber-reports-json/Cucumber.json"} // Generate JSON report

)
public class TestRunner extends AbstractTestNGCucumberTests {
}










