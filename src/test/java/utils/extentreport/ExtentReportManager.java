package utils.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.DirectoryConstants;
import org.testng.ITestResult;
import org.testng.internal.TestResult;


public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getReporter() {

        //Set HTML reporting file location
        String path = DirectoryConstants.USER_DIRECTORY + DirectoryConstants.REPORTS_DIRECTORY + "ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(path);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        return extent;
    }
}
