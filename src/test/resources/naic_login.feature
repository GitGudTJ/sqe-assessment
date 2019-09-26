Feature: Testing NAIC Logins

  Scenario: As a user I will fail to login when using an invalid username and password
    Given I navigate to NAIC portal
    When I sign in with username "Smitty" and password "123fake"
    Then I get the error message "Login failed, please try again."