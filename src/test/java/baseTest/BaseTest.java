package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import util.logs.Log;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }


    private void setDriver(String browserType, String appUrl) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*");
        switch (browserType) {
            case "chrome" :
                driver = new ChromeDriver(chromeOptions);
                WebDriverManager.chromedriver().setup();
                initialization(appUrl);
                break;
            case "firefox" :
                if(driver == null) {
                    driver = new FirefoxDriver();
                }
                break;
        }
    }

    private  void initialization(String appUrl) {
       Log.info("Opening PetSotre!");
       driver.manage().window().maximize();
       driver.navigate().to(appUrl);
    }

    @Parameters({"browserType","appUrl"})
    @BeforeMethod
    public void initializeBaseTestSteup(String browserType, String appUrl) {
        try{
            setDriver(browserType,appUrl);
        } catch (Exception e) {
            System.out.println("Error....."+e.getStackTrace());
        }
    }

    @AfterMethod
    public void tearDown() {
        Log.info("Tests are ending!");
        driver.close();
        driver.quit();
    }
}

