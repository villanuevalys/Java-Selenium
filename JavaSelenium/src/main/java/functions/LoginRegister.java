package functions;

import org.openqa.selenium.WebDriver;

public class LoginRegister extends Base{

    public LoginRegister(WebDriver driver){
        super(driver);
    }

    public static void setUsername(String username){
        sendKeysBy(pages.LoginRegister.usernameField,username);
    }
    public static void setPassword(String password){
        sendKeysBy(pages.LoginRegister.passwordField,password);
    }

    public static void clickSave(){
        clickElementBy(pages.LoginRegister.saveButton);
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
}
