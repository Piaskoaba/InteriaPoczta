package PocztaInteriaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
    @FindBy(xpath = "//span[@class='navigation__new__text']")
    WebElement messageButton;


    public NewMessagePage clickNewMessegeButton() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(messageButton));
        messageButton.click();

        return new NewMessagePage(driver);

    }

    boolean isAvatarVisible (By avatar) {
        try {
            return driver.findElement(avatar).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }


}
