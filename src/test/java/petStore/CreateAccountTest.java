package petStore;

import baseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;
import util.logs.Log;

import java.lang.reflect.Method;

import static util.extentReport.ExtentTestManager.startTest;

public class CreateAccountTest extends BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = getDriver();
    }

    @Test(description = "create account")
//    @Parameters("userName")
//    public void createAccount(String userName) {      This line for Parameterization
    public void createAccount(Method method) {
        LoginPage loginPO = new LoginPage(driver);
//        CreateAccountPage createAccountPO = new CreateAccountPage(driver);

        startTest(method.getName(), "Create account sample extent");
        Assert.assertTrue(loginPO.verifyPageTitle());
        loginPO.selectSignInLick();
        Assert.assertEquals(loginPO.getRegisterLinkText(), "Register Now!");
//        loginPO.selectRegisterLink();
////        createAccountPO.setUserName(userName); This line for Parameterization
//        createAccountPO.setUserName();
//        Assert.assertEquals(loginPO.getRegisterLinkText(), "Register Now!");
    }

}
