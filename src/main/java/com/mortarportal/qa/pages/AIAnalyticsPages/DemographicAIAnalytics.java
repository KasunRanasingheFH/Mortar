package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class DemographicAIAnalytics extends TestBase {

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
}
