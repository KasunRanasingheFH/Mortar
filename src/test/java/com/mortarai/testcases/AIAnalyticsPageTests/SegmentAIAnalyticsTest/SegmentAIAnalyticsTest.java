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
    public void verifiedCustomerSegmentByRFMTIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkCustomerSegmentByRFMTIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By RFMT is Disable");
    }

    @Test(priority = 4)
    public void verifiedCustomerSegmentByRFMTIsSelected() {
        boolean isDisable = segmentsAIAnalytics.checkCustomerSegmentByRFMTIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By RFMT is Disable");
        boolean isSelected = segmentsAIAnalytics.checkCustomerSegmentByRFMTIsSelected();
        Assert.assertTrue(isSelected, "Customer Segment By RFMT is not Selected");
    }

    @Test(priority = 5)
    public void verifiedClickOnCustomerSegmentByRFMT() {
        boolean isDisable = segmentsAIAnalytics.checkCustomerSegmentByRFMTIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By RFMT is Disable");
        segmentsAIAnalytics.clickCustomerSegmentByRFMT();
        boolean isSelected = segmentsAIAnalytics.checkCustomerSegmentByRFMTIsSelected();
        Assert.assertTrue(isSelected, "Customer Segment By RFMT is not Selected");
    }

    @Test(priority = 6)
    public void verifiedCustomerSegmentByProductIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkCustomerSegmentByProductIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By Product is Disable");
    }

    @Test(priority = 7)
    public void verifiedCustomerSegmentByProductsIsSelected() {
        boolean isDisable = segmentsAIAnalytics.checkCustomerSegmentByProductIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By Product is Disable");
        boolean isSelected = segmentsAIAnalytics.checkCustomerSegmentByProductIsSelected();
        Assert.assertTrue(isSelected, "Customer Segment By Product is not Selected");
    }

    @Test(priority = 8)
    public CustomerSegmentByProductCategoryInSegment verifiedClickOnCustomerSegmentByProduct() throws InterruptedException {
        boolean isDisable = segmentsAIAnalytics.checkCustomerSegmentByProductIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By Product is Disable");
        Thread.sleep(5000);
        segmentsAIAnalytics.clickOnCustomerSegmentByProduct();
        boolean isSelected = segmentsAIAnalytics.checkCustomerSegmentByProductIsSelected();
        Assert.assertTrue(isSelected, "Customer Segment By Product is not Selected");
        return new CustomerSegmentByProductCategoryInSegment();
    }

    @Test(priority = 9)
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

    @Test(priority = 10)
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

    @Test(priority = 11)
    public void verifiedTotalCustomerRadioButtonIsSelected() {
        boolean isSelected = segmentsAIAnalytics.isSelectedTotalCustomerRadioBut();
        System.out.println(isSelected);
        segmentsAIAnalytics.isSelectedTotalCustomerRadioBut();
        Assert.assertTrue(isSelected, "Total Customer of One-Off is not selected");

    }

    @Test(priority = 12)
    public void verifiedBasedOnMarketingPreferencesRadioButtonIsSelected() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        System.out.println(isSelected);
        Assert.assertTrue(isSelected, "Based On Marketing Preferences of One-Off is not selected");
    }

    @Test(priority = 13)
    public void verifiedTotalCustomerRadioButtonSelectWhenNotSelect() {
        boolean isSelected = segmentsAIAnalytics.isSelectedTotalCustomerRadioBut();
        System.out.println(isSelected);
        if (!isSelected) {
            segmentsAIAnalytics.clickTotalCustomerRadioBut();
            Assert.assertTrue(isSelected, "Total Customer of One-Off is not selected");
            System.out.println("Total Customer of One-Off is selected");
        } else {
            Assert.assertTrue(isSelected, "Total Customer of One-Off is not selected");
            System.out.println("Total Customer of One-Off is already selected");
        }
    }

    @Test(priority = 14)
    public void verifiedBasedOnMarketingPreferencesSelectWhenNotSelected() {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        System.out.println(isSelected);
        if (!isSelected) {
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is already selected");
        }
    }

    @Test(priority = 15)
    public void verifiedYesIsSelectedInBasedOnMarketingPreferences() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedYes = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedYes = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
        }
    }

    @Test(priority = 16)
    public void verifiedNoIsSelectedInBasedOnMarketingPreferences() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedNo, "No Is not selected on Based on Marketing Preferences");
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedNo, "No Is not selected on Based on Marketing Preferences");
        }
    }

    @Test(priority = 17)
    public void verifiedUnknownIsSelectedInBasedOnMarketingPreferences() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
        }
    }

    @Test(priority = 18)
    public void verifiedIfYesNotSelectedInBasedOnMarketingPreferencesSelectYes() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedYes = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
            if (!isSelectedYes) {
                segmentsAIAnalytics.clickYesInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is selected");
            } else {
                Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is already selected");
            }

        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedYes = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
            if (!isSelectedYes) {
                segmentsAIAnalytics.clickYesInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is selected");
            } else {
                Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is already selected");
            }
        }
    }

    @Test(priority = 19)
    public void verifiedIfYesISSelectedInBasedOnMarketingPreferencesUnselectYes() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedYes = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                Thread.sleep(1000);
                segmentsAIAnalytics.clickYesInBasedOnMarketingPreferences();
                boolean isSelectedYes1 = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedYes1, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is Unselected");
            } else {
                Assert.assertFalse(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is already unselected selected");
            }
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedYes = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                Thread.sleep(1000);
                segmentsAIAnalytics.clickYesInBasedOnMarketingPreferences();
                boolean isSelectedYes1 = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedYes1, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is Unselected");
            } else {
                Assert.assertFalse(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is already unselected selected");
            }
        }
    }

    @Test(priority = 20)
    public void verifiedIfNoISNotSelectedInBasedOnMarketingPreferencesSelectNo() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
            if (!isSelectedNo) {
                segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is selected");
            } else {
                Assert.assertTrue(isSelectedNo, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is already selected");
            }

        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
            if (!isSelectedNo) {
                segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is selected");
            } else {
                Assert.assertTrue(isSelectedNo, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is already selected");
            }
        }
    }

    @Test(priority = 21)
    public void verifiedIfNoISSelectedInBasedOnMarketingPreferencesUnselectNo() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
            if (isSelectedNo) {
                Thread.sleep(1000);
                segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is Unselected");
            } else {
                Assert.assertFalse(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                System.out.println("No Is already unselected selected");
            }
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
            if (isSelectedNo) {
                Thread.sleep(1000);
                segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is Unselected");
            } else {
                Assert.assertFalse(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                System.out.println("No Is already unselected selected");
            }
        }
    }

    @Test(priority = 22)
    public void verifiedIfUnknownISNotSelectedInBasedOnMarketingPreferencesSelectUnknown() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
            if (!isSelectedUnknown) {
                segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is selected");
            } else {
                Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is already selected");
            }

        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
            if (!isSelectedUnknown) {
                segmentsAIAnalytics.clickUnknownInBasedOnMarketingPreferences();
                boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is selected");
            } else {
                Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is already selected");
            }
        }
    }

    @Test(priority = 23)
    public void verifiedIfUnknownISSelectedInBasedOnMarketingPreferencesUnselectUnknown() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
            if (isSelectedUnknown) {
                Thread.sleep(1000);
                segmentsAIAnalytics.clickUnknownInBasedOnMarketingPreferences();
                boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is Unselected");
            } else {
                Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                System.out.println("Unknown Is already unselected selected");
            }
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
            if (isSelectedUnknown) {
                Thread.sleep(1000);
                segmentsAIAnalytics.clickUnknownInBasedOnMarketingPreferences();
                boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is Unselected");

            } else {
                Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                System.out.println("Unknown Is already unselected selected");
            }
        }
    }

    @Test(priority = 24)
    public void verifiedSelectAllWhenNotSelectedAllInBasedOnMarketingPreferencesSelect() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedYes = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                System.out.println("Yes is Selected");
                boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                if (!isSelectedNo) {
                    Thread.sleep(5000);
                    segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is selected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                } else {
                    boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is Already selected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        Thread.sleep(5000);
                        segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                }
            } else {
                System.out.println("Yes is already Selected");
                boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is Already selected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                } else {
                    Thread.sleep(1000);
                    segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is selected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                }
            }

        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedYes = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                System.out.println("Yes is Selected");
                boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                if (!isSelectedNo) {
                    Thread.sleep(5000);
                    segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is selected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                } else {
                    boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is Already selected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        Thread.sleep(5000);
                        segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                }
            } else {
                System.out.println("Yes is already Selected");
                boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is Already selected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                } else {
                    Thread.sleep(1000);
                    segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is selected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                }
            }
        }
    }

    @Test(priority = 25)
    public void verifiedUnSelectAllWhenSelectedAllInBasedOnMarketingPreferencesUnSelect() throws InterruptedException {
        boolean isSelected = segmentsAIAnalytics.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            segmentsAIAnalytics.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedYes = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                Thread.sleep(1000);
                segmentsAIAnalytics.clickYesInBasedOnMarketingPreferences();
                boolean isSelectedYes1 = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedYes1, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is Unselected");
                boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    Thread.sleep(1000);
                    segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                    System.out.println("No Is Unselected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        segmentsAIAnalytics.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is Unselected");
                    } else {
                        Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already unselected selected");
                    }
                } else {
                    Assert.assertFalse(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is already unselected selected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        segmentsAIAnalytics.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is Unselected");
                    } else {
                        Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already unselected selected");
                    }
                }

            } else {
                Assert.assertFalse(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is already unselected selected");
                boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    Thread.sleep(1000);
                    segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                    System.out.println("No Is Unselected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        segmentsAIAnalytics.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is Unselected");
                    } else {
                        Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already unselected selected");
                    }
                }
            }
        } else {
            boolean isSelectedYes = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                Thread.sleep(1000);
                segmentsAIAnalytics.clickYesInBasedOnMarketingPreferences();
                boolean isSelectedYes1 = segmentsAIAnalytics.isCheckedYesInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedYes1, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is Unselected");
                boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    Thread.sleep(1000);
                    segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                    System.out.println("No Is Unselected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        segmentsAIAnalytics.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is Unselected");
                    } else {
                        Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already unselected selected");
                    }
                } else {
                    Assert.assertFalse(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is already unselected selected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        segmentsAIAnalytics.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is Unselected");
                    } else {
                        Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already unselected selected");
                    }
                }

            } else {
                Assert.assertFalse(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is already unselected selected");
                boolean isSelectedNo = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    Thread.sleep(1000);
                    segmentsAIAnalytics.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = segmentsAIAnalytics.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                    System.out.println("No Is Unselected");
                    boolean isSelectedUnknown = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        segmentsAIAnalytics.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = segmentsAIAnalytics.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is Unselected");
                    } else {
                        Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already unselected selected");
                    }
                }
            }

        }

    }

    @Test(priority = 25)
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

    @Test(priority = 26)
    public void verifiedLapsedIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkLapsedIsDisable();
        Assert.assertFalse(isDisable, "Lapsed is Disable");
    }

    @Test(priority = 27)
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

    @Test(priority = 28)
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

    @Test(priority = 29)
    public void verifiedDormantIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkDormantIsDisable();
        Assert.assertFalse(isDisable, "Dormant is Disable");
    }

    @Test(priority = 30)
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

    @Test(priority = 31)
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

    @Test(priority = 32)
    public void verifiedNewIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkNewIsDisable();
        Assert.assertFalse(isDisable, "New is Disable");
    }

    @Test(priority = 33)
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

    @Test(priority = 34)
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

    @Test(priority = 35)
    public void verifiedCommittedIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkCommittedIsDisable();
        Assert.assertFalse(isDisable, "Committed is Disable");
    }

    @Test(priority = 36)
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

    @Test(priority = 37)
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

    @Test(priority = 38)
    public void verifiedVIPIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkVIPIsDisable();
        Assert.assertFalse(isDisable, "VIP is Disable");
    }

    @Test(priority = 39)
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

    @Test(priority = 40)
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

    @Test(priority = 41)
    public void verifiedSporadicVIPIsEnabled() {
        boolean isDisable = segmentsAIAnalytics.checkSporadicVIPIsDisable();
        Assert.assertFalse(isDisable, "Sporadic VIP is Disable");
    }

    @Test(priority = 42)
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

    @Test(priority = 43)
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
