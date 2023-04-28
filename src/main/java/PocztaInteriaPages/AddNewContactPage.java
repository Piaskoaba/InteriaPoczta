package PocztaInteriaPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    String[] names = {"Anna", "Bogumiła", "Aneta", "Maria", "Kazimiera", "Justyna", "Marlena", "Sylwia", "Aleksandra", "Marianna", "Eugenia"};
    String[] sureNames = {"Kowalska", "Michalska", "Janiak", "Kozioł", "Balcerzak", "Nowak", "Pisarek", "Janicka", "Woźniak", "Bojarska", "Kulesza"};

    String[] emailAddress = {"gmail.com", "interia.pl", "interia.eu", "onet.pl", "me.eu", "wp.pl", "wp.eu", "poczta.net", "gmail.com"};

    int pickNames = (int) (Math.random() * names.length);
    String choosenName = names[pickNames];
    int pickSureNames = (int) (Math.random() * sureNames.length);
    String choosenSureNames = sureNames[pickSureNames];
    int pickMail = (int) (Math.random() * emailAddress.length);
    String choosenEmail = emailAddress[pickMail];

    public void fillContactName() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactNameLabel));
        contactNameLabel.sendKeys(choosenName + " " + choosenSureNames);
    }

    public MailPage contactNameLabel() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactNameLabel));
        contactNameLabel.click();
        return new MailPage(driver);
    }

    public int RandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }


    public MailPage fillEmailWindow() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(emailWindow));
        emailWindow.sendKeys(choosenName + choosenSureNames + RandomNumber(999,9999)+"@" + choosenEmail );
        return new MailPage(driver);
    }
}





