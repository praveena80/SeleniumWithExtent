package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CommonMethods {
    public static WebDriver driver;
    public WebDriverWait wait ;

    public void waitForElement( WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForByElement( By element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnWebElement(WebElement element) {
       waitForElement(element);
        element.click();
    }

    public void sendKeysOnTextBox(WebElement element, String text) {
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void selectByVisibleText(WebElement element, String text) {
        waitForElement(element);
        Select dropDownOption = new Select(element);
        dropDownOption.selectByValue(text);
    }

    public void selectOptionFromSortLit(By options, String text) {
        List<WebElement> allOptions = driver.findElements(options);
        for(WebElement option : allOptions){
            if(option.getText().equals(text)) {
                System.out.println(option.getText());
                option.click();
                break;
            }
        }
    }

    public void waitForElementVisibility(By element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementPresent(By element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public String returnText(WebElement element){
        waitForElement(element);
        return element.getText();
    }
}
