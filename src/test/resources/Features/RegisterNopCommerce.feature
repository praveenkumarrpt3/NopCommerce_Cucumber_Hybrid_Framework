@all
Feature: Register Functionality

@regression @smoke
  Scenario Outline: login With all fields
    Given User should be landing in the application url
    And Navigate to Register page
    When User should clicks on male radio button
    And enters all the fields mentioned below  "<firstname>" "<lastname>" "<email>" "<companyname>" "<password>" "<confirm password>"
    And select the day, month and year in date of birth dropdown  "<day>"  "<month>" "<year>"
    And clicks on Newsletter
    And User clicks on REGISTER button
    Then User should navigate to Register complete page

    Examples: 
      | firstname | lastname | day | month    | year | email                 | companyname | password | confirm password |
      | Praveen   | Kumar    |   3 | November | 1994 | praveenvlr3@gmail.com | Chennai     |   123456 |           123456 |
      | Aravind   | Kumar    |  11 | April    | 1991 | aravindvlr@gmail.com  | vellore     |   123456 |           123456 |

@regression @smoke
  Scenario Outline: login With manatory fields
    Given User should be landing in the application url
    And Navigate to Register page
    When User should enters Manatory fields mentioned below  "<firstname>" "<lastname>" "<email>" "<password>" "<confirm password>"
    And User clicks on REGISTER button
    Then User should navigate to Register complete page

    Examples: 
      | firstname | lastname | email                 | password | confirm password |
      | Praveen   | Kumar    | praveenvlr3@gmail.com |   123456 |           123456 |
      | Harish    | Kumar    | harishvlr@hmail.com   |   123456 |           123456 |

@regression @smoke
  Scenario: Register with without enters any value
    Given User should be landing in the application url
    And Navigate to Register page
    And User clicks on REGISTER button
    Then User should got the proper warning message

@regression @smoke
  Scenario Outline: Register With duplicate email
    Given User should be landing in the application url
    And Navigate to Register page
    When User should enters Manatory fields with duplicate mail mentioned below  "<firstname>" "<lastname>" "<email>" "<password>" "<confirm password>"
    And User clicks on REGISTER button
    Then User should validate the duplicate email warning messgae

    Examples: 
      | firstname | lastname | email                 | password | confirm password |
      | Praveen   | Kumar    | praveenvlr3@gmail.com |   123456 |           123456 |
