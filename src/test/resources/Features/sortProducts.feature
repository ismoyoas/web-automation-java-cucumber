Feature: Sort Product Display
  Scenario: User can the sort product by price
    Given User open Swag Labs website
    And User try login using "standard_user" credential
    When User try to sort product price low to high
    Then User got price list products from low to high

  Scenario: User cannot the sort product
    Given User open Swag Labs website
    And User try login using "problem_user" credential
    When User try to sort product price low to high
    And User try to sort product price high to low
    And User try to sort product name A to Z
    And User try to sort product name Z to A
    Then User cannot see product by sorting feature

  Scenario: User cannot the sort product and show notification
    Given User open Swag Labs website
    And User try login using "error_user" credential
    When User try to sort product price low to high
    And Show the user notification
    Then User cannot see product by sorting feature