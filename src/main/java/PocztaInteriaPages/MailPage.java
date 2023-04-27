package PocztaInteriaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileNotFoundException;

public class MailPage extends BasePage {


    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='wrapper']//section[contains(@class,'section--sidebar')]/div/div[contains(@class,'sidebar__main-panel')]/div[1]/div[2]/div/div")
    WebElement avatar;


    @FindBy(xpath = "//span[@class='navigation__new__text']")
    WebElement messageButton;

    @FindBy(xpath = "//*[@id=\"wrapper\"]//span[@class=\"icon icon-inbox\"]")
    WebElement recivedButton;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/section[4]/div/div[1]/div[2]")
    WebElement contaktBook;

    @FindBy(xpath = "/html/body/div[2]/section[4]/div/div[2]/div[1]/div/span[1]")
    WebElement contatctButton;

    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement contactNameLabel;




    public NewMessagePage clickNewMessegeButton() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(messageButton));
        messageButton.click();

        return new NewMessagePage(driver);

    }

    public boolean isAvatarVisible() {
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOf(avatar)).isDisplayed();

        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }

    public boolean IsMailIconVisible() {

        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(recivedButton)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    public MailPage contatctButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contatctButton));
        contatctButton.click();
        return new MailPage(driver);

    }

    public MailPage contactNameLabel() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactNameLabel));
        contactNameLabel.click();
        return new MailPage(driver);
    }

    public MailPage clickContactBookButton() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(contaktBook));
        contaktBook.click();

        return new MailPage(driver);
    }
    String[] names = {"Anna", "Bogumiła", "Aneta", "Maria", "Kazimiera", "Justyna", "Marlena", "Sylwia", "Aleksandra", "Marianna", "Eugenia"};


    String[] sureNames = {"Kowalska", "Michalska", "Janiak", "Kozioł", "Balcerzak", "Nowak", "Posarek", "Janicka", "Woźniak", "Bojarska", "Kulesza"};


    int pickNames = (int) (Math.random() * names.length);
    String choosenName = names[pickNames];


    int pickSureNames = (int) (Math.random() * sureNames.length);
    String choosenSureNames = sureNames[pickSureNames];


    // String randomSureNames = sureNames[randomNamesAndSureNamesGenerator.nextInt(sureNames.length)];

    public void fillContactName() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactNameLabel));
        contactNameLabel.sendKeys(choosenName + " "+ choosenSureNames);

    }
}

