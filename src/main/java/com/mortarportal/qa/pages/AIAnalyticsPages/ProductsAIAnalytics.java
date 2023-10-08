package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsAIAnalytics extends TestBase {
    @FindBy(css = "[class] [class='mb-4 col-md-6']:nth-of-type(1) [class='card-title m-0 p-3 text-left dis-block']")
    WebElement top10ProductHeader;
    @FindBy(css = "[class] [class='mb-4 col-md-6']:nth-of-type(1) [data-zr-dom-id]")
    WebElement top10ProductGraphCanvas;
    @FindBy(xpath = "//label[@for='top10-1']")
    WebElement top10ProductByQuantity;
    @FindBy(xpath = "//label[@for='top10-2']")
    WebElement top10ProductByRevenue;
    @FindBy(css = "[class] [class='mb-4 col-md-6']:nth-of-type(2) [class='card-title m-0 p-3 text-left dis-block']")
    WebElement bottom10ProductHeader;
    @FindBy(css = "[class] [class='mb-4 col-md-6']:nth-of-type(2) [data-zr-dom-id]")
    WebElement bottom10ProductGraphCanvas;
    @FindBy(xpath = "//label[@for='bottom10-1']")
    WebElement bottom10ProductByQuantity;
    @FindBy(xpath = "//label[@for='bottom10-2']")
    WebElement bottom10ProductByRevenue;

    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics = PageFactory.initElements(driver,
            CustomerChurnPredictionAIAnalytics.class);
    public ProductsAIAnalytics() {
        PageFactory.initElements(driver, this);
    }
    public String verifyMortarTitleProductsTab() {
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
    public boolean verifyTop10ProductsHeader() {
        return top10ProductHeader.isDisplayed();
    }
    public boolean verifyTop10ProductsCanvas() {
        return top10ProductGraphCanvas.isDisplayed();
    }
    public boolean verifyTop10ProductsQuantityIsAvailable() {
        return top10ProductByQuantity.isDisplayed();
    }
    public boolean verifyTop10ProductsRevenueIsAvailable() {
        return top10ProductByRevenue.isDisplayed();
    }
    public boolean verifyBottom10ProductsHeader() {
        return bottom10ProductHeader.isDisplayed();
    }
    public boolean verifyBottom10ProductsCanvas() {
        return bottom10ProductGraphCanvas.isDisplayed();
    }
    public boolean verifyBottom10ProductsQuantityIsAvailable() {
        return bottom10ProductByQuantity.isDisplayed();
    }
    public boolean verifyBottom10ProductsRevenueIsAvailable() {
        return bottom10ProductByRevenue.isDisplayed();
    }
}

