package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void goToWebsite() {
        driver.manage().window().maximize();
        //Implicit wait example
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://petstore.octoperf.com/");
//        driver.get("http://automationpractice.com/index.php");
    }

    @AfterTest
    public void closeWindow(){
        driver.close();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

