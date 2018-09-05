package com.waverley.listeners;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import static io.github.sskorol.listeners.BaseListener.getDriverMetaData;

public class WebdriverListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriverRunner.setWebDriver(getDriverMetaData()._1);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        //
    }
}
