package PocztaInteriaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewMessagePage extends BasePage {


    public NewMessagePage(WebDriver driver) {
        super(driver);
    }

   // String reciver = "bartosz.piaskowskii@gmail.com";

    @FindBy(id = "tinymce")
    WebElement textWindow;

    @FindBy(xpath = "//*[@id='wrapper']/div[contains(@class, 'dialog-list--shown')]/div/div/div/div/div[2]/div/div[contains(@class, 'composition__wrapper')]/div[contains(@class, 'email-input-plain-group')]/div[contains(@class, 'composition-to')]/div/input\n")
    WebElement reciverWindow;

    @FindBy(id = "subject")
    WebElement mailSubject;

    @FindBy(xpath =  "//*[@id='wrapper']//div[@class='dialog-list dialog-list--shown']/div/div/div/div/div[2]/div/div[@class='composition__wrapper']/div[@class='composition__basic-actions mail-confirm-allowed']/button")
    WebElement sendMessage;
    public void fillReciver(String deliveryAddress){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(reciverWindow));
        reciverWindow.sendKeys(deliveryAddress);
    }

    public void fillMailSubject(String writeSubject){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mailSubject));
        mailSubject.sendKeys(writeSubject);

    }

    public void clickSendMessageButton (){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendMessage));
        sendMessage.click();
    }

}
