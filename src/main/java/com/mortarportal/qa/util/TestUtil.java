package com.mortarportal.qa.util;

import com.mortarportal.qa.base.TestBase;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICITY_WAIT = 20;

    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");

    }
}
