package pageObjects;

import frameWork.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsAndViewCartPage extends PageObjectBase {
    /**
     * Passing Webdriver object so that each class
     * can access the current browser instance
     *
     * @param driver
     */
    public ProductsAndViewCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Add to Cart")
    WebElement addToCartBtn;

    //View Cart
    @FindBy(linkText = "Proceed to Checkout")
    WebElement proceedToCheckoutBtn;

    //Payment
    @FindBy(xpath = "//*[@id=\"CenterForm\"]/form/div/button[1]")
    WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"CenterForm\"]/form/div/button[1]")
    WebElement confirmBtn;

    @FindBy(xpath = "//*[@id=\"MessageBar\"]/p")
    WebElement orderConfirmMsg;

    public void clickAddToCartBtn(){
        clickOnWebElement(addToCartBtn);
    }

    public void clickProceedToCheckOutBtn(){
        clickOnWebElement(proceedToCheckoutBtn);
    }

    public void clickContinueBtn(){
        clickOnWebElement(continueBtn);
    }

    public void clickConfirmBtn(){
        clickOnWebElement(confirmBtn);
    }

    public boolean verifyConfirmationMsg(){
        return isElementDisplayed(orderConfirmMsg);
    }
}
