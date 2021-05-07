package functions;

import org.openqa.selenium.WebDriver;
import pages.LoginRegisterPage;

public class LoginRegister extends Common {

    public LoginRegister(WebDriver driver){
        super(driver);
    }

    public  void setUsername(String username){

        sendKeysBy(LoginRegisterPage.usernameField,username);
    }
    public  void setPassword(String password){

        sendKeysBy(LoginRegisterPage.passwordField,password);
    }

    public  void clickSave(){

        clickElementBy(LoginRegisterPage.saveButton);
    }

    public void login(String username,String password){
        setUsername(username);
        setPassword(password);
        clickSave();
    }

    public void addUser(String username,String password){
        setUsername(username);
        setPassword(password);
        clickSave();
    }

    public String loginMessage(){
        return getText(LoginRegisterPage.loginMessage);
    }
}
