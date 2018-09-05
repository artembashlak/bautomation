package com.waverley.testcases;

import com.waverley.pages.LoginPage;
import org.testng.annotations.Test;

import static com.waverley.core.PageFactory.*;

public class LoginTest {

    @Test
    public void loginWithCorrectCredentials() {
        open(LoginPage.class).login();
    }
}