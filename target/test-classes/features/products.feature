@ProductsTests
Feature: Products Feature

  Background: 
    Given User is on Login Page of Swag Labs Application
    When User enters username as 'standard_user' and password as 'secret_sauce'
    And User clicks on the Login button
    Then User should be logged into the Application
    And User is on Products Page of Swag Labs Application

	@AddRemoveProducts @Regression
  Scenario: Verify user can add and remove products to and from the cart
    When User adds all products to the cart
    Then The cart displays the badge count of all page products
    And Cart Page shows all Product Page items
    When User clicks on the Continue Shopping button to go back to the Product Page
    And User removes all products from the cart
    Then The cart does not display the badge
    And Cart Page shows 0 Product Page items

	@SortByNameProducts @Regression
  Scenario: Verify products can be sorted by Name (ascending)
    When User selects "Name (A to Z)" from the sorting options
    Then Products should be displayed in alphabetical order
	
	@SortByPriceProducts @Regression
  Scenario: Verify products can be sorted by Price (ascending)
    When User selects "Price (low to high)" from the sorting options
    Then Products should be displayed in ascending order based on their prices

  @ReachProductDetail @Regression
  Scenario Outline: Verify Product Detail Page can be reached by clicking on the product <product_element> of Product <product_number>
    When User clicks on the <product_element> of Product <product_number>
    Then User should be redirected to Product Detail Page for Product <product_number>

    Examples: 
      | product_number | product_element |
      |              0 | 'name'          |
      |              0 | 'image'         |
      |              1 | 'name'          |
      |              1 | 'image'         |
      |              2 | 'name'          |
      |              2 | 'image'         |
      |              3 | 'name'          |
      |              3 | 'image'         |
      |              4 | 'name'          |
      |              4 | 'image'         |
      |              5 | 'name'          |
      |              5 | 'image'         |
