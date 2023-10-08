package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class TrendsAIAnalytics extends TestBase {
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics = PageFactory.initElements(driver,
            CustomerChurnPredictionAIAnalytics.class);
    public TrendsAIAnalytics() {
        PageFactory.initElements(driver, this);
    }
    public String verifyMortarTitleTrendsTab() {
        return driver.getTitle();
    }
    public boolean validateAIAnalyticsHeader() {
        return customerChurnPredictionAIAnalytics.analyticsLabel.isDisplayed();
    }
    public boolean productTabIsEnabled() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.productsLink.getAttribute("aria-disabled"));
    }
    public boolean productTabIsSelected() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.productsLink.getAttribute("aria-selected"));
    }
}
