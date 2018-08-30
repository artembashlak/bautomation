package com.waverley.testcases;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginBookingTest {

    @BeforeSuite
    public void before() {
        Configuration.browser = "chrome";
    }

    @Test
    public void userCanLoginByUsername() {
        openLoginPage();
        fillEmailFieldWith("email", "ivan@waverleysoftware.com");
        fillPasswordFieldWith("password", "hello123.");
        clickLoginButton();
        checkThatUsernameTextIsCorrect();
    }

    private SelenideElement checkThatUsernameTextIsCorrect() {
        return $("#root > div > div > header > div.V2Mck_k7gG08wbdE9v3Bn > div > div > p").shouldHave(text("Ivan"));
    }

    private void clickLoginButton() {
        $("#root > div > div > form > div:nth-child(8) > button").click();
    }

    private SelenideElement fillPasswordFieldWith(String password, String s) {
        return $(By.name(password)).setValue(s);
    }

    private SelenideElement fillEmailFieldWith(String email, String s) {
        return fillPasswordFieldWith(email, s);
    }

    private void openLoginPage() {
        open("https://waverleybooking.github.io/login");
    }

}
