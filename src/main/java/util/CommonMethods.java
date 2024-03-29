package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class CommonMethods {
    protected WebDriver driver = DriverManager.getDriver();
    public WebDriverWait wait ;
    JavascriptExecutor js;
    Actions actions;
    Random random;

    int randomIndex;

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

//    public CommonMethods(WebDriver driver) {
//        this.driver = driver;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        js = (JavascriptExecutor) driver;
//        actions = new Actions(driver);
//        random = new Random();
//    }

    public CommonMethods() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        random = new Random();
    }

    public void waitForElement( WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void implicitWait(long time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
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

    public void sendKeysAndPressingTabKey(WebElement element, String text){
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.TAB);
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
        implicitWait(5);
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
//        Random random = new Random();
        implicitWait(5);
        randomIndex = random.nextInt(element.size());
        WebElement element1 = element.get(randomIndex);
        System.out.println(element1.getText());
        clickOnWebElement(element1);
    }

    public String generateRandomNumString(int length) {
//        Random random = new Random();
        String randomNumString = "";
        for(int i =0; i<length; i++){
            int digit = random.nextInt(10);
            randomNumString += digit;
        }
        return  randomNumString;
    }

    public void scrollToElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    /**
     * Date
     */
    public Date getDate() throws ParseException {
        Date today = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(today);
//        String formattedDate = dateFormat.format(today);
        String fDate = formattedDate(today);
//        Date currentDate = dateFormat.parse(formattedDate);
        return getParseDate(fDate);
    }

    public String formattedDate(Date date) {
        String formattedDate = dateFormat.format(date);
        return formattedDate;
    }

    public Date getParseDate(String date) throws ParseException {
        Date pDate = dateFormat.parse(date);
        return pDate;
    }

    public Date getYesterdaysDate() throws ParseException {
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date yesterday = calendar.getTime();
//        String formattedYesterday = dateFormat.format(yesterday);
//        Date yesterDayDate = dateFormat.parse(formattedYesterday);
        String yDate = formattedDate(yesterday);
        return getParseDate(yDate);
    }
}
