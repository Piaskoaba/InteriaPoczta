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

   //@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/form/div[1]/div[1]/input")
   //WebElement logWindow2;

    @FindBy(id = "password")
    WebElement passWindow;

    @FindBy(xpath = "//*[@id='sitebar']/form/button")
    WebElement logIn;



    public void fillLoginWindow(String login) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logWindow));
        logWindow.sendKeys(login);

    }

    public void fillPasswordWindow(String mailPassword) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passWindow));
        passWindow.sendKeys(mailPassword);
    }

    public MailPage clickLogInButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logIn));
        logIn.click();
        return new MailPage(driver);
    }

   // public String getLoginInput(){
   //     webDriverWait.until(ExpectedConditions.elementToBeClickable(logWindow2));
   //     String a = logWindow2.getText();
   //     return a;
    }




