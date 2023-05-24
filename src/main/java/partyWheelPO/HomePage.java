package partyWheelPO;

import frameWork.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObjectBase {

    /**
     * Passing Webdriver object so that each class
     * can access the current browser instance
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button/span[contains(text(),'Get')]")
    WebElement getQuoteBtn;

    @FindBy(xpath = "//h5[contains(text(),'Elements')]")
    WebElement elementsOption;

    //Method to click link
    public void selectElementOption() {
        clickOnWebElement(elementsOption);
    }

    public void clickGetQuoteBtn(){
        clickOnWebElement(getQuoteBtn);
    }
}
