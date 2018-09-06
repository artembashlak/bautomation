package com.waverley.core;

import io.github.sskorol.core.ScreenshotConsumer;
import org.testng.ITestResult;

import java.time.LocalDate;

import static com.waverley.utils.AttachAllureUtils.attachScreenshot;
import static java.util.Objects.nonNull;
import static org.testng.ITestResult.FAILURE;

public class ScreenShot implements ScreenshotConsumer {

    @Override
    public void handle(final byte[] screenshot, final ITestResult testResult) {
        if (nonNull(screenshot) && testResult.getStatus() == ITestResult.SUCCESS
                && testResult.getStatus() == ITestResult.FAILURE
                && testResult.getStatus() == ITestResult.SKIP) {
            attachScreenshot(screenshot,
                    testResult.getMethod().getMethodName() + "_" + LocalDate.now());
        }
    }
}
