package PocztaInteriaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@class, 'mail')]")
    WebElement mailButton;
    @FindBy(xpath = "//button[@class='rodo-popup-agree']")
    WebElement clickTwo;

    public LoginPage clickMailButton() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(mailButton));
        mailButton.click();

        return new LoginPage(driver);
    }


    public void loginPageCookieButton() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(clickTwo));
        clickTwo.click();

    }

    boolean isAvatarVisible(By avatar) {
        try {
            return driver.findElement(avatar).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;


        }

    }
}


