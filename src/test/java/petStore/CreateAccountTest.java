package petStore;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageNavigation.CreateAcInfoFill;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;

import java.lang.reflect.Method;

import static util.extentReport.ExtentTestManager.startTest;

public class CreateAccountTest extends BaseTest {
    LoginPage loginPO;
    CreateAccountPage createAccountPO;
    CreateAcInfoFill createAcFillPO;

    @BeforeMethod
    public void setup() {
        getDriver();
        loginPO = new LoginPage();
        createAccountPO = new CreateAccountPage();
        createAcFillPO = new CreateAcInfoFill();
    }

    String usrName;

    @Test (priority = 2)
    public void loginUsingCreatedAccount(Method method) {
        startTest(method.getName(), "Login using newly created account user details");

        loginPO.selectSignInLick();
        createAccountPO.setUserNameInLogin(usrName);
        createAccountPO.setValueForNewPassword();
        loginPO.clickLoginBtn();
        Assert.assertTrue(loginPO.isMyAccountLinkDisplayed());
    }

    @Test(description = "create account", priority = 1)
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
    }

}
