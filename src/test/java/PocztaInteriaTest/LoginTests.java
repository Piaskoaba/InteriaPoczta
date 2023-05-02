package PocztaInteriaTest;

import PocztaInteriaPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void demoTest() {
        homePage = new HomePage(driver);
        homePage.loginPageCookieButton();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        loginPage.fillLoginWindow(myLogin);
        //String getLoginInput = loginPage.getLoginInput();
        //Assert.assertEquals(myLogin,getLoginInput);
        loginPage.fillPasswordWindow("PocztaInteria123!");
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        newMessagePage = mailPage.clickNewMessegeButton();
        newMessagePage.fillReciver("@gmail.com");
        newMessagePage.fillMailSubject("Random mail subject");
        newMessagePage.clickSendMessageButton();
    }

    //ToDo poprawne zalogowanie is visible ikona maila, avatar


    // ToDo nieporpawny login/hasło sprawdzenie komunikatu


    //ToDo brak loginu i hasla, sprawdzenie na czerwono czy wyswietla
}
