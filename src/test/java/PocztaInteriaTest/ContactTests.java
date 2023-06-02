package PocztaInteriaTest;

import PocztaInteriaPages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
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
    SqlQueries sqlQueries;
    NewMessagePage newMessagePage;

    @BeforeMethod(alwaysRun = true)
    public void runBrowser() {
        driver = new ChromeDriver();
        service = new Service(driver);
        System.setProperty(service.chromeDriverUrl(), service.getDriver());
        driver.get(service.urlStringInteria());
        driver.manage().window().maximize();
    }

    @Test(priority = 1, groups = {"all", "critical"})
    public void addContact() {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = service.getCredentialValue("eMailLogin");
        String myPassword = service.getCredentialValue("eMailPassword");
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(myPassword);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        mailPage.contactBookButtonClick();
        addNewContactPage = mailPage.contactButtonClick();
        String name = service.getRandomValue(service.namesList());
        String sureName = service.getRandomValue(service.sureNamesList());
        String email = service.createEmailAddress(name, sureName, service.randomNumber(), service.randomValueFromDomainList());
        addNewContactPage.fillContactNameWindow(name, sureName);
        addNewContactPage.fillContactMailWindow(email);
        addNewContactPage.saveContactButtonClick();
        Assert.assertTrue(addNewContactPage.isContactCorrectlyAddedAlert(), "Contact not added");
    }

    @Test(priority = 2, groups = {"all", "high"})
    public void deleteContact() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible(), "Button is not visible");
        loginPage = homePage.clickMailButton();
        String myLogin = service.getCredentialValue("eMailLogin");
        String myPassword = service.getCredentialValue("eMailPassword");
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(myPassword);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        mailPage.contactBookButtonClick();
        addNewContactPage = mailPage.contactButtonClick();
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
        Assert.assertTrue(contactDetailsPage.isContactCorrectlyDeletedAllert(), "Contact is not deleted");
    }

    @Test(priority = 3, groups = {"all", "low"})
    public void editContact() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = service.getCredentialValue("eMailLogin");
        String myPassword = service.getCredentialValue("eMailPassword");
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(myPassword);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        mailPage.contactBookButtonClick();
        addNewContactPage = mailPage.contactButtonClick();
        String name = service.getRandomValue(service.namesList());
        String sureName = service.getRandomValue(service.sureNamesList());
        String email = service.createEmailAddress(name, sureName, service.randomNumber(), service.getRandomValue(service.eMailsDomenList()));
        addNewContactPage.fillContactNameWindow(name, sureName);
        addNewContactPage.fillContactMailWindow(email);
        mailPage = addNewContactPage.saveContactButtonClick();
        Assert.assertTrue(mailPage.isContactCorrectlyAddedAlert(), "Contact is not added");
        contactDetailsPage = mailPage.contactByMailAddressClick(email);
        editContactPage = contactDetailsPage.editContactButtonClick();
        String cellPhoneNumber = service.cellPhoneNumber();
        editContactPage.fillContactPhoneNumberWindow(cellPhoneNumber);
        mailPage = editContactPage.saveEditedContactButtonClick();
        Assert.assertFalse(mailPage.isEditedContactCorrectlySaved(), "Edited contact correctly saved");
        contactDetailsPage = mailPage.contactByMailAddressClick(email);
        Assert.assertEquals(contactDetailsPage.getPhoneNumberFromContactDetailsWindow(), cellPhoneNumber);
    }

    @Test(priority = 1, groups = {"all", "critical"})
    public void addContactbySqlDataBase() {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();

        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = service.getCredentialValue("eMailLogin");
        String myPassword = service.getCredentialValue("eMailPassword");
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(myPassword);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        mailPage.contactBookButtonClick();
        addNewContactPage = mailPage.contactButtonClick();
        String name = sqlQueries.getMaleFirstName();
        String sureName = service.getRandomValue(service.sureNamesList());
        String email = service.createEmailAddress(sqlQueries.getMaleFirstName(), sureName, service.randomNumber(), service.randomValueFromDomainList());
        addNewContactPage.fillContactNameWindow(name, sureName);
        addNewContactPage.fillContactMailWindow(email);
        addNewContactPage.saveContactButtonClick();
        Assert.assertTrue(addNewContactPage.isContactCorrectlyAddedAlert(), "Contact not added");
    }

    @Test(priority = 3, groups = {"all", "critical"})
    public void sendMessage() {
        homePage = new HomePage(driver);
        homePage.cookieButtonClick();
        Assert.assertTrue(homePage.isMailButtonVisible());
        loginPage = homePage.clickMailButton();
        String myLogin = service.getCredentialValue("eMailLogin");
        String myPassword = service.getCredentialValue("eMailPassword");
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(myPassword);
        mailPage = loginPage.clickLogInButton();
        Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
        Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
        Assert.assertTrue(mailPage.isNewMessageButtonClickable(), "Write new message button is not visible");
        newMessagePage = mailPage.writeNewMessageButtonClick();
        String recipientName = service.minimizeString(service.pocztaInteriaDatabase(sqlQueries.getMaleFirstName()));
        String recipientSureName = service.minimizeString(service.pocztaInteriaDatabase(sqlQueries.getMaleSureName()));
        newMessagePage.fillNewRecipientField(recipientName + recipientSureName);

    }

    @Test
    public void addNewContactsqlBase() {
        try {
            service = new Service(driver);
            sqlQueries = new SqlQueries(driver);
            homePage = new HomePage(driver);
            homePage.cookieButtonClick();

            Assert.assertTrue(homePage.isMailButtonVisible());
            loginPage = homePage.clickMailButton();
            String myLogin = service.getCredentialValue("eMailLogin");
            String myPassword = service.getCredentialValue("eMailPassword");
            loginPage.fillLoginWindow(myLogin);
            loginPage.fillPasswordWindow(myPassword);
            mailPage = loginPage.clickLogInButton();
            Assert.assertTrue(mailPage.isAvatarVisible(), "Avatar is not  visible");
            Assert.assertTrue(mailPage.IsMailIconVisible(), "Icon is not visible");
            mailPage.contactBookButtonClick();
            addNewContactPage = mailPage.contactButtonClick();
            String name = service.minimizeString(service.pocztaInteriaDatabase(sqlQueries.getFemaleFirstName()));
            String sureName = service.getRandomValue(service.sureNamesList());
            addNewContactPage.fillContactNameWindow(name, sureName);
            String email = service.minimizeMailString(name + sureName + service.randomNumber() + service.randomValueFromDomainList());
            addNewContactPage.fillContactMailWindow(email);
            addNewContactPage.saveContactButtonClick();
            Assert.assertTrue(addNewContactPage.isContactCorrectlyAddedAlert());



        } catch (Exception exception) {
            System.out.println("Error occurred");
            throw exception;
        }
    }

     @AfterTest(alwaysRun = true)
     public void afterTest() {
         driver.quit();
     }

     @AfterMethod(alwaysRun = true)
     public void afterMethod() {
         driver.close();
     }
}
