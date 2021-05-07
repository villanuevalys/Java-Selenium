package test;

import constants.BrowserConstants;
import functions.Base;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.common.Screenshot;
import utils.common.WebDriverFactory;

public class BaseTest {
    public WebDriver webDriver;
    public String actualResult,expectedResult;
    public Base common ;



    public WebDriver getDriver() {
        return webDriver;
    }

    @BeforeClass
    public void setUp(){
        webDriver = WebDriverFactory.getInstance(BrowserConstants.CHROME);
        webDriver.manage().window().maximize();
        webDriver.get("http://thedemosite.co.uk");
    }

    @BeforeMethod
    public void precondition(){
        common = new Base(webDriver);
    }


    @AfterSuite
    public void tearDown(){
        webDriver.quit();
    }
}
