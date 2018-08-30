package com.waverley.testcases;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignUpNewUserTest {

    @BeforeSuite
    public void before() {
        Configuration.browser = "chrome";
    }

    @Test
    public void newUserRegistration() {
        openSignUpPage();
        fillFirstName().setValue("testuser1");
        fillLastName("#lastName").setValue("testuser1");
        fillEmail().setValue("testuser1@waverleysoftware.com");
        fillPassword("password").setValue("Password123");
        fillConfirmPassword().setValue("Password123");
        $(By.cssSelector("#root > div > div > form > div > button")).click();
    }

    private SelenideElement fillConfirmPassword() {
        return $(By.cssSelector("confirmPassword"));
    }

    private SelenideElement fillPassword(String password) {
        return $(By.cssSelector(password));
    }

    private SelenideElement fillEmail() {
        return $(By.cssSelector("#email"));
    }

    private SelenideElement fillLastName(String s) {
        return $(By.cssSelector(s));
    }

    private SelenideElement fillFirstName() {
        return $(By.cssSelector("#firstName"));
    }

    private void openSignUpPage() {
        open("https://waverleybooking.github.io/sign-up");
    }

}
