@LoginTests
Feature: Login Feature

  Background: 
    Given User is on Login Page of Swag Labs Application

  @LoginPositive @Regression
  Scenario: Verify user can log into the Application
    When User enters username as 'standard_user' and password as 'secret_sauce'
    And User clicks on the Login button
    Then User should be logged into the Application

  @LoginNegative @Regression
  Scenario Outline: Verify user cannot log in without providing a username or both credentials
    When User enters username as <username> and password as <password>
    And User clicks on the Login button
    Then User should see an error message for missing username

    Examples: 
      | username | password       |
      | ''       | 'secret_sauce' |
      | ''       | ''             |

  @LoginNegative @Regression
  Scenario: Verify user cannot login without providing a password
    When User enters username as 'standard_user' and password as ''
    And User clicks on the Login button
    Then User should see an error message for missing password

  @LoginNegative @Regression
  Scenario Outline: Verify user cannot login with invalid credentials
    When User enters username as <username> and password as <password>
    And User clicks on the Login button
    Then User should see an error message for username and password mismatch

    Examples: 
      | username         | password        |
      | 'standard_user'  | 'wrong_pass'    |
      | 'invalid_user'   | 'secret_sauce'  |
      | 'invalid_user'   | 'wrong_pass'    |
      | 'test@test.com'  | 'secret_sauce'  |
      | 'standard_user'  | 'test12345'     |
      | 'standard_user'  | 'secret_sauce ' |
      | 'standard_user'  | ' secret_sauce' |
      | ' standard_user' | 'secret_sauce'  |
      | 'standard_user ' | 'secret_sauce'  |
