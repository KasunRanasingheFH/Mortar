package com.mortarportal.qa.pages;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import com.mortarportal.qa.pages.SocialAndDisplayAdvertising.FacebookAdvertisingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessOverview extends TestBase {
    @FindBy(xpath = "//h1[contains(text(),'Business Overview')]")
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
    @FindBy(xpath = "//li[6]/div/span")
    WebElement navSocialDisplayAdvertisingLink;
@FindBy(xpath = "//span[contains(.,'Facebook Advertising')]")
WebElement navFacebookAdvertisingLink;
    //Digital Media Buying From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'Digital Media Buying')]")
    WebElement navDigitalMediaBuyingLink;

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

    public boolean verifyClientName(String brandNameVerify) {
        WebElement verifyName = driver.findElement(By.xpath("//li[contains(text(),'" + brandNameVerify + "')]"));
        return verifyName.isDisplayed();
    }

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

    public EmailsAndJourneys clickOnGoToEmailsAndJourneys() {
        navEmailsAndJourneyLink.click();
        return new EmailsAndJourneys();
    }

    public FacebookAdvertisingPage clickOnGoToSocialAndDisplayAdvertising() {
        navSocialDisplayAdvertisingLink.click();
        navFacebookAdvertisingLink.click();
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
