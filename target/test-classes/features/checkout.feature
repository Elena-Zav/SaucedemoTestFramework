@CheckoutTests
Feature: Checkout Feature

  Background: 
    Given User is on Login Page of Swag Labs Application
    When User enters username as 'standard_user' and password as 'secret_sauce'
    And User clicks on the Login button
    Then User should be logged into the Application
    And User is on Products Page of Swag Labs Application
    And User adds all products to the cart
    And The cart displays the badge count of all page products
    And Cart Page shows all Product Page items
    And User clicks on the Checkout button

  @NegativeCheckoutInfoForm @Regression
  Scenario Outline: Verify user cannot continue checkout without filling all fields
    Given User is on Checkout Information Page of Swag Labs Application
    When User enters First Name as <First_Name>
    And User enters Last Name as <Last_Name>
    And User enters postal code as <postal_code>
    And User clicks on the Continue button
    Then User should see an error message <Error_Message>

    Examples: 
      | First_Name | Last_Name | postal_code | Error_Message                    |
      | ''         | ''        | ''          | 'Error: First Name is required'  |
      | 'Mike'     | ''        | ''          | 'Error: Last Name is required'   |
      | 'Mike'     | 'Sha'     | ''          | 'Error: Postal Code is required' |

  @PositiveCheckoutInfoForm @Regression
  Scenario: Verify user can successfully checkout with valid information
    Given User is on Checkout Information Page of Swag Labs Application
    When User enters First Name as 'Mike'
    And User enters Last Name as 'Sha'
    And User enters postal code as '12345'
    And User clicks on the Continue button
    Then User should be on the Checkout Overview Page of Swag Labs Application
