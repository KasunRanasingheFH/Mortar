package com.mortarai.testcases.AIAnalyticsPageTests;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SalesAIAnalytics;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.LoginPage;
import com.mortarportal.qa.pages.NavigationBar;
import org.testng.Assert;
import org.testng.annotations.*;

public class SalesAIAnalyticsTest extends TestBase {
    LoginPage loginPage;
    NavigationBar navigationBar;
    DashboardPage dashboardPage;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics;
    SalesAIAnalytics salesAIAnalytics;
    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPredictionAIAnalytics = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
        salesAIAnalytics = customerChurnPredictionAIAnalytics.salesLinkClick();
    }
    @Test(priority = 1)
    public void verifySalesAIAnalyticsTitle(){
        String title = salesAIAnalytics.verifyMortarTitleSalesTab();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }
    @Test(priority = 2)
    public void verifiedAverageHourlySalesGraphHeader(){
        boolean isDisplaying = salesAIAnalytics.verifyAverageHourlySalesGraphHeader();
        Assert.assertTrue(isDisplaying,"Average Hourly Sales Graph is not available");
    }
    @Test(priority = 3)
    public void verifiedAverageDailySalesGraphHeader(){
        boolean isDisplaying = salesAIAnalytics.verifyAverageDailySalesGraphHeader();
        Assert.assertTrue(isDisplaying,"Average Daily Sales Graph is not available");
    }
    @Test(priority = 4)
    public void verifiedAverageMonthlySalesGraphHeader(){
        boolean isDisplaying = salesAIAnalytics.verifyAverageMonthlySalesGraphHeader();
        Assert.assertTrue(isDisplaying,"Average Monthly sales graph is not available");
    }
    @Test(priority = 5)
    public void verifiedYearlySalesByQuarter(){
        boolean isDisplaying = salesAIAnalytics.verifyYearlySalesByQuarter();
        Assert.assertTrue(isDisplaying,"Yearly Sales By Quarter graph is not available");
    }
    @Test(priority = 6)
    public void verifiedSelectYear2020InYearlySalesByQuarter() throws InterruptedException {
        String value = salesAIAnalytics.verifyValueYear2020InYearlySalesByQuarter();
        Thread.sleep(10000);
        Assert.assertEquals(value,"true","Not selected 2020");
    }
    @Test(priority = 6)
    public void verifiedSelectYear2021InYearlySalesByQuarter(){
        String value = salesAIAnalytics.verifyValueYear2021InYearlySalesByQuarter();
        Assert.assertEquals(value,"true","Not selected 2020");
    }
    @Test(priority = 6)
    public void verifiedSelectYear2022InYearlySalesByQuarter(){
        String value = salesAIAnalytics.verifyValue2022InYearlySalesByQuarter();
        Assert.assertEquals(value,"true","Not selected 2020");
    }
    @Test(priority = 6)
    public void verifiedSelectYear2023InYearlySalesByQuarter(){
        String value = salesAIAnalytics.verifyValue2023InYearlySalesByQuarter();
        Assert.assertEquals(value,"true","Not selected 2020");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
