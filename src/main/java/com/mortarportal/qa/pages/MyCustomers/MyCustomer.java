package com.mortarportal.qa.pages.MyCustomers;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCustomer extends TestBase {
    @FindBy(xpath = "//h1[contains(text(),'Customers')]")
    WebElement myCustomerPageHeader;
    @FindBy(css = ".col-xl-2:nth-child(1) .card-body")
    WebElement allCustomerCard;
    @FindBy(id = "my-customer")
    WebElement allCustomerRadioButton;
    @FindBy(css = "div:nth-of-type(1) > .filter_lable .btn.btn-gray.p-2.w-100")
    WebElement allCustomersCSVExportButton;
    @FindBy(xpath = "//b[contains(text(),'All Customers')]")
    WebElement allCustomerHeader;
    @FindBy(css = ".col-xl-2:nth-child(2) .card-body")
    WebElement myTopSpenderCustomersCard;
    @FindBy(id = "my_top_spenders")
    WebElement myTopSpenderCustomerRadioButton;
    @FindBy(css = "div:nth-of-type(2) > .filter_lable .btn.btn-gray.p-2.w-100")
    WebElement myTopSpenderCustomerExport;
    @FindBy(css = ".col-xl-2:nth-child(3) .card-body")
    WebElement myMostLoyalCustomersCard;
    @FindBy(id="my_most_loyal")
    WebElement myMostLoyalCustomerRadioButton;
    @FindBy(css = "div:nth-of-type(2) > .filter_lable .btn.btn-gray.p-2.w-100")
    WebElement myMostLoyalCustomerExport;
    @FindBy(css = ".col-xl-2:nth-child(4) .card-body")
    WebElement recentFirstTimePurchasersCard;
    @FindBy(id="recent_first_time_purchasers")
    WebElement recentFirstTimePurchasersRadioButton;
    @FindBy(css = ".col-xl-2:nth-child(5) .card-body")
    WebElement customersMostLikelyToChurnCard;
    @FindBy(css = ".col-xl-2:nth-child(6) .card-body")
    WebElement targetMarketsForMaximumROICard;
    @FindBy(css = ".total__amount")
    WebElement totalCustomerCount;
    @FindBy(id = "search")
    WebElement searchCustomerPanel;
    @FindBy(css = "#submitButton")
    WebElement searchButton;
    @FindBy(xpath = "//button[contains(text(),'Advanced Search')]")
    WebElement advanceSearchButton;
    @FindBy(id = "product_filter")
    WebElement allProductFilterButton;
    @FindBy(xpath = "//span[contains(text(),'Applied Filters:')]")
    WebElement appliedFilteredSectionText;
    @FindBy(css = ".total__amount:nth-child(1)")
    WebElement inferredValueFilterTag;
    @FindBy(css = ".inferred__lable > .check__marked")
    WebElement inferredValueCheckMark;
    @FindBy(id = "all_customers_Inferred")
    WebElement inferredValueCheckMark1;

    public MyCustomer() {
        PageFactory.initElements(driver, this);
    }

}
