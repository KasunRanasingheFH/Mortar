package com.mortarportal.qa.pages;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertising.FacebookAdvertisingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar extends TestBase {
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
    public NavigationBar(){
        PageFactory.initElements(driver, this);
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

}
