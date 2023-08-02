package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesAIAnalytics extends TestBase {
//Graphs
    @FindBy(css = "[class] [class='col-xl-6 mb-4 ng-star-inserted']:nth-of-type(1) [class='m-0 p-3 text-left dis-block']")
    WebElement averageHourlySalesGraphHeader;
    @FindBy(css = "[class] [class='col-xl-6 mb-4 ng-star-inserted']:nth-of-type(2) [class='m-0 p-3 text-left dis-block']")
    WebElement averageDailySalesGraphHeader;
    @FindBy(css = "[class] [class='col-xl-6 mb-4 ng-star-inserted']:nth-of-type(3) [class='m-0 p-3 text-left dis-block']")
    WebElement averageMonthlySalesGraphHeader;
    @FindBy(css = "[class] [class='col-xl-6 mb-4 ng-star-inserted']:nth-of-type(4) [class='m-0 p-3 text-left dis-block']")
    WebElement yearlySalesByQuarter;
//Yearly Sales by Quarter Years Checkbox
    @FindBy(id = "year-2020")
    WebElement year2020Checkbox;
    @FindBy(id = "year-2021")
    WebElement year2021Checkbox;
    @FindBy(id = "year-2022")
    WebElement year2022Checkbox;
    @FindBy(id = "year-2023")
    WebElement year2023Checkbox;
    public SalesAIAnalytics() {
        PageFactory.initElements(driver, this);
    }
    public String verifyMortarTitleSalesTab() {
        return driver.getTitle();
    }
    public boolean verifyAverageHourlySalesGraphHeader(){
        return averageHourlySalesGraphHeader.isDisplayed();
    }
    public boolean verifyAverageDailySalesGraphHeader(){
        return averageDailySalesGraphHeader.isDisplayed();
    }
    public boolean verifyAverageMonthlySalesGraphHeader(){
        return averageMonthlySalesGraphHeader.isDisplayed();
    }
    public boolean verifyYearlySalesByQuarter(){
        return yearlySalesByQuarter.isDisplayed();
    }
    public boolean verifySelectYear2020InYearlySalesByQuarter(){
      return year2020Checkbox.isSelected();
    }
    public boolean verifySelectYear2021InYearlySalesByQuarter(){
        return year2021Checkbox.isSelected();
    }
    public boolean verifySelect2022InYearlySalesByQuarter(){
        return year2022Checkbox.isSelected();
    }
    public boolean verifySelect2023InYearlySalesByQuarter(){
        return year2023Checkbox.isSelected();
    }
}
