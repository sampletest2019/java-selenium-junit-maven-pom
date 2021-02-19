package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AmazonHomePage;
import pages.AmazonSearchPage;
import utils.ScreenshotUtils;

import java.util.concurrent.TimeUnit;

@Tag("RegressionTest")
public class SearchAmazonTest {
    private WebDriver driver;
    AmazonHomePage amazonHomePage;
    AmazonSearchPage amazonSearchPage;
    String searchItem = "nike airmax";

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        amazonHomePage = new AmazonHomePage(driver);
        amazonSearchPage = new AmazonSearchPage(driver);
    }

    @Test
    @DisplayName("Open Amazon Home page, search for an item and check the title")
    public void openHomePageAndCheckTheTitle() {
        amazonHomePage.navigateToHomePage();
        amazonHomePage.verifyPageTitle();
        amazonHomePage.enterSearchItemAndSubmit(searchItem);
        amazonSearchPage.verifyPageTitle(searchItem);
    }

    @AfterEach
    public void tearDown() {
        ScreenshotUtils.screenshot(driver);
        driver.quit();
    }

}
