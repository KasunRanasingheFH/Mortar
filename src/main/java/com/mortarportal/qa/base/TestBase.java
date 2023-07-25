package com.mortarportal.qa.base;

import com.google.common.collect.ImmutableList;
import com.mortarportal.qa.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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

    public static void initialization(String browser) {
        if (browser == null || browser.isEmpty()) {
            browser = "chrome"; // Set Chrome as default if no browser is provided
        }

        switch (browser.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("remote-allow-origins=*");
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                chromeOptions.addArguments("test-type");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.setExperimentalOption("excludeSwitches", ImmutableList.of("disable-popup-blocking"));
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "ie" -> {
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                // IE configuration options
                driver = new InternetExplorerDriver(ieOptions);
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                // Edge configuration options
                driver = new EdgeDriver();
            }
            case "safari" -> {
                // SafariDriver is automatically installed on macOS Safari
                driver = new SafariDriver();
            }
            case "chrome-headless" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions headlessOptions = new ChromeOptions();
                headlessOptions.addArguments("headless");
                driver = new ChromeDriver(headlessOptions);
            }
            case "firefox-headless" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions headlessFirefoxOptions = new FirefoxOptions();
                headlessFirefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(headlessFirefoxOptions);
            }
            default -> System.exit(-1);
        }

        // Maximise the Browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT));

        driver.get(prop.getProperty("BASE_URL"));
    }

    @AfterMethod
    protected void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
