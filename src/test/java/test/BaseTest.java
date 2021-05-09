package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import functions.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.core.Initialize;
import utils.extentreport.ExtentReportManager;

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
