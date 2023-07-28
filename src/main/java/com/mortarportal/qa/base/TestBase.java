package com.mortarportal.qa.base;


import com.google.common.collect.ImmutableList;
import com.mortarportal.qa.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
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

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }


    public static void initialization(String browser) {

//        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("remote-allow-origins=*");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            //            Maximize the browser
            options.addArguments("test-type");
            options.addArguments("start-maximized");
            options.setExperimentalOption("excludeSwitches", ImmutableList.of("disable-popup-blocking"));
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {

        } else if (browser.equalsIgnoreCase("edge")) {

        } else if (browser.equalsIgnoreCase("safari")) {

        } else if (browser.equalsIgnoreCase("chrome-headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox-headless")) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary(firefoxBinary);
            driver = new FirefoxDriver(options);

        } else {
            System.exit(-1);
        }

//        String browser = prop.getProperty("browser");

//        if (browser.equalsIgnoreCase("chrome")) {
//            /*System.setProperty("webdriver.chrome.driver", "H:\\Firehouse\\Mortar\\MortarNew\\MortarPOM\\WebDriver\\chromedriver_win113\\chromedriver.exe");
//            driver = new ChromeDriver();*/
////            WebDriverManager.chromedriver().setup();
//
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("chrome-headless")) {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("headless");
//            driver = new ChromeDriver(options);
//        }
        // Maximise the Browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
}
