package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.MedunnaHomePage;
import pages.MedunnaRoomPage;
import utilities.Driver;

public class MedunnaRoomStepDef {

    MedunnaRoomPage medunnaRoomPage = new MedunnaRoomPage();
    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    public static int roomNumberFaker;
    public static String roomID;


    @When("click on ItemsAndTitles")
    public void clickOnItemsAndTitles() {
        medunnaHomePage.itemsAndTitles.click();
    }

    @And("click on Room option")
    public void clickOnRoomOption() {
        medunnaHomePage.roomOption.click();
    }

    @And("click on Create a new room button")
    public void clickOnCreateANewRoomButton() {
        medunnaRoomPage.createNewRoomButton.click();
    }

    @And("enter {string} room number input")
    public void enterRoomNumberInput(String roomNumber) {
        roomNumberFaker = Faker.instance().number().numberBetween(100000,1000000);
        medunnaRoomPage.roomNumberInput.sendKeys(roomNumberFaker + "");

    }

    @And("select Suite option from Room Type Drop Down")
    public void selectSuiteOptionFromRoomTypeDropDown() {
        new Select(medunnaRoomPage.roomTypeDD).selectByIndex(2);
    }

    @And("click on Status checkbox")
    public void clickOnStatusCheckbox() {
        medunnaRoomPage.statusCheckBox.click();
    }

    @And("enter {string} in Price input")
    public void enterInPriceInput(String price) {
        medunnaRoomPage.priceInput.sendKeys(price);
    }

    @And("enter {string} in Description input")
    public void enterInDescriptionInput(String description) {
        medunnaRoomPage.decriptionInput.sendKeys(description);
    }

    @And("click on Save button")
    public void clickOnSaveButton() throws InterruptedException {
        medunnaRoomPage.saveSubmitButton.submit();

Thread.sleep(3000);

        roomID = medunnaRoomPage.alert.getText().replaceAll("[^0-9]","");
        System.out.println("Room ID: " + roomID);

    }

    @And("close the app")
    public void closeTheApp() {
        Driver.closeDriver();
    }
}
