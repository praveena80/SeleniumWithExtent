package pageObjects;

import frameWork.PageObjectBase;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObjectBase {
    /**
     * Page factory initiation is required for elements
     * @param driverFromConstructor
     */
    // Constructor
    // Gets called when object of this page is created in MainClass.java
    public LoginPage(WebDriver driverFromConstructor) {
        super(driverFromConstructor);
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Sign In")
    WebElement signInLink;
    @FindBy(linkText = "Register Now!")
    WebElement registerNowLink;
    @FindBy(linkText = "My Account")
    WebElement myAccountLink;

    @FindBy(xpath = "*//div/button[contains(text(),'Login')]")
    WebElement loginButton;
    @FindBy(id = "MessageBar")
    WebElement messageBar;


    public void selectSignInLick() {
        clickOnWebElement(signInLink);
    }

    public boolean verifySignInLink() {
        return isElementDisplayed(signInLink);
    }

    public void selectRegisterLink() {
        clickOnWebElement(registerNowLink);
    }

    public String getRegisterLinkText() {
       return returnText(registerNowLink);
    }

    public boolean isMyAccountLinkDisplayed() {
        return isElementDisplayed(myAccountLink);
    }

    public Boolean verifyAccountCreationMessage() {
        return isElementDisplayed(messageBar);
    }

    public void clickLoginBtn() {
        clickOnWebElement(loginButton);
    }
    public boolean verifyPageTitle() {
        String pageTitle = "JPetStore Demo";
        String title = driver.getTitle();
        return title.contains(pageTitle);
    }

}
