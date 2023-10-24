Feature: Add and Remove Products in Cart
  Scenario: User successfully add and remove product in Cart
    Given User open SwagLabs website
    And User login using "standard_user" credential
    When User add Sauce Labs Backpack to Cart
    And User back to catalogue product
    And User add Sauce Labs Fleece Jacket to Cart
    And User back to catalogue product
    And User remove Sauce Labs Backpack from cart
    Then User viewed products that wants to buy

  Scenario: User unsuccessfully remove product from Cart
    Given User open SwagLabs website
    And User login using "problem_user" credential
    When User add Sauce Labs Backpack to Cart
    And User back to catalogue product
    And User add Sauce Labs Bike Light and Sauce Labs Onesie to Cart
    And User back to catalogue product
    And User remove all of products from cart
    Then User viewed products that wants to buy

  Scenario: User unsuccessfully add product to Cart
    Given User open SwagLabs website
    And User login using "problem_user" credential
    When User add Sauce Labs Backpack to Cart
    And User back to catalogue product
    And User add Sauce Labs Fleece Jacket to Cart
    And User back to catalogue product
    And User remove Sauce Labs Backpack from cart
    Then User viewed products that wants to buy