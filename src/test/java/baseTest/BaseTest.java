package baseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

//import com.aventstack.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports report;
    ExtentTest test;

    @BeforeSuite
    public void setUp() {
//        report = ExtentManager.createInstance("extent.html");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        report.attachReporter(htmlReporter);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @BeforeClass
    public void goToWebsite() {
//        // initialize the HtmlReporter
//        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
//
//        //initialize ExtentReports and attach the HtmlReporter
//        report = new ExtentReports();
//        report.attachReporter(htmlReporter);

//        htmlReporter.config().setChartVisibilityOnOpen(true);
//        htmlReporter.config().setDocumentTitle("Extent Report Demo");
//        htmlReporter.config().setReportName("Test Report");
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
//        htmlReporter.config().setTheme(Theme.STANDARD);
//        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        ExtentTest parent = report.createTest(getClass().getName());
//        parentTest.set(parent);

        driver.manage().window().maximize();
        //Implicit wait example
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://petstore.octoperf.com/");
//        driver.get("http://automationpractice.com/index.php");
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
//        ExtentTest child = parentTest.get().createNode(method.getName());
//        test.set(child);
    }

    @AfterTest
    public void closeWindow(){
        driver.close();
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    @AfterTest
    public void tearDown() {
        //to write or update test information to reporter
        report.flush();
    }

    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }
}

