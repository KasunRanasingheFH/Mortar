package com.mortarai.testcases;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.*;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.DigitalMediaBuyingPages.CampaignReportingPage;
import com.mortarportal.qa.pages.DigitalMediaBuyingPages.CreatNewCampaignPage;
import com.mortarportal.qa.pages.EmailsAndJourneysPages.SingleMailingPage;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.FacebookAdvertisingPage;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.GoogleAnalyticsPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class BusinessOverviewTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    BusinessOverview businessOverview;
    MyCustomer myCustomer;
    Intergrations intergrations;
    SingleMailingPage singleMailingPage;
    FacebookAdvertisingPage facebookAdvertisingPage;
    GoogleAnalyticsPage googleAnalyticsPage;
    CampaignReportingPage campaignReportingPage;
    CreatNewCampaignPage creatNewCampaignPage;
    MyCreatives myCreatives;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalyticsTest;

    public BusinessOverviewTest() {
        super();
    }

    //  Test Case should be Separated -- independent with each other
    //  before each test case -- launch the browser and login
    //  @test -- execute test cases
    //  after each test case -- close the browser
    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = businessOverview.validateBusinessOverviewPageTitle();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }

    @Test(priority = 2)
    public void verifyClientDashboardTest() {
//        testUtil.switchToFrame();

        String businessOverviewPageText = businessOverview.verifyBusinessOverviewPageText();
        Assert.assertEquals(businessOverviewPageText, "Business Overview", "Not in the Business Overview Page");

    }

    @Test(priority = 3)
    public void verifyBusinessOwnerIDTest() {
//        testUtil.switchToFrame();
//        Assert.assertTrue(clientDashboard.verifyBusinessOwnerID("B&M-SankaXYZ"));
        Assert.assertTrue(businessOverview.verifyBusinessOwnerID(prop.getProperty("brandName")));
    }

    @Test(priority = 4)
    public void verifyClickGoToBusinessOverviewPageTest() {
//        testUtil.switchToFrame();
        businessOverview = businessOverview.clickOnGoToBusinessOverview();
    }

    @Test(priority = 5)
    public void verifyClickGoToAIAnalyticsPageTest() {
//        testUtil.switchToFrame();
        customerChurnPredictionAIAnalyticsTest = businessOverview.clickOnGoToAIAnalytics();
    }

    @Test(priority = 6)
    public void verifyClickGoToMyCustomerPageTest() {
//        testUtil.switchToFrame();
        myCustomer = businessOverview.clickOnGoToMyCustomer();
    }

    @Test(priority = 7)
    public void verifyClickGoToIntegrationsPageTest() {
//        testUtil.switchToFrame();
        intergrations = businessOverview.clickOnGoToIntergrations();
    }

    @Test(priority = 8)
    public void verifyClickGoToEmailsAndJourneysPageTest() {
//        testUtil.switchToFrame();
        singleMailingPage = businessOverview.clickOnGoToEmailsAndJourneys();
    }

    @Test(priority = 9)
    public void VerifyOpeningSocialDisplayAdvertisingSubNavBar() {
        businessOverview.clickOnNavSocialDisplayAdvertisingLink();
    }

    @Test(priority = 10)
    public void verifyClickGoToFacebookAdvertisingPageTest() {
//        testUtil.switchToFrame();
        facebookAdvertisingPage = businessOverview.clickOnGoToFacebookAdvertisingPage();
    }

    @Test(priority = 11)
    public void verifyClickGoToGoogleAnalyticsPageTest() {
//        testUtil.switchToFrame();
        googleAnalyticsPage = businessOverview.clickOnGoToAIAnalyticsPage();
    }

    @Test(priority = 12)
    public void VerifyOpeningDigitalMediaBuyingSubNavBar() {
        businessOverview.clickOnNavDigitalMediaBuying();
    }

    @Test(priority = 13)
    public void verifyClickGoToCampaignReportingPageTest() {
//        testUtil.switchToFrame();
        campaignReportingPage = businessOverview.clickOnGoToCampaignReportingPage();
    }

    @Test(priority = 14)
    public void verifyClickGoToCreatACampaignPageTest() {
//        testUtil.switchToFrame();
        creatNewCampaignPage = businessOverview.clickOnGoToCreatNewCampaignPage();
    }

    @Test(priority = 15)
    public void verifyClickGoToMyCreativesTest() {
//        testUtil.switchToFrame();
        myCreatives = businessOverview.clickOnGoToMyCreatives();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
