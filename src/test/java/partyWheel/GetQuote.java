package partyWheel;

import baseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import partyWheelPO.HomePage;

public class GetQuote extends BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void getQuoteFromHome() {
        HomePage homePO = new HomePage(driver);

        homePO.clickGetQuoteBtn();
    }
}
