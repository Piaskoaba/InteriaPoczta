package PocztaInteriaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailPage extends BasePage {
    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='sidebar']//div[@ng-if='!isUpdatingAvatar']")
    WebElement avatar;

    @FindBy(xpath = "//div[@class='navigation navigation--main']//span[@class='icon icon-new-message']")
    WebElement receivedButton;

    @FindBy(xpath = "//div[contains(@title,'Kontakty')]")
    WebElement contactBook;

    @FindBy(xpath = "//div[@class='notification__message']")
    WebElement norificationMessage;


    @FindBy(xpath = "//div[@class='sidebar__title']//div[@class='sidebar__title__icons']/span")
    WebElement contactButton;

    @FindBy(xpath = "//div[@class='notification__list-container']/div[@class='notification__message']")
    WebElement contactEdidetCorrectAlert;
    @FindBy(xpath = "//section[@class='msglist-toolbar']/label[@for='isSelectAllView']")
    WebElement allMessagesCheckBox;
    @FindBy(xpath = "//div[@ng-if='::!folder.isTrash && !folder.isSpam']/span[@class='msglist-action-bar__button-text']")
    WebElement deleteAllMesages;
    @FindBy(xpath = "//span[@class='navigation__new__text']")
    WebElement writeNewMessageButton;


    public boolean isAvatarVisible() {
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOf(avatar)).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean IsMailIconVisible() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(receivedButton)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void contactBookButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactBook));
        contactBook.click();
    }

    public ContactDetailsPage contactByMailAddressClick(String eMailAddress) throws InterruptedException {
        Thread.sleep(2000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactButton));
        WebElement element = driver.findElement(By.xpath("//ul[@class='contact__list']//div[contains(text(),'" + eMailAddress + "')]/../..//span"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new ContactDetailsPage(driver);
    }

    public boolean isContactCorrectlyAddedAlert() {
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOf(norificationMessage)).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public AddNewContactPage contactButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactButton));
        contactButton.click();
        return new AddNewContactPage(driver);
    }

    public boolean isEditedContactCorrectlySaved() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(contactEdidetCorrectAlert)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean deleteAllMessagesCheckBoxIsVissible() {
        try {
            return webDriverWait.until(ExpectedConditions.elementToBeClickable(allMessagesCheckBox)).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void deleteAllMessagesCheckBoxClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(allMessagesCheckBox));
        allMessagesCheckBox.click();
    }

    public void deleteAllMesagesClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteAllMesages));
        deleteAllMesages.click();
    }

    public boolean isDeletedMessagesNotificationVisible() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(norificationMessage)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isNewMessageButtonClickable() {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(writeNewMessageButton));
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public NewMessagePage writeNewMessageButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(writeNewMessageButton));
        writeNewMessageButton.click();
        return new NewMessagePage(driver);
    }
}




