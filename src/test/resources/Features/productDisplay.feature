Feature: Product Display
  Scenario: User see the normal products displayed
    Given User open SwagLabs
    And User login using valid "standard_user" credential
    When User check a products
    Then User got products picture profile comparison

  Scenario: User see the abnormal products displayed using problem_user
    Given User open SwagLabs
    And User login using valid "problem_user" credential
    When User check a products
    Then User got products picture profile comparison

  Scenario: User see the abnormal products displayed using visual_user
    Given User open SwagLabs
    And User login using valid "visual_user" credential
    When User check a products
    Then User got products picture profile comparison