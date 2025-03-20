package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class UrbanLadderPages {
    private WebDriver driver;
    private WebDriverWait wait;

    // Common locators
    private final By closePopupButton = By.cssSelector(".popup-close");
    private final By topOffersSection = By.xpath("//h4[contains(text(),'top-offers')]");
    private final By recommendedSection = By.xpath("//h4[contains(text(),'recommended-for-you')]");
    private final By searchBox = By.id("search");
    private final By searchButton = By.xpath("//button[@id='search_button']");
    private final By productTiles = By.cssSelector(".product-title");
    private final By addToCartButton = By.xpath("//button[contains(text(),'Add to Cart')]");
    private final By cartIcon = By.cssSelector(".cart-icon");
    private final By cartItems = By.cssSelector(".cart-item");
    private final By profileIcon = By.cssSelector(".header-icon-link.user-profile-icon");
    private final By signUpLink = By.cssSelector("a[href='/signup']");
    private final By loginLink = By.id("header-icon-login");
    private final By emailField = By.id("spree_user_email");
    private final By passwordField = By.id("spree_user_password");
    private final By signupButton = By.xpath("//input[@value='Sign Up']");
    private final By loginButton = By.xpath("//input[@value='Log In']");
    private final By accountSettings = By.xpath("//a[contains(text(),'Account')]");

    public UrbanLadderPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openHomePage() {
        driver.get("https://www.urbanladder.com/");
        handlePopup();
    }

    public void handlePopup() {
        try {
            WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(closePopupButton));
            popup.click();
        } catch (Exception e) {
            // Popup might not appear, ignore
        }
    }

    public boolean isTopOffersSectionVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(topOffersSection)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isRecommendedSectionVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(recommendedSection)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void searchForProduct(String productName) {
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        search.clear();
        search.sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public boolean areProductDetailsVisible() {
        try {
            List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productTiles));
            return products.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void goToProductDetailPage() {
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productTiles));
        if (products.size() > 0) {
            // Click on the first product
            products.get(0).click();
        }
    }

    public void addProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public boolean isProductInCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        try {
            List<WebElement> items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cartItems));
            return items.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnProfileIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
    }

    public void clickOnSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpLink)).click();
    }

    public void registerNewUser() {
        clickOnProfileIcon();
        clickOnSignUp();

        Random random = new Random();
        String email = "test" + random.nextInt(10000) + "@example.com";
        String password = "Test@123";

        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signupButton).click();
    }

    public void loginWithValidCredentials() {
        clickOnProfileIcon();
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public boolean isAccountSettingsVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(accountSettings)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}