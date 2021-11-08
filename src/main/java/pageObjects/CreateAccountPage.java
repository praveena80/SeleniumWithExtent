package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {
    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By userNameTextBox = By.name("username");

    public void setUserName() {
        driver.findElement(userNameTextBox).sendKeys("automation1");
    }
}
