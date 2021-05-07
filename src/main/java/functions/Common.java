package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
    public  WebDriver webDriver;
    public WebDriverWait wait;
    private int waitTime = 30;

    public Common(WebDriver webDriver){
        this.webDriver = webDriver;
       wait = new WebDriverWait(webDriver,waitTime);
    }

    public void clickElementBy(By by){
      //  wait = waitElement();
      wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(by)));
        webDriver.findElement(by).click();
    }

    public void sendKeysBy(By by,String str){
      //  wait = waitElement();
      wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(by)));
        webDriver.findElement(by).sendKeys(str);
    }

    public String getText(By by){
     //   wait = waitElement();
       wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(by)));
        return webDriver.findElement(by).getText();
    }
    public  WebDriverWait waitElement(){
     //   wait = new WebDriverWait(webDriver,waitTime);
        return wait;
    }



    public void goTo(String url){
        webDriver.get(url);
    }
}
