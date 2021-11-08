package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Constructor
    // Gets called when object of this page is created in MainClass.java
    public LoginPage(WebDriver driverFromConstructor) {
        // "this" keyword is used here to distinguish global and local variable "driver"
        //gets driver as parameter from MainClass.java and assigns to the driver instance in this class
        this.driver = driverFromConstructor;
    }

    //Locators
    By enterStoreLink = By.linkText("Enter the Store");

    //Method to click link
    public void selectStoreLink() {
        driver.findElement(enterStoreLink).click();
    }

    public String getEnterTheStoreText() {
        return driver.findElement(enterStoreLink).getText();
    }

}
