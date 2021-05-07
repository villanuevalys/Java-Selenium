package functions;

import org.openqa.selenium.WebDriver;
import pages.LoginRegisterPage;

public class LoginRegister extends Base {

    LoginRegisterPage loginRegisterPg = new LoginRegisterPage();

    /*
     */
    public LoginRegister(WebDriver driver){
        super(driver);
    }

    /*
     */
    public  void setUsername(String username){
        sendKeysBy(loginRegisterPg.usernameField,username);
    }

    /*
     */
    public  void setPassword(String password){
        sendKeysBy(loginRegisterPg.passwordField,password);
    }

    /*
     */
    public  void clickSave(){
        clickElementBy(loginRegisterPg.saveButton);
    }


    /*
     */
    public void login(String username,String password){
        setUsername(username);
        setPassword(password);
        clickSave();
    }

    /*
     */
    public void addUser(String username,String password){
        setUsername(username);
        setPassword(password);
        clickSave();
    }

    /*
     */
    public String loginMessage(){
        return getText(loginRegisterPg.loginMessage);
    }
}
