package PocztaInteriaTest;

import PocztaInteriaPages.HomePage;
import PocztaInteriaPages.LoginPage;
import PocztaInteriaPages.MailPage;
import PocztaInteriaPages.NewMessage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Scanner;

public class TestJava {
    LoginPage loginPage;
    HomePage homePage;
    Service service;
    WebDriver driver;
    MailPage mailPage;

    NewMessage newMessage;

    @BeforeMethod(alwaysRun = true)
    public void runBrowser() {
        driver = new ChromeDriver();
        service = new Service(driver);
        System.setProperty(service.chromeDriverUrl(), service.getDriver());
        driver.get(service.urlStringInteria());
        driver.manage().window().maximize();
    }


    @Test
    public void demoTest() {
        homePage = new HomePage(driver);
        homePage.loginPageCookieButton();
        loginPage = homePage.clickMailButton();
        loginPage.fillLoginWindow("adam.testowyy@interia.pl");
        loginPage.fillPasswordWindow("PocztaInteria123!");
        mailPage = loginPage.clickLogInButton();
        newMessage.clickNewMessegeButton();





        // String myLogin = "adam.testowyy@interia.pl";
        //String MyPassword = "PocztaInteria123!";

    }


}
//@AfterClass


