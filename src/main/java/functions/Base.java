package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public static WebDriver webDriver;
    static WebDriverWait wait;
    static int waitTime = 30;

    public Base(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, LoginRegister.class);
    }

    public static void clickElementBy(By by){
        wait = new WebDriverWait(webDriver,waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(by)));
        webDriver.findElement(by).click();
    }

    public static void sendKeysBy(By by,String str){
        wait = new WebDriverWait(webDriver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(by)));
        webDriver.findElement(by).sendKeys(str);
    }

    public static void goTo(String url){
        webDriver.get(url);
    }
}
