package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SegmentsAIAnalytics extends TestBase {
    //Customer segment by RFMT
    @FindBy(id = "ngb-nav-48")
    WebElement customerSegmentByRFMT;
    //Customer segment by product category
    @FindBy(id = " ngb-nav-49")
    WebElement customerSegmentByProductCategory;
    @FindBy(id = "ngb-nav-16")
    WebElement oneOffTab;
    @FindBy(id = "ngb-nav-17")
    WebElement lapsedTab;
    @FindBy(id = "ngb-nav-18")
    WebElement dormantTab;
    @FindBy(id = "ngb-nav-19")
    WebElement committedTab;
    @FindBy(id = "ngb-nav-20")
    WebElement newTab;
    @FindBy(id = "ngb-nav-21")
    WebElement vipTab;
    @FindBy(id = "ngb-nav-22")
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
}
