package utils.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.core.Log;
import utils.core.Screenshot;
import utils.extentreport.ExtentReportManager;


public class TestListener implements ITestListener {

    ExtentReports extentReports = ExtentReportManager.getReporter();
    ExtentTest extentTest ;


    @Override
    public void onTestStart(ITestResult iTestResult) {
        extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
        Log.info("Test Start : " + iTestResult.getMethod().getMethodName());


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        extentTest.log(Status.PASS,iTestResult.getTestName());
        Log.info("Test Passed : " + iTestResult.getMethod().getMethodName());
        Log.printLines();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        extentTest.log(Status.FAIL,iTestResult.getThrowable(),
                MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.takeScreenShot(iTestResult.getMethod().getMethodName())).build());
        Log.error("Test Failed : " + iTestResult.getMethod().getMethodName());
        Log.error(iTestResult.getThrowable().getMessage());
        Log.printLines();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        extentTest.log(Status.SKIP,iTestResult.getThrowable());
        Log.info("Test Skipped : " + iTestResult.getMethod().getMethodName());
        Log.warn(iTestResult.getThrowable().getMessage());
        Log.printLines();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();

        Log.printLines();
        Log.info( "Total Test: " + iTestContext.getAllTestMethods().length);
        Log.info( "Passed: " + iTestContext.getPassedTests().size());
        Log.info( "Failed: " + iTestContext.getFailedTests().size());
        Log.info( "Skipped: " + iTestContext.getSkippedTests().size());
        Log.info("See Full Logs:" + "E:\\Java-Selenium\\ExtentReports\\reports.log" );
    }


}
