package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TargetAudienceAIAnalytics extends TestBase {
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics = PageFactory.initElements(driver,
            CustomerChurnPredictionAIAnalytics.class);
    public TargetAudienceAIAnalytics() {
        PageFactory.initElements(driver, this);
    }
    public String verifyMortarTitleTargetAudienceTab() {
        return driver.getTitle();
    }
    public boolean validateAIAnalyticsHeader() {
        return customerChurnPredictionAIAnalytics.analyticsLabel.isDisplayed();
    }
    public boolean targetAudienceTabIsEnabled() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.productsLink.getAttribute("aria-disabled"));
    }
    public boolean targetAudienceTabIsSelected() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.productsLink.getAttribute("aria-selected"));
    }
}
