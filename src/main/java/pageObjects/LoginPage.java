package pageObjects;

import frameWork.PageObjectBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObjectBase {
    WebDriver driver;

    // Constructor
    // Gets called when object of this page is created in MainClass.java
    public LoginPage(WebDriver driverFromConstructor) {
        // "this" keyword is used here to distinguish global and local variable "driver"
        //gets driver as parameter from MainClass.java and assigns to the driver instance in this class
//        this.driver = driverFromConstructor;
        super(driverFromConstructor);
    }
    //Locators
    By enterStoreLink = By.linkText("Enter the Store");
    By signIn = By.linkText("Sign In");
    By registerNow = By.linkText("Register Now");
//    By signIn = By.linkText("Sign In");
//    By registerLink = By.linkText("Register Now!");

    //Method to click link
//    public void selectStoreLink() {
//        driver.findElement(enterStoreLink).click();
//    }
//
//    public void selectSignInLick() {
//        driver.findElement(signIn).click();
//    }
//
//    public void selectRegisterLink() {
//        driver.findElement(registerLink).click();
//    }
//
//    public String getEnterTheStoreText() {
//        return driver.findElement(enterStoreLink).getText();
//    }
//
//    public String getRegisterLinkText() {
//        return driver.findElement(registerLink).getText();
//    }
//
//    public Boolean enterTheStoreLinkIsDisplayed() {
//
//        return driver.findElement(enterStoreLink).isDisplayed();
//    }
    public void selectStoreLink(){
        waitForVisibilityOfElement(driver.findElement(enterStoreLink));
        driver.findElement(enterStoreLink).click();
    }
    public void selectSignInLink(){
        driver.findElement(signIn).click();
    }
    public void selectRegisterNow (){
        waitForVisibilityOfElement(driver.findElement(registerNow));
        driver.findElement(registerNow).click();
    }

}
