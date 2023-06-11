package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.MedunnaHomePage;
import pages.MedunnaLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class MedunnaSignInStepDef {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();

    @Given("go to {string}")
    public void goTo(String url) {
        Driver.getDriver().get(url);
    }

    @When("click on user icon")
    public void clickOnUserIcon() {
        medunnaHomePage.userIcon.click();
    }

    @And("click on sign in option")
    public void clickOnSignInOption() {
        medunnaHomePage.signInOption.click();
    }

    @And("send username into username box")
    public void sendUsernameIntoUsernameBox() {
        medunnaLoginPage.usernameInput.sendKeys(ConfigReader.getProperty("medunnaUsername"));
    }

    @And("send password into password box")
    public void sendPasswordIntoPasswordBox() {
        medunnaLoginPage.passwordInput.sendKeys(ConfigReader.getProperty("medunnaPassword"));
    }

    @And("click on sign in submit button")
    public void clickOnSignInSubmitButton() {
        medunnaLoginPage.signInSubmit.submit();
    }

}
