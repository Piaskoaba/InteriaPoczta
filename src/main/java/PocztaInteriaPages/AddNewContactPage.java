package PocztaInteriaPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.*;

public class AddNewContactPage extends BasePage {
    public AddNewContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement contactNameLabel;
    @FindBy(xpath = "/html/body/div[2]/section[4]/div/div[2]/div[1]/div/span[1]")
    WebElement contatctButton;

    public MailPage contatctButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contatctButton));
        contatctButton.click();
        return new MailPage(driver);
    }

    String[] names = {"Anna", "Bogumiła", "Aneta", "Maria", "Kazimiera", "Justyna", "Marlena", "Sylwia", "Aleksandra", "Marianna", "Eugenia"};
    String[] sureNames = {"Kowalska", "Michalska", "Janiak", "Kozioł", "Balcerzak", "Nowak", "Pisarek", "Janicka", "Woźniak", "Bojarska", "Kulesza"};

    int pickNames = (int) (Math.random() * names.length);
    String choosenName = names[pickNames];
    int pickSureNames = (int) (Math.random() * sureNames.length);
    String choosenSureNames = sureNames[pickSureNames];

    public void fillContactName() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactNameLabel));
        contactNameLabel.sendKeys(choosenName + " " + choosenSureNames);
    }
    public MailPage contactNameLabel() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactNameLabel));
        contactNameLabel.click();
        return new MailPage(driver);
    }
}





