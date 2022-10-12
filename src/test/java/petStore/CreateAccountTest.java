package petStore;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;

public class CreateAccountTest extends BaseTest {
    String GlobalV = "This is global test";

    @Test
//    @Parameters("userName")
//    public void createAccount(String userName) {      This line for Parameterization
    public void createAccount() {
        LoginPage loginPO = new LoginPage(driver);
        CreateAccountPage createAccountPO = new CreateAccountPage(driver);

        System.out.println(GlobalV);
        Assert.assertTrue(loginPO.enterTheStoreLinkIsDisplayed());
////        Assert.assertTrue(loginPO.enterTheStoreLinkIsDisplayed());
//        loginPO.selectStoreLink();
//        loginPO.selectSignInLick();
//        Assert.assertEquals(loginPO.getRegisterLinkText(), "Register Now!");
//        loginPO.selectRegisterLink();
////        createAccountPO.setUserName(userName); This line for Parameterization
//        createAccountPO.setUserName();
//        Assert.assertEquals(loginPO.getRegisterLinkText(), "Register Now!");
    }
    @Test
    public void verifyingEnterStoreLinkDisplay(){
        LoginPage loginPO = new LoginPage(driver);

//        GlobalV = "This is second test";
        System.out.println(GlobalV);
        Assert.assertTrue(loginPO.enterTheStoreLinkIsDisplayed());
    }

}
