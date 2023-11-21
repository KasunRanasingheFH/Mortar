package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemographicAIAnalytics extends TestBase {
    @FindBy(css = "app-demographic [class='col-xl-6 mb-4 graphs_loader']:nth-of-type(1) [class='card-title m-0 p-3 text-left dis-block']")
    WebElement locationByNumberOfCustomersHeader;
    @FindBy(css = "app-demographic [class='col-xl-6 mb-4 graphs_loader']:nth-of-type(2) [class='card-title m-0 p-3 text-left dis-block']")
    WebElement locationByTotalCustomerSpendHeader;
    @FindBy(css = ".col-xl-6:nth-child(3) .card-title")
    WebElement customerGenderDistribution;
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics = PageFactory.initElements(driver,
            CustomerChurnPredictionAIAnalytics.class);

    public DemographicAIAnalytics() {
        PageFactory.initElements(driver, this);
    }

    public String verifyMortarTitleDemographicTab() {
        return driver.getTitle();
    }

    public boolean validateAIAnalyticsHeader() {
        return customerChurnPredictionAIAnalytics.analyticsLabel.isDisplayed();
    }

    public boolean demographicTabIsEnabled() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.demographicLink.getAttribute("aria-disabled"));
    }

    public boolean demographicTabIsSelected() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.demographicLink.getAttribute("aria-selected"));
    }
    public boolean verifyLocationByNumberOfCustomersHeader(){
        return locationByNumberOfCustomersHeader.isDisplayed();
    }
    public boolean verifyLocationByTotalCustomerSpendHeader(){
        return locationByTotalCustomerSpendHeader.isDisplayed();
    }
    public boolean verifyCustomerGenderDistribution(){
        return customerGenderDistribution.isDisplayed();
    }
}
