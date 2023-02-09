package com.mortarai.pages;

import StepDefinitions.HooksStepDefinitions;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HooksStepDefinitions {
    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//main/div/div[2]/div/form[1]/div[9]/div/button")
    private WebElement btnLogin;

    @FindBy(id = "error-msg")
    private WebElement spanErrorMessage;

    public LoginPage typeUserName(String username)
    {
        txtUsername.sendKeys(username);
        return this;
    }
    public LoginPage typePassword(String password) {
        txtPassword.sendKeys(password);
        return this;
    }
    public LoginPage clickLoginButtonFailure() {
        btnLogin.click();
        return this;
    }
    public String getErrorMessage()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return spanErrorMessage.getText();
    }
    public HomePage clickLoginButtonSuccess()
    {
        btnLogin.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

}
