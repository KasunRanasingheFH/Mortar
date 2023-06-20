package com.mortarai.testcases;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

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

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Sign in to mortar","Title is wrong");
    }

    @Test(priority = 2)
    public void loginPageImageTest() {
        boolean pic = loginPage.validateLoginPageImage();
        Assert.assertTrue(pic);
    }

    @Test(priority = 3)
    public void accountManagerLoginWithValidCredentialsTest(){
       dashboardPage = loginPage.login(prop.getProperty("AdminUsername"),prop.getProperty("AdminPassword"));
    }
    @Test(priority = 4)
    public void accountManagerLoginWithInvalidEmailCredentials(){
        String invalidEmail = "Sankaw233@dmk";
        loginPage.login(invalidEmail, prop.getProperty("AdminPassword"));
      /*  loginPage.getErrorMessage();
        System.out.println("Login Error");*/
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg,"Login failed! Please check your username and password and try again.");
//        Assert.assertTrue(loginPage.getErrorMessage(),"Login failed! Please check your username and password and try again.");
    }
    @Test(priority = 5)
    public void accountManagerLoginWithInvalidPasswordCredentials(){
        String invalidPassword = "Sankaw233@dmk";
        loginPage.login(prop.getProperty("AdminUsername"), invalidPassword);
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg,"Login failed! Please check your username and password and try again.");
    }
    @Test(priority = 6)
    public void businessOwnerLoginWithValidCredentials(){
        businessOverview = loginPage.loginAsUser(prop.getProperty("Username"),prop.getProperty("Password"));
    }
    @Test(priority = 7 )
    public void businessOwnerLoginWithInvalidPasswordCredentials(){
        String invalidPassword = "Sankaw233@dmk";
        businessOverview = loginPage.loginAsUser(prop.getProperty("Username"),invalidPassword);
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg,"Login failed! Please check your username and password and try again.");
    }
    @Test(priority = 8 )
    public void businessOwnerLoginWithInvalidEmailCredentials(){
        String invalidEmail = "Sankaw233@dmk";
        businessOverview = loginPage.loginAsUser(prop.getProperty("Username"),invalidEmail);
        boolean errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg,"Login failed! Please check your username and password and try again.");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("All the test cases of LoginPageTest.class have been executed");
        driver.close();
    }
}
