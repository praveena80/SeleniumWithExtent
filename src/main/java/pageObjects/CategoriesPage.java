package pageObjects;

import frameWork.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage extends PageObjectBase {
    /**
     * Passing Webdriver object so that each class
     * can access the current browser instance
     *
     * @param driver
     */
    public CategoriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"Catalog\"]/table//tr[2]/td[1]")
    WebElement firstCategory;

    public void selectFirstCategory() {
//        if(firstCategory.getText().equals("Dogs")){
//            //list of all elements
//            //random element
//        } else if (comapre where you are){
//            //all list
//            // random
//        }
        clickOnWebElement(firstCategory);
    }
}
