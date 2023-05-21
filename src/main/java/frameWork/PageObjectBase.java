package frameWork;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonMethods;

import java.time.Duration;
import java.util.List;

public class PageObjectBase extends CommonMethods {

    /**
     * Passing Webdriver object so that each class
     * can access the current browser instance
     * @param driver
     */
    public PageObjectBase(WebDriver driver) {
       super(driver);
        PageFactory.initElements(driver, this);
    }

    public String generateRandomString(int numb){
        return RandomStringUtils.randomAlphabetic(numb);
    }


}
