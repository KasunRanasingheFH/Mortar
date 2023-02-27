Feature: Check Login functionality

  Scenario: User logins with valid user credentials
    Given User navigates to the login page
    When User enters username "vimarsha@hyperspacehub.com"
    And User enters the password as "Vimarsha@123"
    And Clicks on login button
    Then User is navigated to the home page and see 'Dashboard' message
    
  Scenario: User tries to login with invalid password
    Given User navigates to the login page
    When User enters username "vimarsha@hyperspacehub.com"
    And User enters the password as "marsha@123"
    And Clicks on login button
    Then User should get an error 'Login failed! Please check your username and password and try again.' message
      
  Scenario: User tries with mistypes(wrong) username but correct password
    Given User navigates to the login page
    When User enters username "marsha@hyperspacehub.com"
    And User enters the password as "Vimarsha@123"
    And Clicks on login button
    Then User should get an error 'Login failed! Please check your username and password and try again.' message

  Scenario: User tries with wrong user credentials
    Given User navigates to the login page
    When User enters username "marsha@hyperspacehub.com"
    And User enters the password as "imarsha@123"
    And Clicks on login button
    Then User should get an error 'Login failed! Please check your username and password and try again.' message