package com.waverley.testcases;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.waverley.utils.DriverManager.initChromeDriver;
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

import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;

public class WikiSearch {

    @BeforeClass
    public void setUp() throws MalformedURLException {
        WebDriverRunner.setWebDriver(initChromeDriver());
    }

    @Test
    public void wikiSearchTest() {
        open("https://en.wikipedia.org/wiki/Main_Page");
        $(By.id("searchInput")).sendKeys("Software");
        $(By.id("searchButton")).click();
        $(("body")).shouldHave(text("Computer software"));
    }

    @Test
    public void openGoogle() {
        open("https://google.com");
    }

    @AfterClass
    public void tearDown() {
        close();
    }
}