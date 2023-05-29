package pageNavigation;

import frameWork.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.*;

public class CreateAcInfoFill extends PageObjectBase {
    public CreateAcInfoFill(WebDriver driver){
        super(driver);
    }
    CreateAccountPage createAccountPO = new CreateAccountPage(driver);
    HomePage homePO = new HomePage(driver);
    LoginPage loginPO = new LoginPage(driver);
    CategoriesPage categoriesPO = new CategoriesPage(driver);
    ProductsAndViewCartPage productsPO = new ProductsAndViewCartPage(driver);

    OrderAndConfirmationPage confPO = new OrderAndConfirmationPage(driver);

    public String fillUserInfo() {
       createAccountPO.setUserIdTextBox();
       createAccountPO.setValueForNewPassword();
       createAccountPO.setValueForRepeatedPassword();
       return createAccountPO.getUserName();
    }

    public void fillAccountInfo(String category, String fav){
        createAccountPO.setValueForFirstName(5);
        createAccountPO.setValuesForLastName();
        createAccountPO.setValueForEmail();
        createAccountPO.setValueForPhoneNumber();
        createAccountPO.setValueForAddress1();
        createAccountPO.setValueForAddress2();
        createAccountPO.setValueForCity();
        createAccountPO.setValueForState();
        createAccountPO.setValueForZip();
        createAccountPO.setValueForCountry();
        createAccountPO.clickLanguagePreference(category);
        createAccountPO.clickFavouriteCategory(fav);
        createAccountPO.clickEnableMyListCheckBox();
        createAccountPO.clickEnableMyBannerCheckBox();
    }

    public void checkOutAnyRandomPet() {
        homePO.selectRandomQuickLink();
        categoriesPO.selectRandomCategoryFromList();
        productsPO.clickRandomAddToCartBtn();
        productsPO.clickProceedToCheckOutBtn();
    }

    public void login(){
//        createAccountPO.setUserNameInLogin("");
//        createAccountPO.setValueForNewPassword();
        loginPO.clickLoginBtn();
    }

    public void checkOutPet(String link) {
        homePO.selectQuickLink(link);
        categoriesPO.selectLastItemFromList();
        productsPO.clickLastAddToCart();
        productsPO.clickProceedToCheckOutBtn();
    }

    public String continueAndConfirmOrder(){
        productsPO.clickContinueBtn();
        confPO.clickConfirmBtn();
        return confPO.getOrderNum();
    }

}
