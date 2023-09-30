package com.mortarai.testcases.AIAnalyticsPageTests.SegmentAIAnalyticsTest;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SalesAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab.CustomerSegmentByProductCategoryInSegment;
import com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab.SegmentsAIAnalytics;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.LoginPage;
import com.mortarportal.qa.pages.NavigationBar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CustomerSegmentByProductCategoryInSegmentTest extends TestBase {
    LoginPage loginPage;
    NavigationBar navigationBar;
    DashboardPage dashboardPage;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics;
    SalesAIAnalytics salesAIAnalytics;
    SegmentsAIAnalytics segmentsAIAnalytics;
    CustomerSegmentByProductCategoryInSegment customerSegmentByProductCategoryInSegment;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPredictionAIAnalytics = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
        segmentsAIAnalytics = customerChurnPredictionAIAnalytics.segmentLinkClick();
        customerSegmentByProductCategoryInSegment = segmentsAIAnalytics.clickOnCustomerSegmentByProduct();
    }
    @Test(priority = 1)
    public void customerSegmentByProductCategoryInSegmentPageTitleTest() {
        String title = customerSegmentByProductCategoryInSegment.verifyPageTitle();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
        System.out.println("Title is match");
    }
    @Test(priority = 2)
    public void verifiedHeaderOfCustomerSegmentByProductsTest() throws InterruptedException {
//        testUtil.switchToFrame();
        Thread.sleep(3000);
        Assert.assertTrue(customerSegmentByProductCategoryInSegment.verifyHeaderOfCustomerSegmentByProductCategory());
        System.out.println("Verified the Segment by Product category");
    }


}
