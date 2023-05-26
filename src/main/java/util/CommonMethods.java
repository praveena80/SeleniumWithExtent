package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class CommonMethods {
    protected WebDriver driver;
    public WebDriverWait wait ;
    JavascriptExecutor js;
    Actions actions;

    int randomIndex;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public void waitForElement( WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForByElement( By element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnWebElement(WebElement element) {
       waitForElement(element);
       element.click();
    }

    public void clickElementUsingJavScriptExecutor(WebElement element){
        waitForElement(element);
        js.executeScript("arguments[0].click();",element);
    }

    public void clickElementWithAction(WebElement elementName) {
        actions.moveToElement(elementName).click().perform();
    }

    public void sendKeysInTextBox(WebElement element, String text) {
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void selectByVisibleText(WebElement element, String text) {
//        waitForElement(element);
        Select dropDownOption = new Select(element);
        dropDownOption.selectByVisibleText(text);
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

    public void invisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By)element));
    }

    public boolean isElementDisplayed(WebElement element) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        boolean result;
        try {
            element.isDisplayed();
            result = true;
        }
        catch(Exception ex){
            System.out.println(ex.getStackTrace());
            result = false;
        }
        return result;
    }

    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public String returnText(WebElement element){
        waitForElement(element);
        return element.getText();
    }

    public String getAttributeValue(WebElement element) {
        return element.getAttribute("value");
    }

    public void hoverOnElement(WebElement e) {
        actions.moveToElement(e).build().perform();
    }

    public boolean verifyTextPresent(WebElement element, String text) {
        return returnText(element).contains(text);
    }

    public boolean compareTextEqual(WebElement element, String text) {
        return returnText(element).equals(text);
    }

    public boolean verifyForInputValue(WebElement element, String text) {
        return (element.getAttribute("value").equals(text));
    }

    public boolean compareTextUsingAttribute(WebElement element, String attributeName, String text) {
        return (element.getAttribute(attributeName).equals(text));
    }

    public void selectRandomOption(List<WebElement> element) {
        Random random = new Random();
        randomIndex = random.nextInt(element.size());
        clickOnWebElement(element.get(randomIndex));
    }
}
