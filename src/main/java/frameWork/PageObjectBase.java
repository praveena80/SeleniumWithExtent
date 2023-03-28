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
    protected WebDriver driver;
    public WebDriverWait wait;

    public PageObjectBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String generateRandomString(int numb){
        return RandomStringUtils.randomAlphabetic(numb);
    }


}
