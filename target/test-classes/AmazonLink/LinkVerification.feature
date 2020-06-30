Feature: Amazon Link Verification

  Scenario: Amazon HomePage Link Verification
    Given User navigates to Amazon HomePage
    When User gets all Urls from Amazon homePage
    Then User Validates if links are broken and store
    And User printOuts the working links
