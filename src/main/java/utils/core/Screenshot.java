package utils.core;

import constants.DirectoryConstants;
import functions.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot extends Base {
    public static WebDriver webDriver;

    public Screenshot(WebDriver webDriver) {
        super(webDriver);
    }


    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        Screenshot.webDriver = webDriver;
    }

    public static String takeScreenShot(String name)  {
       TakesScreenshot ts = (TakesScreenshot)webDriver;
       File source = ts.getScreenshotAs(OutputType.FILE);
       String destination = Initialize.getReportsDirectory() + DirectoryConstants.SCREENSHOT_DIRECTORY +  name +  ".png";
       File file = new File(destination);

        try {
            FileUtils.copyFile(source,file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return DirectoryConstants.SCREENSHOT_DIRECTORY + file.getName();

    }
}
