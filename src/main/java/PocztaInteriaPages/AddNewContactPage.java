package PocztaInteriaPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Random;

public class AddNewContactPage extends BasePage {

    public AddNewContactPage(WebDriver driver) {
        super(driver);
    }

    Random random = new Random();

    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement contactNameLabel;
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailWindow;
    @FindBy(xpath = "/html/body/div[2]/section[4]/div/div[2]/div[1]/div/span[1]")
    WebElement contatctButton;

    public MailPage contatctButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contatctButton));
        contatctButton.click();
        return new MailPage(driver);
    }
    public void fillContactName() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactNameLabel));
        // contactNameLabel.sendKeys(choosenName + " " + choosenSureNames);
    }
    public MailPage contactNameLabel() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactNameLabel));
        contactNameLabel.click();
        return new MailPage(driver);
    }
    public MailPage fillEmailWindow(String chosenName, String sureName, int randomNumber, String eMail) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(emailWindow));
        emailWindow.sendKeys(chosenName + sureName + randomNumber + "@" + eMail);
        return new MailPage(driver);
    }
}





