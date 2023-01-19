package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import util.logs.Log;

public class BaseTest {
    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

//    @BeforeClass
//    public void setDriver() {
//        Log.info("Tests is starting!");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        //Implicit wait example
////        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    private void setDriver(String browserType, String appUrl) {
        switch (browserType) {
            case "chrome" :
                driver = initialization(appUrl);
                break;
            case "firefox" :
                break;
        }
    }

    private static WebDriver initialization(String appUrl) {
        //WebDriverManager.chromedriver().setup();
        Log.info("Opening PetSotre!");
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.navigate().to(appUrl);
//        //Implicit wait example
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//       driver.get("https://petstore.octoperf.com/");
//        driver.get("http://automationpractice.com/index.php");
        return driver;
    }

    @Parameters({"browserType","appUrl"})
    @BeforeClass
    public void initializeBaseTestSteup(String browserType, String appUrl) {
        try{
            setDriver(browserType,appUrl);
        } catch (Exception e) {
            System.out.println("Error....."+e.getStackTrace());
        }
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

