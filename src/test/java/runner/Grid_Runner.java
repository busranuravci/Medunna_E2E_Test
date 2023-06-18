package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features="src/test/resources",
        glue= {"stepDefinitions","hooks"},
        tags= "@grid_features",
        dryRun= true
)


public class Grid_Runner {
}


// cross browser test --> farklı browserlar da yaptığımız test
   //  terminale --> mvn clean install yazdığımızda tüm runnerlarımı çalıştıracak   :  pom'daki plugin sayesinde paralel test