package pageObjects;

import frameWork.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends PageObjectBase {
    /**
     * Passing Webdriver object so that each class
     * can access the current browser instance
     *
     * @param driver
     */
    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy( linkText = "Sign In")
    WebElement signInLink;
    @FindBy(name = "signon")
    WebElement signOn;
   @FindBy(linkText = "My Account")
   WebElement myAccountLink;

    public Boolean signInLinkIsDisplayed() {return isElementDisplayed(signInLink);}
    public void clickSignInOption() {clickOnWebElement(signInLink);}

    public void clickLogInButton() {clickOnWebElement(signOn);}
    public Boolean myAccountLinkIsDisplayed() {return isElementDisplayed(myAccountLink);}

}
