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

    @FindBy(xpath = "//*[@id='wrapper']//section[contains(@class,'section--sidebar')]/div/div[contains(@class,'sidebar__main-panel')]/div[1]/div[2]/div/div")
    WebElement avatar;
    @FindBy(xpath = "//*[@id=\"wrapper\"]//span[@class=\"icon icon-inbox\"]")
    WebElement receivedButton;
    @FindBy(xpath = "//*[@id=\"wrapper\"]/section[4]/div/div[1]/div[2]")
    WebElement contactBook;
    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[3]/div/ul/li/div[2]")
    WebElement contactCorrectAddedAlert;
    @FindBy(xpath = "/html/body/div[2]/section[4]/div/div[2]/div[1]/div/span[1]")
    WebElement contactButton;
    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[3]/div/ul/li/div[2]")
    WebElement contactEdidetCorrectAlert;
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
            return webDriverWait.until(ExpectedConditions.visibilityOf(contactCorrectAddedAlert)).isDisplayed();
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
}



