@LogoutTests
Feature: Logout Feature

  Background: 
    Given User is on Login Page of Swag Labs Application
    When User enters username as 'standard_user' and password as 'secret_sauce'
    And User clicks on the Login button
    Then User should be logged into the Application

  @Logout @Regression
  Scenario: Logout from Swag Labs Application
    When User clicks on the Logout link
    Then User should be on Login Page of Swag Labs Application