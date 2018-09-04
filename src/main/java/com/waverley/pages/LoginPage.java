package com.waverley.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    public static final String LOGIN_PAGE = "https://waverleybooking.github.io/login";

    @FindBy(how = How.ID, using = "loginForm")
    public SelenideElement loginForm;

    @FindBy(how = How.ID, using = "email")
    public SelenideElement email;

    @FindBy(how = How.ID, using = "password")
    public SelenideElement password;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Login')]")
    public SelenideElement loginButton;

    @FindBy(how = How.LINK_TEXT, using = "Sign Up")
    public SelenideElement signUpLink;

    @FindBy(how = How.LINK_TEXT, using = "Forgot password")
    public SelenideElement forgotPasswordLink;

    @FindBy(how = How.ID, using = "remember_me")
    public SelenideElement rememberMeCheckbox;

    public void waitTillFormAppear() {
        loginForm.shouldBe(visible);
    }


    public LoginPage login() {
        this.email.sendKeys("cat@waverleysoftware.com");
        this.password.sendKeys("Hello123.");
        this.loginButton.click();
        return page(LoginPage.class);
    }
}

