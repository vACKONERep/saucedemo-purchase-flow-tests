Feature: Purchase flow on the SauceDemo page
@happyPath
  Scenario Outline: Successful login and purchase
    Given I am on the login page
    When I log in with "<username>" and "<password>"
    Then I should be on the products page
    When I add two products to the cart
    When I view the cart
    When I proceed to checkout
    When I fill out the checkout form with "<firstName>", "<lastName>", and "<postalCode>"
    Then I finish the purchase
  Examples:
    | username       | password     | firstName | lastName | postalCode |
    | standard_user  | secret_sauce | John      | Doe      | 12345      |
