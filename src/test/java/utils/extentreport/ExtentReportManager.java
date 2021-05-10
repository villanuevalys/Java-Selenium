package utils.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utils.core.Initialize;

import java.io.IOException;


public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentTest test;
    private static String dir;

    public static synchronized  ExtentReports getReporter(){

        //Set HTML reporting file location
        dir =  Initialize.getReportsDirectory() + "reports.html";

        ExtentSparkReporter spark = new ExtentSparkReporter(dir);


        extentReports = new ExtentReports();
        extentReports.attachReporter(spark);
        return extentReports;
    }


}
