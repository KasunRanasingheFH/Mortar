package com.mortarai.testcases.AIAnalyticsPageTests;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SalesAIAnalytics;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.LoginPage;
import com.mortarportal.qa.pages.NavigationBar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SalesAIAnalyticsTest extends TestBase {
    LoginPage loginPage;
    NavigationBar navigationBar;
    DashboardPage dashboardPage;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics;
    SalesAIAnalytics salesAIAnalytics;
    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPredictionAIAnalytics = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
        salesAIAnalytics = customerChurnPredictionAIAnalytics.salesLinkClick();
    }
    @Test(priority = 1)
    public void verifySalesAIAnalyticsTitle(){
        String title = salesAIAnalytics.verifyMortarTitleSalesTab();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }
    @Test(priority = 2)
    public void verifiedAverageHourlySalesGraphHeader(){
        boolean isDisplaying = salesAIAnalytics.verifyAverageHourlySalesGraphHeader();
        Assert.assertTrue(isDisplaying,"Average Hourly Sales Graph is not available");
    }
    @Test(priority = 3)
    public void verifiedAverageDailySalesGraphHeader(){
        boolean isDisplaying = salesAIAnalytics.verifyAverageDailySalesGraphHeader();
        Assert.assertTrue(isDisplaying,"Average Daily Sales Graph is not available");
    }
    @Test(priority = 4)
    public void verifiedAverageMonthlySalesGraphHeader(){
        boolean isDisplaying = salesAIAnalytics.verifyAverageMonthlySalesGraphHeader();
        Assert.assertTrue(isDisplaying,"Average Monthly sales graph is not available");
    }
    @Test(priority = 5)
    public void verifiedYearlySalesByQuarter(){
        boolean isDisplaying = salesAIAnalytics.verifyYearlySalesByQuarter();
        Assert.assertTrue(isDisplaying,"Yearly Sales By Quarter graph is not available");
    }
}
