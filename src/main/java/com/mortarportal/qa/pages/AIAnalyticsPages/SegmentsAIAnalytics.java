package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public boolean totalLapsedCustomerIsDisplaying() {
        return totalLapsedCustomerCard.isDisplayed();
    }

    public boolean totalOneOffCustomerCardIsDisplaying() {
        return oneOffCustomerPageHeader.isDisplayed();
    }

    public boolean totalLapsedCustomerCardIsDisplaying() {
        return lapsedCustomerPageHeader.isDisplayed();
    }

    public boolean totalDormantCustomerCardIsDisplaying() {
        return dormantCustomerPageHeader.isDisplayed();
    }

    public boolean totalCommittedCardIsDisplaying() {
        return committedCustomerPageHeader.isDisplayed();
    }

    public boolean totalNewCustomersIsDisplaying() {
        return newCustomerPageHeader.isDisplayed();
    }

    public boolean totalVIPCustomersIsDisplaying() {
        return vipCustomerPageHeader.isDisplayed();
    }

    public boolean totalSporadicVIPCustomers() {
        return sporadicVIPCustomerPageHeader.isDisplayed();
    }

}
