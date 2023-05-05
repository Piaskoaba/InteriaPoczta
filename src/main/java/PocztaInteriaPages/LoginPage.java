package PocztaInteriaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='email']")
    WebElement logWindow;
    @FindBy(id = "password")
    WebElement passWindow;
    @FindBy(xpath = "//*[@id='sitebar']/form/button")
    WebElement logIn;
    @FindBy(xpath = "//*[@id=\"sitebar\"]/form/span[1]")
    WebElement wrongPasswordOrLoginVisibility;
    @FindBy(xpath = "//*[@id=\"sitebar\"]/form/div[1]/div[1]/label")
    WebElement eMailTextIsVisible;



    public void fillLoginWindow(String login) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logWindow));
        logWindow.sendKeys(login);
    }


    public void fillPasswordWindow(String mailPassword) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(passWindow));
        passWindow.sendKeys(mailPassword);

    }

    public void fillWrongPasswordWindow(String mailPassword) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(passWindow));
        passWindow.sendKeys(mailPassword);

    }

    public MailPage clickLogInButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logIn));
        logIn.click();
        return new MailPage(driver);
    }

    public boolean passwordIsNotCorrect() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(wrongPasswordOrLoginVisibility)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean loginIsNotCorrect() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(wrongPasswordOrLoginVisibility)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public boolean isEmailTextVisible() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(eMailTextIsVisible)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public boolean isLoginButtonVisible() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(logIn)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}


