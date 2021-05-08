package utils;

import constants.BrowserConstants;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import utils.core.WebDriverFactory;

public class Initialize {
    public WebDriver webDriver;

    public WebDriver loadWebDriver(){
        webDriver = WebDriverFactory.getInstance(BrowserConstants.CHROME);
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public void configureLog4j(){
        PropertyConfigurator.configure("E:\\Java-Selenium\\src\\log4j.properties");
    }
}
