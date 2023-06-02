package PocztaInteriaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewMessagePage extends BasePage {
    public NewMessagePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='composition-to']//input[@ng-model='inputEmail']")
    WebElement newRecipientField;

    public void fillNewRecipientField(String newRecipient){
        webDriverWait.until(ExpectedConditions.visibilityOf(newRecipientField));
        newRecipientField.clear();
        newRecipientField.sendKeys(newRecipient);
        }
    }








