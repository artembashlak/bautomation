package com.waverley.testcases;

import com.waverley.pages.LoginPage;
import com.waverley.pages.SignUpPage;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.waverley.pages.LoginPage.LOGIN_PAGE;
import static com.waverley.pages.SignUpPage.SIGN_UP_PAGE;
import static io.restassured.RestAssured.when;

public class LoginTest {


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

    @Test
    public void forgotPasswordRest() {
        when().get("https://waverleybooking.github.io/forgot-password")
                .then().statusCode(404);
    }
}