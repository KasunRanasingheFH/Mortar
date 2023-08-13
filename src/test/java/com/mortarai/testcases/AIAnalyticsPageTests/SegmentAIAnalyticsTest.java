package com.mortarai.testcases.AIAnalyticsPageTests;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SalesAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SegmentsAIAnalytics;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.LoginPage;
import com.mortarportal.qa.pages.NavigationBar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SegmentAIAnalyticsTest extends TestBase {
    LoginPage loginPage;
    NavigationBar navigationBar;
    DashboardPage dashboardPage;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics;
    SalesAIAnalytics salesAIAnalytics;
    SegmentsAIAnalytics segmentsAIAnalytics;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPredictionAIAnalytics = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
        segmentsAIAnalytics = customerChurnPredictionAIAnalytics.segmentLinkClick();
    }

    @Test(priority = 1)
    public void segmentPageTitleTest() {
        String title = segmentsAIAnalytics.verifyPageTitle();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
        System.out.println("Title is match");
    }

//    @Test(priority = 2)
//    public void verifiedDownloadUnderlyingSalesData() throws InterruptedException, IOException {
//        Thread.sleep(15000);
//        segmentsAIAnalytics.clickOnExportUnderlyingSalesData();
//        Thread.sleep(5000);
//        checkDownloadedFiles(prop.getProperty("ExportUnderlyingSalesDataDownloadFileName"));
////        isFileDownloaded("Mortar_processed_sales_data",".csv",200);
//    }

    @Test(priority = 3)
    public void verifiedOneOffIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkOneOffIsDisable();
        Assert.assertFalse(isDisable, "One-Off is Disable");
        /*String isEnable = segmentsAIAnalytics.checkOneOffIsDisable();
        if(isEnable.equals("false")){
            System.out.println(isEnable);
            System.out.println("One-Off is Enabled");
        }
        System.out.println(isEnable);
        System.err.println("One-Off is Disabled");*/

    }

    @Test(priority = 3)
    public void verifiedOneOffIsSelected() {
        boolean isSelected = segmentsAIAnalytics.checkOneOffIsSelected();
        System.out.println(isSelected);
        Assert.assertTrue(isSelected, "One-Off is Not Selected");

    /*    String isEnable = segmentsAIAnalytics.checkOneOffIsSelected();
        if(isEnable.equals("false")){
            System.out.println(isEnable);
            System.out.println("One-Off is Enabled");
        }
        System.err.println("One-Off is Disabled");
    }*/
    }

    @Test(priority = 3)
    public void verifySelectOneOffWhenNotSelectedAndEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkOneOffIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkOneOffIsSelected();
        if (!isDisable && !isSelected) {
            segmentsAIAnalytics.clickOnOneOffTab();
        } else if (isSelected) {
            System.out.println("One-Off is Already selected");
        } else if (isDisable) {
            System.err.println("One-Off is Disable");
        }

    }

    @Test(priority = 4)
    public void verifiedLapsedIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkLapsedIsDisable();
        Assert.assertFalse(isDisable, "Lapsed is Disable");
    }

    @Test(priority = 4)
    public void verifiedLapsedIsSelected() {
        boolean isSelected = segmentsAIAnalytics.checkLapsedIsSelected();
        Assert.assertTrue(isSelected, "Lapsed is Not Selected");
    }

    @Test(priority = 4)
    public void verifySelectLapsedWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = segmentsAIAnalytics.checkLapsedIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkLapsedIsSelected();
        if (!isDisable && !isSelected) {
            segmentsAIAnalytics.clickOnLapsedTab();
            Thread.sleep(5000);
        } else if (isSelected) {
            System.out.println("Lapsed is Already selected");
        } else if (isDisable) {
            System.err.println("Lapsed is Disable");
        }

    }

    @Test(priority = 5)
    public void verifiedDormantIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkDormantIsDisable();
        Assert.assertFalse(isDisable, "Dormant is Disable");
    }

    @Test(priority = 5)
    public void verifiedDormantIsSelected() {
        boolean isSelected = segmentsAIAnalytics.checkDormantIsSelected();
        Assert.assertTrue(isSelected, "Dormant is Not Selected");
    }

    @Test(priority = 5)
    public void verifySelectDormantWhenNotSelectedAndEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkDormantIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkDormantIsSelected();
        if (!isDisable && !isSelected) {
            segmentsAIAnalytics.clickOnDormantTab();
        } else if (isSelected) {
            System.out.println("Dormant is Already selected");
        } else if (isDisable) {
            System.err.println("Dormant is Disable");
        }

    }
    @Test(priority = 6)
    public void verifiedNewIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkNewIsDisable();
        Assert.assertFalse(isDisable, "New is Disable");
    }

    @Test(priority = 6)
    public void verifiedNewIsSelected() {
        boolean isSelected = segmentsAIAnalytics.checkNewIsSelected();
        Assert.assertTrue(isSelected, "New is Not Selected");
    }

    @Test(priority = 6)
    public void verifySelectNewWhenNotSelectedAndEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkNewIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkNewIsSelected();
        if (!isDisable && !isSelected) {
            segmentsAIAnalytics.clickOnNewTab();
        } else if (isSelected) {
            System.out.println("New is Already selected");
        } else if (isDisable) {
            System.err.println("New is Disable");
        }

    }

    @Test(priority = 7)
    public void verifiedCommittedIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkCommittedIsDisable();
        Assert.assertFalse(isDisable, "Committed is Disable");
    }

    @Test(priority = 7)
    public void verifiedCommittedIsSelected() {
        boolean isSelected = segmentsAIAnalytics.checkCommittedIsSelected();
        Assert.assertTrue(isSelected, "Committed is Not Selected");
    }

    @Test(priority = 7)
    public void verifySelectCommittedWhenNotSelectedAndEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkCommittedIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkCommittedIsSelected();
        if (!isDisable && !isSelected) {
            segmentsAIAnalytics.clickOnCommittedTab();
        } else if (isSelected) {
            System.out.println("Committed is Already selected");
        } else if (isDisable) {
            System.err.println("Committed is Disable");
        }
    }
    @Test(priority = 8)
    public void verifiedVIPIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkVIPIsDisable();
        Assert.assertFalse(isDisable, "VIP is Disable");
    }

    @Test(priority = 8)
    public void verifiedVIPIsSelected() {
        boolean isSelected = segmentsAIAnalytics.checkVIPIsSelected();
        Assert.assertTrue(isSelected, "VIP is Not Selected");
    }

    @Test(priority = 8)
    public void verifySelectVIPWhenNotSelectedAndEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkVIPIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkVIPIsSelected();
        if (!isDisable && !isSelected) {
            segmentsAIAnalytics.clickOnVIPTab();
        } else if (isSelected) {
            System.out.println("VIP is Already selected");
        } else if (isDisable) {
            System.err.println("VIP is Disable");
        }

    }
    @Test(priority = 9)
    public void verifiedSporadicVIPIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkSporadicVIPIsDisable();
        Assert.assertFalse(isDisable, "Sporadic VIP is Disable");
    }

    @Test(priority = 9)
    public void verifiedSporadicVIPIsSelected() {
        boolean isSelected = segmentsAIAnalytics.checkSporadicVIPIsSelected();
        Assert.assertTrue(isSelected, "Sporadic VIP is Not Selected");
    }

    @Test(priority = 9)
    public void verifySelectSporadicVIPWhenNotSelectedAndEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkSporadicVIPIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkSporadicVIPIsSelected();
        if (!isDisable && !isSelected) {
            segmentsAIAnalytics.clickOnSporadicVIPTab();
        } else if (isSelected) {
            System.out.println("Sporadic VIP is Already selected");
        } else if (isDisable) {
            System.err.println("Sporadic VIP is Disable");
        }

    }


}
