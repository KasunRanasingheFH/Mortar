package com.mortarportal.qa.pages;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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
    DashboardPage dashboardPage = PageFactory.initElements(driver,
            DashboardPage.class);

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

    @Parameters({"browser.name"})
    public void user_navigates_to_the_login_page(@Optional("chrome") String browser) {
        initialization(browser);
    }

    @When("^user enters username \"([^\"]*)\"$")
    public void enter_User_Name(String uname) {
        username.sendKeys(uname);
    }

    @And("user enters the password as \"([^\"]*)\"$")
    public void user_Enter_Password(String pwd) {
        password.sendKeys(pwd);
    }

    @And("clicks on login button")
    public void login_Button_Clickable() {
        loginBtn.click();
    }

    @Then("user is navigated to the home page and see {string} message")
    public DashboardPage user_navigates_to_the_home_page(String message) throws InterruptedException {
        Thread.sleep(5000);
        String getDashboardTitle = dashboardPage.dashboardLabel.getText();
        Assert.assertEquals(getDashboardTitle, message, "Login failed! Please check your username and password and try again.");
//        Assert.assertTrue(isInDashboard, "Login failed! Please check your username and password and try again.");
        return new DashboardPage();
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
