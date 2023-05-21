package petStore;

import baseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageNavigation.CreateAcInfoFill;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;

import java.lang.reflect.Method;

import static util.extentReport.ExtentTestManager.startTest;

public class CreateAccountTest extends BaseTest {
    private WebDriver driver;
    LoginPage loginPO;
    CreateAccountPage createAccountPO;
    CreateAcInfoFill createAcFillPO;

    @BeforeMethod
    public void setup() {
        driver = getDriver();
        loginPO = new LoginPage(driver);
        createAccountPO = new CreateAccountPage(driver);
        createAcFillPO = new CreateAcInfoFill(driver);
    }

    String usrName;

    @Test(description = "create account")
    public void createAccount(Method method) {

        startTest(method.getName(), "Create account sample extent");
        loginPO.verifySignInLink();
        loginPO.selectSignInLick();
        Assert.assertEquals(loginPO.getRegisterLinkText(), "Register Now!");
        loginPO.selectRegisterLink();
        usrName = createAcFillPO.fillUserInfo();
        createAcFillPO.fillAccountInfo("German", "Dogs");
        createAccountPO.clickSaveAccountInformationButton();
        Assert.assertTrue(loginPO.verifyAccountCreationMessage());
        createAccountPO.setUserNameInLogin(usrName);
        createAccountPO.setValueForNewPassword();
        loginPO.clickLoginBtn();
        Assert.assertTrue(loginPO.isMyAccountLinkDisplayed());
    }

}
