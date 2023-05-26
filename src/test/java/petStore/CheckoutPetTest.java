package petStore;

import baseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageNavigation.CreateAcInfoFill;
import pageObjects.HomePage;
import pageObjects.OrderAndConfirmationPage;
import pageObjects.ProductsAndViewCartPage;
import util.logs.Log;

import java.lang.reflect.Method;

import static util.extentReport.ExtentTestManager.startTest;

public class CheckoutPetTest extends BaseTest {
    private WebDriver driver;
    CreateAcInfoFill pageNavigation;
    ProductsAndViewCartPage checkOutPO;
    OrderAndConfirmationPage confPO;

    @BeforeMethod
    public void setup() {
        driver = getDriver();
        pageNavigation = new CreateAcInfoFill(driver);
        checkOutPO = new ProductsAndViewCartPage(driver);
        confPO = new OrderAndConfirmationPage(driver);
    }

    @Test(description = "Testing this")
    public void checkOutRandomPet(Method method) {

        startTest(method.getName(), "Checkout random pet");
        pageNavigation.checkOutAnyRandomPet();
        pageNavigation.login();
        pageNavigation.continueAndConfirmOrder();
        Log.info("Order Num: " + confPO.getOrderNum());
        Assert.assertTrue(checkOutPO.verifyConfirmationMsg());
    }

}
