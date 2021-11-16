package pageObjects;

import frameWork.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class CreateAccountPage extends PageObjectBase {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

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
    By enableMyList =   By.name("account.listOption");
    By enableMyBanner=  By.name("account.bannerOption");
    By saveAccount   =  By.name("newAccount");
    public void setUserName() {
        driver.findElement(userNameTextBox).sendKeys(generateRandomString(6));
        //The below line shows how can we use Key board keys
//        driver.findElement(userNameTextBox).sendKeys(Keys.BACK_SPACE);

    }
    public void enterPassword(){
        driver.findElement(password).sendKeys("manu@123");
    }
    public void enterRepeatPassword(){
        driver.findElement(repeatPassword).sendKeys("manu@123");
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
