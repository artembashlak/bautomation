package com.waverley.browsers;

import io.github.sskorol.config.XmlConfig;
import io.github.sskorol.core.Browser;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox implements Browser{
    public Browser.Name name() {
        return Browser.Name.Firefox;
    }

    @Override
    public boolean isRemote() {
        return true;
    }

    @Override
    public Capabilities configuration(final XmlConfig config) {
        System.setProperty("selenide.browser","com.waverley.browsers.DriverProvider");
        final FirefoxOptions options = new FirefoxOptions();
        options.setCapability("enableVNC", true);
        options.setCapability("name", config.getTestName());
        options.setCapability("screenResolution", "1280x1024x24");
        return merge(config, options);
    }
}
