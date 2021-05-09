package utils.core;

import constants.BrowserConstants;
import constants.DirectoryConstants;
import org.apache.log4j.*;
import org.apache.logging.log4j.util.SystemPropertiesPropertySource;
import org.openqa.selenium.WebDriver;
import utils.core.Log;
import utils.core.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Initialize {
    public static WebDriver webDriver;
    public static String reportsDirectory;

    /**/
    public static WebDriver loadWebDriver(){
        webDriver = WebDriverFactory.getInstance(BrowserConstants.CHROME);
        webDriver.manage().window().maximize();
        Log.info("Chrome Driver Initialize");
        return webDriver;
    }

    /**/
    public static void configureLog4j(){
        //   PropertyConfigurator.configure(DirectoryConstants.LOG4j_DIRECTORY);
        String dir = getReportsDirectory() + DirectoryConstants.LOG4j_FILENAME;
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);

        //Define log pattern layout
        PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}: - %m%n");

        //Add console appender to root logger
        rootLogger.addAppender(new ConsoleAppender(layout));
        try
        {
            //Define file appender with layout and output log file name
            RollingFileAppender fileAppender = new RollingFileAppender(layout, dir);

            //Add the appender to root logger
            rootLogger.addAppender(fileAppender);
        }
        catch (IOException e)
        {
            System.out.println("Failed to add appender !!");
        }
    }

    /**/
    public static void createReportsDirectory(String name){
        String dir = DirectoryConstants.USER_DIRECTORY + DirectoryConstants.REPORTS_DIRECTORY;
        Path path = Paths.get(dir);
        Path subPath =  Paths.get(dir + DateTime.getDateTime() + "_" + name);

        try {
            //Create ExtentReports folder
            if(!Files.exists(path)){
                Files.createDirectory(path);
                Log.info("Reports Folder created");

                //Create sub folder for reports
                if(!Files.exists(subPath)){
                    Files.createDirectory(subPath);
                    Log.info("Test Reports Folder created");
                }
            }
        }catch (IOException e){
            Log.error(e.toString());
        }
        setReportsDirectory(subPath.toString() + File.separator);
    }

    public static String getReportsDirectory() {
        return reportsDirectory;
    }

    public static void setReportsDirectory(String reportsDirectory) {
        Initialize.reportsDirectory = reportsDirectory;

    }

}
