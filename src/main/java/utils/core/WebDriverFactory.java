package utils.core;

import constants.BrowserConstants;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WebDriverFactory {


    private WebDriverFactory(){}

    public static WebDriver getInstance(String browserName){
        WebDriver webDriver;

        if(BrowserConstants.CHROME.equalsIgnoreCase(browserName)){
            ChromeDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();

        }else if(BrowserConstants.FIREFOX.equalsIgnoreCase(browserName)){
            FirefoxDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();

        }else if(BrowserConstants.IE.equalsIgnoreCase(browserName)){
            InternetExplorerDriverManager.iedriver().setup();
            webDriver = new InternetExplorerDriver();
        }else{
            throw new IllegalArgumentException("Blah! Unsupported browser!");
        }

        return webDriver;
    }
}
