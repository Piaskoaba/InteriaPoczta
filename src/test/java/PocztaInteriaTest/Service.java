package PocztaInteriaTest;

import PocztaInteriaPages.MailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "/html/body/div[11]/div[2]/button[3]")
    WebElement clickInteriaCookieButton;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/span[3]/div[1]")
    WebElement contactOptions;

    @FindBy(xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div/div[2]/div[1]/div[4]/span[3]/div[2]/div/div/ul/li[4]")
    WebElement deleteContact;

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

    public ArrayList<String> eMailsDomenList() {
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
        return eMailDomensList;
    }

    public String getRandomValue(ArrayList<String> list) {
        int randomIndex = random.nextInt(list.size());
        String randomValue = list.get(randomIndex);
        return randomValue;
    }

    public String replacePolishLetters(String nonPolishLetters) {
        return nonPolishLetters.replace
                        ("Ą", "A")
                .replace("ą", "a")
                .replace("Ć", "C")
                .replace("Ę", "E")
                .replace("ę", "e")
                .replace("Ł", "L")
                .replace("ł", "l")
                .replace("Ń", "N")
                .replace("ń", "n")
                .replace("Ś", "s")
                .replace("ś", "s")
                .replace("Ó", "O")
                .replace("ó", "o")
                .replace("Ż", "Z")
                .replace("ż", "z")
                .replace("Ź", "z")
                .replace("ź", "z");
    }

    public String createEmailAddress(String name, String sureName, int number, String mailDomen) {
        String email = name + sureName + number + mailDomen;
        return replacePolishLetters(email).toLowerCase();
    }

    public void xpathForElementToDelete(String xpathForElement) {
        WebElement xpathElementDelete = driver.findElement(By.xpath("//ul[@class='contact__list']//div[contains(text(),'" + xpathForElement + "')]/../..//span"));
        xpathElementDelete.click();
    }

    public void contactOptionsClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(contactOptions));
        contactOptions.click();
    }

    public void deleteContactClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(deleteContact));
        deleteContact.click();
    }
}






//ToDo osobne listy dla nazwisk, maili (numery ok) + metoda zwracajaca wielkosc listy z argumentem
//ToDo w argumencie przekazac liste, wziac wielkosc  listy i wylosowac randomowy numer, na podstawie wylosowanego numeru wybrac wartosc










