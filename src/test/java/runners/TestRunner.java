package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/scenarios"},
    glue = {"org.example.configurations", "org.example.steps.wildberries_step_definitions",
        "org.example.steps.asserts"}
)
public class TestRunner {

}
