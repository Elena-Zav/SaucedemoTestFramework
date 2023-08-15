@CartTests
Feature: Cart Feature

  Background: 
    Given User is on Login Page of Swag Labs Application
    When User enters username as 'standard_user' and password as 'secret_sauce'
    And User clicks on the Login button
    Then User should be logged into the Application
    And User is on Products Page of Swag Labs Application
    And User adds all products to the cart
    And The cart displays the badge count of all page products
    And Cart Page shows all Product Page items

  @RemoveProductsFromCart @Regression
  Scenario: Verify that products can be removed from the cart
    Given User has 6 items in the cart
    When User removes all items from the cart one by one
    Then The cart should be empty and the badge count should disappear