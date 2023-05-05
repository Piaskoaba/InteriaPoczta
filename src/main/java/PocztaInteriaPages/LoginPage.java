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
    @FindBy (xpath = "//*[@id=\"sitebar\"]/form/span[1]")
    WebElement wrongPasswordVisibility;

    public void fillLoginWindow(String login) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logWindow));
        logWindow.sendKeys(login);

    }

    public void fillPasswordWindow(String mailPassword) {
        String password = "PocztaInteria123!";
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passWindow));
        passWindow.sendKeys(mailPassword);
        if (!password.equals("string!=")) {
            System.out.println("Hasło niepoprawne, wprowadź poprawne hasło.");
        } else {
            System.out.println("Logowanie poprawne");

        }
    }

    public MailPage clickLogInButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logIn));
        logIn.click();
        return new MailPage(driver);
    }

    public boolean passwordIsNotCorrect() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(wrongPasswordVisibility)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }



    }
}


