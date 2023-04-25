package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import util.dataProvider.PropertyManager;
import util.logs.Log;

import java.io.FileNotFoundException;

public class BaseTest {
    private WebDriver driver;

    String baseUrl = PropertyManager.getInstance().getURL();
    String browserType = PropertyManager.getInstance().getBrowserType();

    public WebDriver getDriver() {
        return driver;
    }

    //********************************************************
    // Reading values from TestNg.xml
    //********************************************************
//    private void setDriver(String browserType, String appUrl) {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        chromeOptions.addArguments("--remote-allow-origins=*");
//        switch (browserType) {
//            case "chrome" :
//                driver = new ChromeDriver(chromeOptions);
//                WebDriverManager.chromedriver().setup();
//                initialization(appUrl);
//                break;
//            case "firefox" :
//                if(driver == null) {
//                    driver = new FirefoxDriver();
//                }
//                break;
//        }
//    }

//    private  void initialization(String appUrl) {
//        Log.info("Opening PetSotre!");
//        driver.manage().window().maximize();
//        driver.navigate().to(appUrl);
//    }

    //    @Parameters({"browserType","appUrl"})
//    @BeforeMethod
//    public void initializeBaseTestSteup(String browserType, String appUrl) {
//        try{
//            setDriver(browserType,appUrl);
//        } catch (Exception e) {
//            System.out.println("Error....."+e.getStackTrace());
//        }
//    }

    //*******************************************
    //Reading from config properties file
    // With this can run tests from test classes
    //*******************************************
    private void setDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*");
        switch (browserType) {
            case "chrome" :
                driver = new ChromeDriver(chromeOptions);
                WebDriverManager.chromedriver().setup();
                initialization();
                break;
            case "firefox" :
                if(driver == null) {
                    driver = new FirefoxDriver();
                }
                break;
        }
    }

    private  void initialization() {
       Log.info("Opening PetStore!");
       driver.manage().window().maximize();
       driver.get(baseUrl);
    }

    @BeforeMethod
    public void initializeBaseTestSteup() {
        try{
            setDriver();
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

