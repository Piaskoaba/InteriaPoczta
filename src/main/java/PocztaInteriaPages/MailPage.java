package PocztaInteriaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileNotFoundException;

public class MailPage extends BasePage {


    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='wrapper']//section[contains(@class,'section--sidebar')]/div/div[contains(@class,'sidebar__main-panel')]/div[1]/div[2]/div/div")
    WebElement avatar;
    @FindBy(xpath = "//span[@class='navigation__new__text']")
    WebElement messageButton;

    @FindBy(xpath = "//*[@id=\"wrapper\"]//span[@class=\"icon icon-inbox\"]")
    WebElement recivedButton;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/section[4]/div/div[1]/div[2]")
    WebElement contaktBook;

    public NewMessagePage clickNewMessegeButton() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(messageButton));
        messageButton.click();

        return new NewMessagePage(driver);

    }

    public boolean isAvatarVisible() {
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOf(avatar)).isDisplayed();

        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }

    public boolean IsMailIconVisible() {

        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(recivedButton)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public AddNewContactPage clickContactBookButton() throws FileNotFoundException {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(contaktBook));
        contaktBook.click();

        return new AddNewContactPage(driver);
    }

}
