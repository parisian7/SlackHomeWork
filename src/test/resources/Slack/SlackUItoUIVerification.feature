Feature: UI to UI verification
  Scenario: UI to UI Post Message Verification
    Given User navigates to Slack WebApp
    When User Sends a massage with Selenium "So sorry!"
    Then User Validates the massage is as expected