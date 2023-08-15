package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SegmentsAIAnalytics extends TestBase {
    @FindBy(css = ".btn.btn-secondary.fill-dark")
    WebElement exportUnderlyingSalesDataButton;

    //Customer segment by RFMT
    //Navigations
    @FindBy(id = "ngb-nav-48")
    WebElement customerSegmentByRFMT;
    //Customer segment by product category
    @FindBy(id = " ngb-nav-49")
    WebElement customerSegmentByProductCategory;
    @FindBy(id = "ngb-nav-9")
    WebElement oneOffTab;
    @FindBy(id = "ngb-nav-10")
    WebElement lapsedTab;
    @FindBy(id = "ngb-nav-11")
    WebElement dormantTab;
    @FindBy(id = "ngb-nav-13")
    WebElement newTab;
    @FindBy(id = "ngb-nav-12")
    WebElement committedTab;
    @FindBy(id = "ngb-nav-14")
    WebElement vipTab;
    @FindBy(id = "ngb-nav-15")
    WebElement sporadicVipTab;
    @FindBy(css = "[for='total_cust_0'] .check__marked")
    WebElement totalCustomerRadioButton;
    @FindBy(css = "[for='based_cust_0'] .check__marked")
    WebElement basedOnMarketingPreferenceRadioButton;

    //Total Customers
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(2) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalLapsedCustomerCard;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalOneOffCustomers;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(3) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalDormantCustomers;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(4) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalCommittedCustomers;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(5) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalNewCustomers;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(6) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalVIPCustomers;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(7) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalSporadicVIPCustomers;
    //
    @FindBy(xpath = "//h4[contains(text(),'Who are One-Off Customer Segment')]")
    WebElement oneOffCustomerPageHeader;
    @FindBy(xpath = "//h4[contains(text(),'Who are Lapsed Customer Segment')]")
    WebElement lapsedCustomerPageHeader;
    @FindBy(xpath = "//h4[contains(text(),'Who are Dormant Customer Segment')]")
    WebElement dormantCustomerPageHeader;
    @FindBy(xpath = "//h4[contains(text(),'Who are Committed Customer Segment')]")
    WebElement committedCustomerPageHeader;
    @FindBy(xpath = "//h4[contains(text(),'Who are New Customer Segment')]")
    WebElement newCustomerPageHeader;
    @FindBy(xpath = "//h4[contains(text(),'Who are VIP Customer Segment')]")
    WebElement vipCustomerPageHeader;
    @FindBy(xpath = "//h4[contains(text(),'Who are Sporadic VIP Customer Segment')]")
    WebElement sporadicVIPCustomerPageHeader;

    //Commons
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(2) .row [class] div")
    WebElement ofTheTotalDatabasePercentage;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(1) .row [class] div")
    WebElement avgNumberOfYearsSinceTheirLastPurchase;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(2) .row [class] div")
    WebElement avgRevenuePerCustomer;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(3) .row [class] div")
    WebElement avgNumberOfPurchases;

    //Graphs
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(1) h4")
    WebElement sourceGraphHeader;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(2) h4")
    WebElement top5ProductsGraphHeader;
    //
    @FindBy(css = "[for='quantity_segment_0']")
    WebElement quantityButtonForTop5Product;
    @FindBy(css = "[for='revenue_segment_0']")
    WebElement revenueButtonForTop5Product;
    //
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) .ng-star-inserted:nth-of-type(4) h4")
    WebElement demographicLocationsGraphsHeader;
    //
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) .bm-table")
    WebElement demographicLocationTableCanvas;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) .ng-star-inserted:nth-of-type(4) [data-zr-dom-id]")
    WebElement demographicLocationMapCanvas;
    //

    public SegmentsAIAnalytics() {
        PageFactory.initElements(driver, this);
    }

    public String verifyPageTitle() {
        return driver.getTitle();
    }

    public void clickOnExportUnderlyingSalesData() {
        exportUnderlyingSalesDataButton.click();
    }

    //Navigations
    public boolean checkOneOffIsSelected() {
        return Boolean.parseBoolean(oneOffTab.getAttribute("aria-selected"));
    }

    public boolean checkOneOffIsDisable() {
        return Boolean.parseBoolean(oneOffTab.getAttribute("aria-disabled"));
//        return oneOffTab.getAttribute("aria-disabled");
    }

    public void clickOnOneOffTab() {
        oneOffTab.click();
    }

    public boolean checkLapsedIsSelected() {
        return Boolean.parseBoolean(lapsedTab.getAttribute("aria-selected"));
    }

    public boolean checkLapsedIsDisable() {
        return Boolean.parseBoolean(lapsedTab.getAttribute("aria-disabled"));
    }

    public void clickOnLapsedTab() {
        lapsedTab.click();
    }

    public boolean checkDormantIsSelected() {
        return Boolean.parseBoolean(dormantTab.getAttribute("aria-selected"));
    }

    public boolean checkDormantIsDisable() {
        return Boolean.parseBoolean(dormantTab.getAttribute("aria-disabled"));
    }

    public void clickOnDormantTab() {
//        explicitWait(dormantTab, timeout);
        notClickableElementsClick(dormantTab, 10000);
    }

    public void clickOnDormant1() {
        elementToBeClicked(dormantTab, 10000);
    }

    public boolean checkCommittedIsSelected() {
        return Boolean.parseBoolean(committedTab.getAttribute("aria-selected"));
    }

    public boolean checkCommittedIsDisable() {
        return Boolean.parseBoolean(committedTab.getAttribute("aria-disabled"));
    }

    public void clickOnCommittedTab() {
        notClickableElementsClick(committedTab, 10000);
    }

    public boolean checkNewIsSelected() {
        return Boolean.parseBoolean(newTab.getAttribute("aria-selected"));
    }

    public boolean checkNewIsDisable() {
        return Boolean.parseBoolean(newTab.getAttribute("aria-disabled"));
    }

    public void clickOnNewTab() {
        notClickableElementsClick(newTab, 10000);
    }

    public boolean checkVIPIsSelected() {
        return Boolean.parseBoolean(vipTab.getAttribute("aria-selected"));
    }

    public boolean checkVIPIsDisable() {
        return Boolean.parseBoolean(vipTab.getAttribute("aria-disabled"));
    }

    public void clickOnVIPTab() {
        vipTab.click();
    }

    public boolean checkSporadicVIPIsSelected() {
        return Boolean.parseBoolean(sporadicVipTab.getAttribute("aria-selected"));
    }

    public boolean checkSporadicVIPIsDisable() {
        return Boolean.parseBoolean(sporadicVipTab.getAttribute("aria-disabled"));
    }

    public void clickOnSporadicVIPTab() {
        sporadicVipTab.click();
    }

    //Test Common Cards
    public boolean ofTheTotalDatabasePercentageCardIsDisplaying() {
        return ofTheTotalDatabasePercentage.isDisplayed();
    }

    public boolean avgNumberOfYearsSinceTheirLastPurchaseCardIsDisplaying() {
        return avgNumberOfYearsSinceTheirLastPurchase.isDisplayed();
    }

    public boolean avgRevenuePerCustomerCardIsDisplaying() {
        return avgRevenuePerCustomer.isDisplayed();
    }

    public boolean avgNumberOfPurchasesCardIsDisplaying() {
        return avgNumberOfPurchases.isDisplayed();
    }

    //Total Customers Cards
    public boolean totalOneOffCustomerCardIsDisplaying() {
        return totalOneOffCustomers.isDisplayed();
    }

    public boolean totalLapsedCustomerCardIsDisplaying() {
        return totalLapsedCustomerCard.isDisplayed();
    }

    public boolean totalDormantCustomerCardIsDisplaying() {
        return totalDormantCustomers.isDisplayed();
    }

    public boolean totalCommittedCustomerCardIsDisplaying() {
        return totalCommittedCustomers.isDisplayed();
    }

    public boolean totalNewCustomerCardIsDisplaying() {
        return totalNewCustomers.isDisplayed();
    }

    public boolean totalVIPCustomerCardIsDisplaying() {
        return totalVIPCustomers.isDisplayed();
    }

    public boolean totalSporadicVIPCustomerCardIsDisplaying() {
        return totalSporadicVIPCustomers.isDisplayed();
    }

    //Graphs Displaying
    public boolean sourceGraphHeaderIsDisplaying() {
        return sourceGraphHeader.isDisplayed();
    }

    public boolean top5ProductsHeaderIsDisplaying() {
        return top5ProductsGraphHeader.isDisplayed();
    }

    public boolean demographicLocationsGraphsHeaderIsDisplaying() {
        return demographicLocationsGraphsHeader.isDisplayed();
    }

    public boolean demographicLocationTableCanvasIsDisplaying() {
        return demographicLocationTableCanvas.isDisplayed();
    }

    public boolean demographicLocationMapCanvasIsDisplaying() {
        return demographicLocationMapCanvas.isDisplayed();
    }

    //Page Headers
    public boolean totalOneOffCustomerPageHeaderIsDisplaying() {
        return oneOffCustomerPageHeader.isDisplayed();
    }

    public boolean totalLapsedCustomerPageHeaderIsDisplaying() {
        return lapsedCustomerPageHeader.isDisplayed();
    }

    public boolean totalDormantCustomerPageHeaderIsDisplaying() {
        return dormantCustomerPageHeader.isDisplayed();
    }

    public boolean totalCommittedCardPageHeaderIsDisplaying() {
        return committedCustomerPageHeader.isDisplayed();
    }

    public boolean totalNewCustomersPageHeaderIsDisplaying() {
        return newCustomerPageHeader.isDisplayed();
    }

    public boolean totalVIPCustomersPageHeaderIsDisplaying() {
        return vipCustomerPageHeader.isDisplayed();
    }

    public boolean totalSporadicVIPCustomersPageHeaderIsDisplaying() {
        return sporadicVIPCustomerPageHeader.isDisplayed();
    }
    //Verify Page navigations
    public void verifyOneOffPage(){
        boolean isSelected = checkOneOffIsSelected();
        Assert.assertTrue(isSelected, "One-Off is Not Selected");
        System.out.println("Selected One-Off Page");
        boolean isDisplayingOneOff = totalOneOffCustomerPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingOneOff,"Not in the Navigated to One-Off Page");
        System.out.println("One-Off Page");
    }
    public void verifyLapsedPage(){
        boolean isSelected = checkLapsedIsSelected();
        Assert.assertTrue(isSelected, "Lapsed is Not Selected");
        System.out.println("Selected Lapsed Page");
        boolean isDisplayingLapsed = totalLapsedCustomerPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingLapsed,"Not in the Navigated to Lapsed Page");
    }
    public void verifyDormantPage(){
        boolean isSelected = checkDormantIsSelected();
        Assert.assertTrue(isSelected, "Dormant is Not Selected");
        System.out.println("Selected Dormant Page");
        boolean isDisplayingDormant = totalDormantCustomerPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingDormant,"Not in the Navigated to Dormant Page");
    }
    public void verifyCommittedPage(){
        boolean isSelected = checkCommittedIsSelected();
        Assert.assertTrue(isSelected, "Committed is Not Selected");
        System.out.println("Selected Committed Page");
        boolean isDisplayingCommitted = totalCommittedCardPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingCommitted,"Not in the Navigated to Committed Page");
    }
    public void verifyNewPage(){
        boolean isSelected = checkNewIsSelected();
        Assert.assertTrue(isSelected, "New is Not Selected");
        System.out.println("Selected New Page");
        boolean isDisplayingNew = totalNewCustomersPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingNew,"Not in the Navigated to New Page");
    }
    public void verifyVIPPage(){
        boolean isSelected = checkVIPIsSelected();
        Assert.assertTrue(isSelected, "VIP is Not Selected");
        System.out.println("Selected VIP Page");
        boolean isDisplayingVIP = totalVIPCustomersPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingVIP,"Not in the Navigated to VIP Page");
    }
    public void verifySporadicVIPPage(){
        boolean isSelected = checkSporadicVIPIsSelected();
        Assert.assertTrue(isSelected, "Sporadic VIP is Not Selected");
        System.out.println("Selected Sporadic VIP Page");
        boolean isDisplayingSporadicVIP = totalSporadicVIPCustomersPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingSporadicVIP,"Not in the Navigated to Sporadic VIP Page");
    }

    //Verify Total Customer Cards
    public void verifyTotalOneOffCustomersCardDisplaying() {
        boolean isDisplayingTotalOneOff = totalOneOffCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalOneOff, "Total One-Off Customer card is not Displaying");
        System.out.println("Total One-Off Customer card is Displaying");
    }

    public void verifyTotalLapsedCustomersCardDisplaying() {
        boolean isDisplayingTotalLapsed = totalLapsedCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalLapsed, "Total Lapsed Customer card is not Displaying");
        System.out.println("Total Lapsed Customer card is Displaying");
    }

    public void verifyTotalDormantCustomersCardDisplaying() {
        boolean isDisplayingTotalDormant = totalDormantCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalDormant, "Total Dormant Customer card is not Displaying");
        System.out.println("Total Dormant Customer card is Displaying");
    }

    public void verifyTotalCommittedCustomersCardDisplaying() {
        boolean isDisplayingTotalCommitted = totalCommittedCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalCommitted, "Total Committed Customer card is not Displaying");
        System.out.println("Total Committed Customer card is Displaying");
    }

    public void verifyTotalNewCustomersCardDisplaying() {
        boolean isDisplayingTotalNew = totalNewCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalNew, "Total New Customer card is not Displaying");
        System.out.println("Total New Customer card is Displaying");
    }

    public void verifyTotalVIPCustomersCardDisplaying() {
        boolean isDisplayingTotalVIP = totalVIPCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalVIP, "Total VIP Customer card is not Displaying");
        System.out.println("Total VIP Customer card is Displaying");
    }

    public void verifyTotalSporadicVIPCustomersCardDisplaying() {
        boolean isDisplayingTotalSporadicVIP = totalSporadicVIPCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalSporadicVIP, "Total Sporadic VIP Customer card is not Displaying");
        System.out.println("Total Sporadic VIP Customer card is Displaying");
    }

    public void verifyCommonCardsDisplaying() {
        //Of the total DB card
        boolean isDisplayingOfTheTotalDatabasePercentage = ofTheTotalDatabasePercentageCardIsDisplaying();
        softAssertion.assertTrue(isDisplayingOfTheTotalDatabasePercentage, "Of the total Database percentage Card is not displaying");
        System.out.println("Of the total Database percentage Card is displaying");
        //AVG number of days since their last purchase card
        boolean isDisplayingAvgNumberOfYearsSinceTheirLastPurchase = avgNumberOfYearsSinceTheirLastPurchaseCardIsDisplaying();
        softAssertion.assertTrue(isDisplayingAvgNumberOfYearsSinceTheirLastPurchase, "AVG number of days since their " +
                "last purchase Card is not displaying");
        System.out.println("AVG number of days since their " +
                "last purchase Card is displaying");
        //AVG revenue per customer card
        boolean isDisplayingAvgRevenuePerCustomer = avgRevenuePerCustomerCardIsDisplaying();
        softAssertion.assertTrue(isDisplayingAvgRevenuePerCustomer, "AVG revenue per customer Card is not displaying");
        System.out.println("AVG revenue per customer Card is displaying");
        //AVG number of purchases card
        boolean isDisplayingAvgNumberOfPurchases = avgNumberOfPurchasesCardIsDisplaying();
        softAssertion.assertTrue(isDisplayingAvgNumberOfPurchases, "AVG number of purchases Card is not displaying");
        System.out.println("AVG number of purchases Card is displaying");
        softAssertion.assertAll();
    }

    public void verifyGraphsInSegmentDisplaying() {
        //SourceGraphHeader
        boolean isDisplayingSourceGraphHeader = sourceGraphHeaderIsDisplaying();
        softAssertion.assertTrue(isDisplayingSourceGraphHeader, "Source Graph Header is not Available");
        System.out.println("Source Graph Header is Available");
        //Top 5 product header
        boolean isDisplayingTop5ProductsHeader = top5ProductsHeaderIsDisplaying();
        softAssertion.assertTrue(isDisplayingTop5ProductsHeader, "Top 5 Product graph header is not Available");
        System.out.println("Top 5 Product graph header is Available");
        //Demographic Locations Graphs Header
        boolean isDisplayingDemographicLocationsGraphsHeader = demographicLocationsGraphsHeaderIsDisplaying();
        softAssertion.assertTrue(isDisplayingDemographicLocationsGraphsHeader, "Demographic Locations Graphs Header " +
                "is not Available");
        System.out.println("Demographic Locations Graphs Header " +
                "is not Available");
        //Demographic Location Table Canvas
        boolean isDisplayingDemographicLocationTableCanvas = demographicLocationTableCanvasIsDisplaying();
        softAssertion.assertTrue(isDisplayingDemographicLocationTableCanvas, "Demographic Location Table Canvas " +
                "is Available");
        System.out.println("Demographic Location Table Canvas " +
                "is Available");
        //Demographic Location Map Canvas
        boolean isDisplayingDemographicLocationMapCanvas = demographicLocationMapCanvasIsDisplaying();
        softAssertion.assertTrue(isDisplayingDemographicLocationMapCanvas, "Demographic Location Map Canvas is not Available");
        System.out.println("Demographic Location Map Canvas is not Available");
    }

}
