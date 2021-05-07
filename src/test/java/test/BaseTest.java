package test;

import constants.BrowserConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utils.common.WebDriverFactory;

public class BaseTest {
    public WebDriver webDriver;
    public String actualResult,expectedResult;

    public WebDriver getDriver() {
        return webDriver;
    }

    @BeforeClass
    public void setUp(){
        webDriver = WebDriverFactory.getInstance(BrowserConstants.CHROME);
        webDriver.manage().window().maximize();
        webDriver.get("http://thedemosite.co.uk");
    }


    @AfterSuite
    public void tearDown(){
        webDriver.quit();
    }
}
