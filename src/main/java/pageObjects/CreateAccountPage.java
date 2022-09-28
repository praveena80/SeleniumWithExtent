package pageObjects;

import frameWork.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateAccountPage extends PageObjectBase {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }
//Creating variables
    By userNameTextBox = By.name("username");
    By password = By.name("password");
    By repeatPassword = By.name("repeatedPassword");
    By firstName    =   By.name("account.firstName");
    By lastName     =   By.name("account.lastName");
    By email        =   By.name("account.email");
    By phone        =   By.name("account.phone");
    By address1     =   By.name("account.address1");
    By address2     =   By.name("account.address2");
    By city         =   By.name("account.city");
    By state        =   By.name("account.state");
    By zip          =   By.name("account.zip");
    By country      =   By.name("account.country");
    By language     =   By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[1]/td[2]/select");
    By favCategory  =   By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[2]/td[2]/select");
    By enableMyList =   By.name("account.listOption");
    By enableMyBanner=  By.name("account.bannerOption");
    By saveAccount   =  By.name("newAccount");

//    @FindBy (xpath = "//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[2]/td[2]/select")
//    WebElement cat;
//    String random = generateRandomString(7);
    String pwd = "Testing123+";

    public void setUserName() {
        driver.findElement(userNameTextBox).sendKeys( generateRandomString(7));
        //The below line shows how can we use Key board keys
//        driver.findElement(userNameTextBox).sendKeys(Keys.BACK_SPACE);
    }

//    public void setUserName() {
//        driver.findElement(userNameTextBox).sendKeys("praveena");
//    }

    public String getUser() {
        return driver.findElement(userNameTextBox).getText();
    }
    public void enterPassword(){

        driver.findElement(password).sendKeys(pwd);
    }

    public void enterRepeatPassword(){

        driver.findElement(repeatPassword).sendKeys(pwd);
    }
    public void setFirstName(){

        driver.findElement(firstName).sendKeys(generateRandomString(10));
    }
    public void setLastName(){

        driver.findElement(lastName).sendKeys(generateRandomString(10));
    }
    public void setEmail(){

        driver.findElement(email).sendKeys("test@gmail.com");
    }
    public void setPhone(){

        driver.findElement(phone).sendKeys("10 digits");
    }
    public void setAddress1(){
        driver.findElement(address1).sendKeys("123 abcd");
    }
    public void setAddress2(){
        driver.findElement(address2).sendKeys("345 abcd");
    }
    public void setCity(){
        driver.findElement(city).sendKeys("Bangalore");
    }
    public void setState(){
        driver.findElement(state).sendKeys("Karnataka");
    }
    public void setZip(){
        driver.findElement(zip).sendKeys("560083");
    }
    public void setCountry(){
        driver.findElement(country).sendKeys("India");
    }
    public void setLanguage(String lang){
        selectOptionFromSortLit(language,lang);
    }
    //Parameterization. This helps to use multiple option selections
    public void setFavCategory(String option){
        selectOptionFromSortLit(favCategory,option);
    }

    public void setEnableMyList(){
        driver.findElement(enableMyList).click();
    }
    public void setEnableMyBanner(){
        driver.findElement(enableMyBanner).click();
    }
    public void setSaveAccount(){
        driver.findElement(saveAccount).click();
    }
//    public void setUserNameWithPara(String userName) {
//        driver.findElement(userNameTextBox).sendKeys(userName);
//    }
}
