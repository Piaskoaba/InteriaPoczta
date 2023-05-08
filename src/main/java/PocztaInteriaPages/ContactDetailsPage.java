package PocztaInteriaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactDetailsPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"dialog__scroll\"]//div[@class='dropdown__icon icon icon-dots']")
    WebElement contactOptionsButton;

    @FindBy(xpath = "//*[@class='dialog__scroll']//*[@class='dropdown__list']//*[contains(text(),'Usuń')]")
    WebElement deleteContactButton;

    @FindBy(xpath = "//div[@class=\"dialog__scroll__header\"]//span[2]")
    WebElement editContactButton;

    @FindBy(xpath = "//div[@class='notification__message']")
    WebElement contactDeletedAlert;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/ul/li/span[2]")
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


