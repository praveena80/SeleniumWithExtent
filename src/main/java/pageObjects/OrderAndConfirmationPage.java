package pageObjects;

import frameWork.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAndConfirmationPage extends PageObjectBase {

//    public OrderAndConfirmationPage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver, this);
//    }
    public OrderAndConfirmationPage() {
        super();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"CenterForm\"]/form/div/button[1]")
    WebElement confirmBtn;
    @FindBy(xpath = "//*[@id=\"CenterForm\"]/table[1]//tr[1]/td[2]")
    WebElement orderNum;

    @FindBy(xpath = "//tbody/tr/th[contains(text(),'Item ')]/following::tr/td[contains(text(),' ')]")
    WebElement selectedPetText;

    public void clickConfirmBtn(){
        clickOnWebElement(confirmBtn);
    }
    public String getOrderNum(){
        return returnText(orderNum);
    }

    public String getOrderedPetText(){
        scrollToElement(selectedPetText);
        return returnText(selectedPetText);
    }
}
