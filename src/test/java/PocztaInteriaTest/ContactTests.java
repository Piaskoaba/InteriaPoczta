package PocztaInteriaTest;

import PocztaInteriaPages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTests {
    LoginPage loginPage;
    HomePage homePage;
    Service service;
    WebDriver driver;
    MailPage mailPage;
    AddNewContactPage addNewContactPage;
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
    public void addContactTest() {
        homePage = new HomePage(driver);
        homePage.loginPageCookieButton();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow("PocztaInteria123!");
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        addNewContactPage = mailPage.clickContactBookButton();
        addNewContactPage.contatctButton();
        String name = service.getRandomValue(service.namesList());
        String sureName = service.getRandomValue(service.sureNamesList());
        String email = service.createEmailAddress(name, sureName, service.randomNumber(1, 9999), service.getRandomValue(service.eMailsDomenList()));
        addNewContactPage.fillContactNameWindow(name, sureName);
        addNewContactPage.fillContactMailWindow(email);
        addNewContactPage.saveContactButtonClick();
        Assert.assertTrue(addNewContactPage.isContactCorectlyAddedAllert(), "Contact is not added");  // do dodania po zapisanym kontakcie
    }

//ToDo  test na usuniecie kontaktu
//ToDo na edyecje konaktu


    @Test
    public void deleteContactTest() {
        homePage = new HomePage(driver);
        homePage.loginPageCookieButton();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow("PocztaInteria123!");
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        addNewContactPage = mailPage.clickContactBookButton();
        addNewContactPage.contatctButton();
        String name = service.getRandomValue(service.namesList());
        String sureName = service.getRandomValue(service.sureNamesList());
        String email = service.createEmailAddress(name, sureName, service.randomNumber(1, 9999), service.getRandomValue(service.eMailsDomenList()));
        addNewContactPage.fillContactNameWindow(name, sureName);
        addNewContactPage.fillContactMailWindow(email);
        addNewContactPage.saveContactButtonClick();
        Assert.assertTrue(addNewContactPage.isContactCorectlyAddedAllert(), "Contact is not added");
        service.xpathForElementToEditOrDelete(email);
        service.contactOptionsClick();
        service.deleteContactClick();

    }

    @Test
    public void editContactTest() {
        homePage = new HomePage(driver);
        homePage.loginPageCookieButton();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow("PocztaInteria123!");
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        addNewContactPage = mailPage.clickContactBookButton();
        addNewContactPage.contatctButton();
        String name = service.getRandomValue(service.namesList());
        String sureName = service.getRandomValue(service.sureNamesList());
        String email = service.createEmailAddress(name, sureName, service.randomNumber(1, 9999), service.getRandomValue(service.eMailsDomenList()));
        addNewContactPage.fillContactNameWindow(name, sureName);
        addNewContactPage.fillContactMailWindow(email);
        addNewContactPage.saveContactButtonClick();
        Assert.assertTrue(addNewContactPage.isContactCorectlyAddedAllert(), "Contact is not added");
        service.xpathForElementToEditOrDelete(email);
        addNewContactPage = service.editContactClick();
        addNewContactPage.fillContactPhoneNumberWindow(service.cellPhoneNumber(service.randomNumber(600, 895)) + service.randomNumber(100, 999) + service.randomNumber(100, 999));
        addNewContactPage.saveEditedContactButtonClick();


    }
}
