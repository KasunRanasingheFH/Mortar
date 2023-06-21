package com.mortarportal.qa.pages;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.DigitalMediaBuyingPages.CampaignReportingPage;
import com.mortarportal.qa.pages.DigitalMediaBuyingPages.CreatNewCampaignPage;
import com.mortarportal.qa.pages.EmailsAndJourneysPages.SingleMailingPage;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.FacebookAdvertisingPage;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.GoogleAnalyticsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessOverview extends TestBase {
    @FindBy(xpath = "//h1[@innertext='Business Overview']")
    WebElement BusinessOverviewPageText;
    @FindBy(xpath = "//li[contains(text(),'B&M-SankaXYZ')]")
    WebElement businessOwnerID;
    //NAVBAR//////////////
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
//    @FindBy(xpath = "//span[contains(text(),'Emails & Journeys')]")
    @FindBy(xpath = "//li[5]/div")
    WebElement navEmailsAndJourneyLink;

    //Social & Display Advertising From Nav Bar
//    @FindBy(xpath = "//span[contains(text(),'Social & Display Advertising')]")
    @FindBy(css = "[data-intercom-target='Social \\& Display Advertising'] .nav-text")
    WebElement navSocialDisplayAdvertisingLink;
    @FindBy(css = "[href='\\/social-and-display-ads\\/facebook'] .item-name")
    WebElement navFacebookAdvertisingPageLink;
    @FindBy(css = ".childNav .ng-star-inserted:nth-of-type(2) .item-name")
    WebElement navGoogleAnalyticsPageLink;
    //Digital Media Buying From Nav Bar
    @FindBy(css = "[data-intercom-target='Digital Media Buying'] .nav-text")
    WebElement navDigitalMediaBuyingLink;
    @FindBy(css = "[href='\\/digital-media-buying\\/campaigns'] .item-name")
    WebElement campaignReportingPageLink;
    @FindBy(css = ".childNav .ng-star-inserted:nth-of-type(2) .item-name")
    WebElement campaignCreatingPageLink;
    //My Creatives From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'My Creatives')]")
    WebElement navMyCreativesLink;
    ///

    public BusinessOverview() {
        PageFactory.initElements(driver, this);
    }

    public String validateBusinessOverviewPageTitle() {
        return driver.getTitle();
    }

    public String verifyBusinessOverviewPageText() {
        return BusinessOverviewPageText.getText();
    }

    /*public boolean verifyClientName(String brandNameVerify) {
        WebElement verifyName = driver.findElement(By.xpath("//li[contains(text(),'" + brandNameVerify + "')]"));
        return verifyName.isDisplayed();
    }*/

    public boolean verifyBusinessOwnerID(String businessOwnerId) {
        return driver.findElement(By.xpath("//li[contains(" +
                "text(),'" + businessOwnerId + "')]")).isDisplayed();
    }

    public BusinessOverview clickOnGoToBusinessOverview() {
        navBusinessOverviewLink.click();
        return new BusinessOverview();
    }

    public CustomerChurnPredictionAIAnalytics clickOnGoToAIAnalytics() {
        navAiAnalyticsLink.click();
        return new CustomerChurnPredictionAIAnalytics();
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

    public void clickOnNavSocialDisplayAdvertisingLink() {
        navSocialDisplayAdvertisingLink.click();
    }

    public FacebookAdvertisingPage clickOnGoToFacebookAdvertisingPage() {
        navSocialDisplayAdvertisingLink.click();
        navFacebookAdvertisingPageLink.click();
        return new FacebookAdvertisingPage();
    }

    public GoogleAnalyticsPage clickOnGoToAIAnalyticsPage() {
        navSocialDisplayAdvertisingLink.click();
        navGoogleAnalyticsPageLink.click();
        return new GoogleAnalyticsPage();
    }

    public void clickOnNavDigitalMediaBuying() {
        navDigitalMediaBuyingLink.click();
    }
    public CampaignReportingPage clickOnGoToCampaignReportingPage() {
        navDigitalMediaBuyingLink.click();
        campaignReportingPageLink.click();
        return new CampaignReportingPage();
    }
    public CreatNewCampaignPage clickOnGoToCreatNewCampaignPage() {
        navDigitalMediaBuyingLink.click();
        campaignCreatingPageLink.click();
        return new CreatNewCampaignPage();
    }

    public MyCreatives clickOnGoToMyCreatives() {
        navMyCreativesLink.click();
        return new MyCreatives();
    }

}
