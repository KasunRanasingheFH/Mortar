package com.mortarai.testcases.AIAnalyticsPageTests;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.DemographicAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.ProductsAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SalesAIAnalytics;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.LoginPage;
import com.mortarportal.qa.pages.NavigationBar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProductsAIAnalyticsTest extends TestBase {
    LoginPage loginPage;
    NavigationBar navigationBar;
    DashboardPage dashboardPage;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    ProductsAIAnalytics productsAIAnalytics;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics;
    SalesAIAnalytics salesAIAnalytics;
    DemographicAIAnalytics demographicAIAnalytics;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPredictionAIAnalytics = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
        productsAIAnalytics = customerChurnPredictionAIAnalytics.productLinkClick();
        customerChurnPredictionAIAnalytics = new CustomerChurnPredictionAIAnalytics();
    }

    @Test(priority = 1)
    public void verifiedDemographicAIAnalyticsTitle() {
        String title = productsAIAnalytics.verifyMortarTitleProductsTab();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }

    @Test(priority = 2)
    public void verifiedAIAnalyticsHeader() {
        boolean isDisplayingAIAnalyticsHeader = productsAIAnalytics.validateAIAnalyticsHeader();
        Assert.assertTrue(isDisplayingAIAnalyticsHeader, "You are not In AI Analytics section");
        System.out.println("Verify in AI Analytics");
    }

    @Test(priority = 3)
    public void verifiedProductTabIsEnabled() {
        boolean isDisable = productsAIAnalytics.productTabIsEnabled();
        Assert.assertFalse(isDisable, "Products Tab is not Enable");
        System.out.println("Products Tab Is Enabled");
    }

    @Test(priority = 3)
    public void verifiedProductTabIsSelected() {
        boolean isSelected = productsAIAnalytics.productTabIsSelected();
        Assert.assertTrue(isSelected, "Products Tab is not Selected");
        System.out.println("Products Tab Is Selected");
    }

    @Test(priority = 5)
    public void verifiedExportUnderlyingSalesData() {
        customerChurnPredictionAIAnalytics.exportUnderlyingSalesDataButtonClick();
    }

    @Test(priority = 6)
    public void verifiedTop10ProductsHeader() {
        boolean isDisplaying = productsAIAnalytics.verifyTop10ProductsHeader();
        Assert.assertTrue(isDisplaying, "Top 10 Product Header Is Not Displaying");
    }

    @Test(priority = 7)
    public void verifiedTop10ProductsCanvas() {
        boolean isDisplaying = productsAIAnalytics.verifyTop10ProductsCanvas();
        Assert.assertTrue(isDisplaying, "Top 10 Product Canvas Is Not Displaying");
    }

    @Test(priority = 8)
    public void verifiedTop10ProductsQuantityIsAvailable() {
        boolean isDisplaying = productsAIAnalytics.verifyTop10ProductsQuantityIsAvailable();
        Assert.assertTrue(isDisplaying, "Top 10 Product Quantity Is Not Displaying");
    }

    @Test(priority = 9)
    public void verifiedTop10ProductsRevenueIsAvailable() {
        boolean isDisplaying = productsAIAnalytics.verifyTop10ProductsRevenueIsAvailable();
        Assert.assertTrue(isDisplaying, "Top 10 Product Revenue Is Not Displaying");
    }

    @Test(priority = 10)
    public void verifiedBottom10ProductsHeader() {
        boolean isDisplaying = productsAIAnalytics.verifyBottom10ProductsHeader();
        Assert.assertTrue(isDisplaying, "Bottom 10 Product Header Is Not Displaying");
    }

    @Test(priority = 11)
    public void verifiedBottom10ProductsCanvas() {
        boolean isDisplaying = productsAIAnalytics.verifyBottom10ProductsCanvas();
        Assert.assertTrue(isDisplaying, "Bottom 10 Product Canvas Is Not Displaying");
    }

    @Test(priority = 12)
    public void verifiedBottom10ProductsQuantityIsAvailable() {
        boolean isDisplaying = productsAIAnalytics.verifyBottom10ProductsQuantityIsAvailable();
        Assert.assertTrue(isDisplaying, "Bottom 10 Product Quantity Is Not Displaying");
    }

    @Test(priority = 13)
    public void verifiedBottom10ProductsRevenueIsAvailable() {
        boolean isDisplaying = productsAIAnalytics.verifyBottom10ProductsRevenueIsAvailable();
        Assert.assertTrue(isDisplaying, "Bottom 10 Product Revenue Is Not Displaying");
    }

    @Test(priority = 14)
    public void verifiedTop10ProductsFilterByQuantity() {
        productsAIAnalytics.verifyTop10ProductsFilterByQuantity();
    }

    @Test(priority = 15)
    public void verifiedTop10ProductsFilterByRevenue() {
        productsAIAnalytics.verifyTop10ProductsFilterByRevenue();
    }

    @Test(priority = 16)
    public void verifiedBottom10ProductsFilterByQuantity() {
        productsAIAnalytics.verifyBottom10ProductsFilterByQuantity();
    }

    @Test(priority = 17)
    public void verifiedBottom10ProductsFilterByRevenue() {
        productsAIAnalytics.verifyBottom10ProductsFilterByRevenue();
    }

    @Test(priority = 18)
    public void verifiedExportAllData() throws InterruptedException {
        productsAIAnalytics.verifyExportAllData();
    }

    @Test(priority = 19)
    public void verifiedExportFilteredData() throws InterruptedException {
        productsAIAnalytics.verifyExportFilteredData();
    }
}
