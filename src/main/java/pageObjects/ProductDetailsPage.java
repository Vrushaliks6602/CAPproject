package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    WebDriver driver;

    // Constructor
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By productTitle = By.cssSelector("h1.product-title");
    By productDescription = By.cssSelector("div.product-description");
    By productPrice = By.cssSelector("span.product-price");
    By addToCartButton = By.id("add-to-cart");
    By addToWishlistButton = By.id("add-to-wishlist");
    By availabilityStatus = By.cssSelector("span.availability-status");

    // Methods
    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public String getProductDescription() {
        return driver.findElement(productDescription).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public boolean isProductAvailable() {
        return driver.findElement(availabilityStatus).isDisplayed();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void addToWishlist() {
        driver.findElement(addToWishlistButton).click();
    }
}