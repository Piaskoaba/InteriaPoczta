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

    @Test(priority = 1, groups = {"all","critical"})
    public void correctLogin () throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        String password = "";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(password);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");

    }
    @Test(priority = 2, groups = {"all","low"})
    public void wrongPassword() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        String wrongPassword = "xyzpass";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(wrongPassword);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(loginPage.isEmailTextUnderLoginWindowVisible(),"Text under login window is not visible");
        Assert.assertFalse(mailPage.isAvatarVisible(),"Avatar is not Visible");

    }

    @Test(priority = 3, groups = {"all","high"})
    public void wrongLoginOrPassword() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible(),"Mail button is not visible");
        loginPage = homePage.clickMailButton();
        String wrongLogin = "adamteestowyy@interia.pl";
        String password = "";
        loginPage.fillLoginWindow(wrongLogin);
        loginPage.fillPasswordWindow(password);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(loginPage.isIncorrectLoginOrPasswordVisible(),"Password or login is not correct");
        Assert.assertTrue(loginPage.isEmailTextUnderLoginWindowVisible(),"Text under login window is not visible");
        Assert.assertTrue(loginPage.isLoginButtonVisible(),"Login button is not visible");
        Assert.assertFalse(mailPage.isAvatarVisible(),"Avatar is not Visible");
        String login = "adam.testowyy@interia.pl";
        String wrongPassword = "xyzpass";

        loginPage.fillLoginWindow(login);
        loginPage.fillPasswordWindow(wrongPassword);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(loginPage.isIncorrectLoginOrPasswordVisible(),"Password or login is not correct");
        Assert.assertTrue(loginPage.isEmailTextUnderLoginWindowVisible(),"Email is visble");
        Assert.assertFalse(mailPage.isAvatarVisible(),"Avatar is visible");
    }

    @Test(priority = 4, groups = {"all","low"})
    public void emptyWindowsLogin() {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(loginPage.isEmailTextUnderLoginWindowVisible(),"Text under login window is not visible");
        Assert.assertFalse(mailPage.isAvatarVisible(),"Avatar is Visible");
        Assert.assertTrue(loginPage.isLoginButtonVisible(),"Login button is not visible");
        Assert.assertEquals(loginPage.getTextFromLoginWindow(),"");
        Assert.assertEquals(loginPage.getTextFromPasswordWindow(),"");
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
