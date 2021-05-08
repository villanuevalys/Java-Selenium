package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import functions.LoginRegister;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.common.Screenshot;
import utils.extentreport.ExtentReportManager;
import utils.extentreport.ExtentTestManager;

import java.lang.reflect.Method;

public class SampleTest extends BaseTest{
    String username = "test";
    String password = "test";

    LoginRegister loginRegister;

    @BeforeMethod
    public void init(){
         loginRegister  = new LoginRegister(webDriver);
    }

    @Test
    public void addUserTest(Method method) {
        ExtentReports extentReports = ExtentReportManager.getReporter();
        ExtentTest extentTest =extentReports.createTest(method.getName()) ;
        extentTest.log(Status.INFO,"INFO");


        common.goTo("http://thedemosite.co.uk/addauser.php");
        loginRegister.addUser(username, password);

        extentReports.flush();

    }

    @Test
    public void loginTest(){
        common.goTo("http://thedemosite.co.uk/login.php");
        loginRegister.login(username,password);

        actualResult = loginRegister.loginMessage();
        expectedResult = "**Successful Logins**";
        Assert.assertEquals(actualResult,expectedResult);


    }
}
