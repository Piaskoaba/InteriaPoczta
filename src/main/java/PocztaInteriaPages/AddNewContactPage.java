package PocztaInteriaPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Random;

public class AddNewContactPage extends BasePage {

    public AddNewContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement contactNameLabel;
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailWindow;
    @FindBy(xpath = "/html/body/div[2]/section[4]/div/div[2]/div[1]/div/span[1]")
    WebElement contatctButton;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[3]/div/ul/li/div[2]")
    WebElement contactCorrectAddedAllert;

    @FindBy(xpath = "//*[@id=\"wrapper\"]//form/div/div[5]/button[1]")
    WebElement saveContactButton;
    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div/div[2]/div/div[2]/div[2]/div/form/div/div[3]/div/div/div[2]/label")
    WebElement phoneNumberField;

    public MailPage contatctButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contatctButton));
        contatctButton.click();
        return new MailPage(driver);
    }

    public void fillContactNameWindow(String randomName, String randomSurename) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactNameLabel));
        contactNameLabel.sendKeys(randomName + " " + randomSurename);

    }
    public void fillContactMailWindow(String eMail) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(emailWindow));
        emailWindow.sendKeys(eMail);
    }
    public boolean isContactCorectlyAddedAllert() {
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOf(contactCorrectAddedAllert)).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public void saveContactButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveContactButton));
        saveContactButton.click();
    }
   public void fillContactPhoneNumberWindow(String phoneNumber){
       webDriverWait.until(ExpectedConditions.visibilityOf(phoneNumberField));
       phoneNumberField.sendKeys(phoneNumber);
   }
    }











