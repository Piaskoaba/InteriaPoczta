package PocztaInteriaTest;

import PocztaInteriaPages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Service extends BasePage {


    public Service (WebDriver driver) {
        super(driver);
    }

//2 metody
   // 1 odpala przegladarke
    // 2 zwraca string z url
    //3 ewentualne cookies zamkniecie  public boolean isVisibleCookies

    public void startBrowser(String startUrlBrowser){
    }


}
