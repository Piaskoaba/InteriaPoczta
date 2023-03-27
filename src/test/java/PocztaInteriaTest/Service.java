package PocztaInteriaTest;

import PocztaInteriaPages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Service {

    WebDriver driver;
    WebDriverWait webDriverWait;

    public Service(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[11]/div[2]/button[3]")
    WebElement clickInteriaCookieButton;


//2 metody
    // 1 odpala przegladarke
    // 2 zwraca string z url
    //3 ewentualne cookies zamkniecie  public boolean isVisibleCookies

    public void startBrowser(String startUrlBrowser) {

        WebDriver driver = new ChromeDriver();  //

        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    public String chromeDriverUrl() {
        return "webdriver.chrome.driver";
    }

    boolean isCookieButtonAbleToClick() {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(clickInteriaCookieButton)).click();
            return true;
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }

    public String urlStringInteria() {
        return "https://www.interia.pl";
    }
public String getDriver(){
    return "C:/Program Files/DRIVERS/chromedriver.exe";

}
}





