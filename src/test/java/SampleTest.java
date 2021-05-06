import functions.LoginRegister;
import functions.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest{
    String username = "test";
    String password = "test";

    @Test
    public void addUserTest(){
        Base.goTo("http://thedemosite.co.uk/addauser.php");
        LoginRegister.addUser(username,password);
    }

    @Test
    public void loginTest(){
        Base.goTo("http://thedemosite.co.uk/login.php");
        LoginRegister.login(username,password);

        actualResult = LoginRegister.loginMessage();
        expectedResult = "**Successful Login**";
        Assert.assertEquals(actualResult,expectedResult);
    }
}
