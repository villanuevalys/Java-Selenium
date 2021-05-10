package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.core.Screenshot;

public class Base{
    public WebDriver webDriver;
    public WebDriverWait wait;
    int waitTime = 30;

    /*
    */
    public Base(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver,waitTime);

        Screenshot.setWebDriver(webDriver);
    }

    /*
     */
    public void clickElementBy(By by){
        waitUntilElementClickable(by);
        webDriver.findElement(by).click();
    }

    /*
     */
    public void sendKeysBy(By by,String str){
        waitUntilElementVisible(by);
        webDriver.findElement(by).sendKeys(str);
    }

    /*
     */
    public String getText(By by){
        waitUntilElementVisible(by);
        return webDriver.findElement(by).getText();
    }

    /*
     */
    public void waitUntilElementVisible(By by){
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(by)));
    }

    public void waitUntilElementClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(by)));
    }

    public void goTo(String url){
        webDriver.get(url);
    }
}
