package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/json-report/cucumber.json",
                "junit:target/resources/features"
        },
        features = "src/test/resources/features",
        glue = {"stepDefinitions","hook"},
        tags = "@senaryo1 or @senaryo2 or @senaryo3 or @senaryo4",
        //tags = "@Scenario1",
        dryRun = false
)

public class Runner {

}
