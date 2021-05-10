package utils.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import utils.core.Screenshot;


import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    public static ExtentReports extentReports ;
    public static ExtentTest extentTest;


    /*
    * Create Test
    * */
    public static synchronized ExtentTest createTest(String name){
        extentTest = extentReports.createTest(name);
        setExtentTest(extentTest);
        return extentTest;
    }


    public static void takeScreenshot(Status status,String name){
        ExtentTestManager.getExtentTest().log(status,name,
                MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.takeScreenShot(name)).build());
    }

    /**/
    public static ExtentReports getExtentReports() {
        return extentReports;
    }

    /**/
    public static void setExtentReports(ExtentReports extentReports) {
        ExtentTestManager.extentReports = extentReports;
    }

    /**/
    public static ExtentTest getExtentTest() {
        return extentTest;
    }

    /**/
    public static void setExtentTest(ExtentTest extentTest) {
        ExtentTestManager.extentTest = extentTest;
    }




}
