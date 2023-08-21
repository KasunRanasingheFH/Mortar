package com.mortarai.testcases.AIAnalyticsPageTests.SegmentAIAnalyticsTest;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SalesAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab.*;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.LoginPage;
import com.mortarportal.qa.pages.NavigationBar;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

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

    @Test(priority = 2)
    public void verifiedDownloadUnderlyingSalesData() throws InterruptedException, IOException {
        Thread.sleep(15000);
        segmentsAIAnalytics.clickOnExportUnderlyingSalesData();
        Thread.sleep(5000);
        checkDownloadedFiles(prop.getProperty("ExportUnderlyingSalesDataDownloadFileName"));
//        isFileDownloaded("Mortar_processed_sales_data",".csv",200);
    }

    @Test(priority = 3)
    public void verifiedOneOffIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkOneOffIsDisable();
        Assert.assertFalse(isDisable, "One-Off is Disable");
        boolean isEnable = segmentsAIAnalytics.checkOneOffIsDisable();
        if (isEnable) {
            System.out.println(isEnable);
            System.out.println("One-Off is Enabled");
        }
        System.out.println(isEnable);
        System.err.println("One-Off is Disabled");
    }

    @Test(priority = 4)
    public void verifiedOneOffIsSelected() throws InterruptedException {
        //Verify One Off Page is Selected
        segmentsAIAnalytics.verifyOneOffPage();
        //Total Customer Card
        segmentsAIAnalytics.verifyTotalOneOffCustomersCardDisplaying();
        //Common Cards
        segmentsAIAnalytics.verifyCardsOneOff();
        //Common Graphs
        segmentsAIAnalytics.verifyGraphsOneOff();
    }

    @Test(priority = 5)
    public void verifySelectOneOffWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = segmentsAIAnalytics.checkOneOffIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkOneOffIsSelected();
        if (!isDisable && !isSelected) {
            segmentsAIAnalytics.clickOnOneOffTab();
            segmentsAIAnalytics.verifyOneOffPage();
            segmentsAIAnalytics.verifyTotalOneOffCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsOneOff();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsOneOff();
        } else if (isSelected) {
            System.out.println("One-Off is Already selected");
            //Verify One Off Page is Selected
            segmentsAIAnalytics.verifyOneOffPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalOneOffCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsOneOff();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsOneOff();
        } else if (isDisable) {
            System.err.println("One-Off is Disable");
        }

    }

    @Test(priority = 6)
    public void verifiedLapsedIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkLapsedIsDisable();
        Assert.assertFalse(isDisable, "Lapsed is Disable");
    }

    @Test(priority = 7)
    public void verifiedLapsedIsSelected() throws InterruptedException {
        //Verify Lapsed Page
        segmentsAIAnalytics.verifyLapsedPage();
        //Total Customer Card
        segmentsAIAnalytics.verifyTotalLapsedCustomersCardDisplaying();
        //Common Cards
        segmentsAIAnalytics.verifyCardsLapsed();
        //Common Graphs
        segmentsAIAnalytics.verifyGraphsLapsed();
    }

    @Test(priority = 8)
    public void verifySelectLapsedWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = segmentsAIAnalytics.checkLapsedIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkLapsedIsSelected();
        System.out.println(!isSelected);
        System.out.println(isDisable);
        if ((!isDisable) && !isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickOnLapsedTab();
            Thread.sleep(1000);
            //Verify Lapsed Page
            segmentsAIAnalytics.verifyLapsedPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalLapsedCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsLapsed();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsLapsed();
        } else if (isSelected) {
            System.out.println("Lapsed is Already selected");
            /*boolean isDisplaying = segmentsAIAnalytics.totalLapsedCustomerPageHeaderIsDisplaying();
            Assert.assertTrue(isDisplaying, "Not in the Navigated to Lapsed Page");*/
            //Verify Lapsed Page
            segmentsAIAnalytics.verifyLapsedPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalLapsedCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsLapsed();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsLapsed();
        } else if (isDisable) {
            System.err.println("Lapsed is Disable");
        }

    }

    @Test(priority = 9)
    public void verifiedDormantIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkDormantIsDisable();
        Assert.assertFalse(isDisable, "Dormant is Disable");
    }

    @Test(priority = 10)
    public void verifiedDormantIsSelected() throws InterruptedException {
        //Verify Dormant Page
        segmentsAIAnalytics.verifyDormantPage();
        //Total Customer Card
        segmentsAIAnalytics.verifyTotalDormantCustomersCardDisplaying();
        //Common Cards
        segmentsAIAnalytics.verifyCardsDormant();
        //Common Graphs
        segmentsAIAnalytics.verifyGraphsDormant();
    }

    @Test(priority = 11)
    public void verifySelectDormantWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = segmentsAIAnalytics.checkDormantIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkDormantIsSelected();
        if (!isDisable && !isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickOnDormantTab();
            //Verify Dormant Page
            segmentsAIAnalytics.verifyDormantPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalDormantCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsDormant();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsDormant();
        } else if (isSelected) {
            System.out.println("Dormant is Already selected");
            //Verify Dormant Page
            segmentsAIAnalytics.verifyDormantPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalDormantCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsDormant();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsDormant();
        } else if (isDisable) {
            System.err.println("Dormant is Disable");
        }

    }

    @Test(priority = 12)
    public void verifiedNewIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkNewIsDisable();
        Assert.assertFalse(isDisable, "New is Disable");
    }

    @Test(priority = 13)
    public void verifiedNewIsSelected() throws InterruptedException {
        //Verify New Page
        segmentsAIAnalytics.verifyNewPage();
        //Total Customer Card
        segmentsAIAnalytics.verifyTotalNewCustomersCardDisplaying();
        //Common Cards
        segmentsAIAnalytics.verifyCardsNew();
        //Common Graphs
        segmentsAIAnalytics.verifyGraphsNew();
    }

    @Test(priority = 14)
    public void verifySelectNewWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = segmentsAIAnalytics.checkNewIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkNewIsSelected();
        if (!isDisable && !isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickOnNewTab();
            //Verify New Page
            segmentsAIAnalytics.verifyNewPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalNewCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsNew();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsNew();
        } else if (isSelected) {
            System.out.println("New is Already selected");
            //Verify New Page
            segmentsAIAnalytics.verifyNewPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalNewCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsNew();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsNew();
        } else if (isDisable) {
            System.err.println("New is Disable");
        }

    }

    @Test(priority = 15)
    public void verifiedCommittedIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkCommittedIsDisable();
        Assert.assertFalse(isDisable, "Committed is Disable");
    }

    @Test(priority = 16)
    public void verifiedCommittedIsSelected() throws InterruptedException {
        //Verify Committed Page
        segmentsAIAnalytics.verifyCommittedPage();
        //Total Customer Card
        segmentsAIAnalytics.verifyTotalCommittedCustomersCardDisplaying();
        //Common Cards
        segmentsAIAnalytics.verifyCardsCommitted();
        //Common Graphs
        segmentsAIAnalytics.verifyGraphsCommitted();
    }

    @Test(priority = 17)
    public void verifySelectCommittedWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = segmentsAIAnalytics.checkCommittedIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkCommittedIsSelected();
        if (!isDisable && !isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickOnCommittedTab();
            //Verify Committed Page
            segmentsAIAnalytics.verifyCommittedPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalCommittedCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsCommitted();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsCommitted();
        } else if (isSelected) {
            System.out.println("Committed is Already selected");
            //Verify Committed Page
            segmentsAIAnalytics.verifyCommittedPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalCommittedCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsCommitted();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsCommitted();
        } else if (isDisable) {
            System.err.println("Committed is Disable");
        }
    }

    @Test(priority = 18)
    public void verifiedVIPIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkVIPIsDisable();
        Assert.assertFalse(isDisable, "VIP is Disable");
    }

    @Test(priority = 19)
    public void verifiedVIPIsSelected() throws InterruptedException {
        //Verify VIP Page
        segmentsAIAnalytics.verifyVIPPage();
        //Total Customer Card
        segmentsAIAnalytics.verifyTotalVIPCustomersCardDisplaying();
        //Common Cards
        segmentsAIAnalytics.verifyCardsVIP();
        //Common Graphs
        segmentsAIAnalytics.verifyGraphsVIP();
    }

    @Test(priority = 20)
    public void verifySelectVIPWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = segmentsAIAnalytics.checkVIPIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkVIPIsSelected();
        if (!isDisable && !isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickOnVIPTab();
            //Verify VIP Page
            segmentsAIAnalytics.verifyVIPPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalVIPCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsVIP();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsVIP();
        } else if (isSelected) {
            System.out.println("VIP is Already selected");
            //Verify VIP Page
            segmentsAIAnalytics.verifyVIPPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalVIPCustomersCardDisplaying();
            //Common Cards
//            vipTabInSegment.verifyCommonCardsDisplaying();
            segmentsAIAnalytics.verifyCardsVIP();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsVIP();
        } else if (isDisable) {
            System.err.println("VIP is Disable");
        }

    }

    @Test(priority = 21)
    public void verifiedSporadicVIPIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkSporadicVIPIsDisable();
        Assert.assertFalse(isDisable, "Sporadic VIP is Disable");
    }

    @Test(priority = 22)
    public void verifiedSporadicVIPIsSelected() throws InterruptedException {
        //Verify Sporadic VIP Page
        segmentsAIAnalytics.verifySporadicVIPPage();
        //Total Customer Card
        segmentsAIAnalytics.verifyTotalSporadicVIPCustomersCardDisplaying();
        //Common Cards
        segmentsAIAnalytics.verifyCardsSporadicVIP();
        //Common Graphs
        segmentsAIAnalytics.verifyGraphsSporadicVIP();
    }

    @Test(priority = 23)
    public void verifySelectSporadicVIPWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = segmentsAIAnalytics.checkSporadicVIPIsDisable();
        boolean isSelected = segmentsAIAnalytics.checkSporadicVIPIsSelected();
        if (!isDisable && !isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickOnSporadicVIPTab();
            //Verify Sporadic VIP Page
            segmentsAIAnalytics.verifySporadicVIPPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalSporadicVIPCustomersCardDisplaying();
            //Common Cards
//            sporadicVIPTabInSegment.verifyCommonCardsDisplaying();
            segmentsAIAnalytics.verifyCardsSporadicVIP();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsSporadicVIP();
        } else if (isSelected) {
            System.out.println("Sporadic VIP is Already selected");
            //Verify Sporadic VIP Page
            segmentsAIAnalytics.verifySporadicVIPPage();
            //Total Customer Card
            segmentsAIAnalytics.verifyTotalSporadicVIPCustomersCardDisplaying();
            //Common Cards
            segmentsAIAnalytics.verifyCardsSporadicVIP();
            //Common Graphs
            segmentsAIAnalytics.verifyGraphsSporadicVIP();
        } else if (isDisable) {
            System.err.println("Sporadic VIP is Disable");
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
