package petStore;

import baseTest.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageNavigation.CreateAcInfoFill;
import pageObjects.OrderAndConfirmationPage;
import pageObjects.ProductsAndViewCartPage;

import java.lang.reflect.Method;

import static util.extentReport.ExtentTestManager.getTest;
import static util.extentReport.ExtentTestManager.startTest;

public class CheckoutPetTest extends BaseTest {
    CreateAcInfoFill pageNavigation;
    ProductsAndViewCartPage checkOutPO;
    OrderAndConfirmationPage confPO;

    @BeforeMethod
    public void setup() {
        getDriver();
        pageNavigation = new CreateAcInfoFill();
        checkOutPO = new ProductsAndViewCartPage();
        confPO = new OrderAndConfirmationPage();
    }

    @Test(description = "Testing this")
    public void checkOutRandomPet(Method method) {

        startTest(method.getName(), "Checkout random pet");
        pageNavigation.checkOutAnyRandomPet();
        pageNavigation.login();
        String ordNum = pageNavigation.continueAndConfirmOrder();
        getTest().log(Status.INFO, "Order Num: " + ordNum);
        Assert.assertTrue(checkOutPO.verifyConfirmationMsg());
        getTest().log(Status.INFO,"Ordered Pet : "+confPO.getOrderedPetText());
    }

    @Test(description = "Testing this")
    public void checkOutReptileLastOption(Method method) {

        startTest(method.getName(), "Checkout random pet");
        pageNavigation.checkOutPet("Reptiles");
        pageNavigation.login();
        String ordNum = pageNavigation.continueAndConfirmOrder();
        getTest().log(Status.INFO, "Order Num: " + ordNum);
        Assert.assertTrue(checkOutPO.verifyConfirmationMsg());
        getTest().log(Status.INFO,"Ordered Pet : "+confPO.getOrderedPetText());
    }

    @Test(description = "Testing this")
    public void checkOutDogsLastOption(Method method) {

        startTest(method.getName(), "Checkout random pet");
        pageNavigation.checkOutPet("Dogs");
        pageNavigation.login();
        String ordNum = pageNavigation.continueAndConfirmOrder();
        getTest().log(Status.INFO, "Order Num: " + ordNum);
        Assert.assertTrue(checkOutPO.verifyConfirmationMsg());
        getTest().log(Status.INFO,"Ordered Pet : "+confPO.getOrderedPetText());
    }
}
