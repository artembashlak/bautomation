package com.waverley.testcases;


import com.codeborne.selenide.WebDriverRunner;
import com.waverley.pages.LoginPage;
import com.waverley.pages.SignUpPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.waverley.pages.LoginPage.LOGIN_PAGE;
import static com.waverley.pages.SignUpPage.SIGN_UP_PAGE;
import static com.waverley.utils.DriverManagerUtil.initChromeDriver;

public class LoginTest {

    @BeforeClass
    public void setUp() throws MalformedURLException {
        WebDriverRunner.setWebDriver(initChromeDriver());
    }

    @Test
    public void bookingLogin() {
        LoginPage loginPage = page(LoginPage.class);
        open(LOGIN_PAGE);
        loginPage.login();
    }

    @Test
    public void bookingSignUp() {
        SignUpPage signUpPage = page(SignUpPage.class);
        open(SIGN_UP_PAGE);
        signUpPage.signUp();
    }

    @AfterClass
    public void tearDown() {
        close();
    }
}