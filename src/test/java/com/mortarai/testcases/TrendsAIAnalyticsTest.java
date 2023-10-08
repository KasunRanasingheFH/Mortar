package com.mortarai.testcases;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.*;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.LoginPage;
import com.mortarportal.qa.pages.NavigationBar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TrendsAIAnalyticsTest extends TestBase {
    LoginPage loginPage;
    NavigationBar navigationBar;
    TrendsAIAnalytics trendsAIAnalytics;
    DashboardPage dashboardPage;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    ProductsAIAnalytics productsAIAnalytics;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics;
    SalesAIAnalytics salesAIAnalytics;
    DemographicAIAnalytics demographicAIAnalytics;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPredictionAIAnalytics = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
        trendsAIAnalytics = customerChurnPredictionAIAnalytics.trendsLinkClick();
        customerChurnPredictionAIAnalytics = new CustomerChurnPredictionAIAnalytics();
    }

    @Test(priority = 1)
    public void verifiedDemographicAIAnalyticsTitle() {
        String title = productsAIAnalytics.verifyMortarTitleProductsTab();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }

    @Test(priority = 2)
    public void verifiedAIAnalyticsHeader() {
        boolean isDisplayingAIAnalyticsHeader = productsAIAnalytics.validateAIAnalyticsHeader();
        Assert.assertTrue(isDisplayingAIAnalyticsHeader, "You are not In AI Analytics section");
        System.out.println("Verify in AI Analytics");
    }

    @Test(priority = 3)
    public void verifiedCustomerChurnIsEnabled() {
        boolean isDisable = productsAIAnalytics.productTabIsEnabled();
        Assert.assertFalse(isDisable, "Trends Tab is not Enable");
        System.out.println("Trends Tab Is Enabled");
    }

    @Test(priority = 3)
    public void verifiedCustomerChurnIsSelected() {
        boolean isSelected = productsAIAnalytics.productTabIsSelected();
        Assert.assertTrue(isSelected, "Trends Tab is not Selected");
        System.out.println("Trends Tab Is Selected");
    }

    @Test(priority = 5)
    public void verifyExportUnderlyingSalesData() {
        customerChurnPredictionAIAnalytics.exportUnderlyingSalesDataButtonClick();
    }
}
