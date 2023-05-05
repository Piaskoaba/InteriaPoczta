package PocztaInteriaTest;

import PocztaInteriaPages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {


    LoginPage loginPage;
    HomePage homePage;
    WebDriver driver;
    MailPage mailPage;
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
    public void correctLogin () {

        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        String password = "PocztaInteria123!";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(password);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");

    }
    @Test
    public void wrongPassword() {

        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        String wrongPassword = "xyzpass";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(wrongPassword);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(loginPage.isEmailTextUnderLoginWindowVisible());
        Assert.assertFalse(mailPage.isAvatarVisible());
    }
    @Test
    public void wrongLoginOrPassword() {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String wrongLogin = "adamteestowyy@interia.pl";
        String password = "PocztaInteria123!";
        loginPage.fillLoginWindow(wrongLogin);
        loginPage.fillPasswordWindow(password);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(loginPage.isIncorrectLoginOrPasswordVisible());
        Assert.assertTrue(loginPage.isEmailTextUnderLoginWindowVisible());
        Assert.assertTrue(loginPage.isLoginButtonVisible());
        Assert.assertFalse(mailPage.isAvatarVisible());
        String login = "adam.testowyy@interia.pl";
        String wrongPassword = "xyzpass";
        loginPage.fillLoginWindow(login);
        loginPage.fillPasswordWindow(wrongPassword);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(loginPage.isIncorrectLoginOrPasswordVisible());
        Assert.assertFalse(loginPage.isEmailTextUnderLoginWindowVisible(),"Email is visble");
        Assert.assertFalse(mailPage.isAvatarVisible(),"Avatar is visible");
    }
    @Test
    public void emptyWindowsLogin() {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(loginPage.isEmailTextUnderLoginWindowVisible());
        Assert.assertFalse(mailPage.isAvatarVisible());
        Assert.assertTrue(loginPage.isLoginButtonVisible());
        Assert.assertEquals(loginPage.getTextFromLoginWindow(),"");
              to smao do textu  assert equals do gettext

    }
    @AfterTest(alwaysRun = true)
    public void afterTest(){
        driver.quit();
    }
    @AfterMethod(alwaysRun = true)
        public void afterMethod(){
            driver.close();
        }
    }
