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
        customerChurnPredictionAIAnalyticsTest = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
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

    @Test(priority = 16)
    public void verifiedConversionGraphsHeading() {
        try {
            Assert.assertTrue(businessOverview.verifyConversionGraphHeader(), "Conversion graph  not displaying");
        } catch (Exception e) {
            System.out.println("Conversion Graph is Not displaying");
        }
    }

    @Test(priority = 16)
    public void verifiedSalesGraphInConversionHeading() {
        try {
            Assert.assertTrue(businessOverview.verifySalesGraphInConversionHeader(), "Sales Graph not displaying");
        } catch (Exception e) {
            System.out.println("Sales Graph not displaying");
        }
    }

    @Test(priority = 17)
    public void verifiedMailingListSubscriptionGraphInHeading() {
        try {
            Assert.assertTrue(businessOverview.verifyMailingListSubscriptionGraphInConversionHeader(), "Mailing List " +
                    "Subscription Graph is Not displaying");
        } catch (Exception e) {
            System.out.println("Mailing List Subscription Graph is Not displaying");
        }
    }

    @Test(priority = 18)
    public void verifiedNewContactGraphHeading() {
        try {
            String errorMessage = "New Contact Graph not displaying";
            Assert.assertTrue(businessOverview.verifyNewContactGraph(), "New Contact graph is not displaying");
        } catch (Exception e) {
            System.out.println("New Contact Graph is Not displaying");
        }
    }

    @Test(priority = 19)
    public void verifiedCustomerSpendersGraphHeading() {
        try {
            String errorMessage = "Customer(Spenders) Graph not displaying";
            Assert.assertTrue(businessOverview.verifyCustomerSpendersGraphHeading(), errorMessage);
        } catch (Exception e) {
            System.out.println("Customer(Spenders) Graph is Not displaying");
        }
    }

    @Test(priority = 20)
    public void verifiedBasketSummaryGraphHeading() {
        try {
            Assert.assertTrue(businessOverview.verifyBasketSummaryGraphHeading(), "Basket Summary is " +
                    "Graph not displaying");
        } catch (Exception e) {
            System.out.println("Basket Summary is Graph not displaying");
        }
    }

    @Test(priority = 21)
    public void verifiedBestPerformingProductGraph() {
        try {
            Assert.assertTrue(businessOverview.verifyBestPerformingProductGraphHeading(), "Best " +
                    "performing product is Graph not displaying");
        } catch (Exception e) {
            System.out.println("Best performing product is Graph not displaying");
        }
    }

    @Test(priority = 22)
    public void verifiedWooComDataInSalesGraph() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        try {
            Assert.assertTrue(businessOverview.verifyWooComIsInSalesDataGraph(), "Woocommerce Data is not " +
                    "Available in Sales graph");
        } catch (Exception e) {
            System.out.println("Woocommerce Data is not Available in Sales graph");
        }
    }

    @Test(priority = 23)
    public void verifiedMyObDataInSalesGraph() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        try {
            Assert.assertTrue(businessOverview.verifyMyObIsInSalesDataGraph(), "Myob Data is not " +
                    "Available in Sales graph");
        } catch (Exception e) {
            System.out.println("Myob Data is not Available in Sales graph");
        }
    }

    @Test(priority = 22)
    public void verifiedWooComDataIsSelectedInSalesGraph() {
        try {
            Assert.assertTrue(businessOverview.verifyWooComCheckBoxChecked(), "Woocommerce Data is not " +
                    "Available in Sales graph");
        } catch (Exception e) {
            System.out.println("Woocommerce Data is not Available in Sales graph");
        }
    }

    @Test(priority = 23)
    public void verifiedMyObDataIsSelectedInSalesGraph() {
        boolean isSelected = businessOverview.verifyWooComCheckBoxChecked();
        if (isSelected) {
            Assert.assertTrue(businessOverview.verifyMyObCheckBoxChecked(), "Myob Data is not " +
                    "Available in Sales graph");
        }
        System.out.println("Myob Data is not Available in Sales graph");

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
