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
    NavigationBar navigationBar;
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
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
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
    public void verifyBusinessOverviewPage() {
//        testUtil.switchToFrame();

        boolean businessOverviewPageText = businessOverview.verifyBusinessOverviewPageText();
        Assert.assertTrue(businessOverviewPageText, "Not in the Business Overview Page");

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
    public void verifyAIAnalyticsPageTest() {
//        testUtil.switchToFrame();
        customerChurnPredictionAIAnalyticsTest = navigationBar.clickOnGoToCustomerChurnPredictionAIAnalytics();
    }

    @Test(priority = 6)
    public void verifyClickGoToMyCustomerPageTest() {
//        testUtil.switchToFrame();
        myCustomer = navigationBar.clickOnGoToMyCustomer();
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


    //Verify Graphs Available
    @Test(priority = 16)
    public void verifiedConversionGraphsHeading() {
        Assert.assertTrue(businessOverview.verifyConversionGraphHeader(), "Conversion graph  not displaying");
    }

    @Test(priority = 16)
    public void verifiedSalesGraphInConversionHeading() {

        Assert.assertTrue(businessOverview.verifySalesGraphInConversionHeader(), "Sales Graph not displaying");
    }

    @Test(priority = 17)
    public void verifiedMailingListSubscriptionGraphInHeading() {

        Assert.assertTrue(businessOverview.verifyMailingListSubscriptionGraphInConversionHeader(), "Mailing List " +
                "Subscription Graph is Not displaying");

    }

    @Test(priority = 18)
    public void verifiedNewContactGraphHeading() {

        String errorMessage = "New Contact Graph not displaying";
        Assert.assertTrue(businessOverview.verifyNewContactGraph(), "New Contact graph is not displaying");

    }

    @Test(priority = 19)
    public void verifiedCustomerSpendersGraphHeading() {

        String errorMessage = "Customer(Spenders) Graph not displaying";
        Assert.assertTrue(businessOverview.verifyCustomerSpendersGraphHeading(), errorMessage);
    }

    @Test(priority = 20)
    public void verifiedBasketSummaryGraphHeading() {

        Assert.assertTrue(businessOverview.verifyBasketSummaryGraphHeading(), "Basket Summary is " +
                "Graph not displaying");
    }

    @Test(priority = 21)
    public void verifiedBestPerformingProductGraphHeading() {
        Assert.assertTrue(businessOverview.verifyBestPerformingProductGraphHeading(), "Best " +
                "performing product is Graph not displaying");
    }

    //Sales Graph
    @Test(priority = 22)
    public void verifiedWooComDataInSalesGraph() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        Assert.assertTrue(businessOverview.verifyWooComIsInSalesDataGraph(), "Woocommerce Data is not " +
                "Available in Sales graph");

    }

    @Test(priority = 23)
    public void verifiedMyObDataInSalesGraph() {
        businessOverview.verifyClickOnSelectOptionDropDown();

        Assert.assertTrue(businessOverview.verifyMyObIsInSalesDataGraph(), "Myob Data is not " +
                "Available in Sales graph");
    }

    @Test(priority = 24)
    public void verifiedMailChimpInSalesGraph() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        Assert.assertTrue(businessOverview.verifyMyObIsInSalesDataGraph(), "Myob Data is not " +
                "Available in Sales graph");

    }

    @Test(priority = 25)
    public void verifiedWooComDataIsSelectedInSalesGraph() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        Assert.assertTrue(businessOverview.verifyWooComCheckBoxCheckedInSales(), "Woocommerce Data is not " +
                "Selected in Sales graph");
    }

    @Test(priority = 26)
    public void verifiedMyObDataIsSelectedInSalesGraph() throws InterruptedException {
        businessOverview.verifyClickOnSelectOptionDropDown();
        Thread.sleep(2000);
        boolean isSelected = businessOverview.verifyMyObCheckBoxCheckedSales();
        Assert.assertTrue(isSelected, "Myob Data is not " +
                "Selected in Sales graph");
    }

    @Test(priority = 27)
    public void verifiedUnselectWooComDataInSales() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        boolean isSelected = businessOverview.verifyUnselectWooComCheckBox();
        Assert.assertFalse(isSelected, "Woocommerce data is checkbox didnt unselected");
    }

    @Test(priority = 28)
    public void verifiedUnselectMyObDataInSales() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        boolean isSelected = businessOverview.verifyUnselectMyObCheckBox();
        Assert.assertFalse(isSelected, "Myob data is checkbox didnt unselected");
    }

    //Mailing List Subscription Graph
    @Test(priority = 29)
    public void verifiedWooComDataInMailing() {
        businessOverview.verifyClickOnSelectOptionDropdownInMailing();
        Assert.assertTrue(businessOverview.verifyWooComDataInMailingGraph(), "Woocommerce Data is not " +
                "Available in Mailing graph");
    }

    @Test(priority = 30)
    public void verifiedMyObDataInMailing() {
        businessOverview.verifyClickOnSelectOptionDropdownInMailing();
        Assert.assertTrue(businessOverview.verifyMyObDataInMailing(), "Myob Data is not " +
                "Available in Sales graph");
    }

    @Test(priority = 31)
    public void verifiedOmniSendInMailing() {
        businessOverview.verifyClickOnSelectOptionDropdownInMailing();
        Assert.assertTrue(businessOverview.verifyOmniSendDataInMailing(), "Omnisend Data is not " +
                "Available in Sales graph");
    }

    @Test(priority = 32)
    public void verifiedWooComDataIsSelectedInMailing() throws InterruptedException {
        businessOverview.verifyClickOnSelectOptionDropdownInMailing();
        Thread.sleep(2500);
        Assert.assertTrue(businessOverview.verifyWooComCheckBoxCheckedInMailing(), "Woocommerce Data is not " +
                "Selected in Mailing graph");
    }

    @Test(priority = 33)
    public void verifiedMyObDataIsSelectedInMailing() throws InterruptedException {
        businessOverview.verifyClickOnSelectOptionDropdownInMailing();
        Thread.sleep(2000);
        boolean isSelected = businessOverview.verifyMyObCheckBoxCheckedMailing();
        Assert.assertTrue(isSelected, "Myob Data is not " +
                "Selected in Mailing graph");

    }
    @Test(priority = 34)
    public void verifiedBestPerformingProductsIsInQuantity() {
        boolean isSelect = businessOverview.verifyBestPerformingProductsInQuantity();
        Assert.assertTrue(isSelect,"Best Performing Products data are not in Quantity");
    }
    @Test(priority = 35)
    public void verifiedBestPerformingProductsIsInRevenue() {
        boolean isSelect = businessOverview.verifyBestPerformingProductsInRevenue();
        Assert.assertTrue(isSelect,"Best Performing Products data are not in Revenue");
    }
    @Test(priority = 36)
    public void verifiedSelectBestPerformingProductsToQuantity() {
        businessOverview.verifyQuantityRadioButtonClick();
        boolean isSelect = businessOverview.verifyBestPerformingProductsInQuantity();
        Assert.assertTrue(isSelect,"Best Performing Products data are not in Quantity");
    }
    @Test(priority = 37)
    public void verifiedSelectBestPerformingProductsToRevenue() {
        businessOverview.verifyRevenueRadioButtonClick();
        boolean isSelect = businessOverview.verifyBestPerformingProductsInRevenue();
        Assert.assertTrue(isSelect,"Best Performing Products data are not in Revenue");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
