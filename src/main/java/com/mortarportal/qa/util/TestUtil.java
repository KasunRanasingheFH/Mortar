package com.mortarportal.qa.util;

import com.mortarportal.qa.base.TestBase;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 60;
    public static long IMPLICITLY_WAIT = 30;

    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");

    }
}
