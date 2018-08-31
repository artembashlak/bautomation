package com.waverley.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static io.github.sskorol.listeners.BaseListener.getDriverMetaData;

public class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        this.driver = getDriverMetaData()._1;
        this.wait = getDriverMetaData()._2;
    }

    protected void navigateTo(final String url) {
        driver.get(url);
    }

    protected void click(final By locator) {
        waitFor(locator,
                ExpectedConditions::elementToBeClickable).click();
    }

    protected void type(final By locator, final CharSequence text) {
        waitFor(locator, ExpectedConditions::visibilityOfElementLocated).sendKeys(text);
    }

    private WebElement waitFor(final By locator, final Function<By, ExpectedCondition<WebElement>> condition) {
        return wait.until(condition.apply(locator));
    }
}
