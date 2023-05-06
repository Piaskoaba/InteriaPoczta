package PocztaInteriaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

    public String chromeDriverUrl() {
        return "webdriver.chrome.driver";
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

    public int randomNumber() {
        return random.nextInt(9999 - 1000 + 1) + 1000;
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

    public String cellPhoneNumber() {
        String contactNumber = String.valueOf(randomNumber(600, 895)) + String.valueOf(randomNumber(100, 999)) + String.valueOf(randomNumber(100, 999));
        System.out.println(contactNumber);
        return contactNumber;
    }
}











