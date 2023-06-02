package PocztaInteriaPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewContactPage extends BasePage {
    public AddNewContactPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='name']")
    WebElement contactNameLabel;

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailWindow;

    @FindBy(xpath = "//div[@class='dialog__buttons-container']/button[@type='submit']")
    WebElement saveContactButton;

    @FindBy(xpath = "//div[@class='notification-container']")
    WebElement contactCorrectlyAdded;


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

    public boolean isContactCorrectlyAddedAlert() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(contactCorrectlyAdded)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}











