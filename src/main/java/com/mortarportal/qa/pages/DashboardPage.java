package com.mortarportal.qa.pages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends TestBase {
    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement dashboardLabel;
    // xpath=//h1[contains(.,'DashboardPage')]

    //B&M-SankaXYZ Button to go to dashboard
    @FindBy(xpath = "//tr[4]/td[3]/button")
    WebElement goToBrandDashboardDirectButton;
    @FindBy(xpath = "/html/body/app-root/app-admin-layout-sidebar-large/div/div[2]/app-managers-default/div/div[3]/div/" +
            "div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr/td[3]/button")
    WebElement goToSearchedDashboardButton;
    @FindBy(xpath = "/html/body/app-root/app-admin-layout-sidebar-large/div/div[2]/app-managers-default/div/div[3]" +
            "/div/div/div/div/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[1]/td[1]")
    WebElement searchedCustomer;
    @FindBy(xpath = "//tr[1]/td[3]/button")
    WebElement goToSearchedClient;

    @FindBy(id = "search")
    WebElement placeholderSearchClient;

    /*@FindBy(xpath="//button[contains(text(),'Search')]")
    WebElement brandSearchButton;*/
    @FindBy(id = "submitButton")
    WebElement brandSearchButton;

    //Initializing the Page Objects;
    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyMortarTitle() {
        return driver.getTitle();
    }

    public boolean verifyDashboardText() {
        return dashboardLabel.isDisplayed();
    }

    /*public void searchABrand(String brandName){
         placeholderSearchClient.sendKeys(brandName);
        brandSearchButton.click();
    }*/
    public void searchABrand(String brandName) {
        placeholderSearchClient.sendKeys(brandName);
        brandSearchButton.click();

    }

    public BusinessOverview searchABrandAndGoToBusinessOverview(String brandName) {
        placeholderSearchClient.sendKeys(brandName);
        brandSearchButton.click();
        goToSearchedDashboardButton.click();
        return new BusinessOverview();
    }

    public String verifySearchedBrand() {
        return searchedCustomer.getText();
    }

    public DashboardPage enterSearchedBrand() {
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
        return this;
    }

    public void clickBrandSearchButton() {
        driver.findElement(By.id("submitButton")).click();
    }


    public BusinessOverview clickOnGoToClientsBusinessOverView() {
        goToBrandDashboardDirectButton.click();
        return new BusinessOverview();
    }

    public BusinessOverview clickOnGoToSearchedClientDashboard() {
        goToSearchedClient.click();
        return new BusinessOverview();
    }
}
