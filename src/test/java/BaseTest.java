import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import constants.BrowserConstants;
import functions.Common;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver webDriver;
    public String actualResult,expectedResult;


    @BeforeClass
    public void setUp(){
        webDriver = WebDriverFactory.getInstance(BrowserConstants.CHROME);
        webDriver.manage().window().maximize();
        webDriver.get("http://thedemosite.co.uk");
       // Common.webDriver = webDriver;

    }


    @AfterSuite
    public void tearDown(){
        webDriver.quit();
    }
}
