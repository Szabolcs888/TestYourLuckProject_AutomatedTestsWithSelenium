package driverFrameworkCore.utils;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerLogMessages implements ITestListener {
    static Logger log = Logger.getLogger(ListenerLogMessages.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Method FAILED: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.error("Method FAILED with certain success percentage: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Method SKIPPED: " + result.getName());
    }
}
