package com.mortarportal.qa.pages.AIAnalyticsPages.SegmentTab;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.AIAnalyticsPages.CustomerChurnPredictionAIAnalytics;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerSegmentByProductCategoryInSegment extends TestBase {

    @FindBy(xpath = "//h4[contains(text(),'Product Category Creator')]")
    WebElement customerSegmentByProductHeader;
    @FindBy(css = "[class='col-md-6 col-lg-6 bm-aligned-middle bm-mobile-aligned mb-2'] [data-intercom-target]")
    WebElement createProductCategoryButton;
    @FindBy(css = ".modal-content")
    WebElement addNewProductCategoryPopUpPanel;
    @FindBy(id = "search")
    WebElement searchInputField;
    @FindBy(id = "submitButton")
    WebElement searchButton;
    @FindBy(id = "dropdownBasic1")
    WebElement topPercentageOfCustomersByRevenue;
    @FindBy(id = "modal-basic-title")
    WebElement addNewProductCategoryPanelHeader;
    @FindBy(css = ".form-control:nth-child(2)")
    WebElement categoryNameInputField;
    @FindBy(css = "[class] [class='form-group col-12']:nth-of-type(1) .ng-star-inserted:nth-child(3) .ng-star-inserted")
    WebElement categoryNameEmptyError;
    //    @FindBy(css = ".ng-input > input")
    @FindBy(xpath = "//ng-select/div/div/div[2]/input")
    WebElement selectProductDropDown;
    @FindBy(css = "div:nth-of-type(2) [role='option']:nth-of-type(1)")
    WebElement dropdownFirstValue1;
    @FindBy(css = "[class] [class='form-group col-12']:nth-of-type(2) .ng-star-inserted:nth-child(3) .ng-star-inserted")
    WebElement productFieldEmptyError;
    @FindBy(css = "#afcc2f4dc14c-0")
    WebElement dropdownFirstValue;
    @FindBy(css = "[for='prod-cat140'] [d]")
    WebElement starIcon;
    @FindBy(css = ".custom__checkboxe__lable .check__marked")
    WebElement addToFavouriteInUpdateProduct;
    @FindBy(css = ".btn-cancel-mortar")
    WebElement cancelButtonInProductCategoryPopup;
    @FindBy(css = ".btn.btn-primary-mortar")
    WebElement creatProductCategoryButtonInPanel;
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
    CustomerChurnPredictionAIAnalytics customerChurnPredictionAIAnalytics = PageFactory.initElements(driver,
            CustomerChurnPredictionAIAnalytics.class);

    public CustomerSegmentByProductCategoryInSegment() {
        PageFactory.initElements(driver, this);
    }

    public String verifyCustomerSegmentByProductCategoryPageTitle() {
        return driver.getTitle();
    }

    public boolean validateAIAnalyticsHeader() {
        return customerChurnPredictionAIAnalytics.analyticsLabel.isDisplayed();
    }

    public boolean segmentTabIsEnabled() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.segmentLink.getAttribute("aria-disabled"));
    }

    public boolean segmentTabIsSelected() {
        return Boolean.parseBoolean(customerChurnPredictionAIAnalytics.segmentLink.getAttribute("aria-selected"));
    }

    public boolean verifyHeaderOfCustomerSegmentByProductCategory() {
        return customerSegmentByProductHeader.isDisplayed();
    }

    public boolean verifyCreateProductCategoryButtonIsAvailable() {
        return createProductCategoryButton.isDisplayed();
    }

    public boolean verifyClickOnCreateCategoryButton() throws InterruptedException {
        Thread.sleep(5000);
        createProductCategoryButton.click();
        System.out.println("1");
        return addNewProductCategoryPopUpPanel.isDisplayed();
    }

    public boolean verifySearchInputFieldIsVisible() {
        return searchInputField.isDisplayed();
    }

    public boolean verifySearchButtonIsVisible() {
        return searchButton.isDisplayed();
    }

    public boolean verifyCategoryNameFieldAvailable() throws InterruptedException {
        verifyClickOnCreateCategoryButton();
        return categoryNameInputField.isDisplayed();
    }

    public boolean verifySelectProductsFieldAvailable() throws InterruptedException {
        verifyClickOnCreateCategoryButton();
        System.out.println("3");
        Thread.sleep(2000);
        return selectProductDropDown.isDisplayed();
    }

    public boolean verifyAddToFavouriteCheckBoxInPanelAvailable() throws InterruptedException {
        verifyClickOnCreateCategoryButton();
        return addToFavouriteInUpdateProduct.isDisplayed();
    }

    public boolean verifyCreateProductCategoryButtonInPanelAvailable() throws InterruptedException {
        verifyClickOnCreateCategoryButton();
        return creatProductCategoryButtonInPanel.isDisplayed();
    }

    public boolean verifyCancelButtonInPanelAvailable() throws InterruptedException {
        verifyClickOnCreateCategoryButton();
        return cancelButtonInProductCategoryPopup.isDisplayed();
    }

    public void verifyAddingValidProductCategoryWithAddingFavourite() throws InterruptedException {
        Thread.sleep(5000);
        verifyClickOnCreateCategoryButton();
        categoryNameInputField.sendKeys("Test1");
        System.out.println("Entered the Category Name As");
        Thread.sleep(5000);
        selectProductDropDown.click();
        dropdownFirstValue1.click();
        System.out.println("Selected a Product As");
        addToFavouriteInUpdateProduct.click();
        System.out.println("Added To Favourite");
        boolean isDisabled = Boolean.parseBoolean(creatProductCategoryButtonInPanel.getAttribute("disabled"));
        Assert.assertFalse(isDisabled, "Disabled");
        creatProductCategoryButtonInPanel.click();
        Thread.sleep(5000);
    }

    public void verifyAddingValidProductCategoryWithoutAddingFavourite() throws InterruptedException {
        Thread.sleep(5000);
        verifyClickOnCreateCategoryButton();
        categoryNameInputField.sendKeys("Test1");
        System.out.println("Entered the Category Name As");
        Thread.sleep(5000);
        selectProductDropDown.click();
        dropdownFirstValue1.click();
        System.out.println("Selected a Product As");
        boolean isDisabled = Boolean.parseBoolean(creatProductCategoryButtonInPanel.getAttribute("disabled"));
        Assert.assertFalse(isDisabled, "Disabled");
        Thread.sleep(5000);
    }

    public void verifyUserNotToAddProductCategoryWithEmptyFields() throws InterruptedException {
        Thread.sleep(5000);
        verifyClickOnCreateCategoryButton();
//    creatProductCategoryButtonInPanel.isEnabled();
        boolean isDisabled = Boolean.parseBoolean(creatProductCategoryButtonInPanel.getAttribute("disabled"));
        Assert.assertTrue(isDisabled, "Not Disabled");
        System.out.println("Create Product Category Button Is Disabled");
    /*creatProductCategoryButtonInPanel.click();
    productFieldEmptyError.isDisplayed();
    categoryNameEmptyError.isDisplayed();*/
        Thread.sleep(5000);
    }

    public void verifyNotToAddOnlyWithEnteringOnlyProductNameToProductCategory() throws InterruptedException {
        Thread.sleep(5000);
        verifyClickOnCreateCategoryButton();
        categoryNameInputField.sendKeys("Test1");
        System.out.println("Entered the Category Name As");
        categoryNameInputField.clear();
        boolean isDisabled = Boolean.parseBoolean(creatProductCategoryButtonInPanel.getAttribute("disabled"));
        Assert.assertTrue(isDisabled, "Not Disabled");
        System.out.println("Create Product Category Button Is Disabled");
        /*creatProductCategoryButtonInPanel.click();
        productFieldEmptyError.isDisplayed();*/
        Thread.sleep(5000);
    }

    public void verifyNotToAddOnlyWithSelectOnlyProductToProductCategory() throws InterruptedException {
        Thread.sleep(5000);
        verifyClickOnCreateCategoryButton();
        selectProductDropDown.click();
        dropdownFirstValue1.click();
        System.out.println("Selected a Product As");
        addToFavouriteInUpdateProduct.click();
        boolean isDisabled = Boolean.parseBoolean(creatProductCategoryButtonInPanel.getAttribute("disabled"));
        Assert.assertTrue(isDisabled, "Not Disabled");
        System.out.println("Create Product Category Button Is Disabled");
        /*creatProductCategoryButtonInPanel.click();
        categoryNameEmptyError.isDisplayed();*/
        Thread.sleep(5000);
    }

    public void verifyErrorMessagesInFieldsWhenEmptiedFieldCategoryNameField() throws InterruptedException {
        Thread.sleep(5000);
        verifyClickOnCreateCategoryButton();
        categoryNameInputField.sendKeys("T");
        System.out.println("Entered the Category Name As");
        Thread.sleep(5000);
        categoryNameInputField.sendKeys(Keys.BACK_SPACE);
        selectProductDropDown.click();
//    categoryNameInputField.clear();
        boolean isDisplaying = categoryNameEmptyError.isDisplayed();
        System.out.println("isDis" + isDisplaying);
    }

    public void verifyErrorMessagesInFieldsWhenEmptiedFieldProductCategoryField() throws InterruptedException {
        Thread.sleep(5000);
        verifyClickOnCreateCategoryButton();
        selectProductDropDown.click();
        Thread.sleep(5000);
        categoryNameInputField.click();
//    categoryNameInputField.clear();
        boolean isDisplaying = productFieldEmptyError.isDisplayed();
        System.out.println("isDis" + isDisplaying);
    }

    public void verifyCloseButtonWhenFieldsAreEmptyProductCategory() throws InterruptedException {
        Thread.sleep(5000);
        verifyClickOnCreateCategoryButton();
        cancelButtonInProductCategoryPopup.click();
    }

    public void verifyCloseButtonClickWhenFieldsAreFilled() throws InterruptedException {
        Thread.sleep(5000);
        verifyClickOnCreateCategoryButton();
        categoryNameInputField.sendKeys("Test1");
        System.out.println("Entered the Category Name As");
        Thread.sleep(5000);
        selectProductDropDown.click();
        dropdownFirstValue1.click();
        System.out.println("Selected a Product As");
        addToFavouriteInUpdateProduct.click();
        System.out.println("Added To Favourite");
        cancelButtonInProductCategoryPopup.click();
    }
}
