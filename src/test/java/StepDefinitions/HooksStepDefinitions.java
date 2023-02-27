package StepDefinitions;
import com.mortarai.pages.HomePage;
import com.mortarai.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.Constants;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HooksStepDefinitions {
    public HooksStepDefinitions(){}
    public static WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(HooksStepDefinitions.class);

    private LoginPage loginPage;
    private HomePage homePage;
    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        logger.info("In BeforeSuite");
    }

    @Parameters({"browser.name"})
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
//            Remove the message of "Chrome is being controlled by Automated Test Software" in the browser
//            options.addArguments("disable-infobars");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            //            Maximize the browser
            options.addArguments("start-maximized");
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
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        logger.info("In BeforeMethod");
        driver.manage().window().maximize();
        driver.navigate().to(Constants.BASE_URL);

        Duration duration = Duration.ofSeconds(60);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.titleContains("Mortar - Web Portal"));
    }

    @AfterMethod
    public void afterMethod()
    {
        logger.info("In AfterMethod");
        driver.close();
    }

    @Given("User navigates to the login page")
    public void user_navigates_to_the_login_page() {
        beforeSuite();
        beforeMethod("chrome");
//        System.out.println("I'm in login page");
    }
    @When("User enters username \"([^\"]*)\"$")
    public void user_enters_username(String username) {
//        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.typeUserName(username);
        System.out.println("username");
//        logger.info("Entered the Username");
    }
    @And("User enters the password as \"([^\"]*)\"$")
    public void userEntersThePasswordAs(String password) {
        loginPage.typePassword(password);
    }
    @And("Clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLoginButtonSuccess();
//        System.out.println("I pressed Login button");
    }

    @Then("User is navigated to the home page and see {string} message")
    public void userIsNavigatedToTheHomePageAndSeeWelcomeAdminMessage(String message) {
        Duration duration = Duration.ofSeconds(60);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.urlToBe(Constants.BASE_URL + "dashboard"));
        Assert.assertEquals(homePage.getWelcomeMessage(),message);
        System.out.println("I'm in Home Page" + message);
        System.out.println("Expected message:" +homePage.getWelcomeMessage());

        homePage.logout();
//        System.out.println("I pressed Logout button");
        afterMethod();
//        System.out.println("Officially closed the test case");
    }

    @Then("User should get an error {string} message")
    public void userShouldGettingAnErrorInvalidCredentialsMessage(String message) {
        Assert.assertEquals(loginPage.getErrorMessage(),message);
        afterMethod();
    }
}
