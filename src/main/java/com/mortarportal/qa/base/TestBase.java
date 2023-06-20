package com.mortarportal.qa.base;


import com.mortarportal.qa.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    //Web driver Static
    public static WebDriver driver;
    public static Properties prop;
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/mortarportal/"
                    + "/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {

        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            /*System.setProperty("webdriver.chrome.driver", "H:\\Firehouse\\Mortar\\MortarNew\\MortarPOM\\WebDriver\\chromedriver_win113\\chromedriver.exe");
            driver = new ChromeDriver();*/
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("chrome-headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        }
        // Maximise the Browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }

  /*  @AfterMethod
    public void afterMethod()
    {
        logger.info("In AfterMethod");
        driver.close();
    }*/
}
