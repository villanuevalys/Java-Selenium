package utils.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.common.Log;
import utils.common.Screenshot;
import utils.extentreport.ExtentReportManager;


public class TestListener implements ITestListener {

    ExtentReports extentReports = ExtentReportManager.getReporter();
    ExtentTest extentTest ;


    @Override
    public void onTestStart(ITestResult iTestResult) {
      extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
      Log.startLog(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        extentTest.log(Status.PASS,iTestResult.getTestName());
        extentTest.log(Status.INFO,"See Full logs:");
        Log.endLog(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        extentTest.log(Status.FAIL,iTestResult.getThrowable(),
                MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.takeScreenShot(iTestResult.getMethod().getMethodName())).build());
        extentTest.log(Status.INFO,"See Full logs:");
        Log.startLog(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        extentTest.log(Status.SKIP,iTestResult.getThrowable());
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
    }


}
