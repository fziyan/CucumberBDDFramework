Feature: User Login Test with username and password

  Background: Common Steps
    Given User navigate homepage

  @senaryo1
  Scenario: User Login into system
    When User enter username password and click submit button
    Then User see the product page title
    Then User close the browser

   @senaryo2
   Scenario: User should be fail login
     When Username password information is entered incorrectly and submit button
     Then User see validation error message for username and password field
     Then User close the browser

   @senaryo3
   Scenario: User enter the true username
     When Username enter valid and password enter incorrect
     Then user see validation error for password field
     Then User close the browser

  @senaryo4
  Scenario: User not enter the username and enter password
    When User does not enter username and enter password
    When User click login button
    Then user see validation error for empty username field
    Then User close the browser