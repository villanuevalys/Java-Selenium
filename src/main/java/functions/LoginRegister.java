package functions;

import org.openqa.selenium.WebDriver;
import pages.LoginRegisterPage;

public class LoginRegister extends Base{

    public LoginRegister(WebDriver driver){
        super(driver);
    }

    public static void setUsername(String username){

        sendKeysBy(LoginRegisterPage.usernameField,username);
    }
    public static void setPassword(String password){

        sendKeysBy(LoginRegisterPage.passwordField,password);
    }

    public static void clickSave(){

        clickElementBy(LoginRegisterPage.saveButton);
    }

    public static void login(String username,String password){
        setUsername(username);
        setPassword(password);
        clickSave();
    }

    public static void addUser(String username,String password){
        setUsername(username);
        setPassword(password);
        clickSave();
    }

    public static String loginMessage(){
        return getText(LoginRegisterPage.loginMessage);
    }
}
