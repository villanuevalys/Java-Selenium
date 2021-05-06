package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginRegisterPage {

    public static By usernameField =  By.name("username");
    public static By passwordField =  By.name("password");
    public static By saveButton =  By.name("FormsButton2");
    public static By loginMessage = By.xpath("//b[text()='**Successful Login**']");

}
