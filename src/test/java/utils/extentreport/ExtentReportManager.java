package utils.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utils.core.Initialize;

import java.io.IOException;


public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static String dir;

    public static ExtentReports getReporter(){

        //Set HTML reporting file location
        dir =  Initialize.getReportsDirectory() + "reports.html";

        ExtentSparkReporter spark = new ExtentSparkReporter(dir);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        return extent;
    }


}
