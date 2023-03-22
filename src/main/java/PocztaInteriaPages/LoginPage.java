package PocztaInteriaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    WebElement logWindow;
    WebElement passWindow;

    WebElement logIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginWindow() {
        driver.findElement(By.cssSelector("[title='Poczta'"));
        logWindow.click();
        String name = "adam.testowy@interia.pl";
        logWindow.sendKeys(name);


    }
    public void passwordWindow(){

        driver.findElement(By.id("email"));
        passWindow.click();
        String password = "PocztaInteria123!";
        passWindow.sendKeys(password);
    }

    public void logInButton(){

        driver.findElement(By.xpath("//*[@id='sitebar']/form/button"));
        logIn.click();
    }




}
