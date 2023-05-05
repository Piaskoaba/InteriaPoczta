package PocztaInteriaPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewContactPage extends BasePage {
    public AddNewContactPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement contactNameLabel;
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailWindow;
    @FindBy(xpath = "/html/body/div[2]/section[4]/div/div[2]/div[1]/div/span[1]")
    WebElement contactButton;
    @FindBy(xpath = "//*[@id=\"wrapper\"]//form/div/div[5]/button[1]")
    WebElement saveContactButton;
    public MailPage contactButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactButton));
        contactButton.click();
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

    public MailPage saveContactButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveContactButton));
        saveContactButton.click();
        return new MailPage(driver);
    }



}











