Feature: Purchase flow on the SauceDemo page
@happyPath
  Scenario: Successful login and purchase
    Given I am on the login page
    When I log in with "standard_user" and "secret_sauce"
    Then I should be on the products page
    When I add two products to the cart
    When I view the cart
    When I proceed to checkout
    When I fill out the checkout form with:
    | firstName | lastName | postalCode |
    | John      | Doe      | 12345      |
    Then I finish the purchase