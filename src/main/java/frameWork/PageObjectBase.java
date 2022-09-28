package frameWork;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageObjectBase {
    protected WebDriver driver;

    public PageObjectBase(WebDriver driver) {
        this.driver = driver;
    }

    public String generateRandomString(int numb){
        return RandomStringUtils.randomAlphabetic(numb);
    }

    //Selecting elements from dropdown. Pass element variable and String text
    public void selectOptionFromSortLit(By options, String text) {
//        List<WebElement> allOptions = driver.findElements(options);
//        for(WebElement option : allOptions){
//            if(option.getText().equals(text)) {
//                System.out.println(option.getText());
//                option.click();
//                break;
//            }
//        }
        //Other way to select dropdown
        WebElement dropDown = driver.findElement(options);
        Select dropDownOption = new Select(dropDown); //object creation
        dropDownOption.selectByValue(text);
    }

    public void selectOptionFromSortLitUsingFindBy(WebElement options, String text) {
        //Other way to select dropdown
        WebElement dropDown = options;
        Select dropDownOption = new Select(dropDown); //object creation
        dropDownOption.selectByValue(text);
    }

    public void waitForVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
