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

public class CustomerSegmentsByRFMTTest extends TestBase {
    LoginPage loginPage;
    NavigationBar navigationBar;
    DashboardPage dashboardPage;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics;
    SalesAIAnalytics salesAIAnalytics;
    CustomerSegmentsByRFMT customerSegmentsByRFMT;
    CustomerSegmentByProductCategoryInSegment customerSegmentByProductCategoryInSegment;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboardPage.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPredictionAIAnalytics = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
        customerSegmentsByRFMT = customerChurnPredictionAIAnalytics.segmentLinkClick();
        customerChurnPredictionAIAnalytics = new CustomerChurnPredictionAIAnalytics();
    }

    @Test(priority = 1)
    public void segmentPageTitleTest() {
        String title = customerSegmentsByRFMT.verifyPageTitle();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
        System.out.println("Title is match");
    }

    @Test(priority = 2)
    public void verifiedAIAnalyticsHeader() {
        boolean isDisplayingAIAnalyticsHeader = customerSegmentsByRFMT.validateAIAnalyticsHeader();
        Assert.assertTrue(isDisplayingAIAnalyticsHeader, "You are not In AI Analytics section");
        System.out.println("Verify in AI Analytics");
    }

    @Test(priority = 3)
    public void verifiedCustomerChurnIsEnabled() {
        boolean isDisable = customerSegmentsByRFMT.segmentTabIsEnabled();
        Assert.assertFalse(isDisable, "Segments Tab is not Enable");
        System.out.println("Segments Tab Is Enabled");
    }

    @Test(priority = 4)
    public void verifiedCustomerChurnIsSelected() {
        boolean isSelected = customerSegmentsByRFMT.segmentTabIsSelected();
        Assert.assertTrue(isSelected, "Segments Tab is not Selected");
        System.out.println("Segments Tab Is Selected");
    }

    @Test(priority = 5)
    public void verifiedDownloadUnderlyingSalesData() throws InterruptedException, IOException {
        Thread.sleep(15000);
        customerSegmentsByRFMT.clickOnExportUnderlyingSalesData();
        Thread.sleep(5000);
        checkDownloadedFiles(prop.getProperty("ExportUnderlyingSalesDataDownloadFileName"));
//        isFileDownloaded("Mortar_processed_sales_data",".csv",200);
    }

    @Test(priority = 6)
    public void verifiedCustomerSegmentByRFMTIsEnabled() {
        boolean isDisable = customerSegmentsByRFMT.checkCustomerSegmentByRFMTIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By RFMT is Disable");
    }

    @Test(priority = 7)
    public void verifiedCustomerSegmentByRFMTIsSelected() {
        boolean isDisable = customerSegmentsByRFMT.checkCustomerSegmentByRFMTIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By RFMT is Disable");
        boolean isSelected = customerSegmentsByRFMT.checkCustomerSegmentByRFMTIsSelected();
        Assert.assertTrue(isSelected, "Customer Segment By RFMT is not Selected");
    }

    @Test(priority = 8)
    public void verifiedClickOnCustomerSegmentByRFMT() {
        boolean isDisable = customerSegmentsByRFMT.checkCustomerSegmentByRFMTIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By RFMT is Disable");
        customerSegmentsByRFMT.clickCustomerSegmentByRFMT();
        boolean isSelected = customerSegmentsByRFMT.checkCustomerSegmentByRFMTIsSelected();
        Assert.assertTrue(isSelected, "Customer Segment By RFMT is not Selected");
    }

    @Test(priority = 9)
    public void verifiedCustomerSegmentByProductIsEnabled() {
        boolean isDisable = customerSegmentsByRFMT.checkCustomerSegmentByProductIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By Product is Disable");
    }

    @Test(priority = 10)
    public void verifiedCustomerSegmentByProductsIsSelected() {
        boolean isDisable = customerSegmentsByRFMT.checkCustomerSegmentByProductIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By Product is Disable");
        boolean isSelected = customerSegmentsByRFMT.checkCustomerSegmentByProductIsSelected();
        Assert.assertTrue(isSelected, "Customer Segment By Product is not Selected");
    }

    @Test(priority = 11)
    public CustomerSegmentByProductCategoryInSegment verifiedClickOnCustomerSegmentByProduct() throws InterruptedException {
        boolean isDisable = customerSegmentsByRFMT.checkCustomerSegmentByProductIsDisable();
        Assert.assertFalse(isDisable, "Customer Segment By Product is Disable");
        Thread.sleep(5000);
        customerSegmentsByRFMT.clickOnCustomerSegmentByProduct();
        boolean isSelected = customerSegmentsByRFMT.checkCustomerSegmentByProductIsSelected();
        Assert.assertTrue(isSelected, "Customer Segment By Product is not Selected");
        return new CustomerSegmentByProductCategoryInSegment();
    }

    @Test(priority = 12)
    public void verifiedOneOffIsEnabled() {
        boolean isDisable = customerSegmentsByRFMT.checkOneOffIsDisable();
        Assert.assertFalse(isDisable, "One-Off is Disable");
        boolean isEnable = customerSegmentsByRFMT.checkOneOffIsDisable();
        if (isEnable) {
            System.out.println(isEnable);
            System.out.println("One-Off is Enabled");
        }
        System.out.println(isEnable);
        System.err.println("One-Off is Disabled");
    }

    @Test(priority = 13)
    public void verifiedOneOffIsSelected() throws InterruptedException {
        //Verify One Off Page is Selected
        customerSegmentsByRFMT.verifyOneOffPage();
        //Total Customer Card
        customerSegmentsByRFMT.verifyTotalOneOffCustomersCardDisplaying();
        //Common Cards
        customerSegmentsByRFMT.verifyCardsOneOff();
        //Common Graphs
        customerSegmentsByRFMT.verifyGraphsOneOff();
    }

    @Test(priority = 14)
    public void verifiedTotalCustomerRadioButtonIsSelected() {
        boolean isSelected = customerSegmentsByRFMT.isSelectedTotalCustomerRadioBut();
        System.out.println(isSelected);
        customerSegmentsByRFMT.isSelectedTotalCustomerRadioBut();
        Assert.assertTrue(isSelected, "Total Customer of One-Off is not selected");

    }

    @Test(priority = 15)
    public void verifiedBasedOnMarketingPreferencesRadioButtonIsSelected() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        System.out.println(isSelected);
        Assert.assertTrue(isSelected, "Based On Marketing Preferences of One-Off is not selected");
    }

    @Test(priority = 16)
    public void verifiedTotalCustomerRadioButtonSelectWhenNotSelect() {
        boolean isSelected = customerSegmentsByRFMT.isSelectedTotalCustomerRadioBut();
        System.out.println(isSelected);
        if (!isSelected) {
            customerSegmentsByRFMT.clickTotalCustomerRadioBut();
            Assert.assertTrue(isSelected, "Total Customer of One-Off is not selected");
            System.out.println("Total Customer of One-Off is selected");
        } else {
            Assert.assertTrue(isSelected, "Total Customer of One-Off is not selected");
            System.out.println("Total Customer of One-Off is already selected");
        }
    }

    @Test(priority = 17)
    public void verifiedBasedOnMarketingPreferencesSelectWhenNotSelected() {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        System.out.println(isSelected);
        if (!isSelected) {
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is already selected");
        }
    }

    @Test(priority = 18)
    public void verifiedYesIsSelectedInBasedOnMarketingPreferences() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedYes = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedYes = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
        }
    }

    @Test(priority = 19)
    public void verifiedNoIsSelectedInBasedOnMarketingPreferences() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedNo, "No Is not selected on Based on Marketing Preferences");
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedNo, "No Is not selected on Based on Marketing Preferences");
        }
    }

    @Test(priority = 20)
    public void verifiedUnknownIsSelectedInBasedOnMarketingPreferences() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
            Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
        }
    }

    @Test(priority = 21)
    public void verifiedIfYesNotSelectedInBasedOnMarketingPreferencesSelectYes() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedYes = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
            if (!isSelectedYes) {
                customerSegmentsByRFMT.clickYesInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is selected");
            } else {
                Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is already selected");
            }

        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedYes = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
            if (!isSelectedYes) {
                customerSegmentsByRFMT.clickYesInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is selected");
            } else {
                Assert.assertTrue(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is already selected");
            }
        }
    }

    @Test(priority = 22)
    public void verifiedIfYesISSelectedInBasedOnMarketingPreferencesUnselectYes() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedYes = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                Thread.sleep(1000);
                customerSegmentsByRFMT.clickYesInBasedOnMarketingPreferences();
                boolean isSelectedYes1 = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedYes1, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is Unselected");
            } else {
                Assert.assertFalse(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is already unselected selected");
            }
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedYes = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                Thread.sleep(1000);
                customerSegmentsByRFMT.clickYesInBasedOnMarketingPreferences();
                boolean isSelectedYes1 = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedYes1, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is Unselected");
            } else {
                Assert.assertFalse(isSelectedYes, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is already unselected selected");
            }
        }
    }

    @Test(priority = 23)
    public void verifiedIfNoISNotSelectedInBasedOnMarketingPreferencesSelectNo() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
            if (!isSelectedNo) {
                customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is selected");
            } else {
                Assert.assertTrue(isSelectedNo, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is already selected");
            }

        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
            if (!isSelectedNo) {
                customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is selected");
            } else {
                Assert.assertTrue(isSelectedNo, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is already selected");
            }
        }
    }

    @Test(priority = 24)
    public void verifiedIfNoISSelectedInBasedOnMarketingPreferencesUnselectNo() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
            if (isSelectedNo) {
                Thread.sleep(1000);
                customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is Unselected");
            } else {
                Assert.assertFalse(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                System.out.println("No Is already unselected selected");
            }
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
            if (isSelectedNo) {
                Thread.sleep(1000);
                customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                System.out.println("No Is Unselected");
            } else {
                Assert.assertFalse(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                System.out.println("No Is already unselected selected");
            }
        }
    }

    @Test(priority = 25)
    public void verifiedIfUnknownISNotSelectedInBasedOnMarketingPreferencesSelectUnknown() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
            if (!isSelectedUnknown) {
                customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is selected");
            } else {
                Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is already selected");
            }

        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
            if (!isSelectedUnknown) {
                customerSegmentsByRFMT.clickUnknownInBasedOnMarketingPreferences();
                boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is selected");
            } else {
                Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is already selected");
            }
        }
    }

    @Test(priority = 26)
    public void verifiedIfUnknownISSelectedInBasedOnMarketingPreferencesUnselectUnknown() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
            if (isSelectedUnknown) {
                Thread.sleep(1000);
                customerSegmentsByRFMT.clickUnknownInBasedOnMarketingPreferences();
                boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is Unselected");
            } else {
                Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                System.out.println("Unknown Is already unselected selected");
            }
        } else {
            Assert.assertTrue(isSelected, "Based on Marketing Preferences is Not selected");
            System.out.println("Based on Marketing Preferences is selected");
            boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
            if (isSelectedUnknown) {
                Thread.sleep(1000);
                customerSegmentsByRFMT.clickUnknownInBasedOnMarketingPreferences();
                boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                System.out.println("Unknown Is Unselected");

            } else {
                Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                System.out.println("Unknown Is already unselected selected");
            }
        }
    }

    @Test(priority = 27)
    public void verifiedSelectAllWhenNotSelectedAllInBasedOnMarketingPreferencesSelect() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedYes = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                System.out.println("Yes is Selected");
                boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                if (!isSelectedNo) {
                    Thread.sleep(5000);
                    customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is selected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                } else {
                    boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is Already selected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        Thread.sleep(5000);
                        customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                }
            } else {
                System.out.println("Yes is already Selected");
                boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is Already selected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                } else {
                    Thread.sleep(1000);
                    customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is selected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
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
            boolean isSelectedYes = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                System.out.println("Yes is Selected");
                boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                if (!isSelectedNo) {
                    Thread.sleep(5000);
                    customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is selected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                } else {
                    boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is Already selected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        Thread.sleep(5000);
                        customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                }
            } else {
                System.out.println("Yes is already Selected");
                boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo1, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is Already selected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertTrue(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is selected");
                    } else {
                        Assert.assertTrue(isSelectedUnknown, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already selected");
                    }
                } else {
                    Thread.sleep(1000);
                    customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                    Assert.assertTrue(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is selected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (!isSelectedUnknown) {
                        customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
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

    @Test(priority = 28)
    public void verifiedUnSelectAllWhenSelectedAllInBasedOnMarketingPreferencesUnSelect() throws InterruptedException {
        boolean isSelected = customerSegmentsByRFMT.isSelectedBasedOnMarketingPreferencesRadioBut();
        if (!isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickBasedOnMarketingPreferencesRadioBut();
            boolean isSelectedYes = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                Thread.sleep(1000);
                customerSegmentsByRFMT.clickYesInBasedOnMarketingPreferences();
                boolean isSelectedYes1 = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedYes1, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is Unselected");
                boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    Thread.sleep(1000);
                    customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                    System.out.println("No Is Unselected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        customerSegmentsByRFMT.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is Unselected");
                    } else {
                        Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already unselected selected");
                    }
                } else {
                    Assert.assertFalse(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is already unselected selected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        customerSegmentsByRFMT.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
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
                boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    Thread.sleep(1000);
                    customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                    System.out.println("No Is Unselected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        customerSegmentsByRFMT.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is Unselected");
                    } else {
                        Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already unselected selected");
                    }
                }
            }
        } else {
            boolean isSelectedYes = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
            if (isSelectedYes) {
                Thread.sleep(1000);
                customerSegmentsByRFMT.clickYesInBasedOnMarketingPreferences();
                boolean isSelectedYes1 = customerSegmentsByRFMT.isCheckedYesInBasedOnMarketingPreferences();
                Assert.assertFalse(isSelectedYes1, "Yes Is not selected on Based on Marketing Preferences");
                System.out.println("Yes Is Unselected");
                boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    Thread.sleep(1000);
                    customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                    System.out.println("No Is Unselected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        customerSegmentsByRFMT.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                        Assert.assertFalse(isSelectedUnknown1, "Unknown Is not selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is Unselected");
                    } else {
                        Assert.assertFalse(isSelectedUnknown, "Unknown Is selected on Based on Marketing Preferences");
                        System.out.println("Unknown Is already unselected selected");
                    }
                } else {
                    Assert.assertFalse(isSelectedNo, "No Is selected on Based on Marketing Preferences");
                    System.out.println("No Is already unselected selected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        customerSegmentsByRFMT.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
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
                boolean isSelectedNo = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                if (isSelectedNo) {
                    Thread.sleep(1000);
                    customerSegmentsByRFMT.clickNoInBasedOnMarketingPreferences();
                    boolean isSelectedNo1 = customerSegmentsByRFMT.isCheckedNoInBasedOnMarketingPreferences();
                    Assert.assertFalse(isSelectedNo1, "No Is not selected on Based on Marketing Preferences");
                    System.out.println("No Is Unselected");
                    boolean isSelectedUnknown = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
                    if (isSelectedUnknown) {
                        Thread.sleep(1000);
                        customerSegmentsByRFMT.clickUnknownInBasedOnMarketingPreferences();
                        boolean isSelectedUnknown1 = customerSegmentsByRFMT.isCheckedUnknownInBasedOnMarketingPreferences();
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

    @Test(priority = 29)
    public void verifySelectOneOffWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = customerSegmentsByRFMT.checkOneOffIsDisable();
        boolean isSelected = customerSegmentsByRFMT.checkOneOffIsSelected();
        if (!isDisable && !isSelected) {
            customerSegmentsByRFMT.clickOnOneOffTab();
            customerSegmentsByRFMT.verifyOneOffPage();
            customerSegmentsByRFMT.verifyTotalOneOffCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsOneOff();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsOneOff();
        } else if (isSelected) {
            System.out.println("One-Off is Already selected");
            //Verify One Off Page is Selected
            customerSegmentsByRFMT.verifyOneOffPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalOneOffCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsOneOff();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsOneOff();
        } else if (isDisable) {
            System.err.println("One-Off is Disable");
        }

    }

    @Test(priority = 30)
    public void verifiedLapsedIsEnabled() {
        boolean isDisable = customerSegmentsByRFMT.checkLapsedIsDisable();
        Assert.assertFalse(isDisable, "Lapsed is Disable");
    }

    @Test(priority = 31)
    public void verifiedLapsedIsSelected() throws InterruptedException {
        //Verify Lapsed Page
        customerSegmentsByRFMT.verifyLapsedPage();
        //Total Customer Card
        customerSegmentsByRFMT.verifyTotalLapsedCustomersCardDisplaying();
        //Common Cards
        customerSegmentsByRFMT.verifyCardsLapsed();
        //Common Graphs
        customerSegmentsByRFMT.verifyGraphsLapsed();
    }

    @Test(priority = 32)
    public void verifySelectLapsedWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = customerSegmentsByRFMT.checkLapsedIsDisable();
        boolean isSelected = customerSegmentsByRFMT.checkLapsedIsSelected();
        System.out.println(!isSelected);
        System.out.println(isDisable);
        if ((!isDisable) && !isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickOnLapsedTab();
            Thread.sleep(1000);
            //Verify Lapsed Page
            customerSegmentsByRFMT.verifyLapsedPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalLapsedCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsLapsed();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsLapsed();
        } else if (isSelected) {
            System.out.println("Lapsed is Already selected");
            /*boolean isDisplaying = segmentsAIAnalytics.totalLapsedCustomerPageHeaderIsDisplaying();
            Assert.assertTrue(isDisplaying, "Not in the Navigated to Lapsed Page");*/
            //Verify Lapsed Page
            customerSegmentsByRFMT.verifyLapsedPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalLapsedCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsLapsed();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsLapsed();
        } else if (isDisable) {
            System.err.println("Lapsed is Disable");
        }

    }

    @Test(priority = 33)
    public void verifiedDormantIsEnabled() {
        boolean isDisable = customerSegmentsByRFMT.checkDormantIsDisable();
        Assert.assertFalse(isDisable, "Dormant is Disable");
    }

    @Test(priority = 34)
    public void verifiedDormantIsSelected() throws InterruptedException {
        //Verify Dormant Page
        customerSegmentsByRFMT.verifyDormantPage();
        //Total Customer Card
        customerSegmentsByRFMT.verifyTotalDormantCustomersCardDisplaying();
        //Common Cards
        customerSegmentsByRFMT.verifyCardsDormant();
        //Common Graphs
        customerSegmentsByRFMT.verifyGraphsDormant();
    }

    @Test(priority = 35)
    public void verifySelectDormantWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = customerSegmentsByRFMT.checkDormantIsDisable();
        boolean isSelected = customerSegmentsByRFMT.checkDormantIsSelected();
        if (!isDisable && !isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickOnDormantTab();
            //Verify Dormant Page
            customerSegmentsByRFMT.verifyDormantPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalDormantCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsDormant();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsDormant();
        } else if (isSelected) {
            System.out.println("Dormant is Already selected");
            //Verify Dormant Page
            customerSegmentsByRFMT.verifyDormantPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalDormantCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsDormant();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsDormant();
        } else if (isDisable) {
            System.err.println("Dormant is Disable");
        }

    }

    @Test(priority = 36)
    public void verifiedNewIsEnabled() {
        boolean isDisable = customerSegmentsByRFMT.checkNewIsDisable();
        Assert.assertFalse(isDisable, "New is Disable");
    }

    @Test(priority = 37)
    public void verifiedNewIsSelected() throws InterruptedException {
        //Verify New Page
        customerSegmentsByRFMT.verifyNewPage();
        //Total Customer Card
        customerSegmentsByRFMT.verifyTotalNewCustomersCardDisplaying();
        //Common Cards
        customerSegmentsByRFMT.verifyCardsNew();
        //Common Graphs
        customerSegmentsByRFMT.verifyGraphsNew();
    }

    @Test(priority = 38)
    public void verifySelectNewWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = customerSegmentsByRFMT.checkNewIsDisable();
        boolean isSelected = customerSegmentsByRFMT.checkNewIsSelected();
        if (!isDisable && !isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickOnNewTab();
            //Verify New Page
            customerSegmentsByRFMT.verifyNewPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalNewCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsNew();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsNew();
        } else if (isSelected) {
            System.out.println("New is Already selected");
            //Verify New Page
            customerSegmentsByRFMT.verifyNewPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalNewCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsNew();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsNew();
        } else if (isDisable) {
            System.err.println("New is Disable");
        }

    }

    @Test(priority = 39)
    public void verifiedCommittedIsEnabled() {
        boolean isDisable = customerSegmentsByRFMT.checkCommittedIsDisable();
        Assert.assertFalse(isDisable, "Committed is Disable");
    }

    @Test(priority = 40)
    public void verifiedCommittedIsSelected() throws InterruptedException {
        //Verify Committed Page
        customerSegmentsByRFMT.verifyCommittedPage();
        //Total Customer Card
        customerSegmentsByRFMT.verifyTotalCommittedCustomersCardDisplaying();
        //Common Cards
        customerSegmentsByRFMT.verifyCardsCommitted();
        //Common Graphs
        customerSegmentsByRFMT.verifyGraphsCommitted();
    }

    @Test(priority = 41)
    public void verifySelectCommittedWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = customerSegmentsByRFMT.checkCommittedIsDisable();
        boolean isSelected = customerSegmentsByRFMT.checkCommittedIsSelected();
        if (!isDisable && !isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickOnCommittedTab();
            //Verify Committed Page
            customerSegmentsByRFMT.verifyCommittedPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalCommittedCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsCommitted();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsCommitted();
        } else if (isSelected) {
            System.out.println("Committed is Already selected");
            //Verify Committed Page
            customerSegmentsByRFMT.verifyCommittedPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalCommittedCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsCommitted();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsCommitted();
        } else if (isDisable) {
            System.err.println("Committed is Disable");
        }
    }

    @Test(priority = 42)
    public void verifiedVIPIsEnabled() {
        boolean isDisable = customerSegmentsByRFMT.checkVIPIsDisable();
        Assert.assertFalse(isDisable, "VIP is Disable");
    }

    @Test(priority = 43)
    public void verifiedVIPIsSelected() throws InterruptedException {
        //Verify VIP Page
        customerSegmentsByRFMT.verifyVIPPage();
        //Total Customer Card
        customerSegmentsByRFMT.verifyTotalVIPCustomersCardDisplaying();
        //Common Cards
        customerSegmentsByRFMT.verifyCardsVIP();
        //Common Graphs
        customerSegmentsByRFMT.verifyGraphsVIP();
    }

    @Test(priority = 44)
    public void verifySelectVIPWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = customerSegmentsByRFMT.checkVIPIsDisable();
        boolean isSelected = customerSegmentsByRFMT.checkVIPIsSelected();
        if (!isDisable && !isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickOnVIPTab();
            //Verify VIP Page
            customerSegmentsByRFMT.verifyVIPPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalVIPCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsVIP();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsVIP();
        } else if (isSelected) {
            System.out.println("VIP is Already selected");
            //Verify VIP Page
            customerSegmentsByRFMT.verifyVIPPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalVIPCustomersCardDisplaying();
            //Common Cards
//            vipTabInSegment.verifyCommonCardsDisplaying();
            customerSegmentsByRFMT.verifyCardsVIP();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsVIP();
        } else if (isDisable) {
            System.err.println("VIP is Disable");
        }

    }

    @Test(priority = 45)
    public void verifiedSporadicVIPIsEnabled() {
        boolean isDisable = customerSegmentsByRFMT.checkSporadicVIPIsDisable();
        Assert.assertFalse(isDisable, "Sporadic VIP is Disable");
    }

    @Test(priority = 46)
    public void verifiedSporadicVIPIsSelected() throws InterruptedException {
        //Verify Sporadic VIP Page
        customerSegmentsByRFMT.verifySporadicVIPPage();
        //Total Customer Card
        customerSegmentsByRFMT.verifyTotalSporadicVIPCustomersCardDisplaying();
        //Common Cards
        customerSegmentsByRFMT.verifyCardsSporadicVIP();
        //Common Graphs
        customerSegmentsByRFMT.verifyGraphsSporadicVIP();
    }

    @Test(priority = 47)
    public void verifySelectSporadicVIPWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = customerSegmentsByRFMT.checkSporadicVIPIsDisable();
        boolean isSelected = customerSegmentsByRFMT.checkSporadicVIPIsSelected();
        if (!isDisable && !isSelected) {
            Thread.sleep(5000);
            customerSegmentsByRFMT.clickOnSporadicVIPTab();
            //Verify Sporadic VIP Page
            customerSegmentsByRFMT.verifySporadicVIPPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalSporadicVIPCustomersCardDisplaying();
            //Common Cards
//            sporadicVIPTabInSegment.verifyCommonCardsDisplaying();
            customerSegmentsByRFMT.verifyCardsSporadicVIP();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsSporadicVIP();
        } else if (isSelected) {
            System.out.println("Sporadic VIP is Already selected");
            //Verify Sporadic VIP Page
            customerSegmentsByRFMT.verifySporadicVIPPage();
            //Total Customer Card
            customerSegmentsByRFMT.verifyTotalSporadicVIPCustomersCardDisplaying();
            //Common Cards
            customerSegmentsByRFMT.verifyCardsSporadicVIP();
            //Common Graphs
            customerSegmentsByRFMT.verifyGraphsSporadicVIP();
        } else if (isDisable) {
            System.err.println("Sporadic VIP is Disable");
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
