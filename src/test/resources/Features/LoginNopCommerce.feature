@all
Feature: Login Functionality
@regression @smoke
  Scenario Outline: login With Valid Credentials
    Given User should be landing in the application url
    And Navigate to login page
    When User should be logged in with valid "<valid username>" and valid "<valid password>"
    And User clicks on Login button
    Then User should navigate to My account page

    Examples: 
      | valid username        | valid password |
      | praveenvlr3@gmail.com |         123456 |

@regression @smoke 
  Scenario Outline: login With Invalid Credentials
    Given User should be landing in the application url
    And Navigate to login page
    When User should be logged in with  "<invalid username>" and "<invalid password>"
    And User clicks on Login button
    Then User validate the proper warning message for both invalid credentials

    Examples: 
      | invalid username           | invalid password |
      | praveenvlr333232@gmail.com |         12345678 |

  Scenario Outline: login With Valid username and Invalid password
    Given User should be landing in the application url
    And Navigate to login page
    When User should be logged in with valid username and invalid password "<valid username>" and "<invalid password>"
    And User clicks on Login button
    Then User validate the proper warning message for valid username and invalid password

    Examples: 
      | valid username        | invalid password |
      | praveenvlr3@gmail.com |        123456789 |

  Scenario Outline: login With invalid username and Valid password
    Given User should be landing in the application url
    And Navigate to login page
    When User should be logged in with invalid username and valid password "<invalid username>" and "<valid password>"
    And User clicks on Login button
    Then User validate the proper warning message for invalid username and valid password

    Examples: 
      | invalid username           | valid password |
      | praveenvlr333232@gmail.com |         123456 |

  Scenario Outline: login With without enters any values in usernames and password fields
    Given User should be landing in the application url
    And Navigate to login page
    When User should not be enter any credentials in text fields
    And User clicks on Login button
    Then User validate the proper warning message for without enters any credentials
