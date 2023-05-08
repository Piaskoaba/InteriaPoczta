package PocztaInteriaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactDetailsPage extends BasePage {

    @FindBy(xpath = "//div[@class='dialog__scroll']//div[@class='dropdown__icon icon icon-dots']")
    WebElement contactOptionsButton;

    @FindBy(xpath = "//div[@class='dialog__scroll']//div[@class='dropdown__scroll']//li[@ng-click='deleteContact()']")
    WebElement deleteContactButton;

    @FindBy(xpath = "//div[@class='dialog__scroll__header']//span[@data-tooltip='Edytuj']")
    WebElement editContactButton;

    @FindBy(xpath = "//div[@class='notification__message']")
    WebElement contactDeletedAlert;

    @FindBy(xpath = "//div[@class='contact-details__sections']//span[@ng-bind='::phone.value | number']")
    WebElement addedContactNumber;

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void contactOptionsButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactOptionsButton));
        contactOptionsButton.click();
    }

    public EditContactPage editContactButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editContactButton));
        editContactButton.click();
        return new EditContactPage(driver);
    }

    public MailPage deleteContactButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteContactButton));
        deleteContactButton.click();
        return new MailPage(driver);
    }

    public boolean isContactCorrectlyDeletedAllert() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(contactDeletedAlert)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

      public String getPhoneNumberFromContactDetailsWindow() {
          webDriverWait.until(ExpectedConditions.visibilityOf(addedContactNumber));
          String text = addedContactNumber.getText().replace(" ","");
          return text;
     }
}


