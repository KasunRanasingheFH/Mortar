package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.*;
import com.mortarportal.qa.pages.EmailsAndJourneysPages.SingleMailingPage;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.FacebookAdvertisingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerChurnPredictionAIAnalytics extends TestBase {
    @FindBy(xpath = "xpath=//h1[contains(text(),'Analytics')]")
    WebElement analyticsLabel;
    @FindBy(xpath = "xpath=//li[contains(text(),'B&M-SankaXYZ')]")
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
    @FindBy(id = "ngb-nav-0")
    WebElement customerChurnPredictionLink;
    @FindBy(xpath = "//button[contains(.,' Export Underlying Sales Data')]")
    WebElement exportUnderlyingSalesDataButton;
    @FindBy(css = "[class='btn btn-outline-dark mx-2']")
    WebElement exportButton;
    @FindBy(id = "ngb-nav-1")
    WebElement salesLink;
    @FindBy(id = "ngb-nav-2")
    WebElement segmentLink;
    @FindBy(id = "ngb-nav-3")
    WebElement productsLink;
    @FindBy(id = "ngb-nav-4")
    WebElement trendsLink;
    @FindBy(id = "ngb-nav-5")
    WebElement demographicLink;
    @FindBy(id = "ngb-nav-6")
    WebElement targetAudienceLink;

    @FindBy(xpath = "//div[2]/div/div/div/div/h5[contains(text(),'Customers at risk of churn')]")
            //[contains(text(),'Customers at risk of churn')]
    WebElement customersAtChurnList;
    @FindBy(css = "[class='text-36 subheading mb-3 ng-star-inserted']")
    WebElement connectYourPlatformText;
    @FindBy(id = "dropdownBasic1")
    WebElement minimumPurchaseCountDropdown;

    public CustomerChurnPredictionAIAnalytics(){
        PageFactory.initElements(driver, this);
    }
    public String verifyAIAnalyticsPageTitle() {
        return driver.getTitle();
    }

    public boolean validateAIAnalyticsHeader() {
        return analyticsLabel.isDisplayed();
    }

    public boolean validateAIAnalyticsText() {
        return businessOwnerID.isDisplayed();
    }

    public BusinessOverview clickOnGoToBusinessOverview() {
        navBusinessOverviewLink.click();
        return new BusinessOverview();
    }
        public MyCustomer clickOnGoToMyCustomer() {
        navMyCustomersLink.click();
        return new MyCustomer();
    }
    public Intergrations clickOnGoToIntergrations() {
        navIntegrationsLink.click();
        return new Intergrations();
    }
    public SingleMailingPage clickOnGoToEmailsAndJourneys() {
        navEmailsAndJourneyLink.click();
        return new SingleMailingPage();
    }
    public FacebookAdvertisingPage clickOnGoToSocialAndDisplayAdvertising() {
        navSocialDisplayAdvertisingLink.click();
//        navFacebookAdvertisingLink.click();
        return new FacebookAdvertisingPage();
    }
    public MyCreatives clickOnGoToMyCreatives() {
        navMyCreativesLink.click();
        return new MyCreatives();
    }

    public boolean customersAtChurnListDisplay(){
        return customersAtChurnList.isDisplayed();
    }
    public void exportUnderlyingSalesDataButtonClick(){
        exportUnderlyingSalesDataButton.click();
    }
    public void exportUnderlyingSalesDataButtonHover(){
        Actions action = new Actions(driver);
        action.moveToElement(exportUnderlyingSalesDataButton);

    }
    public boolean customerNoDataInAIAnalyticsTextCheck(){
        return connectYourPlatformText.isDisplayed();
    }

    public SalesAIAnalytics salesLinkClick(){
        salesLink.click();
        return new SalesAIAnalytics();
    }
    public SegmentsAIAnalytics segmentLinkClick(){
        segmentLink.click();
        return new SegmentsAIAnalytics();
    }
    public ProductsAIAnalytics productLinkClick(){
        productsLink.click();
        return new ProductsAIAnalytics();
    }
    public TrendsAIAnalytics trendsLinkClick(){
        trendsLink.click();
        return new TrendsAIAnalytics();
    }
    public DemographicAIAnalytics demographicLinkClick(){
        demographicLink.click();
        return new DemographicAIAnalytics();
    }
    public TargetAudienceAIAnalytics targetAudienceLinkClick(){
        targetAudienceLink.click();
        return new TargetAudienceAIAnalytics();
    }
    public void changeMinimumPurchaseCount(String minimumPurchaseCountValue){
        Select minimumPurchaseCount = new Select(driver.findElement(By.id("dropdownBasic1")));
        minimumPurchaseCount.selectByValue(minimumPurchaseCountValue);
    }


}
