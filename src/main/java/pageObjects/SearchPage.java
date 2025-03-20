package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By searchInput = By.id("search");
    By searchButton = By.xpath("//button[@type='submit' and contains(@class, 'search-button')]");
    By filterNewArrivals = By.xpath("//label[contains(text(), 'New Arrivals')]");
    By filterPrice = By.xpath("//label[contains(text(), 'Price')]");
    By filterRatings = By.xpath("//label[contains(text(), 'Ratings')]");

    // Methods
    public void enterSearchTerm(String productName) {
        driver.findElement(searchInput).sendKeys(productName);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void filterByNewArrivals() {
        driver.findElement(filterNewArrivals).click();
    }

    public void filterByPrice() {
        driver.findElement(filterPrice).click();
    }

    public void filterByRatings() {
        driver.findElement(filterRatings).click();
    }
}