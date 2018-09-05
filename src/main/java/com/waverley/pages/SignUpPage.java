package com.waverley.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class SignUpPage {

    @FindBy(how = How.ID, using = "firstName")
    public SelenideElement firstName;

    @FindBy(how = How.ID, using = "lastName")
    public SelenideElement lastName;

    @FindBy(how = How.ID, using = "email")
    public SelenideElement email;

    @FindBy(how = How.ID, using = "password")
    public SelenideElement password;

    @FindBy(how = How.ID, using = "confirmPassword")
    public SelenideElement confirmPassword;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign Up')]")
    public SelenideElement SignUpButton;

    @FindBy(how = How.LINK_TEXT, using = "<-- Back to Login")
    public SelenideElement backToLoginLink;

    public SignUpPage signUp() {
        this.firstName.sendKeys("Dog");
        this.lastName.sendKeys("Dog");
        this.email.sendKeys("cat@waverleysoftware.com");
        this.password.sendKeys("Hello123.");
        this.confirmPassword.sendKeys("Hello123.");
        return page(SignUpPage.class);
    }
}
