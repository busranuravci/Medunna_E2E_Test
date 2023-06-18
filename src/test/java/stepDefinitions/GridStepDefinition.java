package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.Driver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class GridStepDefinition {

    @Given("user goes to app with chrome")
    public void userGoesToAppWithChrome() throws MalformedURLException {

        // remote driver obj oluşturma (Grid kısmı sadece burası aslında!)
        new RemoteWebDriver(new URL("http://192.168.1.145:4444"),new ChromeOptions());  // http://localhost:4444  şeklinde de yazabilirdik-bu test için.

        Driver.getDriver().get("https://bluerentalcars.com");
    }


    @When("verify the title is {string}")
    public void verifyTheTitleIs(String title) {

        assertEquals(title,Driver.getDriver().getTitle());

    }

    @Then("close the driver")
    public void closeTheDriver() throws InterruptedException {

Thread.sleep(3000);
        Driver.quitDriver();
    }

    @Given("user goes to app with firefox")
    public void userGoesToAppWithFirefox() throws MalformedURLException {

        new RemoteWebDriver(new URL("http://192.168.1.145:4444"), new FirefoxOptions());
        Driver.getDriver().get("https://bluerentalcars.com");
    }

    @Given("user goes to app with edge")
    public void userGoesToAppWithEdge() throws MalformedURLException {

        new RemoteWebDriver(new URL("http://192.168.1.145:4444"), new EdgeOptions());
        Driver.getDriver().get("https://bluerentalcars.com");
    }

}
