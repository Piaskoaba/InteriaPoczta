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
        public String getMaleFirstName() {
            return "SELECT malenames FROM malenames ORDER BY RANDOM() FETCH FIRST ROWS ONLY;";
        }
    }

