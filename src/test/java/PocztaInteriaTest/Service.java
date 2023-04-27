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
import java.lang.reflect.Array;
import java.util.Random;


public class Service {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public Service(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    Random randomNumberGen = new Random();

    @FindBy(xpath = "/html/body/div[11]/div[2]/button[3]")
    WebElement clickInteriaCookieButton;

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

    public String getDriver() {
        return "C:/Program Files/DRIVERS/chromedriver.exe";
    }

    String[] names = {"Anna", "Bogumiła", "Aneta", "Maria", "Kazimiera", "Justyna", "Marlena", "Sylwia", "Aleksandra", "Marianna", "Eugenia"};
    String[] sureNames = {"Kowalska", "Michalska", "Janiak", "Kozioł", "Balcerzak", "Nowak", "Pisarek", "Janicka", "Woźniak", "Bojarska", "Kulesza"};

    public void randomNumbersGenerator() {
        int min = 0;
        int max = 999999;
        int RandomNumGenerator = randomNumberGen.nextInt(max - min+1)+min;


    }
}




