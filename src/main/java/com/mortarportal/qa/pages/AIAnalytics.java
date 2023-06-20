package com.mortarportal.qa.pages;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.*;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertising.FacebookAdvertisingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AIAnalytics extends TestBase {

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
    //AI Analytics Page
    @FindBy(id = "ngb-nav-0")
    WebElement customerChurnPredictionLink;
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


    public AIAnalytics() {
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

    public AIAnalytics clickOnGoToAIAnalytics() {
        navAiAnalyticsLink.click();
        return new AIAnalytics();
    }

    public MyCustomer clickOnGoToMyCustomer() {
        navMyCustomersLink.click();
        return new MyCustomer();
    }

    public Intergrations clickOnGoToIntergrations() {
        navIntegrationsLink.click();
        return new Intergrations();
    }

    public EmailsAndJourneys clickOnGoToEmailsAndJourneys() {
        navEmailsAndJourneyLink.click();
        return new EmailsAndJourneys();
    }

    public FacebookAdvertisingPage clickOnGoToSocialAndDisplayAdvertising() {
        navSocialDisplayAdvertisingLink.click();
        return new FacebookAdvertisingPage();
    }

    public DigitalMediaBuying clickOnGoToDigitalMediaBuying() {
        navDigitalMediaBuyingLink.click();
        return new DigitalMediaBuying();
    }

    public MyCreatives clickOnGoToMyCreatives() {
        navMyCreativesLink.click();
        return new MyCreatives();
    }

    public CustomerChurnPredictionAIAnalytics clickOnGoToCustomerChurnPredictionAIAnalytics() {
        customerChurnPredictionLink.click();
        return new CustomerChurnPredictionAIAnalytics();
    }

    public SalesAIAnalytics clickOnGoToSalesAIAnalytics() {
        salesLink.click();
        return new SalesAIAnalytics();
    }

    public SegmentsAIAnalytics clickOnGoToSegmentsAIAnalytics() {
        segmentLink.click();
        return new SegmentsAIAnalytics();
    }

    public ProductsAIAnalytics clickOnGoToProductsAIAnalytics() {
        productsLink.click();
        return new ProductsAIAnalytics();
    }

    public TrendsAIAnalytics clickOnGoToTrendsAIAnalytics() {
        trendsLink.click();
        return new TrendsAIAnalytics();
    }

    public DemographicAIAnalytics clickOnGoToDemographicAIAnalytics() {
        demographicLink.click();
        return new DemographicAIAnalytics();
    }

    public TargetAudienceAIAnalytics clickOnGoToTargetAudienceAIAnalytics() {
        demographicLink.click();
        return new TargetAudienceAIAnalytics();
    }

}
