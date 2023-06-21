package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.*;
import com.mortarportal.qa.pages.EmailsAndJourneysPages.SingleMailingPage;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertisingPages.FacebookAdvertisingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//div[2]/div/div/div/div/h5[contains(text(),'Customers at risk of churn')]")
            //[contains(text(),'Customers at risk of churn')]
    WebElement customersAtChurnList;
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
    public boolean verifyCustomersAtChurnListDisplay(){
        return customersAtChurnList.isDisplayed();
    }
    public void changeMinimumPurchaseCount(String minimumPurchaseCountValue){
        Select minimumPurchaseCount = new Select(driver.findElement(By.id("dropdownBasic1")));
        minimumPurchaseCount.selectByValue(minimumPurchaseCountValue);
    }


}
