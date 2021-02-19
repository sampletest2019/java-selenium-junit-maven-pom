package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonSearchPage {
    protected WebDriver driver;

    private String pageTitle = "Amazon.com : ";
    private String pageUrl = "https://www.amazon.com/s?k=";

    private By searchInputField = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");

    public AmazonSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToSearchPage(String item) {
        this.driver.get(pageUrl+item);
    }

    public boolean verifyPageTitle(String item){
        Assertions.assertEquals(pageTitle+item, this.driver.getTitle());
        return true;
    }

    public void clearSearchInputField() {
        this.driver.findElement(searchInputField).clear();
    }

    public void enterSearchItemAndSubmit (String item) {
        this.driver.findElement(searchInputField).sendKeys(item);
        this.driver.findElement(searchButton).click();
    }
}
