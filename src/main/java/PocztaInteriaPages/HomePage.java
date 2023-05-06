package PocztaInteriaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@class, 'mail')]")
    WebElement mailButton;
    @FindBy(xpath = "//button[@class='rodo-popup-agree']")
    WebElement secondCookieButton;

    @FindBy(xpath = "//div[@class=\"rodo-popup\"]//div[@class=\"rodo-popup-buttons\"]//*[@class='rodo-popup-agree']")
    WebElement incognitoCookieButton;

    public LoginPage clickMailButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mailButton));
        mailButton.click();
        return new LoginPage(driver);
    }

    public void cookieButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(secondCookieButton));
        secondCookieButton.click();
    }

    public boolean isMailButtonVisible() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(mailButton)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void incognitoCookieButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(incognitoCookieButton));
        incognitoCookieButton.click();
    }
}


