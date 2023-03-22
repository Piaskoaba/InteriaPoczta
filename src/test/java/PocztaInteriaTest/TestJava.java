package PocztaInteriaTest;

import PocztaInteriaPages.BasePage;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.Scanner;

public class TestJava {

@BeforeMethod

    @Test
    public void demoTest() {


        WebDriver driver = new ChromeDriver();

        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("http://interia.pl");            //wejdz na strone interia.pl

        WebElement cookieButton = driver.findElement(By.cssSelector("body > div.rodo-popup > div.rodo-popup-buttons > button.rodo-popup-agree")); //lokalizacja przycisku rodo/cookies
        cookieButton.click();       //click




       // String myLogin = "adam.testowyy@interia.pl";
        //String MyPassword = "PocztaInteria123!";


        // driver.quit();



    }

@AfterMethod
@AfterClass
}

