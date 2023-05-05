package PocztaInteriaTest;

import PocztaInteriaPages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {


    LoginPage loginPage;
    HomePage homePage;
    WebDriver driver;
    MailPage mailPage;
    NewMessagePage newMessagePage;
    Service service;

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
        String myLogin = "adam.testowyy@interia.pl";
        String password = "PocztaInteria123!";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(password);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        newMessagePage = mailPage.clickNewMessegeButton();
        newMessagePage.fillReciver("@gmail.com");
        newMessagePage.fillMailSubject("Random mail subject");
        newMessagePage.clickSendMessageButton();
    }
// ToDo nieporpawny login/hasło sprawdzenie komunikatu

//ToDo brak loginu i hasla, sprawdzenie na czerwono czy wyswietla


    @Test
    public void wrongPasswordTest() {

        homePage = new HomePage(driver);
        homePage.loginPageCookieButton();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        String wrongPassword = "xyzpass";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillWrongPasswordWindow(wrongPassword);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(loginPage.passwordIsNotCorrect());
        Assert.assertTrue(loginPage.isEmailTextVisible());
        Assert.assertFalse(mailPage.isAvatarVisible());

    }

    @Test
    public void wrongLoginTest() {

        homePage = new HomePage(driver);
        homePage.loginPageCookieButton();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myWrongLogin = "adamteestowyy@interia.pl";
        String myPassword = "PocztaInteria123!";
        loginPage.fillLoginWindow(myWrongLogin);
        loginPage.fillPasswordWindow(myPassword);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(loginPage.loginIsNotCorrect());
        Assert.assertTrue(loginPage.isEmailTextVisible());
        Assert.assertFalse(mailPage.isAvatarVisible());
        Assert.assertTrue(loginPage.isLoginButtonVisible());
    }

    @Test
    public void emptyWindowsLoginTest() {

        homePage = new HomePage(driver);
        homePage.loginPageCookieButton();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(loginPage.isEmailTextVisible());
        Assert.assertFalse(mailPage.isAvatarVisible());
        Assert.assertTrue(loginPage.isLoginButtonVisible());

    }
}