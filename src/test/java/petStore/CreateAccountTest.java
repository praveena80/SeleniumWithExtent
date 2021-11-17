package petStore;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;

public class CreateAccountTest extends BaseTest {

    @Test
//    @Parameters("userName")
//    public void createAccount(String userName) {      This line for Parameterization
    public void createAccount() {
        LoginPage loginPO = new LoginPage(driver);
        CreateAccountPage createAccountPO = new CreateAccountPage(driver);

        Assert.assertTrue(loginPO.enterTheStoreLinkIsDisplayed());
        loginPO.selectStoreLink();
        loginPO.selectSignInLink();
        loginPO.selectRegisterNow();
        createAccountPO.setUserName();
        createAccountPO.enterPassword();
        createAccountPO.enterRepeatPassword();
        createAccountPO.setFirstName();
        createAccountPO.setLastName();
        createAccountPO.setEmail();
        createAccountPO.setPhone();
        createAccountPO.setAddress1();
        createAccountPO.setAddress2();
        createAccountPO.setCity();
        createAccountPO.setState();
        createAccountPO.setZip();
        createAccountPO.setCountry();
        createAccountPO.setEnableMyList();
        createAccountPO.setEnableMyBanner();
        createAccountPO.setSaveAccount();
//        loginPO.selectSignInLick();
//        Assert.assertEquals(loginPO.getRegisterLinkText(), "Register Now!");
//        loginPO.selectRegisterLink();
//        createAccountPO.setUserName(userName); This line for Parameterization
//        createAccountPO.setUserName();
   //     Assert.assertEquals(loginPO.getRegisterLinkText(), "Register Now!");
    }


}
