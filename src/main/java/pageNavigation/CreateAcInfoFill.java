package pageNavigation;

import org.openqa.selenium.WebDriver;
import pageObjects.CreateAccountPage;

public class CreateAcInfoFill {
    protected  WebDriver driver;
    CreateAccountPage createAccountPO = new CreateAccountPage(driver);

    public String fillUserInfo() {
        createAccountPO.setUserIdTextBox();
        createAccountPO.setValueForNewPassword();
        createAccountPO.setValueForRepeatedPassword();
        return createAccountPO.getUserName();
    }

    public void fillAccountInfo(){
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
        createAccountPO.clickLanguagePreference("english");
        createAccountPO.clickFavouriteCategory("Fish");
        createAccountPO.clickEnableMyListCheckBox();
        createAccountPO.clickEnableMyBannerCheckBox();
    }

}
