import functions.LoginRegister;
import functions.Common;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest{
    String username = "test";
    String password = "test";

    LoginRegister logiRegister;
    Common common ;

    @BeforeMethod
    public void init(){
        logiRegister  = new LoginRegister(webDriver);
        common = new Common(webDriver);;
    }

    @Test
    public void addUserTest(){
        common.goTo("http://thedemosite.co.uk/addauser.php");
        logiRegister.addUser(username,password);
    }

    @Test
    public void loginTest(){
        common.goTo("http://thedemosite.co.uk/login.php");
        logiRegister.login(username,password);

        actualResult = logiRegister.loginMessage();
        expectedResult = "**Successful Login**";
        Assert.assertEquals(actualResult,expectedResult);
    }
}
