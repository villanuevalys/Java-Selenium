package test;

import com.relevantcodes.extentreports.LogStatus;
import functions.LoginRegister;
import functions.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.extentreport.ExtentTestManager;

import java.lang.reflect.Method;

public class SampleTest extends BaseTest{
    String username = "test";
    String password = "test";

    LoginRegister loginRegister;
    Base common ;

    @BeforeMethod
    public void init(){
         common = new Base(webDriver);;
         loginRegister  = new LoginRegister(webDriver);
    }

    @Test
    public void addUserTest(Method method){
        ExtentTestManager.startTest(method.getName(), "Add User");
        common.goTo("http://thedemosite.co.uk/addauser.php");
        loginRegister.addUser(username,password);

    }

    @Test
    public void loginTest(Method method){
        ExtentTestManager.startTest(method.getName(), "User Login");
        common.goTo("http://thedemosite.co.uk/login.php");
        loginRegister.login(username,password);

        actualResult = loginRegister.loginMessage();
        expectedResult = "**Successful Logins**";
        Assert.assertEquals(actualResult,expectedResult);

    }
}
