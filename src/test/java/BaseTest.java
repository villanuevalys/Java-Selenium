import constants.BrowserConstants;
import functions.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver webDriver;
    public String actualResult,expectedResult;

    @BeforeClass
    public void init(){
        webDriver = WebDriverFactory.getInstance(BrowserConstants.CHROME);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://thedemosite.co.uk");
        Base.webDriver = webDriver;
    }


    @AfterSuite
    public void tearDown(){
        webDriver.quit();
    }
}
