package petStore;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CatalogPage;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;

public class CreateAccountTest extends BaseTest {
//    LoginPage loginPO = new LoginPage(driver);
//    CreateAccountPage createAccountPO = new CreateAccountPage(driver);

    @Test
//    @Parameters("userName")
//    public void createAccount(String userName) {      This line for Parameterization
    public void createAccount() {
        LoginPage loginPO = new LoginPage(driver);
        CreateAccountPage createAccountPO = new CreateAccountPage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);

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
        createAccountPO.setLanguage();
        createAccountPO.setFavCategory("DOGS");
        createAccountPO.setEnableMyList();
        createAccountPO.setEnableMyBanner();
        createAccountPO.setSaveAccount();
        Assert.assertTrue(catalogPage.verifyBirdText());
    }
    @Test
    public void createAccountWithBirds(){
      LoginPage loginPO = new LoginPage(driver); //Page object and initiation,calling page to utilize elements and methods
      CreateAccountPage createAccountPO = new CreateAccountPage(driver);
      CatalogPage catalogPage = new CatalogPage(driver);

        loginPO.selectStoreLink();//calling utilization a method to click element
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
        createAccountPO.setLanguage();
        createAccountPO.setFavCategory("BIRDS");
        createAccountPO.setSaveAccount();
        Assert.assertTrue(catalogPage.verifyBirdText());
    }
  @Test
  public void createAccountWithFish(){
      LoginPage loginPO = new LoginPage(driver);
      CreateAccountPage createAccountPO = new CreateAccountPage(driver);
      CatalogPage catalogPage = new CatalogPage(driver);

      loginPO.selectStoreLink();//calling utilization a method to click element
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
      createAccountPO.setLanguage();
      createAccountPO.setFavCategory("FISH");
      createAccountPO.setSaveAccount();
      Assert.assertTrue(catalogPage.verifyBirdText());

  }

@Test
public void createAccountWithReptiles(){
    LoginPage loginPO = new LoginPage(driver);
    CreateAccountPage createAccountPO = new CreateAccountPage(driver);
    CatalogPage catalogPage = new CatalogPage(driver);

    loginPO.selectStoreLink();//calling utilization a method to click element
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
    createAccountPO.setLanguage();
    createAccountPO.setFavCategory("REPTILES");
    createAccountPO.setSaveAccount();
    Assert.assertTrue(catalogPage.verifyBirdText());
}
@Test
    public void createAccountWithCats(){
    LoginPage loginPO = new LoginPage(driver);
    CreateAccountPage createAccountPO = new CreateAccountPage(driver);
    CatalogPage catalogPage = new CatalogPage(driver);

    loginPO.selectStoreLink();//calling utilization a method to click element
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
    createAccountPO.setLanguage();
    createAccountPO.setFavCategory("CATS");
    createAccountPO.setSaveAccount();
    Assert.assertTrue(catalogPage.verifyBirdText());
}
}

