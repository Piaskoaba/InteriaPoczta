package PocztaInteriaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewMessage extends BasePage {



    public NewMessage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[@class='navigation__new__text']")
    WebElement messageButton;


    public void clickNewMessegeButton(){


        webDriverWait.until(ExpectedConditions.elementToBeClickable(messageButton));
        messageButton.click();


    }
}
