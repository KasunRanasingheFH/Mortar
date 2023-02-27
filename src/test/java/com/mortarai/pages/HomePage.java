package com.mortarai.pages;

import StepDefinitions.HooksStepDefinitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends HooksStepDefinitions {
    @FindBy(xpath = "/html/body/app-root/app-admin-layout-sidebar-large/div/div[2]/app-managers-default/div/div[1]/h1")
    private WebElement lbldashboard;

    @FindBy(id = "userDropdown")
    private WebElement ddlogout;

    @FindBy(xpath = "//app-header-sidebar-large/div/div[4]/div/div/button")
    private WebElement lnklogout;

    @FindBy(id = "error-msg")
    private WebElement spanErrorMessage;

    public String getWelcomeMessage()
    {
        return lbldashboard.getText();
    }

    public LoginPage logout(){
        lbldashboard.getText();
        ddlogout.click();
        lnklogout.click();
// Once the user logouts, it will navigate to login page again
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        return loginPage;
    }
}
