package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features="src/test/resources",
        glue= {"stepDefinitions","hooks"},
        tags= "@e2e",
        dryRun= false
)


public class API_Runner {
}


// cross browser test --> farklı browserlar da yaptığımız tes