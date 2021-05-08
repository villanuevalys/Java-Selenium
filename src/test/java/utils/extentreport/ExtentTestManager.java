package utils.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {


    static ExtentReports extentReports = ExtentReportManager.getReporter();
    static ExtentTest extentTest ;


    public static ExtentTest startTest(String testName) {
        extentTest = extentReports.createTest(testName);
        return extentTest;
    }




}
