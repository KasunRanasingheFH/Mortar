import com.mortarportal.qa.base.TestBase;

import com.mortarportal.qa.pages.*;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.DigitalMediaBuyingPages.CampaignReportingPage;
import com.mortarportal.qa.pages.DigitalMediaBuyingPages.CreatNewCampaignPage;
import com.mortarportal.qa.pages.EmailsAndJourneysPages.EmailsAndJourney.SingleMailingPage;
import com.mortarportal.qa.pages.Integrations.Integrations;
import com.mortarportal.qa.pages.MyCustomers.MyCustomer;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.FacebookAdvertisingPage;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.GoogleAnalyticsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NavigationBarTest extends TestBase {
    LoginPage loginPage;
    NavigationBar navigationBar;
    DashboardPage dashboardPage;
    BusinessOverview businessOverview;
    MyCustomer myCustomer;
    Integrations integrations;
    SingleMailingPage singleMailingPage;
    FacebookAdvertisingPage facebookAdvertisingPage;
    GoogleAnalyticsPage googleAnalyticsPage;
    CampaignReportingPage campaignReportingPage;
    CreatNewCampaignPage creatNewCampaignPage;
    MyCreatives myCreatives;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalyticsTest;
    public NavigationBarTest() {
        super();
    }

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        navigationBar = new NavigationBar();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void BusinessOverviewPageTitleTest() {
        String title = businessOverview.validateBusinessOverviewPageTitle();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }

    @Test(priority = 2)
    public void verifyNavigationBarIsAvailable() throws InterruptedException {
        Thread.sleep(2000);
        boolean isAvailable = navigationBar.verifyNavigationBarIsAvailable();
        Assert.assertTrue(isAvailable, "Navigation bar is Not Available");
    }

    @Test(priority = 3)
    public void verifiedGoToBusinessOverview() {
         businessOverview = navigationBar.clickOnGoToBusinessOverview();
         boolean isDisplaying = businessOverview.verifyBusinessOverviewPageHeader();
         Assert.assertTrue(isDisplaying,"Business Overview Page is not Available");
        System.out.println("Navigate To BusinessOverview");
    }

    @Test(priority = 4)
    public void verifiedGoToAIAnalytics() throws InterruptedException {
        Thread.sleep(2000);
        customerChurnPredictionAIAnalyticsTest = navigationBar.clickOnGoToCustomerChurnPredictionAIAnalytics();
        System.out.println("Navigate to Customer Churn Prediction AI Analytics");
        Thread.sleep(2000);
    }
    @Test(priority = 5)
    public void verifyClickGoToMyCustomerPageTest() throws InterruptedException {
//        testUtil.switchToFrame();
        myCustomer = navigationBar.clickOnGoToMyCustomer();
        System.out.println("Navigate to My Customer");
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void verifyClickGoToIntegrationsPageTest() throws InterruptedException {
//        testUtil.switchToFrame();
        integrations = navigationBar.clickOnGoToIntegrations();
        System.out.println("Navigate to Integrations");
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void verifyClickToOpenSubMenuEmailsAndJourneysPageTest() throws InterruptedException {
//        testUtil.switchToFrame();
        navigationBar.clickOnOpenSubMenuEmailsAndJourneys();
        System.out.println("Navigate to Mails And Journeys Sub Menu ");
        Thread.sleep(5000);
    }
    @Test(priority = 8)
    public void verifiedClickToGoToSingleMailingInEmailsAndJourney() throws InterruptedException {
        navigationBar.clickOnOpenSubMenuEmailsAndJourneys();
        System.out.println("Navigate to Mails And Journeys Sub Menu ");
        Thread.sleep(5000);
        navigationBar.clickOnGoToSingleMailingInEmailsAndJourneyPage();
        Thread.sleep(5000);
        System.out.println("Navigate to Single Mailing Page in Mails And Journeys");
    }
    @Test(priority = 9)
    public void verifiedClickGoToKlaviyoDashboardInEmailsAndJourney() throws InterruptedException {
        navigationBar.clickOnOpenSubMenuEmailsAndJourneys();
        System.out.println("Navigate to Mails And Journeys Sub Menu ");
        Thread.sleep(5000);
        navigationBar.clickOnGoToKlaviyoDashboardPage();
        Thread.sleep(5000);
        System.out.println("Navigate to Klaviyo Dashboard Page in Mails And Journeys");
    }


    @Test(priority = 10)
    public void VerifyOpeningSocialDisplayAdvertisingSubNavBar() {
        navigationBar.clickOnOpenSubMenuNavSocialDisplayAdvertising();
        System.out.println("Navigate to Social Display Advertising Sub Navigation Bar");
    }

    @Test(priority = 11)
    public void verifyClickGoToFacebookAdvertisingPageTest() {
//        testUtil.switchToFrame();
        navigationBar.clickOnOpenSubMenuNavSocialDisplayAdvertising();
        facebookAdvertisingPage = navigationBar.clickOnGoToFacebookAdvertisingPage();
        System.out.println("Navigate to Facebook Advertising");
    }

    @Test(priority = 12)
    public void verifyClickGoToGoogleAnalyticsPageTest() {
//        testUtil.switchToFrame();
        navigationBar.clickOnOpenSubMenuNavSocialDisplayAdvertising();
        googleAnalyticsPage = navigationBar.clickOnGoToGoogleAnalyticsReportingPage();
        System.out.println("Navigate to Google Analytics Reporting");
    }

    @Test(priority = 13)
    public void VerifyOpeningDigitalMediaBuyingSubNavBar() {
        navigationBar.clickOnToOpenSubNavDigitalMediaBuying();
        System.out.println("Navigate to Digital Media Buying Sub Navigation Bar");
    }

    @Test(priority = 14)
    public void verifyClickGoToCampaignReportingPageTest() {
//        testUtil.switchToFrame();
        navigationBar.clickOnToOpenSubNavDigitalMediaBuying();
        campaignReportingPage = navigationBar.clickOnGoToCampaignReportingPage();
        System.out.println("Navigate to Campaign Reporting");
    }

    @Test(priority = 15)
    public void verifyClickGoToCreatACampaignPageTest() {
//        testUtil.switchToFrame();
        navigationBar.clickOnToOpenSubNavDigitalMediaBuying();
        creatNewCampaignPage = navigationBar.clickOnGoToCreatNewCampaignPage();
        System.out.println("Navigate to Create New CampaignPage");
    }

    @Test(priority = 16)
    public void verifyClickGoToMyCreativesTest() {
//        testUtil.switchToFrame();
        myCreatives = navigationBar.clickOnGoToMyCreatives();
        System.out.println("Navigate to My Creatives");
    }

}
