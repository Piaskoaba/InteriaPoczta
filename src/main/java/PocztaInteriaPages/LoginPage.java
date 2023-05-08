package PocztaInteriaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='email']")
    WebElement loginWindow;

    @FindBy(id = "password")
    WebElement passwordWindow;

    @FindBy(xpath = "//*[@id='sitebar']/form/button")
    WebElement logInButton;

    @FindBy(xpath = "//*[@id='sitebar']//span[contains(text(),'Błędny e-mail lub hasło')]")
    WebElement wrongPasswordOrLoginAlert;

    @FindBy(xpath = "//form[@class='login-form']//label[@class='account-input__label']")
    WebElement eMailTextUnderLoginWindowIsVisible;


    public void fillLoginWindow(String login) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginWindow));
        loginWindow.clear();
        loginWindow.sendKeys(login);
    }

    public void fillPasswordWindow(String mailPassword) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordWindow));
        passwordWindow.clear();
        passwordWindow.sendKeys(mailPassword);
    }

    public MailPage clickLogInButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
        return new MailPage(driver);
    }

    public boolean isEmailTextUnderLoginWindowVisible() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(eMailTextUnderLoginWindowIsVisible)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLoginButtonVisible() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(logInButton)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isIncorrectLoginOrPasswordVisible() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(wrongPasswordOrLoginAlert)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public String getTextFromLoginWindow() {
        webDriverWait.until(ExpectedConditions.visibilityOf(loginWindow));
        String text = loginWindow.getText();
        return text;
    }

    public String getTextFromPasswordWindow() {
        webDriverWait.until(ExpectedConditions.visibilityOf(passwordWindow));
        String text = passwordWindow.getText();
        return text;
    }
}

