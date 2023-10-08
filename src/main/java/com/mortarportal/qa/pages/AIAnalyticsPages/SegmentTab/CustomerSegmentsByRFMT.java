package com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerSegmentsByRFMT extends TestBase {
    @FindBy(css = ".btn.btn-secondary.fill-dark")
    WebElement exportUnderlyingSalesDataButton;

    //Customer segment by RFMT
    //Navigations
    @FindBy(id = "ngb-nav-7")
    WebElement customerSegmentByRFMT;
    //Customer segment by product category
    @FindBy(id = "ngb-nav-8")
    WebElement customerSegmentByProductCategory;

    //One-Off//
    @FindBy(id = "ngb-nav-9")
    WebElement oneOffTab;
    @FindBy(id = "total_cust_0")
    WebElement totalCustomerRadioButOneOffCheck;
    @FindBy(css = "[for='total_cust_0']")
    WebElement totalCustomerRadioButOneOff;
    @FindBy(id = "based_cust_0")
    WebElement basedOnMarketingPreferenceRadioButOneOffCheck;
    @FindBy(css = "[for='based_cust_0']")
    WebElement basedOnMarketingPreferenceRadioButOneOff;
    @FindBy(id = "filtering_data_yes_0")
    WebElement yesInBOMPCheckbox;
    @FindBy(css = "[for='filtering_data_yes_0']")
    WebElement yesInBOMPCheckboxSelect;
    @FindBy(id = "filtering_data_No_0")
    WebElement noInBOMPCheckbox;
    @FindBy(css = "[for='filtering_data_No_0']")
    WebElement noInBOMPCheckboxSelect;
    @FindBy(id = "filtering_data_Notset_0")
    WebElement unknownInBOMPCheckbox;
    @FindBy(css = "[for='filtering_data_Notset_0']")
    WebElement unknownInBOMPCheckboxSelect;

    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalOneOffCustomers;
    @FindBy(xpath = "//h4[contains(text(),'Who are One-Off Customer Segment')]")
    WebElement oneOffCustomerPageHeader;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(2) .row [class] div")
    WebElement ofTheTotalDatabasePercentageOneOff;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(1) .row [class] div")
    WebElement avgNumberOfYearsSinceTheirLastPurchaseOneOff;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(2) .row [class] div")
    WebElement avgRevenuePerCustomerOneOff;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(3) .row [class] div")
    WebElement avgNumberOfPurchasesOneOff;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(1) h4")
    WebElement sourceGraphHeaderOneOff;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(2) h4")
    WebElement top5ProductsGraphHeaderOneOff;
    //
    @FindBy(css = "[for='quantity_segment_0']")
    WebElement quantityButtonForTop5ProductOneOff;
    @FindBy(css = "[for='revenue_segment_0']")
    WebElement revenueButtonForTop5ProductOneOff;
    //
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) .ng-star-inserted:nth-of-type(4) h4")
    WebElement demographicLocationsGraphsHeaderOneOff;
    //
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) .bm-table")
    WebElement demographicLocationTableOneOff;
    @FindBy(css = "[class='col-md-12 md-4 segment_tabs'] [role='tabpanel']:nth-of-type(1) .ng-star-inserted:nth-of-type(4) [data-zr-dom-id]")
    WebElement demographicLocationMapCanvasOneOff;
    //
    //Lapsed//
    @FindBy(id = "ngb-nav-10")
    WebElement lapsedTab;
    @FindBy(xpath = "//h4[contains(text(),'Who are Lapsed Customer Segment')]")
    WebElement lapsedCustomerPageHeader;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(2) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalLapsedCustomerCard;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(2) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(2) .row [class] div")
    WebElement ofTheTotalDatabasePercentageLapsed;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(2) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(2) .row [class] div")
    WebElement avgNumberOfYearsSinceTheirLastPurchaseLapsed;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(2) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(2) .row [class] div")
    WebElement avgRevenuePerCustomerLapsed;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(2) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(3) .row [class] div")
    WebElement avgNumberOfPurchasesLapsed;
    //Graphs
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(2) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(1) h4")
    WebElement sourceGraphHeadersLapsed;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(2) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(2) h4")
    WebElement top5ProductsGraphHeadersLapsed;
    //
    @FindBy(css = "[for='quantity_segment_0']")
    WebElement quantityButtonForTop5ProductsLapsed;
    @FindBy(css = "[for='revenue_segment_0']")
    WebElement revenueButtonForTop5ProductsLapsed;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(2) .ng-star-inserted:nth-of-type(4) h4")
    WebElement demographicLocationsGraphsHeadersLapsed;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(2) .bm-table")
    WebElement demographicLocationTableLapsed;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(2) .ng-star-inserted:nth-of-type(4) [data-zr-dom-id]")
    WebElement demographicLocationMapCanvasLapsed;
    //
    //Dormant//
    @FindBy(id = "ngb-nav-11")
    WebElement dormantTab;
    //Page headers
    @FindBy(xpath = "//h4[contains(text(),'Who are Dormant Customer Segment')]")
    WebElement dormantCustomerPageHeader;
    //Total Customers
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(3) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalDormantCustomers;
    //Commons
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(3) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(2) .row [class] div")
    WebElement ofTheTotalDatabasePercentageDormant;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(3) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(1) .row [class] div")
    WebElement avgNumberOfYearsSinceTheirLastPurchaseDormant;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(3) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(2) .row [class] div")
    WebElement avgRevenuePerCustomerDormant;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(3) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(3) .row [class] div")
    WebElement avgNumberOfPurchasesDormant;
    //Graphs
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(3) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(1) h4")
    WebElement sourceGraphHeadersDormant;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(3) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(2) h4")
    WebElement top5ProductsGraphHeadersDormant;
    //
    @FindBy(css = "[for='quantity_segment_0']")
    WebElement quantityButtonForTop5ProductsDormant;
    @FindBy(css = "[for='revenue_segment_0']")
    WebElement revenueButtonForTop5ProductsDormant;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(3) .ng-star-inserted:nth-of-type(4) h4")
    WebElement demographicLocationsGraphsHeadersDormant;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(3) .bm-table")
    WebElement demographicLocationTableDormant;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(3) .ng-star-inserted:nth-of-type(4) [data-zr-dom-id]")
    WebElement demographicLocationMapCanvasDormant;
    //
    //Committed//
    @FindBy(id = "ngb-nav-12")
    WebElement committedTab;
    @FindBy(xpath = "//h4[contains(text(),'Who are Committed Customer Segment')]")
    WebElement committedCustomerPageHeader;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(4) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalCommittedCustomers;
    //Commons
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(4) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(2) .row [class] div")
    WebElement ofTheTotalDatabasePercentageCommitted;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(4) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(1) .row [class] div")
    WebElement avgNumberOfYearsSinceTheirLastPurchaseCommitted;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(4) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(2) .row [class] div")
    WebElement avgRevenuePerCustomerCommitted;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(4) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(3) .row [class] div")
    WebElement avgNumberOfPurchasesCommitted;
    //Graphs
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(4) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(1) h4")
    WebElement sourceGraphHeadersCommitted;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(4) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(2) h4")
    WebElement top5ProductsGraphHeadersCommitted;
    //
    @FindBy(css = "[for='quantity_segment_0']")
    WebElement quantityButtonForTop5ProductsCommitted;
    @FindBy(css = "[for='revenue_segment_0']")
    WebElement revenueButtonForTop5ProductsCommitted;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(4) .ng-star-inserted:nth-of-type(4) h4")
    WebElement demographicLocationsGraphsHeadersCommitted;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(4) .bm-table")
    WebElement demographicLocationTableCommitted;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(4) .ng-star-inserted:nth-of-type(4) [data-zr-dom-id]")
    WebElement demographicLocationMapCanvasCommitted;
    //
    //New//
    @FindBy(id = "ngb-nav-13")
    WebElement newTab;
    @FindBy(xpath = "//h4[contains(text(),'Who are New Customer Segment')]")
    WebElement newCustomerPageHeader;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(5) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalNewCustomers;
    //Commons
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(5) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(2) .row [class] div")
    WebElement ofTheTotalDatabasePercentageNew;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(5) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(1) .row [class] div")
    WebElement avgNumberOfYearsSinceTheirLastPurchaseNew;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(5) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(2) .row [class] div")
    WebElement avgRevenuePerCustomerNew;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(5) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(3) .row [class] div")
    WebElement avgNumberOfPurchasesNew;

    //Graphs
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(5) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(1) h4")
    WebElement sourceGraphHeadersNew;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(5) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(2) h4")
    WebElement top5ProductsGraphHeadersNew;
    //
    @FindBy(css = "[for='quantity_segment_0']")
    WebElement quantityButtonForTop5ProductsNew;
    @FindBy(css = "[for='revenue_segment_0']")
    WebElement revenueButtonForTop5ProductsNew;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(5) .ng-star-inserted:nth-of-type(4) h4")
    WebElement demographicLocationsGraphsHeadersNew;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(5) .bm-table")
    WebElement demographicLocationTableNew;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(5) .ng-star-inserted:nth-of-type(4) [data-zr-dom-id]")
    WebElement demographicLocationMapCanvasNew;
    //
    //VIP//
    @FindBy(id = "ngb-nav-14")
    WebElement vipTab;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(6) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalVIPCustomers;
    @FindBy(xpath = "//h4[contains(text(),'Who are VIP Customer Segment')]")
    WebElement vipCustomerPageHeader;
    //Commons
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(6) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(2) .row [class] div")
    WebElement ofTheTotalDatabasePercentageVIP;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(6) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(1) .row [class] div")
    WebElement avgNumberOfYearsSinceTheirLastPurchaseVIP;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(6) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(2) .row [class] div")
    WebElement avgRevenuePerCustomerVIP;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(6) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(3) .row [class] div")
    WebElement avgNumberOfPurchasesVIP;

    //Graphs
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(6) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(1) h4")
    WebElement sourceGraphHeadersVIP;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(6) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(2) h4")
    WebElement top5ProductsGraphHeadersVIP;
    //
    @FindBy(css = "[for='quantity_segment_0']")
    WebElement quantityButtonForTop5ProductsVIP;
    @FindBy(css = "[for='revenue_segment_0']")
    WebElement revenueButtonForTop5ProductsVIP;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(6) .ng-star-inserted:nth-of-type(4) h4")
    WebElement demographicLocationsGraphsHeadersVIP;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(6) .bm-table")
    WebElement demographicLocationTableVIP;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(6) .ng-star-inserted:nth-of-type(4) [data-zr-dom-id]")
    WebElement demographicLocationMapCanvasVIP;
    //
    //Sporadic VIP//
    @FindBy(id = "ngb-nav-15")
    WebElement sporadicVipTab;
    @FindBy(xpath = "//h4[contains(text(),'Who are Sporadic VIP Customer Segment')]")
    WebElement sporadicVIPCustomerPageHeader;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(7) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(1) .row [class] div")
    WebElement totalSporadicVIPCustomers;
    //Commons
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(7) [class='col-lg-6 col-md-12 segement-data-cards mb-4']:nth-of-type(2) .row [class] div")
    WebElement ofTheTotalDatabasePercentageSporadicVIP;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(7) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(1) .row [class] div")
    WebElement avgNumberOfYearsSinceTheirLastPurchaseSporadicVIP;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(7) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(2) .row [class] div")
    WebElement avgRevenuePerCustomerSporadicVIP;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(7) [class='col-lg-4 mb-4 in_detailed_cards']:nth-of-type(3) .row [class] div")
    WebElement avgNumberOfPurchasesSporadicVIP;

    //Graphs
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(7) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(1) h4")
    WebElement sourceGraphHeadersSporadicVIP;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(7) [class='col-lg-6 mb-4 graph_cards']:nth-of-type(2) h4")
    WebElement top5ProductsGraphHeadersSporadicVIP;
    //
    @FindBy(css = "[for='quantity_segment_0']")
    WebElement quantityButtonForTop5ProductsSporadicVIP;
    @FindBy(css = "[for='revenue_segment_0']")
    WebElement revenueButtonForTop5ProductsSporadicVIP;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(7) .ng-star-inserted:nth-of-type(4) h4")
    WebElement demographicLocationsGraphsHeadersSporadicVIP;
    //
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(7) .bm-table")
    WebElement demographicLocationTableSporadicVIP;
    @FindBy(css = "[class] [role='tabpanel']:nth-of-type(7) .ng-star-inserted:nth-of-type(4) [data-zr-dom-id]")
    WebElement demographicLocationMapCanvasSporadicVIP;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics = PageFactory.initElements(driver,
            CustomerChurnPredictionAIAnalytics.class);
    //
    public CustomerSegmentsByRFMT() {
        PageFactory.initElements(driver, this);
    }

    public String verifyPageTitle() {
        return driver.getTitle();
    }
    public boolean validateAIAnalyticsHeader() {
        return customerChurnPredictionAIAnalytics.analyticsLabel.isDisplayed();
    }
    public boolean segmentTabIsEnabled() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.segmentLink.getAttribute("aria-disabled"));
    }
    public boolean segmentTabIsSelected() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.segmentLink.getAttribute("aria-selected"));
    }

    public void clickOnExportUnderlyingSalesData() {
        exportUnderlyingSalesDataButton.click();
    }

    public boolean checkCustomerSegmentByRFMTIsSelected() {
        return Boolean.parseBoolean(customerSegmentByRFMT.getAttribute("aria-selected"));
    }

    public boolean checkCustomerSegmentByRFMTIsDisable() {
        return Boolean.parseBoolean(customerSegmentByRFMT.getAttribute("aria-disabled"));
    }

    public void clickCustomerSegmentByRFMT() {
        customerSegmentByRFMT.click();
    }

    public boolean checkCustomerSegmentByProductIsSelected() {
        return Boolean.parseBoolean(customerSegmentByProductCategory.getAttribute("aria-selected"));
    }

    public boolean checkCustomerSegmentByProductIsDisable() {
        return Boolean.parseBoolean(customerSegmentByProductCategory.getAttribute("aria-disabled"));
    }

    public CustomerSegmentByProductCategoryInSegment clickOnCustomerSegmentByProduct() {
        customerSegmentByProductCategory.click();
        return new CustomerSegmentByProductCategoryInSegment();
    }

    //Common Methods
    public boolean ofTheTotalDatabasePercentageCardIsDisplaying(WebElement element) {
        return element.isDisplayed();
    }

    public boolean avgNumberOfYearsSinceTheirLastPurchaseCardIsDisplaying(WebElement element) {
        return element.isDisplayed();
    }

    public boolean avgRevenuePerCustomerCardIsDisplaying(WebElement element) {
        return element.isDisplayed();
    }

    public boolean avgNumberOfPurchasesCardIsDisplaying(WebElement element) {
        return element.isDisplayed();
    }

    public boolean sourceGraphHeaderIsDisplaying(WebElement element) {
        return element.isDisplayed();
    }

    public boolean top5ProductsHeaderIsDisplaying(WebElement element) {
        return element.isDisplayed();
    }

    public boolean demographicLocationsGraphsHeaderIsDisplaying(WebElement element) {
        return element.isDisplayed();
    }

    public boolean demographicLocationTableIsDisplaying(WebElement element) {
        return element.isDisplayed();
    }

    public boolean demographicLocationMapCanvasIsDisplaying(WebElement element) {
        return element.isDisplayed();
    }

    //Navigations
    //One off Navigation
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

    //Page Headers
    public boolean totalOneOffCustomerPageHeaderIsDisplaying() {
        return oneOffCustomerPageHeader.isDisplayed();
    }
    //One_Off

    /*public boolean ofTheTotalDatabasePercentageCardIsDisplaying(ofTheTotalDatabasePercentageOneOff) {
        return ofTheTotalDatabasePercentageOneOff.isDisplayed();
    }

    public boolean avgNumberOfYearsSinceTheirLastPurchaseCardIsDisplaying() {
        return avgNumberOfYearsSinceTheirLastPurchaseOneOff.isDisplayed();
    }
    public boolean avgRevenuePerCustomerCardIsDisplaying() {
        return avgRevenuePerCustomerOneOff.isDisplayed();
    }

    public boolean avgNumberOfPurchasesCardIsDisplaying() {
        return avgNumberOfPurchasesOneOff.isDisplayed();
    }*/
    public boolean isSelectedTotalCustomerRadioBut(){
        return totalCustomerRadioButOneOffCheck.isSelected();
    }
    public void clickTotalCustomerRadioBut(){
        totalCustomerRadioButOneOff.click();
    }
    public boolean isSelectedBasedOnMarketingPreferencesRadioBut(){
        return  basedOnMarketingPreferenceRadioButOneOffCheck.isSelected();
    }
    public void  clickBasedOnMarketingPreferencesRadioBut(){
        notClickableElementsClick(basedOnMarketingPreferenceRadioButOneOff,10000);
//        basedOnMarketingPreferenceRadioButOneOff.click();
    }
    public boolean isCheckedYesInBasedOnMarketingPreferences(){
        return yesInBOMPCheckbox.isSelected();
    }
    public void  clickYesInBasedOnMarketingPreferences(){
        yesInBOMPCheckboxSelect.click();
    }
    public boolean isCheckedNoInBasedOnMarketingPreferences(){
        return noInBOMPCheckbox.isSelected();
    }
    public void clickNoInBasedOnMarketingPreferences(){
        noInBOMPCheckboxSelect.click();
    }
    public boolean isCheckedUnknownInBasedOnMarketingPreferences(){
        return unknownInBOMPCheckbox.isSelected();
    }
    public void clickUnknownInBasedOnMarketingPreferences(){
        unknownInBOMPCheckboxSelect.click();
    }
    //Total Customers Cards
    public boolean totalOneOffCustomerCardIsDisplaying() {
        return totalOneOffCustomers.isDisplayed();
    }

    public void verifyCardsOneOff() {
        verifyCommonCardsDisplaying(ofTheTotalDatabasePercentageOneOff, avgNumberOfYearsSinceTheirLastPurchaseOneOff,
                avgRevenuePerCustomerOneOff, avgNumberOfPurchasesOneOff);
        ofTheTotalDatabasePercentageCardIsDisplaying(ofTheTotalDatabasePercentageOneOff);
        avgNumberOfYearsSinceTheirLastPurchaseCardIsDisplaying(avgNumberOfYearsSinceTheirLastPurchaseOneOff);
        avgRevenuePerCustomerCardIsDisplaying(avgRevenuePerCustomerOneOff);
        avgNumberOfPurchasesCardIsDisplaying(avgNumberOfPurchasesOneOff);
    }

    public void verifyGraphsOneOff() throws InterruptedException {
        verifyGraphsInSegmentDisplaying(sourceGraphHeaderOneOff, top5ProductsGraphHeaderOneOff,
                demographicLocationsGraphsHeaderOneOff, demographicLocationTableOneOff,
                demographicLocationMapCanvasOneOff);
        sourceGraphHeaderIsDisplaying(sourceGraphHeaderOneOff);
        top5ProductsHeaderIsDisplaying(top5ProductsGraphHeaderOneOff);
        demographicLocationsGraphsHeaderIsDisplaying(demographicLocationsGraphsHeaderOneOff);
        demographicLocationTableIsDisplaying(demographicLocationTableOneOff);
        demographicLocationMapCanvasIsDisplaying(demographicLocationMapCanvasOneOff);

    }

    public void verifyOneOffPage() {
        boolean isSelected = checkOneOffIsSelected();
        Assert.assertTrue(isSelected, "One-Off is Not Selected");
        System.out.println("Selected One-Off Page");
        boolean isDisplayingOneOff = totalOneOffCustomerPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingOneOff, "Not in the Navigated to One-Off Page");
        System.out.println("One-Off Page");
    }

    //Verify Total Customer Cards
    public void verifyTotalOneOffCustomersCardDisplaying() {
        boolean isDisplayingTotalOneOff = totalOneOffCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalOneOff, "Total One-Off Customer card is not Displaying");
        System.out.println("Total One-Off Customer card is Displaying");
    }

    //Lapsed//
    public boolean checkLapsedIsSelected() {
        return Boolean.parseBoolean(lapsedTab.getAttribute("aria-selected"));
    }

    public boolean checkLapsedIsDisable() {
        return Boolean.parseBoolean(lapsedTab.getAttribute("aria-disabled"));
    }

    public void clickOnLapsedTab() {
        lapsedTab.click();
    }

    //Total Customers Cards
    public boolean totalLapsedCustomerCardIsDisplaying() {
        return totalLapsedCustomerCard.isDisplayed();
    }

    //Test Common Cards
    public void verifyCardsLapsed() {
        verifyCommonCardsDisplaying(ofTheTotalDatabasePercentageLapsed, avgNumberOfYearsSinceTheirLastPurchaseLapsed,
                avgRevenuePerCustomerLapsed, avgNumberOfPurchasesLapsed);
    }

    public void verifyGraphsLapsed() throws InterruptedException {
        verifyGraphsInSegmentDisplaying(sourceGraphHeadersLapsed, top5ProductsGraphHeadersLapsed,
                demographicLocationsGraphsHeadersLapsed, demographicLocationTableLapsed,
                demographicLocationMapCanvasLapsed);
    }

    public boolean totalLapsedCustomerPageHeaderIsDisplaying() {
        return lapsedCustomerPageHeader.isDisplayed();
    }

    public void verifyLapsedPage() {
        boolean isSelected = checkLapsedIsSelected();
        Assert.assertTrue(isSelected, "Lapsed is Not Selected");
        System.out.println("Selected Lapsed Page");
        boolean isDisplayingLapsed = totalLapsedCustomerPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingLapsed, "Not in the Navigated to Lapsed Page");
    }

    public void verifyTotalLapsedCustomersCardDisplaying() {
        boolean isDisplayingTotalLapsed = totalLapsedCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalLapsed, "Total Lapsed Customer card is not Displaying");
        System.out.println("Total Lapsed Customer card is Displaying");
    }

    //
    //Dormant//
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

    public boolean totalDormantCustomerPageHeaderIsDisplaying() {
        return dormantCustomerPageHeader.isDisplayed();
    }

    public boolean totalDormantCustomerCardIsDisplaying() {
        return totalDormantCustomers.isDisplayed();
    }

    //Test Common Cards
    public void verifyCardsDormant() {
        verifyCommonCardsDisplaying(ofTheTotalDatabasePercentageDormant, avgNumberOfYearsSinceTheirLastPurchaseDormant,
                avgRevenuePerCustomerDormant, avgNumberOfPurchasesDormant);
    }

    public void verifyGraphsDormant() throws InterruptedException {
        verifyGraphsInSegmentDisplaying(sourceGraphHeadersDormant, top5ProductsGraphHeadersDormant,
                demographicLocationsGraphsHeadersDormant, demographicLocationTableDormant,
                demographicLocationMapCanvasDormant);
    }

    public void verifyDormantPage() throws InterruptedException {
        Thread.sleep(5000);
        boolean isSelected = checkDormantIsSelected();
        Assert.assertTrue(isSelected, "Dormant is Not Selected");
        System.out.println("Selected Dormant Page");
        boolean isDisplayingDormant = totalDormantCustomerPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingDormant, "Not in the Navigated to Dormant Page");
    }

    public void verifyTotalDormantCustomersCardDisplaying() {
        boolean isDisplayingTotalDormant = totalDormantCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalDormant, "Total Dormant Customer card is not Displaying");
        System.out.println("Total Dormant Customer card is Displaying");
    }

    //
    //Committed//
    public boolean checkCommittedIsSelected() {
        return Boolean.parseBoolean(committedTab.getAttribute("aria-selected"));
    }

    public boolean checkCommittedIsDisable() {
        return Boolean.parseBoolean(committedTab.getAttribute("aria-disabled"));
    }

    public void clickOnCommittedTab() {
        notClickableElementsClick(committedTab, 10000);
    }

    public boolean totalCommittedCardPageHeaderIsDisplaying() {
        return committedCustomerPageHeader.isDisplayed();
    }

    public boolean totalCommittedCustomerCardIsDisplaying() {
        return totalCommittedCustomers.isDisplayed();
    }

    //Test Common Cards
    public void verifyCardsCommitted() {
        verifyCommonCardsDisplaying(ofTheTotalDatabasePercentageCommitted, avgNumberOfYearsSinceTheirLastPurchaseCommitted,
                avgRevenuePerCustomerCommitted, avgNumberOfPurchasesCommitted);
    }

    public void verifyGraphsCommitted() throws InterruptedException {
        verifyGraphsInSegmentDisplaying(sourceGraphHeadersCommitted, top5ProductsGraphHeadersCommitted,
                demographicLocationsGraphsHeadersCommitted, demographicLocationTableCommitted,
                demographicLocationMapCanvasCommitted);
    }

    public void verifyCommittedPage() {
        boolean isSelected = checkCommittedIsSelected();
        Assert.assertTrue(isSelected, "Committed is Not Selected");
        System.out.println("Selected Committed Page");
        boolean isDisplayingCommitted = totalCommittedCardPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingCommitted, "Not in the Navigated to Committed Page");
    }

    public void verifyTotalCommittedCustomersCardDisplaying() {
        boolean isDisplayingTotalCommitted = totalCommittedCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalCommitted, "Total Committed Customer card is not Displaying");
        System.out.println("Total Committed Customer card is Displaying");
    }

    //
    //New//
    public boolean checkNewIsSelected() {
        return Boolean.parseBoolean(newTab.getAttribute("aria-selected"));
    }

    public boolean checkNewIsDisable() {
        return Boolean.parseBoolean(newTab.getAttribute("aria-disabled"));
    }

    public void clickOnNewTab() {
        notClickableElementsClick(newTab, 10000);
    }

    public boolean totalNewCustomersPageHeaderIsDisplaying() {
        return newCustomerPageHeader.isDisplayed();
    }

    public boolean totalNewCustomerCardIsDisplaying() {
        return totalNewCustomers.isDisplayed();
    }

    //Test Common Cards
    public void verifyCardsNew() {
        verifyCommonCardsDisplaying(ofTheTotalDatabasePercentageNew, avgNumberOfYearsSinceTheirLastPurchaseNew,
                avgRevenuePerCustomerNew, avgNumberOfPurchasesNew);
    }

    public void verifyGraphsNew() throws InterruptedException {
        verifyGraphsInSegmentDisplaying(sourceGraphHeadersNew, top5ProductsGraphHeadersNew,
                demographicLocationsGraphsHeadersNew, demographicLocationTableNew,
                demographicLocationMapCanvasNew);
    }

    public void verifyNewPage() {
        boolean isSelected = checkNewIsSelected();
        Assert.assertTrue(isSelected, "New is Not Selected");
        System.out.println("Selected New Page");
        boolean isDisplayingNew = totalNewCustomersPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingNew, "Not in the Navigated to New Page");
    }

    public void verifyTotalNewCustomersCardDisplaying() {
        boolean isDisplayingTotalNew = totalNewCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalNew, "Total New Customer card is not Displaying");
        System.out.println("Total New Customer card is Displaying");
    }

    //
    //VIP//
    public boolean checkVIPIsSelected() {
        return Boolean.parseBoolean(vipTab.getAttribute("aria-selected"));
    }

    public boolean checkVIPIsDisable() {
        return Boolean.parseBoolean(vipTab.getAttribute("aria-disabled"));
    }

    public void clickOnVIPTab() {
        vipTab.click();
    }

    public boolean totalVIPCustomersPageHeaderIsDisplaying() {
        return vipCustomerPageHeader.isDisplayed();
    }

    public boolean totalVIPCustomerCardIsDisplaying() {
        return totalVIPCustomers.isDisplayed();
    }

    //Test Common Cards
    public void verifyCardsVIP() {
        verifyCommonCardsDisplaying(ofTheTotalDatabasePercentageVIP, avgNumberOfYearsSinceTheirLastPurchaseVIP,
                avgRevenuePerCustomerVIP, avgNumberOfPurchasesVIP);
    }

    public void verifyGraphsVIP() throws InterruptedException {
        verifyGraphsInSegmentDisplaying(sourceGraphHeadersVIP, top5ProductsGraphHeadersVIP,
                demographicLocationsGraphsHeadersVIP, demographicLocationTableVIP,
                demographicLocationMapCanvasVIP);
    }

    public void verifyVIPPage() {
        boolean isSelected = checkVIPIsSelected();
        Assert.assertTrue(isSelected, "VIP is Not Selected");
        System.out.println("Selected VIP Page");
        boolean isDisplayingVIP = totalVIPCustomersPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingVIP, "Not in the Navigated to VIP Page");
    }

    public void verifyTotalVIPCustomersCardDisplaying() {
        boolean isDisplayingTotalVIP = totalVIPCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalVIP, "Total VIP Customer card is not Displaying");
        System.out.println("Total VIP Customer card is Displaying");
    }

    //
    //Sporadic VIP//
    public boolean checkSporadicVIPIsSelected() {
        return Boolean.parseBoolean(sporadicVipTab.getAttribute("aria-selected"));
    }

    public boolean checkSporadicVIPIsDisable() {
        return Boolean.parseBoolean(sporadicVipTab.getAttribute("aria-disabled"));
    }

    public void clickOnSporadicVIPTab() {
        sporadicVipTab.click();
    }

    public boolean totalSporadicVIPCustomersPageHeaderIsDisplaying() {
        return sporadicVIPCustomerPageHeader.isDisplayed();
    }

    //Total Customers Cards
    public boolean totalSporadicVIPCustomerCardIsDisplaying() {
        return totalSporadicVIPCustomers.isDisplayed();
    }

    //Test Common Cards
    public void verifyCardsSporadicVIP() {
        verifyCommonCardsDisplaying(ofTheTotalDatabasePercentageSporadicVIP, avgNumberOfYearsSinceTheirLastPurchaseSporadicVIP,
                avgRevenuePerCustomerSporadicVIP, avgNumberOfPurchasesSporadicVIP);
    }

    public void verifyGraphsSporadicVIP() throws InterruptedException {
        verifyGraphsInSegmentDisplaying(sourceGraphHeadersSporadicVIP, top5ProductsGraphHeadersSporadicVIP,
                demographicLocationsGraphsHeadersSporadicVIP, demographicLocationTableSporadicVIP,
                demographicLocationMapCanvasSporadicVIP);
    }

    public void verifySporadicVIPPage() {
        boolean isSelected = checkSporadicVIPIsSelected();
        Assert.assertTrue(isSelected, "Sporadic VIP is Not Selected");
        System.out.println("Selected Sporadic VIP Page");
        boolean isDisplayingSporadicVIP = totalSporadicVIPCustomersPageHeaderIsDisplaying();
        Assert.assertTrue(isDisplayingSporadicVIP, "Not in the Navigated to Sporadic VIP Page");
    }

    public void verifyTotalSporadicVIPCustomersCardDisplaying() {
        boolean isDisplayingTotalSporadicVIP = totalSporadicVIPCustomerCardIsDisplaying();
        Assert.assertTrue(isDisplayingTotalSporadicVIP, "Total Sporadic VIP Customer card is not Displaying");
        System.out.println("Total Sporadic VIP Customer card is Displaying");
    }//


    public void verifyCommonCardsDisplaying(WebElement ofTheTotalElement, WebElement avgNumLastPurchase, WebElement avgRevenue, WebElement avgNumberOfPurchases) {
        //Of the total DB card
        boolean isDisplayingOfTheTotalDatabasePercentage = ofTheTotalDatabasePercentageCardIsDisplaying(ofTheTotalElement);
        Assert.assertTrue(isDisplayingOfTheTotalDatabasePercentage, "Of the total Database percentage Card is not displaying");
        System.out.println("Of the total Database percentage Card is displaying");
        //AVG number of days since their last purchase card
        boolean isDisplayingAvgNumberOfYearsSinceTheirLastPurchase = avgNumberOfYearsSinceTheirLastPurchaseCardIsDisplaying(avgNumLastPurchase);
        Assert.assertTrue(isDisplayingAvgNumberOfYearsSinceTheirLastPurchase, "AVG number of days since their " +
                "last purchase Card is not displaying");
        System.out.println("AVG number of days since their " +
                "last purchase Card is displaying");
        //AVG revenue per customer card
        boolean isDisplayingAvgRevenuePerCustomer = avgRevenuePerCustomerCardIsDisplaying(avgRevenue);
        Assert.assertTrue(isDisplayingAvgRevenuePerCustomer, "AVG revenue per customer Card is not displaying");
        System.out.println("AVG revenue per customer Card is displaying");
        //AVG number of purchases card
        boolean isDisplayingAvgNumberOfPurchases = avgNumberOfPurchasesCardIsDisplaying(avgNumberOfPurchases);
        Assert.assertTrue(isDisplayingAvgNumberOfPurchases, "AVG number of purchases Card is not displaying");
        System.out.println("AVG number of purchases Card is displaying");
    }

    public void verifyGraphsInSegmentDisplaying(WebElement sourceHeader, WebElement top5ProHeader, WebElement demoHeader, WebElement demoTable, WebElement demoMapCanvas) throws InterruptedException {
        //SourceGraphHeader
        boolean isDisplayingSourceGraphHeader = sourceGraphHeaderIsDisplaying(sourceHeader);
        Assert.assertTrue(isDisplayingSourceGraphHeader, "Source Graph Header is not Available");
        System.out.println("Source Graph Header is Available");
        //Top 5 product header
        boolean isDisplayingTop5ProductsHeader = top5ProductsHeaderIsDisplaying(top5ProHeader);
        Assert.assertTrue(isDisplayingTop5ProductsHeader, "Top 5 Product graph header is not Available");
        System.out.println("Top 5 Product graph header is Available");
        //Demographic Locations Graphs Header
        boolean isDisplayingDemographicLocationsGraphsHeader = demographicLocationsGraphsHeaderIsDisplaying(demoHeader);
        Assert.assertTrue(isDisplayingDemographicLocationsGraphsHeader, "Demographic Locations Graphs Header " +
                "is not Available");
        System.out.println("Demographic Locations Graphs Header " +
                "is Available");
        //Demographic Location Table Canvas
        boolean isDisplayingDemographicLocationTable = demographicLocationTableIsDisplaying(demoTable);
        Assert.assertTrue(isDisplayingDemographicLocationTable, "Demographic Location Table Canvas " +
                "is Available");
        System.out.println("Demographic Location Table Canvas " +
                "is Available");
        //Demographic Location Map Canvas
        boolean isDisplayingDemographicLocationMapCanvas = demographicLocationMapCanvasIsDisplaying(demoMapCanvas);
        Assert.assertTrue(isDisplayingDemographicLocationMapCanvas, "Demographic Location Map Canvas is not Available");
        System.out.println("Demographic Location Map Canvas is Available");
//        softAssertion.assertAll();
    }

}
