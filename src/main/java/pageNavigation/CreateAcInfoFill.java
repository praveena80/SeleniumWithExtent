package pageNavigation;

import frameWork.PageObjectBase;
import org.openqa.selenium.WebDriver;
import pageObjects.CreateAccountPage;

public class CreateAcInfoFill extends PageObjectBase {
    public CreateAcInfoFill(WebDriver driver){
        super(driver);
    }
    CreateAccountPage createAccountPO = new CreateAccountPage(driver);

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

}
