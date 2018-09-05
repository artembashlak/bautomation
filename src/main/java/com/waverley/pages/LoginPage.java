package com.waverley.pages;

import com.codeborne.selenide.SelenideElement;
import com.waverley.core.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage implements Page {
    public static final String LOGIN_PAGE = "https://waverleybooking.github.io/login";

    @FindBy(how = How.ID, using = "loginForm")
    public SelenideElement loginForm;

    @FindBy(how = How.ID, using = "email")
    public SelenideElement email;

    @FindBy(how = How.ID, using = "password")
    public SelenideElement password;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Login')]")
    public SelenideElement loginButton;

    public LoginPage login() {
        this.email.sendKeys("cat@waverleysoftware.com");
        this.password.sendKeys("Hello123.");
        this.loginButton.click();
        return page(LoginPage.class);
    }

    @Override
    public String url() {
        return Page.super.url() + "/login";
    }
}

