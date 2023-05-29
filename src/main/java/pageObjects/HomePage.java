package pageObjects;

import frameWork.PageObjectBase;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class HomePage extends PageObjectBase {
    /**
     * Passing Webdriver object so that each class
     * can access the current browser instance
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindAll
    (@FindBy(xpath = "//div[@id=\"QuickLinks\"]/a"))
    List<WebElement> quickLinks;

    @FindBy(xpath = "*//a[contains(text(),'Reptiles')]")
    WebElement reptilesLink;
    @FindBy(xpath = "*//a[contains(text(),'Dogs')]")
    WebElement dogsLink;
    public void selectRandomQuickLink(){
        selectRandomOption(quickLinks);
    }

    public void selectQuickLink(String link) {
        if(link == "Reptiles"){
            clickOnWebElement(reptilesLink);
        } else if( link == "Dogs"){
            clickOnWebElement(dogsLink);
        }
    }
}
