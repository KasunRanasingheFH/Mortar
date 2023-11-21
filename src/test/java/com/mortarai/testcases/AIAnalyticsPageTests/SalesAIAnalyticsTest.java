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
        customerChurnPredictionAIAnalytics = new CustomerChurnPredictionAIAnalytics();
    }

    @Test(priority = 1)
    public void verifySalesAIAnalyticsTitle() {
        String title = salesAIAnalytics.verifyMortarTitleSalesTab();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }
    @Test(priority = 2)
    public void verifiedAIAnalyticsHeader() {
        boolean isDisplayingAIAnalyticsHeader = salesAIAnalytics.validateAIAnalyticsHeader();
        Assert.assertTrue(isDisplayingAIAnalyticsHeader, "You are not In AI Analytics section");
        System.out.println("Verify in AI Analytics");
    }

    @Test(priority = 3)
    public void verifiedSalesTabIsEnabled() {
        boolean isDisable = salesAIAnalytics.salesTabIsEnabled();
        Assert.assertFalse(isDisable, "Products Tab is not Enable");
        System.out.println("Products Tab Is Enabled");
    }

    @Test(priority = 4)
    public void verifiedSalesTabIsSelected() {
        boolean isSelected = salesAIAnalytics.salesTabIsSelected();
        Assert.assertTrue(isSelected, "Products Tab is not Selected");
        System.out.println("Products Tab Is Selected");
    }

    @Test(priority = 5)
    public void verifyExportUnderlyingSalesData() {
        customerChurnPredictionAIAnalytics.exportUnderlyingSalesDataButtonClick();
    }
    @Test(priority = 6)
    public void verifiedAverageHourlySalesGraphHeader() {
        boolean isDisplaying = salesAIAnalytics.verifyAverageHourlySalesGraphHeader();
        Assert.assertTrue(isDisplaying, "Average Hourly Sales Graph is not available");
    }

    @Test(priority = 7)
    public void verifiedAverageDailySalesGraphHeader() {
        boolean isDisplaying = salesAIAnalytics.verifyAverageDailySalesGraphHeader();
        Assert.assertTrue(isDisplaying, "Average Daily Sales Graph is not available");
    }

    @Test(priority = 8)
    public void verifiedAverageMonthlySalesGraphHeader() {
        boolean isDisplaying = salesAIAnalytics.verifyAverageMonthlySalesGraphHeader();
        Assert.assertTrue(isDisplaying, "Average Monthly sales graph is not available");
    }

    @Test(priority = 9)
    public void verifiedYearlySalesByQuarter() {
        boolean isDisplaying = salesAIAnalytics.verifyYearlySalesByQuarter();
        Assert.assertTrue(isDisplaying, "Yearly Sales By Quarter graph is not available");
    }

    @Test(priority = 10)
    public void verifiedSelectedYear2020InYearlySalesByQuarter() throws InterruptedException {
        String value = salesAIAnalytics.verifyValueYear2020InYearlySalesByQuarter();
        Thread.sleep(10000);
        Assert.assertEquals(value, "true", "Not selected 2020");
    }

    @Test(priority = 11)
    public void verifiedSelectedYear2021InYearlySalesByQuarter() {
        String value = salesAIAnalytics.verifyValueYear2021InYearlySalesByQuarter();
        Assert.assertEquals(value, "true", "Not selected 2021");
    }

    @Test(priority = 12)
    public void verifiedSelectedYear2022InYearlySalesByQuarter() {
        String value = salesAIAnalytics.verifyValue2022InYearlySalesByQuarter();
        Assert.assertEquals(value, "true", "Not selected 2022");
    }

    @Test(priority = 13)
    public void verifiedSelectedYear2023InYearlySalesByQuarter() {
        String value = salesAIAnalytics.verifyValue2023InYearlySalesByQuarter();
        Assert.assertEquals(value, "true", "Not selected 2023");
    }

    @Test(priority = 14)
    public void verifiedSelectYear2020InYearlySalesByQuarterIfNotSelected() {
        String value = salesAIAnalytics.verifyValueYear2020InYearlySalesByQuarter();
        if (value.equals("false")) {
            salesAIAnalytics.verifySelectYear2020InYearlySalesByQuarter();
        } else {
            Assert.assertEquals(value, "true", "Not selected 2020");
            System.out.println("Already selected 2020 in graph");
        }
    }

    @Test(priority = 15)
    public void verifiedSelectYear2021InYearlySalesByQuarterIfNotSelected() {
        String value = salesAIAnalytics.verifyValueYear2021InYearlySalesByQuarter();
        if (value.equals("false")) {
            salesAIAnalytics.verifySelectYear2021InYearlySalesByQuarter();
        } else {
            Assert.assertEquals(value, "true", "Not selected 2021");
            System.out.println("Already selected 2021 in graph");
        }
    }

    @Test(priority = 16)
    public void verifiedSelectYear2022InYearlySalesByQuarterIfNotSelected() {
        String value = salesAIAnalytics.verifyValue2022InYearlySalesByQuarter();
        if (value.equals("false")) {
            salesAIAnalytics.verifySelect2022InYearlySalesByQuarter();
        } else {
            Assert.assertEquals(value, "true", "Not selected 2022");
            System.out.println("Already selected 2022 in graph");
        }
    }

    @Test(priority = 17)
    public void verifiedSelectYear2023InYearlySalesByQuarterIfNotSelected() throws InterruptedException {
        String value = salesAIAnalytics.verifyValue2023InYearlySalesByQuarter();
        if (value.equals("false")) {
            salesAIAnalytics.verifySelect2023InYearlySalesByQuarter();
        } else {
            Assert.assertEquals(value, "true", "Not selected 2023");
            System.out.println("Already selected 2023 in graph");
        }
    }

    @Test(priority = 18)
    public void verifiedUnselectYear2020InYearlySalesByQuarterIfSelected() throws InterruptedException {
        String value = salesAIAnalytics.verifyValueYear2020InYearlySalesByQuarter();
        System.out.println(value);
        if (value.equals("true")) {
            Thread.sleep(1000);
            salesAIAnalytics.verifySelectYear2020InYearlySalesByQuarter();
            Thread.sleep(10000);
        } else {
            Assert.assertEquals(value, "true", "Not selected 2020");
            System.out.println("Already selected 2020 in graph");

        }
    }

    @Test(priority = 19)
    public void verifiedUnselectYear2021InYearlySalesByQuarterIfSelected() {
        String value = salesAIAnalytics.verifyValueYear2021InYearlySalesByQuarter();
        if (value.equals("true")) {
            salesAIAnalytics.verifySelectYear2021InYearlySalesByQuarter();
        } else {
            Assert.assertEquals(value, "true", "Not selected 2021");
            System.out.println("Already selected 2021 in graph");
        }
    }

    @Test(priority = 20)
    public void verifiedUnselectYear2022InYearlySalesByQuarterIfSelected() {
        String value = salesAIAnalytics.verifyValue2022InYearlySalesByQuarter();
        if (value.equals("true")) {
            salesAIAnalytics.verifySelect2022InYearlySalesByQuarter();
        } else {
            Assert.assertEquals(value, "true", "Not selected 2022");
            System.out.println("Already selected 2022 in graph");
        }
    }

    @Test(priority = 21)
    public void verifiedUnselectYear2023InYearlySalesByQuarterIfSelected() {
        String value = salesAIAnalytics.verifyValue2023InYearlySalesByQuarter();
        if (value.equals("true")) {
            salesAIAnalytics.verifySelect2023InYearlySalesByQuarter();
        } else {
            Assert.assertEquals(value, "true", "Not selected 2023");
            System.out.println("Already selected 2023 in graph");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
