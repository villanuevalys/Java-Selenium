package pages;

import org.openqa.selenium.By;

public class LoginRegisterPage extends BasePage {

    public By usernameField =  By.name("username");
    public  By passwordField =  By.name("password");
    public  By saveButton =  By.name("FormsButton2");
    public  By loginMessage = By.xpath("//b[text()='**Successful Login**']");

}
