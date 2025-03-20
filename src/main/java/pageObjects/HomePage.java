package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By topOffersSection = By.id("top-recently-viewed");
    By recommendedForYouSection = By.id("homepage_slider");
    By searchBar = By.id("search");

    // Methods
    public boolean isTopOffersDisplayed() {
        return driver.findElement(topOffersSection).isDisplayed();
    }

    public boolean isRecommendedForYouDisplayed() {
        return driver.findElement(recommendedForYouSection).isDisplayed();
    }

    public void searchForProduct(String productName) {
        driver.findElement(searchBar).sendKeys(productName);
        driver.findElement(By.id("search-button")).click();
    }
}

