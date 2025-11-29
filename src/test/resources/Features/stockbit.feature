Feature: Stockbit Login
  As a QA engineer
  I want to automate Stockbit invalid login flow
  So that I can verify the error message failed login page

  Scenario: User starts login with email
    Given user is on the Stockbit homepage
    When user navigates to the login page
    And user enters email "testuser@example.com"
    And user enters password "password123"
    And user clicks the login button
    Then user should see the error message
