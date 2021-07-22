package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"}, plugin = {"json:target/cucumber.json", "pretty"},
        glue = "stepDefinition")
public class TestRunner {

}