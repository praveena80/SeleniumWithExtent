package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import util.logs.Log;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setDriver() {
        Log.info("Tests is starting!");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Implicit wait example
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void goToWebsite() {
        //WebDriverManager.chromedriver().setup();
        Log.info("Opening PetSotre!");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        //Implicit wait example
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get("https://petstore.octoperf.com/");
//        driver.get("http://automationpractice.com/index.php");
         loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void closeWindow(){
        driver.close();
    }

    @AfterClass
    public void tearDown() {
        Log.info("Tests are ending!");
        driver.quit();
    }
}

