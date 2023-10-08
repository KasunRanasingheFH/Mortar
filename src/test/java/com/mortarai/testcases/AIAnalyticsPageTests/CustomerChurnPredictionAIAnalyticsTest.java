package com.mortarai.testcases.AIAnalyticsPageTests;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.*;
import com.mortarportal.qa.pages.AIAnalyticsPages.*;
import com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab.CustomerSegmentsByRFMT;
import com.mortarportal.qa.pages.Integrations.Integrations;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.FacebookAdvertisingPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class CustomerChurnPredictionAIAnalyticsTest extends TestBase {
    //NAV BAR
    LoginPage loginPage;
    NavigationBar navigationBar;
    DashboardPage dashboardPage;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    MyCustomer myCustomer;
    Integrations intergrations;
    FacebookAdvertisingPage facebookAdvertisingPage;
    MyCreatives myCreatives;
    //AI Analytics Page
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics;
    SalesAIAnalytics salesAIAnalytics;
    CustomerSegmentsByRFMT customerSegmentsByRFMT;
    ProductsAIAnalytics productsAIAnalytics;
    TrendsAIAnalytics trendsAIAnalytics;
    DemographicAIAnalytics demographicAIAnalytics;
    TargetAudienceAIAnalytics targetAudienceAIAnalytics;

    public CustomerChurnPredictionAIAnalyticsTest() {
        super();
    }

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPredictionAIAnalytics = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
    }
    @Test(priority = 1)
    public void verifiedDemographicAIAnalyticsTitle() {
        String title = salesAIAnalytics.verifyMortarTitleSalesTab();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }

    @Test(priority = 1)
    public void verifyingCustomersAtChurnListDisplay() {
//        testUtil.switchToFrame();
        try {
            boolean customerChurnTable = customerChurnPredictionAIAnalytics.customersAtChurnListDisplay();
            Assert.assertTrue(customerChurnTable, "AI analytics Data is not available");
        } catch (Exception e) {
            boolean customerAiAnalyticsData = customerChurnPredictionAIAnalytics.customerNoDataInAIAnalyticsTextCheck();
            Assert.assertTrue(customerAiAnalyticsData, "Error");
        }

    }
    @Test(priority = 2)
    public void verifiedAIAnalyticsHeader(){
        boolean isDisplayingAIAnalyticsHeader = customerChurnPredictionAIAnalytics.validateAIAnalyticsHeader();
        Assert.assertTrue(isDisplayingAIAnalyticsHeader,"You are not In AI Analytics section");
        System.out.println("Verify in AI Analytics");
    }
    @Test(priority = 3)
    public void verifiedCustomerChurnIsEnabled(){
        boolean isDisable = customerChurnPredictionAIAnalytics.customerChurnPredictionIsEnabled();
        Assert.assertFalse(isDisable, "Customer Churn Prediction is not Enable");
        System.out.println("Customer Churn Prediction Tab Is Enabled");
    }
    @Test(priority = 4)
    public void verifiedCustomerChurnIsSelected(){
        boolean isSelected = customerChurnPredictionAIAnalytics.customerChurnPredictionIsSelected();
        Assert.assertTrue(isSelected, "Customer Churn Prediction is not Selected");
        System.out.println("Customer Churn Prediction Tab Is Selected");
    }

    @Test(priority = 5)
    public void verifiedCustomerAtChurnListHeader() {
        String heading = customerChurnPredictionAIAnalytics.verifyCustomerAtChurnListHeaderName();
        Assert.assertEquals(heading, "Customers at risk of churn", "Customer at risk churn list header is not available");
    }

    @Test(priority = 6)
    public void verifyExportUnderlyingSalesData() {
        customerChurnPredictionAIAnalytics.exportUnderlyingSalesDataButtonClick();
    }

    @Test(priority = 7)
    public void verifySelectMinimumPurchaseCount() {
        String value = "5";
        customerChurnPredictionAIAnalytics.changeMinimumPurchaseCount(value);
    }

    @Test(priority = 8)
    public void verifyGoToSalesPage() {
        salesAIAnalytics = customerChurnPredictionAIAnalytics.salesLinkClick();
    }

    @Test(priority = 9)
    public void verifyGoToSegmentsPage() {
        customerSegmentsByRFMT = customerChurnPredictionAIAnalytics.segmentLinkClick();
    }

    @Test(priority = 10)
    public void verifyGoToProductsPage() {
        productsAIAnalytics = customerChurnPredictionAIAnalytics.productLinkClick();
    }

    @Test(priority = 11)
    public void verifyGoToTrendsPage() {
        trendsAIAnalytics = customerChurnPredictionAIAnalytics.trendsLinkClick();
    }

    @Test(priority = 12)
    public void verifyGoToDemographicsPage() {
        demographicAIAnalytics = customerChurnPredictionAIAnalytics.demographicLinkClick();
    }

    @Test(priority = 13)
    public void verifyGoToTargetAudience() {
        targetAudienceAIAnalytics = customerChurnPredictionAIAnalytics.targetAudienceLinkClick();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
