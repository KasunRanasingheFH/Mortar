package com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab;

import com.mortarportal.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerSegmentByProductCategoryInSegment extends TestBase {
    @FindBy(xpath = "//h4[contains(text(),'Product Category Creator')]")
    WebElement customerSegmentByProductHeader;
    @FindBy(css = "[class='col-md-6 col-lg-6 bm-aligned-middle bm-mobile-aligned mb-2'] .btn-primary-bsa-nav")
    WebElement createProductCategoryButton;
    @FindBy(id = "search")
    WebElement searchInputField;
    @FindBy(id = "submitButton")
    WebElement searchButton;
    @FindBy(id = "dropdownBasic1")
    WebElement topPercentageOfCustomersByRevenue;
    @FindBy(id = "modal-basic-title")
    WebElement addNewProductPanel;
    @FindBy(css = ".form-control:nth-child(2)")
    WebElement categoryNameInputField;
    @FindBy(css = ".ng-input > input")
    WebElement selectProductDropDown;
    @FindBy(css = "[for='prod-cat140'] [d]")
    WebElement starIcon;
    @FindBy(id = "add_fav")
    WebElement addToFavouriteInUpdateProduct;
    @FindBy(css = ".btn-cancel-mortar")
    WebElement cancelButtonInProductCategoryPopup;
    @FindBy(css = ".btn-primary-mortar")
    WebElement creatProductCategoryButton;
    @FindBy(css = "[class='col-xl-3 col-lg-6 col-md-6 col-sm-12 fave-cards']:nth-of-type(2) [class='btn btn-link px-1 py-0 btn-delete']")
    WebElement deleteProductCategory;
    @FindBy(css = "[class='col-xl-3 col-lg-6 col-md-6 col-sm-12 fave-cards']:nth-of-type(2) [class='btn btn-link px-1 py-0 btn-edit']")
    WebElement editProductCategory;
    //    String productCategoryName;
    String productCatName = prop.getProperty("ProductCategoryName");
    @FindBy(xpath = "//h5[contains(text(),productCatName)]")
    WebElement productCategoryName;
    @FindBy(xpath = "//a[contains(text(),productCatName)]")
    WebElement selectAFavouriteProduct;

}
