package PocztaInteriaTest;


import PocztaInteriaPages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginIncognitoModeTests {
    LoginPage loginPage;
    HomePage homePage;
    Service service;
    WebDriver driver;
    MailPage mailPage;

    @BeforeMethod(alwaysRun = true)
    public void runBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        driver = new ChromeDriver(options);
        service = new Service(driver);
        System.setProperty(service.chromeDriverUrl(), service.getDriver());
        driver.get(service.urlStringInteria());
        driver.manage().window().maximize();
    }

    @Test(priority = 1, groups = {"all","critical"})
    public void loginIncognitoMode() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.incognitoCookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible(), "Button ins not visible");
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow("");
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
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

