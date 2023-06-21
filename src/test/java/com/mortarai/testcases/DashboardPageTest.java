package com.mortarai.testcases;

import com.mortarportal.qa.base.TestBase;
import com.mortarportal.qa.pages.BusinessOverview;
import com.mortarportal.qa.pages.DashboardPage;
import com.mortarportal.qa.pages.LoginPage;
import com.mortarportal.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class DashboardPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage, dashboardPage1;
    TestUtil testUtil;
//    ClientDashboard clientDashboard;
    BusinessOverview businessOverview;

    public DashboardPageTest() {
        super();
    }

    //  Test Case should be Separated -- independent with each other
    //  before each test case -- launch the browser and login
    //  @test -- execute test cases
    //  after each test case -- close the browser
    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
        testUtil = new TestUtil();
        businessOverview = new BusinessOverview();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
//        clientDashboard = dashboardPage.clickOnGoToClientDashboard();
    }

    @Test(priority = 1)
    public void verifyDashboardPageTitleTest() {
        String title = dashboardPage.verifyMortarTitle();
        Assert.assertEquals(title, "Web Portal", "Home page Title is not matched");
    }

    @Test(priority = 2)
    public void verifyDashboardTextTest() {
//        testUtil.switchToFrame();
        Assert.assertTrue(dashboardPage.verifyDashboardText());
    }

    @Test(priority = 3)
    public void verifySearchABrandTest() {
//        testUtil.switchToFrame();
//        dashboardPage.searchABrand("B&M-SankaXYZ");
        dashboardPage.searchABrand("B&M-SankaXYZ2");
    }

    @Test(priority = 4)
    public void verifyClickGoToBrandDashboardTest() {
//        testUtil.switchToFrame();
        businessOverview = dashboardPage.clickOnGoToClientsBusinessOverView();
    }

    @Test(priority = 5)
    public void verifySearchABrandAndGoToBrandDashboard() {

        dashboardPage.searchABrand(prop.getProperty("brandName"));
        String searchedUser = dashboardPage.verifySearchedBrand();
        Assert.assertEquals(searchedUser, prop.getProperty("brandName"),"Searched user is displaying wrong");
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
