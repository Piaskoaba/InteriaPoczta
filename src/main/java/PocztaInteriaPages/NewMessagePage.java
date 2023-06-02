package PocztaInteriaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewMessagePage extends BasePage {
    public NewMessagePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div/div/div/div/div[2]/div/div[2]/div[3]/div[3]/div/input")
    WebElement newRecipientField;

    public void fillNewRecipientField(String newRecipient){
        webDriverWait.until(ExpectedConditions.visibilityOf(newRecipientField));
        newRecipientField.clear();
        newRecipientField.sendKeys(newRecipient);
        }
    }








