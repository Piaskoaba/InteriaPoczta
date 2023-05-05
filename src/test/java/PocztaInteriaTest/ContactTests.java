package PocztaInteriaTest;

import PocztaInteriaPages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    ContactDetailsPage contactDetailsPage;
    EditContactPage editContactPage;

    @BeforeMethod(alwaysRun = true)
    public void runBrowser() {
        driver = new ChromeDriver();
        service = new Service(driver);
        System.setProperty(service.chromeDriverUrl(), service.getDriver());
        driver.get(service.urlStringInteria());
        driver.manage().window().maximize();
    }

    @Test
    public void addContact() {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow("PocztaInteria123!");
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        addNewContactPage = mailPage.contactBookButtonClick();
        addNewContactPage.contactButtonClick();
        String name = service.getRandomValue(service.namesList());
        String sureName = service.getRandomValue(service.sureNamesList());
        String email = service.createEmailAddress(name, sureName, service.randomNumber(), service.getRandomValue(service.eMailsDomenList()));
        addNewContactPage.fillContactNameWindow(name, sureName);
        addNewContactPage.fillContactMailWindow(email);
        addNewContactPage.saveContactButtonClick();
        Assert.assertTrue(addNewContactPage.isContactCorrectlyAddedAlert(), "Contact is not added");
    }

    @Test
    public void deleteContact() {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible()); //message
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow("PocztaInteria123!");
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        addNewContactPage = mailPage.contactBookButtonClick();
        addNewContactPage.contactButtonClick();
        String name = service.getRandomValue(service.namesList());
        String sureName = service.getRandomValue(service.sureNamesList());
        String email = service.createEmailAddress(name, sureName, service.randomNumber(), service.getRandomValue(service.eMailsDomenList()));
        addNewContactPage.fillContactNameWindow(name, sureName);
        addNewContactPage.fillContactMailWindow(email);
        mailPage = addNewContactPage.saveContactButtonClick();
        Assert.assertTrue(mailPage.isContactCorrectlyAddedAlert(), "Contact is not added");
        contactDetailsPage = mailPage.contactByMailAddressClick(email);
        contactDetailsPage.contactOptionsButtonClick();
        mailPage = contactDetailsPage.deleteContactButtonClick();
        assert !czy jest usuniety komunikat
        assert boolean po xpath email niewidoczny
    }

    @Test
    public void editContact() {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = "adam.testowyy@interia.pl";
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow("PocztaInteria123!");
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        addNewContactPage = mailPage.contactBookButtonClick();
        addNewContactPage.contactButtonClick();
        String name = service.getRandomValue(service.namesList());
        String sureName = service.getRandomValue(service.sureNamesList());
        String email = service.createEmailAddress(name, sureName, service.randomNumber(), service.getRandomValue(service.eMailsDomenList()));
        addNewContactPage.fillContactNameWindow(name, sureName);
        addNewContactPage.fillContactMailWindow(email);
        mailPage = addNewContactPage.saveContactButtonClick();
        Assert.assertTrue(mailPage.isContactCorrectlyAddedAlert(), "Contact is not added");
        contactDetailsPage = mailPage.contactByMailAddressClick(email);
        editContactPage = contactDetailsPage.editContactButtonClick();
        editContactPage.fillContactPhoneNumberWindow(service.cellPhoneNumber());
        mailPage = editContactPage.saveEditedContactButtonClick();

        !assert widoczny czy sie zapisal


        contactDetailsPage = mailPage.contactByMailAddressClick(email);
        editContactPage = contactDetailsPage.editContactButtonClick();
        get text assert equal //w edit contactpage
    }
}
