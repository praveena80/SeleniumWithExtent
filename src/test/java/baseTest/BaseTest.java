package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void goToWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Implicit wait example
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://petstore.octoperf.com/");
//        driver.get("http://automationpractice.com/index.php");
    }

    @AfterMethod
    public void closeWindow(){
        driver.close();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

