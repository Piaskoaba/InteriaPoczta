package PocztaInteriaTest;

import PocztaInteriaPages.MailPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class Service {
    WebDriver driver;
    WebDriverWait webDriverWait;

    Random random = new Random();


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

    public int randomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public ArrayList<String> namesList() {
        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("Anna");
        nameList.add("Bogumiła");
        nameList.add("Maria");
        nameList.add("Bożena");
        nameList.add("Wiesława");
        nameList.add("Katarzyna");
        nameList.add("Bronisława");
        nameList.add("Eugenia");
        nameList.add("Aleksandra");
        nameList.add("Monika");
        return nameList;
    }

    public ArrayList<String> sureNamesList() {
        ArrayList<String> sureNameList = new ArrayList<>();
        sureNameList.add("Antoniak");
        sureNameList.add("Bogucka");
        sureNameList.add("Kazimierczak");
        sureNameList.add("Kowalska");
        sureNameList.add("Andrzejewicz");
        sureNameList.add("Kulesza");
        sureNameList.add("Glapa");
        sureNameList.add("Woźniak");
        sureNameList.add("Balcerzak");
        sureNameList.add("Wierzbińska");
        sureNameList.add("Kulesza");
        sureNameList.add("Kownacka");
        return sureNameList;
    }

    public ArrayList<String> eMailsDomensList() {
        ArrayList<String> eMailDomensList = new ArrayList<>();
        eMailDomensList.add("@gmail.com");
        eMailDomensList.add("@interia.com");
        eMailDomensList.add("@interia.eu");
        eMailDomensList.add("@interia.pl");
        eMailDomensList.add("@wp.pl");
        eMailDomensList.add("@vp.pl");
        eMailDomensList.add("@wp.eu");
        eMailDomensList.add("@me.com");
        eMailDomensList.add("@onet.pl");
        eMailDomensList.add("@onet.eu");
        eMailDomensList.add("@tlen.pl");
        return eMailsDomensList();
    }





    public static String getRandomValue(ArrayList<String> list) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        String randomValue = list.get(randomIndex);
        return randomValue;
    }
    String randomName = getRandomValue(namesList());
    String randomSurename = getRandomValue(sureNamesList());
    String randomMailDomen = getRandomValue(eMailsDomensList());





    public int returnListSize(ArrayList<String> list) {
        return list.size();
    }
    public String returnRandomNameSureNameNumberEmail() {
        return returnRandomNameSureNameNumberEmail();
    }

    public String fillContactNameWindow(){
        return randomName + randomSurename;
    }
    public String fillContactMailWindow(){
        return randomName + randomSurename + randomMailDomen;
    }
}


//ToDo osobne listy dla nazwisk, maili (numery ok) + metoda zwracajaca wielkosc listy z argumentem
//ToDo w argumencie przekazac liste, wziac wielkosc  listy i wylosowac randomowy numer, na podstawie wylosowanego numeru wybrac wartosc










