package PocztaInteriaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditContactPage extends BasePage {
    public EditContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"phone\"]")
    WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div/div[2]/div/div[2]/div[2]/div/form/div/div[5]/button[1]")
    WebElement saveEditedContactButton;

    public void fillContactPhoneNumberWindow(String phoneNumber) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(phoneNumberField));
        phoneNumberField.sendKeys(phoneNumber);
    }

    public MailPage saveEditedContactButtonClick() {
        webDriverWait.until((ExpectedConditions.elementToBeClickable(saveEditedContactButton)));
        saveEditedContactButton.click();
        return new MailPage(driver);
    }
}
