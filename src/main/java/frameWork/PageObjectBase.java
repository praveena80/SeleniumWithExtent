package frameWork;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonMethods;

import java.time.Duration;
import java.util.List;

public class PageObjectBase extends CommonMethods {
//    protected static WebDriver driver;
    public WebDriverWait wait;

    /**
     * Passing Webdriver object so that each class
     * can access the current browser instance
     * @param driver
     */
    public PageObjectBase(WebDriver driver) {
       super(driver);
//       this.driver = driver;
    }

    /**
     * Defines a WebDriver object, instantiates it, and then sets it in this page.
     * Subsequent page classes then inherit from this page, thus automatically having access to the driver.
//     * @param driver
     */
//    public void setWebDriver(WebDriver driver){
//        PageObjectBase.driver = driver;
//    }

    public String generateRandomString(int numb){
        return RandomStringUtils.randomAlphabetic(numb);
    }


}
