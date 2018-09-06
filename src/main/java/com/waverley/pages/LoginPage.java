package com.waverley.pages;

import com.waverley.core.Page;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage implements Page {

    public LoginPage login() {
        $("#email").sendKeys("cat@waverleysoftware.com");
        $("#password").sendKeys("Hello123.");
        $(byXpath("//button[contains(text(),'Login')]")).click();
        return page(LoginPage.class);
    }

    @Override
    public String url() {
        return Page.super.url() + "/login";
    }
}

