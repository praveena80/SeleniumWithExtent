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

    public void setUserName() {
        driver.findElement(userNameTextBox).sendKeys(generateRandomString(6));
        //The below line shows how can we use Key board keys
//        driver.findElement(userNameTextBox).sendKeys(Keys.BACK_SPACE);
    }

//    public void setUserNameWithPara(String userName) {
//        driver.findElement(userNameTextBox).sendKeys(userName);
//    }
}
