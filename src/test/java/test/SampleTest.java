package test;


import com.aventstack.extentreports.ExtentTest;
import functions.LoginRegister;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.extentreport.ExtentReportManager;
import utils.extentreport.ExtentTestManager;

import java.lang.reflect.Method;

public class SampleTest extends BaseTest{
    String username = "test";
    String password = "test";

    LoginRegister loginRegister;

    @BeforeMethod
    public void preconditions(){
        loginRegister  = new LoginRegister(webDriver);
    }

    @Test
    public void addUserTest(Method method) {
        common.goTo("http://thedemosite.co.uk/addauser.php");
        loginRegister.addUser(username, password);
        ExtentReportManager.getReporter().flush();
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
