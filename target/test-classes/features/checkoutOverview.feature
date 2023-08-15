@CheckoutOverviewTests
Feature: Checkout Overview Feature

  Background: 
    Given User is on Login Page of Swag Labs Application
    When User enters username as 'standard_user' and password as 'secret_sauce'
    And User clicks on the Login button
    Then User should be logged into the Application
    And User is on Products Page of Swag Labs Application
    And User adds all products to the cart
    And Cart Page shows all Product Page items
    And User clicks on the Checkout button
    And User is on Checkout Information Page of Swag Labs Application
    And User enters First Name as 'Mike'
    And User enters Last Name as 'Sha'
    And User enters postal code as '12345'
    And User clicks on the Continue button
    And User is on Checkout Overview Page of Swag Labs Application

  @ItemTotalAmount @Regression
  Scenario: Verify that the Item Total amount is correct for the Products selected
    Then The displayed Item Total amount is correct for the selected products

  @Completion @Regression
  Scenario: Confirm order checkout can be completed
    When User clicks on the Finish button
    Then User should see a confirmation message that order has been placed
    And User should be on the Order Completion page
