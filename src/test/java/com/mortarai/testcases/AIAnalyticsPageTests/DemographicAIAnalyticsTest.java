package com.mortarai.testcases.AIAnalyticsPageTests;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.DemographicAIAnalytics;
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

public class DemographicAIAnalyticsTest extends TestBase {
    LoginPage loginPage;
    NavigationBar navigationBar;
    DashboardPage dashboardPage;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
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
        demographicAIAnalytics = customerChurnPredictionAIAnalytics.demographicLinkClick();
        customerChurnPredictionAIAnalytics = new CustomerChurnPredictionAIAnalytics();
    }

    @Test(priority = 1)
    public void verifiedDemographicAIAnalyticsTitle() {
        String title = demographicAIAnalytics.verifyMortarTitleDemographicTab();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }

    @Test(priority = 2)
    public void verifiedAIAnalyticsHeader() {
        boolean isDisplayingAIAnalyticsHeader = demographicAIAnalytics.validateAIAnalyticsHeader();
        Assert.assertTrue(isDisplayingAIAnalyticsHeader, "You are not In AI Analytics section");
        System.out.println("Verify in AI Analytics");
    }

    @Test(priority = 3)
    public void verifiedCustomerChurnIsEnabled() {
        boolean isDisable = demographicAIAnalytics.demographicTabIsEnabled();
        Assert.assertFalse(isDisable, "Demographic Tab is not Enable");
        System.out.println("Demographic Tab Is Enabled");
    }

    @Test(priority = 3)
    public void verifiedCustomerChurnIsSelected() {
        boolean isSelected = demographicAIAnalytics.demographicTabIsSelected();
        Assert.assertTrue(isSelected, "Demographic Tab is not Selected");
        System.out.println("Demographic Tab Is Selected");
    }

    @Test(priority = 5)
    public void verifyExportUnderlyingSalesData() {
        customerChurnPredictionAIAnalytics.exportUnderlyingSalesDataButtonClick();
    }
    @Test(priority = 6)
    public void verifiedLocationByNumberOfCustomersHeader(){
        boolean isDisplay = demographicAIAnalytics.verifyLocationByNumberOfCustomersHeader();
        Assert.assertTrue(isDisplay,"Location by Number of Customers Header Is not Available");
    }
    @Test(priority = 7)
    public void verifiedLocationByTotalCustomerSpendHeader(){
        boolean isDisplay = demographicAIAnalytics.verifyLocationByTotalCustomerSpendHeader();
        System.out.println(isDisplay);
        Assert.assertTrue(isDisplay,"Location by Total Customer Spend Header Is not Available");
    }
    @Test(priority = 7)
    public void verifiedCustomerGenderDistribution(){
        boolean isDisplay = demographicAIAnalytics.verifyCustomerGenderDistribution();
        Assert.assertTrue(isDisplay,"Customer Gender Distribution Header Is not Available");
    }



}
