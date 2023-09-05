package pageObjects;

import frameWork.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;


public class CreateAccountPage extends PageObjectBase {

//    public CreateAccountPage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver, this);
//    }
    public CreateAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement userIdTextBox;
    @FindBy(name = "password")
    WebElement newPasswordTextBox;
    @FindBy(name = "repeatedPassword")
    WebElement repeatedPasswordTextBox;
    @FindBy(name = "firstName")
    WebElement firstNameTextBox;
    @FindBy(name = "lastName")
    WebElement lastNameTextBox;
    @FindBy(name = "email")
    WebElement emailTextBox;
    @FindBy(name = "phone")
    WebElement phoneTextBox;
    @FindBy(name = "address1")
    WebElement address1TextBox;
    @FindBy(name = "address2")
    WebElement address2TextBox;
    @FindBy(name = "city")
    WebElement cityTextBox;
    @FindBy(name = "state")
    WebElement stateTextBox;
    @FindBy(name = "zip")
    WebElement zipTextBox;
    @FindBy(name = "country")
    WebElement countryTextBox;
    @FindBy(name = "languagePreference") WebElement languagePreferenceTextBox;
    @FindBy(name = "favouriteCategoryId") WebElement favouriteCategoryIdTextBox;
    @FindBy(name = "listOption") WebElement enableMyListCheckBox;
    @FindBy(name = "bannerOption") WebElement enableMyBannerCheckBox;

    @FindBy(xpath = "//*[@id=\"CenterForm\"]/form/div/button") WebElement saveAccountInformationButton;

    @FindBy(id = "MessageBar") WebElement messageBar;

    String pwd = "12345";

    public String getUserName() {
        String textValue = getAttributeValue(userIdTextBox);
        System.out.println(textValue);
        return textValue;
    }
    public void setUserIdTextBox() {
        sendKeysInTextBox(userIdTextBox, generateRandomString(6));
    }

    public void setUserNameInLogin(String usrName) {
        sendKeysInTextBox(userIdTextBox, usrName);
    }
    public void setValueForNewPassword() {sendKeysInTextBox(newPasswordTextBox,pwd);}
    public void setValueForRepeatedPassword() {sendKeysInTextBox(repeatedPasswordTextBox,pwd);}
    public void setValueForFirstName(int num) {sendKeysInTextBox(firstNameTextBox,generateRandomString(num));}
    public void setValuesForLastName() {sendKeysInTextBox(lastNameTextBox,generateRandomString(5));}
    public void setValueForEmail() {sendKeysInTextBox(emailTextBox,generateRandomString(5)+"@gmail.com");}
    public void setValueForPhoneNumber() {sendKeysInTextBox(phoneTextBox,"123"+generateRandomNumString(3)+generateRandomNumString(4));}
    public void setValueForAddress1() {sendKeysInTextBox(address1TextBox,"Alpine Drive");}
    public void setValueForAddress2() throws ParseException {sendKeysInTextBox(address2TextBox,getDate().toString());}
    public void setValueForCity() {sendKeysInTextBox(cityTextBox,"Farmington");}
    public void setValueForState() {sendKeysInTextBox(stateTextBox,"MI");}
    public void setValueForZip(){sendKeysInTextBox(zipTextBox,"48335");}
    public void setValueForCountry() {sendKeysInTextBox(countryTextBox,"USA");}

    /**
     *
     * @param language
     */
    public void clickLanguagePreference(String language) {
        selectByVisibleText(languagePreferenceTextBox,language);
    }

    /**
     *
     * @param category
     */
    public void clickFavouriteCategory(String category) {
        selectByVisibleText(favouriteCategoryIdTextBox, category);
    }
    public void clickEnableMyListCheckBox() {clickOnWebElement(enableMyListCheckBox);}
    public void clickEnableMyBannerCheckBox() {clickOnWebElement(enableMyBannerCheckBox);}
    public void clickSaveAccountInformationButton () {
        clickOnWebElement(saveAccountInformationButton);
    }

}
