package com.waverley.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverManager {
    @Step("Init Chrome driver")
    public static WebDriver initChromeDriver() throws MalformedURLException {
        RemoteWebDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("latest");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
        return driver;
    }
}
