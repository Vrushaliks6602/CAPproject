package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAccountPage {
    WebDriver driver;

    // Constructor
    public UserAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By registerLink = By.id("register"); // Locator for the registration link
    By loginLink = By.id("login"); // Locator for the login link
    By usernameInput = By.id("username"); // Locator for the username input field
    By passwordInput = By.id("password"); // Locator for the password input field
    By submitButton = By.id("submit"); // Locator for the submit button
    By accountSettingsLink = By.id("account-settings"); // Locator for account settings link
    By editPasswordLink = By.id("edit-password"); // Locator for edit password link
    By newPasswordInput = By.id("new-password"); // Locator for new password input field
    By saveChangesButton = By.id("save-changes"); // Locator for save changes button

    // Methods
    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(submitButton).click();
    }

    public void goToAccountSettings() {
        driver.findElement(accountSettingsLink).click();
    }

    public void clickEditPassword() {
        driver.findElement(editPasswordLink).click();
    }

    public void enterNewPassword(String newPassword) {
        driver.findElement(newPasswordInput).sendKeys(newPassword);
    }

    public void saveChanges() {
        driver.findElement(saveChangesButton).click();
    }
}