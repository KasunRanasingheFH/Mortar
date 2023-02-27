package com.mortarai.test;

import StepDefinitions.HooksStepDefinitions;
import com.mortarai.pages.HomePage;
import com.mortarai.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Constants;

import java.time.Duration;

public class LoginTest extends HooksStepDefinitions {
    Duration duration = Duration.ofSeconds(60);

    @Test
    public void testValidUserLogin()
    {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage homePage = loginPage.typeUserName(Constants.BASE_USERNAME)
                .typePassword(Constants.BASE_PASSWORD)
                .clickLoginButtonSuccess();

        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.urlToBe(Constants.BASE_URL + "dashboard"));
        Assert.assertEquals(homePage.getWelcomeMessage(), "Dashboard");
        homePage.logout();
    }
    @Test
    public void testLoginWithInvalidUserName()
    {
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.typeUserName("test@test.com")
                .typePassword(Constants.BASE_PASSWORD)
                .clickLoginButtonFailure();
        Assert.assertEquals(loginPage.getErrorMessage(),"Login failed! Please check your username and password and try again.");
    }

    @Test
    public void testLoginWithInvalidPassword()
    {
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.typeUserName(Constants.BASE_USERNAME)
                .typePassword("123@qwer")
                .clickLoginButtonFailure();
        Assert.assertEquals(loginPage.getErrorMessage(),"Login failed! Please check your username and password and try again.");
    }
}
