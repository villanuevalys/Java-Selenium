package utils.listeners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import functions.Base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.BaseTest;
import utils.common.Screenshot;
import utils.extentreport.ExtentManager;

import java.io.IOException;

public class TestListener implements ITestListener {

    ExtentReports extentReports = ExtentManager.getReporter();
    ExtentTest extentTest ;


    @Override
    public void onTestStart(ITestResult iTestResult) {
        extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        extentTest.log(Status.PASS,iTestResult.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        extentTest.log(Status.FAIL,iTestResult.getThrowable());
        extentTest.addScreenCaptureFromPath(Screenshot.takeScreenShot("Fail"));
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
