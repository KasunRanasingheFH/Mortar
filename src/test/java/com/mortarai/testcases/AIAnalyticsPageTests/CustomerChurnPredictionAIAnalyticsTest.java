package com.mortarai.testcases.AIAnalyticsPageTests;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.*;
import com.mortarportal.qa.pages.AIAnalyticsPages.*;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.FacebookAdvertisingPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class CustomerChurnPredictionAIAnalyticsTest extends TestBase {
    //NAV BAR
    LoginPage loginPage;
    DashboardPage dashboardPage;
//    ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    MyCustomer myCustomer;
    Intergrations intergrations;
    FacebookAdvertisingPage facebookAdvertisingPage;
    MyCreatives myCreatives;

    //AI Analytics Page
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics;
    SalesAIAnalytics salesAIAnalytics;
    SegmentsAIAnalytics segmentsAIAnalytics;
    ProductsAIAnalytics productsAIAnalytics;
    TrendsAIAnalytics trendsAIAnalytics;
    DemographicAIAnalytics demographicAIAnalytics;
    TargetAudienceAIAnalytics targetAudienceAIAnalytics;


    public CustomerChurnPredictionAIAnalyticsTest(){
        super();
    }
    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPredictionAIAnalytics = businessOverview.clickOnGoToAIAnalytics();
    }

    @Test(priority = 1)
    public void verifyingCustomersAtChurnListDisplay() {
//        testUtil.switchToFrame();
//        String customerChurnTable = customerChurnPredictionAIAnalytics.verifyCustomersAtChurnListDisplay();
        Assert.assertTrue(customerChurnPredictionAIAnalytics.verifyCustomersAtChurnListDisplay());
    }
    @Test(priority = 2)
    public void verifySelectMinimumPurchaseCount(){
        String value = "5";
        customerChurnPredictionAIAnalytics.changeMinimumPurchaseCount(value);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
