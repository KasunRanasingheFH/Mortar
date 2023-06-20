package com.mortarai.testcases;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.*;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertising.FacebookAdvertisingPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BusinessOverviewTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    //    ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    MyCustomer myCustomer;
    Intergrations intergrations;
    EmailsAndJourneys emailsAndJourneys;
//    SocialAndDisplayAdvertising socialAndDisplayAdvertising;
    FacebookAdvertisingPage facebookAdvertisingPage;
    DigitalMediaBuying digitalMediaBuying;
    MyCreatives myCreatives;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalyticsTest;

    public BusinessOverviewTest() {
        super();
    }

    //  Test Case should be Separated -- independent with each other
    //  before each test case -- launch the browser and login
    //  @test -- execute test cases
    //  after each test case -- close the browser
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
    }

    @Test(priority = 1)
    public void verifyClientDashboardTest() {
//        testUtil.switchToFrame();

        String businessOverviewPageText = businessOverview.verifyBusinessOverviewPageText();
        Assert.assertEquals(businessOverviewPageText, "Business Overview","Not in the Business Overview Page");

    }

    @Test(priority = 2)
    public void verifyBusinessOwnerIDTest() {
//        testUtil.switchToFrame();
//        Assert.assertTrue(clientDashboard.verifyBusinessOwnerID("B&M-SankaXYZ"));
        Assert.assertTrue(businessOverview.verifyBusinessOwnerID(prop.getProperty("brandName")));
    }

    @Test(priority = 3)
    public void verifyClickGoToBusinessOverviewTest() {
//        testUtil.switchToFrame();
        businessOverview = businessOverview.clickOnGoToBusinessOverview();
    }

    @Test(priority = 4)
    public void verifyClickGoToAIAnalyticsTest() {
//        testUtil.switchToFrame();
        customerChurnPredictionAIAnalyticsTest = businessOverview.clickOnGoToAIAnalytics();
    }

    @Test(priority = 5)
    public void verifyClickGoToMyCustomerTest() {
//        testUtil.switchToFrame();
        myCustomer = businessOverview.clickOnGoToMyCustomer();
    }

    @Test(priority = 6)
    public void verifyClickGoToIntegrationsTest() {
//        testUtil.switchToFrame();
        intergrations = businessOverview.clickOnGoToIntergrations();
    }

    @Test(priority = 7)
    public void verifyClickGoToEmailsAndJourneysTest() {
//        testUtil.switchToFrame();
        emailsAndJourneys = businessOverview.clickOnGoToEmailsAndJourneys();
    }

    @Test(priority = 8)
    public void verifyClickGoToSocialAndDisplayAdvertisingTest() {
//        testUtil.switchToFrame();
        facebookAdvertisingPage = businessOverview.clickOnGoToSocialAndDisplayAdvertising();
    }

    @Test(priority = 9)
    public void verifyClickGoToDigitalMediaBuyingTest() {
//        testUtil.switchToFrame();
        digitalMediaBuying = businessOverview.clickOnGoToDigitalMediaBuying();
    }

    @Test(priority = 10)
    public void verifyClickGoToMyCreativesTest() {
//        testUtil.switchToFrame();
        myCreatives = businessOverview.clickOnGoToMyCreatives();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
