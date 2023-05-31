package PocztaInteriaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SqlQueries {

        WebDriver driver;
        WebDriverWait webDriverWait;

        private static final int TIMEOUT = 10;

        public SqlQueries (WebDriver driver) {
            this.driver = driver;
            webDriverWait = new WebDriverWait(driver, TIMEOUT);

        }
        public String getFemaleFirstName() {
            return "SELECT name FROM female_first_name ORDER BY RANDOM();";
        }
    }

