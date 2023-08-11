Feature: search funtionality

  Scenario: search valid product with user logged in
    Given User should be landing in the application url
    And Navigate to login page
    When User should be logged in with valid credential
    And Search with valid product
    And scroll down the page and select a manufacturer
    And User should open a product in a new tab
    Then User should validate the similar product list as searched

  Scenario: search with invalid product with user logged in
    Given User should be landing in the application url
    And Navigate to login page
    When User should be logged in with valid credential
    And Search with invalid product
    Then User should validate the error message

  Scenario: search with empty search bar with user logged in
    Given User should be landing in the application url
    And Navigate to login page
    When User should be logged in with valid credential
    And Search with empty search bar
    Then User should validate the error message

  Scenario: search valid product with user without log in
    Given User should be landing in the application url
    When Search with valid product
    And scroll down the page and select a manufacturer
    And User should open a product in a new tab
    Then User should validate the similar product list as searched

  Scenario: search with invalid product without user log in
    Given User should be landing in the application url
    When Search with invalid product
    Then User should validate the error message

  Scenario: search with empty search bar without user log in
    Given User should be landing in the application url
    When Search with empty search bar
    Then User should validate the error message
