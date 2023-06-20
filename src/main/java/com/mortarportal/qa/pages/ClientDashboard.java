package com.mortarportal.qa.pages;/*
package com.mortarportal.qa.pages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientDashboard extends TestBase {

    @FindBy(xpath = "//h1[contains(text(),'Business Overview')]")
    WebElement ClientDashboardText;
    @FindBy(xpath = "xpath=//li[contains(text(),'B&M-SankaXYZ')]")
    WebElement businessOwnerID;

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

    @FindBy(xpath = "//li[contains(text(),'B&M-SankaXYZ')]")
    WebElement brandNameText;
    //Initializing the Page Objects;
    public ClientDashboard(){
        PageFactory.initElements(driver, this);
    }
    public boolean verifyClientDashboardText(){
        return ClientDashboardText.isDisplayed();
    }
    public boolean verifyClientName(String brandNameVerify){
         WebElement verifyName = driver.findElement(By.xpath("//li[contains(text(),'"+brandNameVerify+"')]"));
        return verifyName.isDisplayed();
    }
    public boolean verifyBusinessOwnerID(String businessOwnerId){
        return driver.findElement(By.xpath("//li[contains(" +
                "text(),'"+businessOwnerId+"')]")).isDisplayed();
    }
    public BusinessOverview clickOnGoToBusinessOverview(){
        navBusinessOverviewLink.click();
        return new BusinessOverview();
    }
    public AIAnalytics clickOnGoToAIAnalytics(){
        navAiAnalyticsLink.click();
        return new AIAnalytics();
    }
    public MyCustomer clickOnGoToMyCustomer(){
        navMyCustomersLink.click();
        return new MyCustomer();
    }
    public Intergrations clickOnGoToIntergrations(){
        navIntegrationsLink.click();
        return new Intergrations();
    }
    public EmailsAndJourneys clickOnGoToEmailsAndJourneys(){
        navEmailsAndJourneyLink.click();
        return new EmailsAndJourneys();
    }
    public SocialAndDisplayAdvertising clickOnGoToSocialAndDisplayAdvertising(){
        navSocialDisplayAdvertisingLink.click();
        return new SocialAndDisplayAdvertising();
    }
    public DigitalMediaBuying clickOnGoToDigitalMediaBuying(){
        navDigitalMediaBuyingLink.click();
        return new DigitalMediaBuying();
    }
    public MyCreatives clickOnGoToMyCreatives(){
        navMyCreativesLink.click();
        return new MyCreatives();
    }

}
*/
