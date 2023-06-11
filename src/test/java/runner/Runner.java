package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features="src/test/resources/endtoend_features",
        glue= {"stepDefinitions","hooks"},
        tags= "@database",
        dryRun= false
)


public class Runner {
}
