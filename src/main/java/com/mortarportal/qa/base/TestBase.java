package com.mortarportal.qa.base;

import com.google.common.collect.ImmutableList;
import com.mortarportal.qa.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TimeoutException;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public enum BrowserType {
        CHROME,
        FIREFOX,
        IE,
        EDGE,
        SAFARI,
        CHROME_HEADLESS,
        FIREFOX_HEADLESS
    }

    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    private static final String DEFAULT_BROWSER = "chrome";

    public static WebDriver driver;
    public static Properties prop;

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
        WebDriverManager.iedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    public static void initialization(String browser) {
        BrowserType browserType = getBrowserTypeOrDefault(browser);

        driver = createWebDriver(browserType);
        if (driver == null) {
            logger.error("Unsupported browser: " + browserType);
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
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT));

        try {
            driver.get(prop.getProperty("BASE_URL"));
        } catch (TimeoutException e) {
            logger.error("Timeout occurred while loading the page. Closing the browser.");
            closeBrowser();
        }
    }

    private static BrowserType getBrowserTypeOrDefault(String browser) {
        if (browser == null || browser.isEmpty()) {
            return BrowserType.valueOf(DEFAULT_BROWSER.toUpperCase());
        } else {
            try {
                return BrowserType.valueOf(browser.toUpperCase());
            } catch (IllegalArgumentException e) {
                logger.error("Invalid browser type provided: " + browser);
                return BrowserType.valueOf(DEFAULT_BROWSER.toUpperCase());
            }
        }
    }

    private static WebDriver createWebDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("remote-allow-origins=*");
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                chromeOptions.addArguments("test-type");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.setExperimentalOption("excludeSwitches", ImmutableList.of("disable-popup-blocking"));
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                return new FirefoxDriver();
            case IE:
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.setCapability(InternetExplorerDriver.IE_USE_PER_PROCESS_PROXY, false);
                return new InternetExplorerDriver(ieOptions);
            case EDGE:
                return new EdgeDriver();
            case SAFARI:
                return new SafariDriver();
            case CHROME_HEADLESS:
                ChromeOptions headlessOptions = new ChromeOptions();
                headlessOptions.addArguments("headless");
                return new ChromeDriver(headlessOptions);
            case FIREFOX_HEADLESS:
                FirefoxOptions headlessFirefoxOptions = new FirefoxOptions();
                headlessFirefoxOptions.addArguments("--headless");
                return new FirefoxDriver(headlessFirefoxOptions);
            default:
                logger.error("Unsupported browser type: " + browserType);
                return null;
            }
        }
    }

    public void checkDownloadedFiles(String fileName) throws InterruptedException {
        String FILES_DIRECTORY = ("C:\\Users\\SankaKodda\\Downloads");
        File folder = new File(FILES_DIRECTORY);
        // capture time before looking for files in directory
        // last modified time of previous files will always less than start time
        // this is basically to ignore previous downloaded files
//    File[] allFiles = new File(folder.getPath()).listFiles();
        File[] allFiles = folder.listFiles();
        for (int i = 0; i < allFiles.length; i++) {
            String eachFile = allFiles[i].getName();
            if (eachFile.contains(fileName)) {
                System.out.println("Verified: File : " + fileName + " Has Been Download.");
            } else continue;
        }
       /* File directory = new File("C:\\Users\\SankaKodda\\Downloads");
        boolean downloadinFilePresence = false;
        File[] filesList =null;
        LOOP:
        while(true) {
            filesList =  directory.listFiles();
            for (File file : filesList) {
                downloadinFilePresence = file.getName().contains(fileName);
                System.out.println();
            }
            if(downloadinFilePresence) {
                for(;downloadinFilePresence;) {
                    sleep(5);
                    System.out.println(downloadinFilePresence+"Downloaded");
                    continue LOOP;
                }
            }else {
                break;
            }
        }*/

    }
//    public static boolean isFileDownloaded(String expectedFileName, String fileExtension, int timeOut) throws IOException
//    {
//        // Download Folder Path
////        String folderName = System.getProperty("user.dir") + File.separator + "downloads";
//        String folderName = ("C:\\Users\\SankaKodda\\Downloads");
//        // Array to Store List of Files in Directory
//        File[] listOfFiles;
//
//        // Store File Name
//        String fileName;
//
//        //  Consider file is not downloaded
//        boolean fileDownloaded = false;
//
//        // capture time before looking for files in directory
//        // last modified time of previous files will always less than start time
//        // this is basically to ignore previous downloaded files
//        long startTime = Instant.now().toEpochMilli();
//
//        // Time to wait for download to finish
//        long waitTime = startTime + timeOut;
//
//        // while current time is less than wait time
//        while (Instant.now().toEpochMilli() < waitTime)
//        {
//            System.out.println(Instant.now().toEpochMilli());
//            System.out.println("dddds1");
//            // get all the files of the folder
//            listOfFiles = new File(folderName).listFiles();
//
//            // iterate through each file
//            for (File file : listOfFiles)
//            {
//                // get the name of the current file
//                fileName = file.getName().toLowerCase();
//                System.out.println("dddds12");
//                // condition 1 - Last Modified Time > Start Time
//                // condition 2 - till the time file is completely downloaded extension will be crdownload
//                // Condition 3 - Current File name contains expected Text
//                // Condition 4 - Current File name contains expected extension
//                if (file.lastModified() > startTime && !fileName.contains(prop.getProperty("ExportUnderlyingSalesDataDownloadFileName")) &&   fileName.contains(expectedFileName.toLowerCase()) && fileName.contains(fileExtension.toLowerCase()))
//                {
//                    // File Found
//                    fileDownloaded = true;
//                    System.out.println("dddds123");
//                    System.out.println("Verified: File : " + fileName + " Has Been Download.");
//                    break;
//                }
//            }
//            // File Found Break While Loop
//            if (fileDownloaded)
//                System.out.println("dddds124");
//                break;
//        }
//        System.out.println("dddds125");
//        // File Not Found
//        return fileDownloaded;
//
//    }

    @AfterTest
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

