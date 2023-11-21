package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrendsAIAnalytics extends TestBase {
    @FindBy(css = ".card-title.dis-block.m-0.p-3.text-left")
    WebElement cumulativeSalesChartTitle;
    @FindBy(css = "[data-zr-dom-id]")
    WebElement cumulativeSalesChartCanvas;
    @FindBy(css = ".charts div:nth-of-type(2) span:nth-child(2)")
    WebElement previousSales;
    @FindBy(css = ".charts div:nth-of-type(2) span:nth-child(6)")
    WebElement currentSales;
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
    public boolean trendsTabIsEnabled() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.trendsLink.getAttribute("aria-disabled"));
    }
    public boolean trendsTabIsSelected() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.trendsLink.getAttribute("aria-selected"));
    }
    public boolean verifyCumulativeSalesChartHeader(){
        return cumulativeSalesChartTitle.isDisplayed();
    }
    public boolean verifyCumulativeSalesChartCanvas(){
        return cumulativeSalesChartCanvas.isDisplayed();
    }
    public void verifyClickOnPreviousSalesFilter(){
        previousSales.click();
    }
    public void verifyClickOnCurrentSalesFilter(){
        currentSales.click();
    }
}
