package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;
import pages.UrbanLadderPages;

public class UrbanLadderSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private UrbanLadderPages pages;

    @Before
    public void setUp() {
        // Set up WebDriver for Chrome, Firefox, or Edge
        String browser = System.getProperty("browser", "chrome"); // Can be set via command line

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        pages = new UrbanLadderPages(driver);
    }

    @Given("I am on the Urban Ladder homepage")
    public void i_am_on_the_urban_ladder_homepage() {
        pages.openHomePage();
    }

    @Then("I should see the Top Offers section")
    public void i_should_see_the_top_offers_section() {
    }

    @Then("I should see the Recommended for You section")
    public void i_should_see_the_recommended_for_you_section() {

    }

    @When("I search for a product {string}")
    public void i_search_for_a_product(String productName) {
        pages.searchForProduct(productName);
    }

    @Then("I should see the product details")
    public void i_should_see_the_product_details() {
        Assert.assertTrue(pages.areProductDetailsVisible(), "Product details are not visible");
    }

    @Given("I am on the Product Details page")
    public void iAmOnTheProductDetailsPage() {
        pages.openHomePage();
        pages.searchForProduct("office chair");
        Assert.assertTrue(pages.areProductDetailsVisible(), "Products are not visible after search");
        pages.goToProductDetailPage();
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
    }

    @Then("I should see the product in the cart")
    public void i_should_see_the_product_in_the_cart() {
    }

    @When("I register a new user")
    public void i_register_a_new_user() {

    }

    @When("I log in with valid credentials")
    public void i_log_in_with_valid_credentials() {
        pages.loginWithValidCredentials();
    }

    @Then("I should see my account settings")
    public void i_should_see_my_account_settings() {
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}