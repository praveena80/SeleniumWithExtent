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


    public void selectSignInLick() {
        clickOnWebElement(signInLink);
    }

    public void selectRegisterLink() {
        clickOnWebElement(registerNowLink);
    }

    public String getRegisterLinkText() {
       return returnText(registerNowLink);
    }

    public boolean verifyPageTitle() {
        String pageTitle = "JPetStore Demo";
        String title = driver.getTitle();
        return title.contains(pageTitle);
    }

}
