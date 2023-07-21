package com.mortarportal.qa.pages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory - OR:
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    //    @FindBy(xpath = "//button[@type='submit']")
    @FindBy(id = "kc-login")
    WebElement loginBtn;
    @FindBy(id = "kc-page-title")
    WebElement loginPageTitle;
    @FindBy(xpath = "//h3[contains(text(),'Sign In')]")
    WebElement signUpText;

    @FindBy(xpath = "//img[contains(@class,'ui header ellipsis')]")
    WebElement mortarLogo;
    @FindBy(id = "input-error")
    WebElement spanErrorMessage;

    //Initializing Page Objects
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateLogInPageHeaderTitle() {
        return loginPageTitle.isDisplayed();
    }

    public boolean validateLoginPageImage() {
        return mortarLogo.isDisplayed();
    }

    public boolean loginUserNameFieldVisibility() {
        return username.isDisplayed();
    }

    public boolean loginPasswordFieldVisibility() {
        return password.isDisplayed();
    }

    public boolean loginButtonVisibility() {
        return loginBtn.isDisplayed();
    }

    public void loginButtonClickable() {
        loginBtn.click();
    }

    public DashboardPage login(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginBtn.click();
        return new DashboardPage();
    }

    public BusinessOverview loginAsUser(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginBtn.click();
        return new BusinessOverview();
    }

    public boolean getErrorMessage() {
        return spanErrorMessage.isDisplayed();
    }


}
