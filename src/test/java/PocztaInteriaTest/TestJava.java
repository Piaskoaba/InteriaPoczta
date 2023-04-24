package PocztaInteriaTest;

import PocztaInteriaPages.HomePage;
import PocztaInteriaPages.LoginPage;
import PocztaInteriaPages.MailPage;
import PocztaInteriaPages.NewMessagePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestJava {
    LoginPage loginPage;
    HomePage homePage;
    Service service;
    WebDriver driver;
    MailPage mailPage;

    NewMessagePage newMessagePage;

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
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        loginPage.fillLoginWindow("adam.testowyy@interia.pl");
        loginPage.fillPasswordWindow("PocztaInteria123!");
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible());
        Assert.assertTrue(mailPage.IsMailIconVisible());
        newMessagePage = mailPage.clickNewMessegeButton();
        newMessagePage.fillReciver("@gmail.com");
        newMessagePage.fillMailSubject("Random mail subject");
        newMessagePage.clickSendMessageButton();
        // String myLogin = "adam.testowyy@interia.pl";
        //String MyPassword = "PocztaInteria123!";

    }


}
//@AfterClass


