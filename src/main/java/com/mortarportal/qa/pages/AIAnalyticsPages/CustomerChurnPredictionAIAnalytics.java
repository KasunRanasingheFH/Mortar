package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab.CustomerSegmentsByRFMT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerChurnPredictionAIAnalytics extends TestBase {
    @FindBy(xpath = "//h1[contains(text(),'Analytics')]")
    public WebElement analyticsLabel;
    @FindBy(xpath = "//li[contains(text(),'B&M-SankaXYZ')]")
    WebElement businessOwnerID;
    //Nav BAr
    //Business Overview Button
    @FindBy(xpath = "//span[contains(text(),'Business Overview')]")
    WebElement navBusinessOverviewLink;

    //Ai Analytics From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'AI Analytics')]")
    WebElement navAiAnalyticsLink;

    //My Customer From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'My Customers')]")
    WebElement navMyCustomersLink;

    //Integration From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'Integrations')]")
    WebElement navIntegrationsLink;

    //Emails & Journeys From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'Emails & Journeys')]")
    WebElement navEmailsAndJourneyLink;

    //Social & Display Advertising From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'Social & Display Advertising')]")
    WebElement navSocialDisplayAdvertisingLink;

    //Digital Media Buying From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'Digital Media Buying')]")
    WebElement navDigitalMediaBuyingLink;

    //My Creatives From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'My Creatives')]")
    WebElement navMyCreativesLink;
    //Date Filter
    @FindBy(id = "dropdownMenuButton")
    WebElement dateFilterButton;
    @FindBy(css = "[class='dropdown-menu mb-2 show'] .dropdown-item:nth-child(1)")
    WebElement next30DaysFilter;
    @FindBy(css = "[class='dropdown-menu mb-2 show'] .dropdown-item:nth-of-type(2)")
    WebElement next60DaysFilter;
    @FindBy(css = "[class='dropdown-menu mb-2 show'] .dropdown-item:nth-of-type(3)")
    WebElement previous30DaysFilter;
    @FindBy(css = "[class='dropdown-menu mb-2 show'] .dropdown-item:nth-of-type(4)")
    WebElement previous60DaysFilter;
    //AI Analytics Page
    @FindBy(xpath = "//button[contains(.,' Export Underlying Sales Data')]")
    WebElement exportUnderlyingSalesDataButton;
    @FindBy(id = "ngb-nav-0")
    WebElement customerChurnPredictionLink;
    @FindBy(css = "[class='btn btn-outline-dark mx-2']")
    WebElement exportButton;
    @FindBy(id = "ngb-nav-1")
    WebElement salesLink;
    @FindBy(id = "ngb-nav-2")
    public WebElement segmentLink;
    @FindBy(id = "ngb-nav-3")
    WebElement productsLink;
    @FindBy(id = "ngb-nav-4")
    WebElement trendsLink;
    @FindBy(id = "ngb-nav-5")
    WebElement demographicLink;
    @FindBy(id = "ngb-nav-6")
    WebElement targetAudienceLink;

    @FindBy(css = "[class='col-md-6 col-lg-6 bm-aligned-middle bm-mobile-aligned'] h5")
    //[contains(text(),'Customers at risk of churn')]
    WebElement customersAtChurnList;

    @FindBy(css = "[class='text-36 subheading mb-3 ng-star-inserted']")
    WebElement connectYourPlatformText;
    @FindBy(id = "dropdownBasic1")
    WebElement minimumPurchaseCountDropdown;

    public CustomerChurnPredictionAIAnalytics() {
        PageFactory.initElements(driver, this);
    }

    public String verifyAIAnalyticsPageTitle() {
        return driver.getTitle();
    }

    public boolean validateAIAnalyticsHeader() {
        return analyticsLabel.isDisplayed();
    }
    public boolean customerChurnPredictionIsEnabled() {
        return Boolean.parseBoolean(customerChurnPredictionLink.getAttribute("aria-disabled"));
    }


    public boolean customerChurnPredictionIsSelected() {
        return Boolean.parseBoolean(customerChurnPredictionLink.getAttribute("aria-selected"));
    }

    public boolean validateAIAnalyticsText() {
        return businessOwnerID.isDisplayed();
    }


    public boolean customersAtChurnListDisplay() {
        return customersAtChurnList.isDisplayed();
    }

    public String verifyCustomerAtChurnListHeaderName() {
        String text = customersAtChurnList.getText();
        System.out.println(text);
        return text;
    }

    public void exportUnderlyingSalesDataButtonClick() {
        exportUnderlyingSalesDataButton.click();
    }

    public void exportUnderlyingSalesDataButtonHover() {
        Actions action = new Actions(driver);
        action.moveToElement(exportUnderlyingSalesDataButton);

    }

    public boolean customerNoDataInAIAnalyticsTextCheck() {
        return connectYourPlatformText.isDisplayed();
    }

    public SalesAIAnalytics salesLinkClick() {
        salesLink.click();
        return new SalesAIAnalytics();
    }

    public CustomerSegmentsByRFMT segmentLinkClick() {
        segmentLink.click();
        return new CustomerSegmentsByRFMT();
    }

    public ProductsAIAnalytics productLinkClick() {
        productsLink.click();
        return new ProductsAIAnalytics();
    }

    public TrendsAIAnalytics trendsLinkClick() {
        trendsLink.click();
        return new TrendsAIAnalytics();
    }

    public DemographicAIAnalytics demographicLinkClick() {
        demographicLink.click();
        return new DemographicAIAnalytics();
    }

    public TargetAudienceAIAnalytics targetAudienceLinkClick() {
        targetAudienceLink.click();
        return new TargetAudienceAIAnalytics();
    }

    public void changeMinimumPurchaseCount(String minimumPurchaseCountValue) {
        Select minimumPurchaseCount = new Select(driver.findElement(By.id("dropdownBasic1")));
        minimumPurchaseCount.selectByValue(minimumPurchaseCountValue);
    }


}
