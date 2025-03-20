Feature: Urban Ladder Website Testing

  Scenario: Verify Home Page Sections
    Given I am on the Urban Ladder homepage
    Then I should see the Top Offers section
    And I should see the Recommended for You section

  Scenario: Search for a Product
    Given I am on the Urban Ladder homepage
    When I search for a product "office chair"
    Then I should see the product details

  Scenario: Add Product to Cart
    Given I am on the Product Details page
    When I add the product to the cart
    Then I should see the product in the cart

  Scenario: User Registration and Login
    Given I am on the Urban Ladder homepage
    When I register a new user
    And I log in with valid credentials
    Then I should see my account settings
    