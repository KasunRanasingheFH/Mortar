package com.mortarai.testcases.Integration;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SalesAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab.CustomerSegmentByProductCategoryInSegment;
import com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab.SegmentsAIAnalytics;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.Integrations.Integrations;
import com.mortarportal.qa.pages.LoginPage;
import com.mortarportal.qa.pages.NavigationBar;
import io.cucumber.java.sl.In;
import org.testng.Assert;
import org.testng.annotations.*;

public class IntegrationTest extends TestBase {
    LoginPage loginPage;
    NavigationBar navigationBar;
    DashboardPage dashboardPage;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics;
    SalesAIAnalytics salesAIAnalytics;
    SegmentsAIAnalytics segmentsAIAnalytics;
    CustomerSegmentByProductCategoryInSegment customerSegmentByProductCategoryInSegment;
    Integrations integrations;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        integrations = navigationBar.clickOnGoToIntegrations();
    }

    @Test(priority = 1)
    public void IntegrationPageTitleTest() {
        String title = integrations.verifyPageTitle();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
