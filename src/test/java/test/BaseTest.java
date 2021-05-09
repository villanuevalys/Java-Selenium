package test;

import functions.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.core.Initialize;

public class BaseTest {
    public WebDriver webDriver;
    public String actualResult,expectedResult;
    public Base common ;


    @BeforeClass
    public void setUp(){
        webDriver = Initialize.loadWebDriver();
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
