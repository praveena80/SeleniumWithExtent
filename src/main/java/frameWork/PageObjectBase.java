package frameWork;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class PageObjectBase {
    protected WebDriver driver;

    public PageObjectBase(WebDriver driver) {
        this.driver = driver;
    }

    public String generateRandomString(int numb){
        return RandomStringUtils.randomAlphabetic(numb);
    }
}
