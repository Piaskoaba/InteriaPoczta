package PocztaInteriaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver){
        super(driver);
    }


    WebElement mailButton;

    public void clickMailButton(){
        driver.findElement(By.cssSelector("[title='Poczta'"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mailButton));
        mailButton.click();


    }




}
