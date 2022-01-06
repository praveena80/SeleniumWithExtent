package pageobjectsLimousine;

import frameWork.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObjectBase {
//    WebDriver driver;

    // Constructor
    // Gets called when object of this page is created in MainClass.java
    public HomePage(WebDriver driverFromConstructor) {
        // "this" keyword is used here to distinguish global and local variable "driver"
        //gets driver as parameter from MainClass.java and assigns to the driver instance in this class
//        this.driver = driverFromConstructor;
        super(driverFromConstructor);
    }
    //Locators

    @FindBy(name = "Home")
    WebElement homeLink;

    @FindBy(name = "Occasion")
    WebElement occasionLink;

    @FindBy(name = "Sedan")
    WebElement sedanLink;

    @FindBy(name = "SUVs")
    WebElement suvLink;

    @FindBy(name = "Limousine")
    WebElement limousineLink;

    @FindBy(name = "Coaches")
    WebElement coachesLink;

    @FindBy(name = "Carriage")
    WebElement carriageLink;

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
    public void clickHomeLink() {
        homeLink.click();
    }

    public void clickOccasionLink() {
        occasionLink.click();
    }

   public void clickSedanLink(){
        sedanLink.click();
   }

}
