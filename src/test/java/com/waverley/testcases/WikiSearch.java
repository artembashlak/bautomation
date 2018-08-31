package com.waverley.testcases;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URI;

public class WikiSearch {

    private RemoteWebDriver driver;

    @BeforeTest
    public void openDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("latest");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
    }

    @Test
    public void wikiSearchTest() {
        WebDriverRunner.setWebDriver(driver);
        open("https://en.wikipedia.org/wiki/Main_Page");
        $(By.id("searchInput")).sendKeys("Software");
        $(By.id("searchButton")).click();
        $(("body")).shouldHave(text("Computer software"));
    }

    @Test
    public void openGoogle() {
        WebDriverRunner.setWebDriver(driver);
        open("https://google.com");
    }

    @AfterTest
    public void closeDriver()  {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}