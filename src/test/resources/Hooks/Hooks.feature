Feature: Check Login functionality

  Scenario: User logins with valid user credentials
    Given user navigates to the login page
    When user enters username "vimarsha@hyperspacehub.com"
    And user enters the password as "Vimarsha@123"
    And clicks on login button
    Then user is navigated to the home page and see 'Dashboard' message