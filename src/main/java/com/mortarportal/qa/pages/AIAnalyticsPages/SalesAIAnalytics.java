package com.mortarportal.qa.pages.AIAnalyticsPages;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

}
