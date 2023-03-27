package PocztaInteriaTest;

import PocztaInteriaPages.BasePage;
import PocztaInteriaPages.HomePage;
import PocztaInteriaPages.LoginPage;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.Scanner;

public class TestJava {

    Service service;
    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void runBrowser() {
        driver = new ChromeDriver();
        service = new Service(driver);
        System.setProperty(service.chromeDriverUrl(),service.getDriver());
        driver.get(service.urlStringInteria());
        driver.manage().window().maximize();
        }


    @Test
    public void demoTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMailButton();



        // String myLogin = "adam.testowyy@interia.pl";
        //String MyPassword = "PocztaInteria123!";

    }


}
//@AfterClass


