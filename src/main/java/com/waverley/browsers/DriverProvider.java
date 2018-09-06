package com.waverley.browsers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.github.sskorol.listeners.BaseListener.getDriverMetaData;

public class DriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
      return getDriverMetaData()._1;
    }
}
