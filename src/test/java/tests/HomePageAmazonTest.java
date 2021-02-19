package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AmazonHomePage;
import utils.ScreenshotUtils;

import java.util.concurrent.TimeUnit;

@Tag("SmokeTest")
public class HomePageAmazonTest {
    private WebDriver driver;
    AmazonHomePage amazonHomePage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        amazonHomePage = new AmazonHomePage(driver);
    }

    @Test
    @DisplayName("Open Amazon Home page and check the title")
    public void openHomePageAndCheckTheTitle() {
        amazonHomePage.navigateToHomePage();
        amazonHomePage.verifyPageTitle();
    }

    @AfterEach
    public void tearDown() {
        ScreenshotUtils.screenshot(driver);
        driver.quit();
    }
}
