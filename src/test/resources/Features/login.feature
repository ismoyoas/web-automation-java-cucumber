Feature: Login
  Scenario: User login using registered username and password
    Given User open chrome browser
    And User open website SwagLabs
    When User type username "standard_user"
    And  User type password "secret_sauce"
    And User click login button
    Then User directed to dashboard

  Scenario: User login using invalid username and password
    Given User open chrome browser
    And User open website SwagLabs
    When User type username "Standard_User"
    And  User type password "secret_sauce"
    And User click login button
    Then Show warning notification

  Scenario: User login using blank username
    Given User open chrome browser
    And User open website SwagLabs
    When User type username ""
    And  User type password "secret_sauce"
    And User click login button
    Then Show warning notification

  Scenario: User login using blank password
    Given User open chrome browser
    And User open website SwagLabs
    When User type username "standard_user"
    And  User type password ""
    And User click login button
    Then Show warning notification

  Scenario: User login using blank password
    Given User open chrome browser
    And User open website SwagLabs
    When User type username "locked_out_user"
    And  User type password "secret_sauce"
    And User click login button
    Then Show warning notification