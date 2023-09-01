package util;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
        private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

        private DriverManager() {
            // Private constructor to prevent direct instantiation
        }

        public static WebDriver getDriver() {
            if (webDriverThreadLocal.get() == null) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--remote-allow-origins=*");
                WebDriver driver = new ChromeDriver(chromeOptions);
                webDriverThreadLocal.set(driver);
            }
            return webDriverThreadLocal.get();
        }

        public static void quitDriver() {
            WebDriver driver = webDriverThreadLocal.get();
            if (driver != null) {
                driver.quit();
                webDriverThreadLocal.remove();
            }
        }

}
