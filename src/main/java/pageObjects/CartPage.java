package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By cartItems = By.cssSelector("div.cart-item");
    By removeItemButton = By.cssSelector("button.remove-item");
    By updateQuantityInput = By.cssSelector("input.quantity-input");
    By proceedToCheckoutButton = By.id("proceed-to-checkout");

    // Methods
    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public void removeItemFromCart() {
        driver.findElement(removeItemButton).click();
    }

    public void updateItemQuantity(int quantity) {
        driver.findElement(updateQuantityInput).clear();
        driver.findElement(updateQuantityInput).sendKeys(String.valueOf(quantity));
    }

    public void proceedToCheckout() {
        driver.findElement(proceedToCheckoutButton).click();
    }
}