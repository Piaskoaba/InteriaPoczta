package PocztaInteriaTest;


import PocztaInteriaPages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
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
    @Test
    public void loginIncognitoMode() {
        homePage = new HomePage(driver);
        homePage.incognitoCookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow("PocztaInteria123!");
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
    }
}

