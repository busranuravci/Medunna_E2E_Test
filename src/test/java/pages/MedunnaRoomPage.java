package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaRoomPage {
    public MedunnaRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "jh-create-entity")
    public WebElement createNewRoomButton;

    @FindBy(id = "room-roomNumber")
    public WebElement roomNumberInput;

    @FindBy(id = "room-roomType")
    public WebElement roomTypeDD;

    @FindBy(id = "room-status")
    public WebElement statusCheckBox;

    @FindBy(id = "room-price")
    public WebElement priceInput;

    @FindBy(id = "room-description")
    public  WebElement decriptionInput;

    @FindBy(id = "save-entity")
    public WebElement saveSubmitButton;

    @FindBy(xpath = "//span[.='Created Date']")
    public WebElement createDate;

    @FindBy(xpath = "//tbody//td[2]")
    public WebElement roomNumberList;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement firstId;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alert;

}
