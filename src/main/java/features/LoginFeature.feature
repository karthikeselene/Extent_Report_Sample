Feature: Login to the app

  Scenario: Login to the app with password
    Given I am on the login screen
    When I enter my passcode
    Then I press the ok button
