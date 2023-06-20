package com.mortarportal.qa.testcases.AIAnalyticsPageTests;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.*;
import com.mortarportal.qa.pages.AIAnalyticsPages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerChurnPredictionAIAnalyticsTest extends TestBase {
    //NAV BAR
    LoginPage loginPage;
    DashboardPage dashboardPage;
//    ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    AIAnalytics aiAnalytics;
    MyCustomer myCustomer;
    Intergrations intergrations;
    EmailsAndJourneys emailsAndJourneys;
    SocialAndDisplayAdvertising socialAndDisplayAdvertising;
    DigitalMediaBuying digitalMediaBuying;
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
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.clickOnGoToClientsBusinessOverView();
        aiAnalytics = businessOverview.clickOnGoToAIAnalytics();
        customerChurnPredictionAIAnalytics = aiAnalytics.clickOnGoToCustomerChurnPredictionAIAnalytics();
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
