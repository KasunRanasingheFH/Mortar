Feature: Check Login functionality
  Scenario: User logins with valid user credentials
    Given user navigates to the login page in browser "EDGE"
    When user enters username "chaturanga@fh.technology"
    And user enters the password as "Chaturanga@123"
    And clicks on login button
    Then user is navigated to the home page and see 'Dashboard' message