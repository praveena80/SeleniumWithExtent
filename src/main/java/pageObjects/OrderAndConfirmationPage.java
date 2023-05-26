package pageObjects;

import frameWork.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAndConfirmationPage extends PageObjectBase {
    /**
     * Passing Webdriver object so that each class
     * can access the current browser instance
     *
     * @param driver
     */
    public OrderAndConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"CenterForm\"]/table[1]//tr[1]/td[2]")
    WebElement orderNum;

    public String getOrderNum(){
        return returnText(orderNum);
    }
}
