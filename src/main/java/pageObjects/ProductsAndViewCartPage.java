package pageObjects;

import frameWork.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsAndViewCartPage extends PageObjectBase {

//    public ProductsAndViewCartPage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver, this);
//    }
    public ProductsAndViewCartPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Add to Cart")
    WebElement addToCartBtn;

    @FindAll(@FindBy(xpath = "//td/a[contains(text(),'Add ')]"))
    List<WebElement> addToCartBtns;

    //View Cart
    @FindBy(linkText = "Proceed to Checkout")
    WebElement proceedToCheckoutBtn;

    //Payment
    @FindBy(xpath = "//*[@id=\"CenterForm\"]/form/div/button[1]")
    WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"MessageBar\"]/p")
    WebElement orderConfirmMsg;

    public void clickAddToCartBtn(){
        clickOnWebElement(addToCartBtn);
    }

    public void clickRandomAddToCartBtn() {
        selectRandomOption(addToCartBtns);
    }

    public void clickLastAddToCart(){
        int size = addToCartBtns.size();
        for(int i =size-1; i<=size; i++){
            if(i== size){
                clickOnWebElement(addToCartBtns.get(size-1));
            }
        }
    }

    public void clickProceedToCheckOutBtn(){
        clickOnWebElement(proceedToCheckoutBtn);
    }

    public void clickContinueBtn(){
        clickOnWebElement(continueBtn);
    }

    public boolean verifyConfirmationMsg(){
        return isElementDisplayed(orderConfirmMsg);
    }
}
