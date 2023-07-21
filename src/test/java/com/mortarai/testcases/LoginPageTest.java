package com.mortarai.testcases;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.LoginPage;
import com.mortarportal.qa.util.TestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    BusinessOverview businessOverview;

    private static final Logger logger = LoggerFactory.getLogger(LoginPageTest.class);

    public LoginPageTest() {
        super();
    }

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
        loginPage = new LoginPage();
    }

    int x = 1;

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Sign in to mortar", "Title is wrong");
    }

    @Test(priority = 2)
    public void verifyLoginPageTitleHeader(){
        boolean header = loginPage.validateLogInPageHeaderTitle();
        Assert.assertTrue(header,"Login page header title is not available");
    }

    @Test(priority = 3)
    public void verifyUserNameInputFieldIsVisible(){
        Assert.assertTrue(loginPage.loginUserNameFieldVisibility(),"UserName Field is Not Visible");
    }
    @Test(priority = 4)
    public void verifyPasswordInputFieldIsVisible(){
        Assert.assertTrue(loginPage.loginPasswordFieldVisibility(),"Password Field is Not Visible");
    }
    @Test(priority = 5)
    public void verifyLoginButtonIsVisible(){
        Assert.assertTrue(loginPage.loginButtonVisibility(),"Password Field is Not Visible");
    }
    @Test(priority = 6)
    public void verifyLoginButtonClickable(){
        loginPage.loginButtonClickable();
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg, "Login failed! Please check your username and password and try again.");
    }
    @Test(priority = 7)
    public void accountManagerLoginWithValidCredentialsTest() {
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
    }

    @Test(priority = 8)
    public void accountManagerLoginWithInvalidEmailCredentials() {
        String invalidEmail = "Sankaw233@dmk";
        loginPage.login(invalidEmail, prop.getProperty("AdminPassword"));
      /*  loginPage.getErrorMessage();
        System.out.println("Login Error");*/
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");
//        Assert.assertTrue(loginPage.getErrorMessage(),"Login failed! Please check your username and password and try again.");
    }

    @Test(priority = 9)
    public void accountManagerLoginWithInvalidPasswordCredentials() {
        String invalidPassword = "Sankaw233@dmk";
        loginPage.login(prop.getProperty("AdminUsername"), invalidPassword);
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");

    }

    @Test(priority = 10)
    public void businessOwnerLoginWithValidCredentials() throws InterruptedException {
        businessOverview = loginPage.loginAsUser(prop.getProperty("Username"), prop.getProperty("Password"));
        Thread.sleep(5000);
        boolean popupVerify = businessOverview.verifyUserVerificationPopup();
        Assert.assertTrue(popupVerify,"User verify Popup didn't Showed");

    }

    @Test(priority = 11)
    public void businessOwnerLoginWithInvalidPasswordCredentials() {
        String invalidPassword = "Sankaw233@dmk";
        businessOverview = loginPage.loginAsUser(prop.getProperty("Username"), invalidPassword);
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg,"Error Message not popped up");
    }

    @Test(priority = 12)
    public void businessOwnerLoginWithInvalidEmailCredentials() {
        String invalidEmail = "Sankaw233@dmk";
        businessOverview = loginPage.loginAsUser(prop.getProperty("Username"), invalidEmail);
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");
    }

    @Test(priority = 13)
    public void loginWithEmptyEmailCredentials() {
        String invalidEmail = "";
        businessOverview = loginPage.loginAsUser(invalidEmail, prop.getProperty("Password"));
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");

    }

    @Test(priority = 14)
    public void loginWithEmptyPasswordCredentials() {
        String invalidPassword = "";
        businessOverview = loginPage.loginAsUser(prop.getProperty("Username"), invalidPassword);
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");
    }

    @Test(priority = 15)
    public void loginWithEmptyCredentials() {
        String invalidEmail = "";
        String invalidPassword = "";
        businessOverview = loginPage.loginAsUser(invalidEmail, invalidPassword);
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");
    }


    @AfterMethod
    public void tearDown() {
        logger.info("All the test cases of LoginPageTest.class have been executed");
        driver.close();
    }
}
