package com.mortarai.testcases.AIAnalyticsPageTests.SegmentAIAnalyticsTest;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SalesAIAnalytics;
import com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab.CustomerSegmentByProductCategoryInSegment;
import com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab.CustomerSegmentsByRFMT;
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
        customerSegmentByProductCategoryInSegment = customerSegmentsByRFMT.clickOnCustomerSegmentByProduct();
        customerChurnPredictionAIAnalytics = new CustomerChurnPredictionAIAnalytics();
    }

    @Test(priority = 1)
    public void customerSegmentByProductCategoryInSegmentPageTitleTest() {
        String title = customerSegmentByProductCategoryInSegment.verifyCustomerSegmentByProductCategoryPageTitle();
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
        boolean isDisable = customerSegmentByProductCategoryInSegment.segmentTabIsEnabled();
        Assert.assertFalse(isDisable, "Segments Tab is not Enable");
        System.out.println("Segments Tab Is Enabled");
    }

    @Test(priority = 4)
    public void verifiedCustomerChurnIsSelected() {
        boolean isSelected = customerSegmentByProductCategoryInSegment.segmentTabIsSelected();
        Assert.assertTrue(isSelected, "Segments Tab is not Selected");
        System.out.println("Segments Tab Is Selected");
    }

    @Test(priority = 5)
    public void verifiedHeaderOfCustomerSegmentByProductsTest() throws InterruptedException {
//        testUtil.switchToFrame();
        Thread.sleep(3000);
        Assert.assertTrue(customerSegmentByProductCategoryInSegment.verifyHeaderOfCustomerSegmentByProductCategory());
        System.out.println("Verified the Segment by Product category");
    }

    @Test(priority = 6)
    public void verifiedCreateProductButtonIsAvailable() {
        boolean isDisplaying = customerSegmentByProductCategoryInSegment.verifyCreateProductCategoryButtonIsAvailable();
        Assert.assertTrue(isDisplaying, "Create Product Category Button is Not Available");
        System.out.println("Create Product Category Button is Available");
    }

    @Test(priority = 7)
    public void verifiedClickOnCreateProductCategoryButton() throws InterruptedException {
        boolean isDisplaying = customerSegmentByProductCategoryInSegment.verifyClickOnCreateCategoryButton();
        Assert.assertTrue(isDisplaying, "Clicked and not Opened the Product Category Creating Panel");
        System.out.println("Clicked and Opened the Product Category Creating Panel");
    }

    @Test(priority = 8)
    public void verifiedSearchInputField() throws InterruptedException {
        boolean isDisplaying = customerSegmentByProductCategoryInSegment.verifySearchInputFieldIsVisible();
        Thread.sleep(2000);
        Assert.assertTrue(isDisplaying, "Search Input Field Is Not Visible");
        System.out.println("Search Input Field Is Visible");
    }

    @Test(priority = 9)
    public void verifiedCategoryNameFieldAvailableInPanel() throws InterruptedException {
        boolean isDisplaying = customerSegmentByProductCategoryInSegment.verifyCategoryNameFieldAvailable();
        Assert.assertTrue(isDisplaying, "Category Name Field Is Not Visible");
        System.out.println("Category Name Field Is Visible");
    }

    @Test(priority = 10)
    public void verifiedSelectProductsFieldAvailableInPanel() throws InterruptedException {
        boolean isDisplaying = customerSegmentByProductCategoryInSegment.verifySelectProductsFieldAvailable();
        Assert.assertTrue(isDisplaying, "Select Products Field Is Not Visible");
        System.out.println("Select Products Field Is  Visible");
    }

    @Test(priority = 11)
    public void verifiedAddToFavouriteCheckBoxInPanelAvailable() throws InterruptedException {
        boolean isDisplaying = customerSegmentByProductCategoryInSegment.verifyAddToFavouriteCheckBoxInPanelAvailable();
        Assert.assertTrue(isDisplaying, "Add To Favourite CheckBox Field Is Not Visible");
        System.out.println("Add To Favourite CheckBox Field Is  Visible");
    }

    @Test(priority = 11)
    public void verifiedCreateProductCategoryButtonInPanelAvailable() throws InterruptedException {
        boolean isDisplaying = customerSegmentByProductCategoryInSegment.verifyCreateProductCategoryButtonInPanelAvailable();
        Assert.assertTrue(isDisplaying, "Create Product Category Button In Product Category adding" +
                " panel Is Not Visible");
        System.out.println("Create Product Category Button In Product Category adding Is Visible");
    }

    @Test(priority = 12)
    public void verifiedCancelButtonInPanelAvailable() throws InterruptedException {
        boolean isDisplaying = customerSegmentByProductCategoryInSegment.verifyCancelButtonInPanelAvailable();
        Assert.assertTrue(isDisplaying, "Cancel Button In Product Category adding" +
                " panel Is Not Visible");
        System.out.println("Cancel Button In Product Category adding Is Visible");
    }

    @Test(priority = 13)
    public void verifiedAddingValidProductCategory() throws InterruptedException {
        customerSegmentByProductCategoryInSegment.verifyAddingValidProductCategoryWithAddingFavourite();
    }

    @Test(priority = 14)
    public void verifiedNotToAddProductCategoryWithEmptyFields() throws InterruptedException {
        customerSegmentByProductCategoryInSegment.verifyUserNotToAddProductCategoryWithEmptyFields();
    }

    @Test(priority = 15)
    public void verifiedNotToAddOnlyWithEnteringOnlyProductNameToProductCategory() throws InterruptedException {
        customerSegmentByProductCategoryInSegment.verifyNotToAddOnlyWithEnteringOnlyProductNameToProductCategory();
    }

    @Test(priority = 16)
    public void verifiedNotToAddOnlyWithSelectOnlyProductToProductCategory() throws InterruptedException {
        customerSegmentByProductCategoryInSegment.verifyNotToAddOnlyWithSelectOnlyProductToProductCategory();
    }

    @Test(priority = 17)
    public void verifiedErrorMessagesInFieldsWhenEmptiedFieldCategoryNameField() throws InterruptedException {
        customerSegmentByProductCategoryInSegment.verifyErrorMessagesInFieldsWhenEmptiedFieldCategoryNameField();
    }

    @Test(priority = 18)
    public void verifiedErrorMessagesInFieldsWhenEmptiedFieldProductCategoryField() throws InterruptedException {
        customerSegmentByProductCategoryInSegment.verifyErrorMessagesInFieldsWhenEmptiedFieldProductCategoryField();
    }

    @Test(priority = 19)
    public void verifiedAddingValidProductCategoryWithoutAddingFavourite() throws InterruptedException {
        customerSegmentByProductCategoryInSegment.verifyAddingValidProductCategoryWithoutAddingFavourite();
    }

    @Test(priority = 20)
    public void verifiedCloseButtonWhenFieldsAreEmptyProductCategory() throws InterruptedException {
        customerSegmentByProductCategoryInSegment.verifyAddingValidProductCategoryWithoutAddingFavourite();
    }

    @Test(priority = 21)
    public void verifiedCloseButtonClickWhenFieldsAreFilled() throws InterruptedException {
        customerSegmentByProductCategoryInSegment.verifyCloseButtonClickWhenFieldsAreFilled();
    }


}
