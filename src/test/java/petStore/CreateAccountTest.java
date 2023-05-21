package petStore;

import baseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageNavigation.CreateAcInfoFill;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;
import pageObjects.SignInPage;
import util.logs.Log;

import java.lang.reflect.Method;

import static util.extentReport.ExtentTestManager.startTest;

public class CreateAccountTest extends BaseTest {
    private WebDriver driver;
    LoginPage loginPO;
    CreateAccountPage createAccountPO;
    CreateAcInfoFill createAcFillPO;
    SignInPage signInPO;

    @BeforeMethod
    public void setup() {
        driver = getDriver();
        loginPO = new LoginPage(driver);
        createAccountPO = new CreateAccountPage(driver);
        createAcFillPO = new CreateAcInfoFill();
        signInPO = new SignInPage(driver);
    }

    String usrName;

    @Test(description = "create account")
    public void createAccount(Method method) {

        startTest(method.getName(), "Create account sample extent");
        loginPO.selectSignInLick();
        Assert.assertEquals(loginPO.getRegisterLinkText(), "Register Now!");
        loginPO.selectRegisterLink();
//        createAccountPO.setUserName();
//        createAccountPO.setValueForNewPassword();
//        usrName = createAccountPO.getUserName();
//        createAccountPO.setValueForRepeatedPassword();
        usrName = createAcFillPO.fillUserInfo();
//        createAccountPO.setValueForFirstName();
//        createAccountPO.setValuesForLastName();
//        createAccountPO.setValueForEmail();
//        createAccountPO.setValueForPhoneNumber();
//        createAccountPO.setValueForAddress1();
//        createAccountPO.setValueForAddress2();
//        createAccountPO.setValueForCity();
//        createAccountPO.setValueForState();
//        createAccountPO.setValueForZip();
//        createAccountPO.setValueForCountry();
//        createAccountPO.clickLanguagePreference("english");
//        createAccountPO.clickFavouriteCategory("Fish");
//        createAccountPO.clickEnableMyListCheckBox();
//        createAccountPO.clickEnableMyBannerCheckBox();
        createAcFillPO.fillAccountInfo();
        createAccountPO.clickSaveAccountInformationButton();
        Assert.assertTrue(signInPO.signInLinkIsDisplayed());
        signInPO.clickSignInOption();
        usrName = createAccountPO.getUserName();
        createAccountPO.setUserNameInLogin(usrName);
        createAccountPO.setValueForNewPassword();
        signInPO.clickLogInButton();
        Assert.assertTrue(signInPO.myAccountLinkIsDisplayed());
    }

}
