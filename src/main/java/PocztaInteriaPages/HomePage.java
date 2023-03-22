package PocztaInteriaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/header/nav/ul/li[1]/a")
    WebElement mailButton;

    public LoginPage clickMailButton() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(mailButton));
        mailButton.click();

        return new LoginPage(driver);
    }


}
